package br.com.jajm.multidb.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;

@Configuration
@EnableJpaRepositories(
		basePackages = "br.com.jajm.multidb.repository.db2",
		entityManagerFactoryRef = "db2EntityManager"
		)
public class Db2Config {
	
	@Bean
	@ConfigurationProperties(prefix = "db2.datasource")
	public DataSource db2DataSource() {
		return DataSourceBuilder.create().build();
	}
	
	@Bean
	// @Primary
	public LocalContainerEntityManagerFactoryBean db2EntityManager(EntityManagerFactoryBuilder builder, 
			@Qualifier("db2DataSource") DataSource dataSource) {
		return builder
				.dataSource(dataSource)
				.packages("br.com.jajm.multidb.model.db2")
				.build();
	}

}
