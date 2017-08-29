package com.nishant.spring.mongodb.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix="spring.data.mongodb")
public class MongoConfigProperties {

	private String host;
	private Integer port;
	private String database;
	private String collectionname;

	public String getHost() {
		return host;
	}
	public void setHost(String host) {
		this.host = host;
	}
	public Integer getPort() {
		return port;
	}
	public void setPort(Integer port) {
		this.port = port;
	}
	public String getDatabase() {
		return database;
	}
	public void setDatabase(String database) {
		this.database = database;
	}
	public String getCollectionname() {
		return collectionname;
	}
	public void setCollectionname(String collectionname) {
		this.collectionname = collectionname;
	}

}
