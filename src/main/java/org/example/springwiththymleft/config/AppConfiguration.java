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
        dataSource.setUrl("jdbc:postgresql://aws-1-ap-southeast-1.pooler.supabase.com/postgres");
        dataSource.setUsername("postgres.vhgybkxnjecfnpvmgfwo");
        dataSource.setPassword("Zerogg1688$");
        return dataSource;
    }
}
