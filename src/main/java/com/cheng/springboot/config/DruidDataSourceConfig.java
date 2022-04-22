package com.cheng.springboot.config;



import javax.sql.DataSource;

import org.springframework.boot.context.properties.ConfigurationProperties;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.alibaba.druid.pool.DruidDataSource;


@Configuration
public class DruidDataSourceConfig {

	    @Bean
		@ConfigurationProperties(prefix = "spring.datasource")
	    public DataSource druid() {
			DruidDataSource druidDataSource = new DruidDataSource();
			return druidDataSource;
	    }


	 
}
