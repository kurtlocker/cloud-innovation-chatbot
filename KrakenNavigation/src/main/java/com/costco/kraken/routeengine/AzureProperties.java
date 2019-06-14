package com.costco.kraken.routeengine;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "kraken.azure-storage")
public class AzureProperties {
	
	
	private String storageConnectionString;

	public String getStorageConnectionString() {
		return storageConnectionString;
	}

	public void setStorageConnectionString(String storageConnectionString) {
		this.storageConnectionString = storageConnectionString;
	}

}
