package com.ppmoney.asset.rms.engine;

import org.apache.commons.dbcp2.BasicDataSource;
import org.postgresql.jdbc.PgConnection;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

@SpringBootApplication // Same as @Configuration @EnableAutoConfiguration @ComponentScan
@EnableJpaRepositories(basePackages = "com.ppmoney.asset.rms.engine.repositories")
@EntityScan(basePackages = "com.ppmoney.asset.rms.engine.entity")
@EnableTransactionManagement
public class Application {
    @Bean
    public DataSource dataSource() {
        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setDriverClassName("org.postgresql.Driver");
        dataSource.setUrl("jdbc:postgresql://localhost/stg");
        dataSource.setUsername("ppmoney");
        dataSource.setPassword("ppmoney");

        return dataSource;
    }

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}