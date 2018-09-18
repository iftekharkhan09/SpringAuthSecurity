package com.cache.config;

import javax.sql.DataSource;

import org.springframework.cloud.config.java.AbstractCloudConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class CloudConfig extends AbstractCloudConfig {
	@Primary
	@Bean(name = "first-db")
	public DataSource firstDataSource() {
		return connectionFactory().dataSource("first-db");
	}

	@Bean(name = "second-db")
	public DataSource secondDataSource() {
		return connectionFactory().dataSource("second-db");
	}
}
