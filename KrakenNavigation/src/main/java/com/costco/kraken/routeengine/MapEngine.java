package com.costco.kraken.routeengine;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.geom.Ellipse2D;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.InputStream;
import java.util.List;
import java.util.UUID;

import javax.imageio.ImageIO;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import com.microsoft.azure.storage.blob.CloudBlobClient;
import com.microsoft.azure.storage.blob.CloudBlobContainer;
import com.microsoft.azure.storage.blob.CloudBlockBlob;


public class MapEngine {
	
	@Autowired
	//static TelemetryClient telemetryClient;
	
	private static final Logger logger = LogManager.getLogger(MapEngine.class);
	
	public static String generateMap(List<Point> path) throws Exception {
		
		//telemetryClient.trackEvent("Start to generate map image");
		
		Resource defaultOfficeMapImage = new ClassPathResource("maps/Office_Map_1.png");
		BufferedImage mapImage = drawPathOverMap(path, defaultOfficeMapImage.getInputStream());
		
		//telemetryClient.trackEvent("Finished generating and uploading map image");
		return uploadFile(mapImage);
	}
	
	public static BufferedImage drawPathOverMap(List<Point> path, InputStream imageFile) throws Exception {

	        BufferedImage mapImage = ImageIO.read(imageFile);
	        Graphics2D g = (Graphics2D) mapImage.getGraphics();
	        g.setStroke(new BasicStroke(3));
	        g.setColor(Color.BLUE);

	        for(int x=0; x < path.size()-1; x++) {
	            Point start = path.get(x);
	            Point end = path.get(x+1);
	            g.drawLine((int)start.getX(),(int)start.getY(),(int)end.getX(),(int)end.getY());
	        }
	        //Draw start point
	        Ellipse2D circleMarker = new Ellipse2D.Double((int)path.get(0).getX() - 8,(int)path.get(0).getY() - 8,16,16);
	        g.fill(circleMarker);
	        //Draw end point
	        Point endPoint = path.get(path.size()-1);
	        g.drawLine((int)endPoint.getX()-6,(int)endPoint.getY()-6,(int)endPoint.getX()+6,(int)endPoint.getY()+6);
	        g.drawLine((int)endPoint.getX()-6,(int)endPoint.getY()+6,(int)endPoint.getX()+6,(int)endPoint.getY()-6);

	        return mapImage;
	 }
	
	
	public static String uploadFile(BufferedImage buffImage) {
        
        CloudBlobClient blobClient;
        try {
        	blobClient = BlobClientProvider.getBlobClientReference();
        	CloudBlobContainer blobContainer = blobClient.getContainerReference("direction");
        	
        	CloudBlockBlob blockBlob = blobContainer.getBlockBlobReference(UUID.randomUUID()+".png");
        	
        	
        	ByteArrayOutputStream baos = new ByteArrayOutputStream();
        	ImageIO.write( buffImage, "png", baos );
        	baos.flush();
        	byte[] imageInByte = baos.toByteArray();
        	baos.close();
        	
        	blockBlob.uploadFromByteArray(imageInByte, 0, imageInByte.length);
        	
        	logger.info("Completed uploading image to azure");
        	
        	return blockBlob.getUri().toString();
        }
        catch(Exception e) {
        	logger.error("Issue writing file to blob storage", e);
        }
        
        return "";   
    }
}
