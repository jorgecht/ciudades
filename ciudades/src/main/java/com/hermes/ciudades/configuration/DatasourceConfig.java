package com.hermes.ciudades.configuration;

import javax.sql.DataSource;

import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration


public class DatasourceConfig {
	
	@Bean
	public DataSource getDataSource() {
        DataSourceBuilder<?> dataSourceBuilder = DataSourceBuilder.create();
        dataSourceBuilder.driverClassName("oracle.jdbc.OracleDriver");
        dataSourceBuilder.url("jdbc:oracle:thin:@//localhost:1521/orcl");
        dataSourceBuilder.username("ORACLEJ");
        dataSourceBuilder.password("maskedhero2");
        return (DataSource) dataSourceBuilder.build();
    }

}
