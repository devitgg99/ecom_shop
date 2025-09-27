package org.example.springwiththymleft.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

@Configuration
public class AppConfiguration {
    @Bean
    public DataSource getDataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setUrl("jdbc:postgresql://35.240.149.171:5433/ecom_db");
        dataSource.setUsername("admin");
        dataSource.setPassword("Zerogg168");
        return dataSource;
    }
}
