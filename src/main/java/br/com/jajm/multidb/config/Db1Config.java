package br.com.jajm.multidb.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;

@Configuration
@EnableJpaRepositories(
		basePackages = "br.com.jajm.multidb.repository.db1",
		entityManagerFactoryRef = "db1EntityManager"
		)
public class Db1Config {
	
	@Bean
	@Primary
	@ConfigurationProperties(prefix = "db1.datasource")
	public DataSource db1DataSource() {
		return DataSourceBuilder.create().build();
	}
	
	@Bean
	@Primary
	public LocalContainerEntityManagerFactoryBean db1EntityManager(EntityManagerFactoryBuilder builder, 
			@Qualifier("db1DataSource") DataSource dataSource) {
		return builder
				.dataSource(dataSource)
				.packages("br.com.jajm.multidb.model.db1")
				.build();
	}

}
