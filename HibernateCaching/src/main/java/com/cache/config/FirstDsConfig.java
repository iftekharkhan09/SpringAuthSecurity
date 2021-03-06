package com.cache.config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import static java.util.Collections.singletonMap;

@Configuration
@EnableJpaRepositories(entityManagerFactoryRef = "firstEntityManagerFactory", transactionManagerRef = "firstTransactionManager", basePackages = "com.marcosbarbero.wd.pcf.multidatasources.first.repository")
@EnableTransactionManagement
public class FirstDsConfig {
	@Primary
	@Bean(name = "firstEntityManagerFactory")
	public LocalContainerEntityManagerFactoryBean firstEntityManagerFactory(final EntityManagerFactoryBuilder builder,
			final @Qualifier("first-db") DataSource dataSource) {
		return builder.dataSource(dataSource).packages("com.marcosbarbero.wd.pcf.multidatasources.first.domain")
				.persistenceUnit("firstDb").properties(singletonMap("hibernate.hbm2ddl.auto", "create-drop")).build();
	}

	@Primary
	@Bean(name = "firstTransactionManager")
	public PlatformTransactionManager firstTransactionManager(
			@Qualifier("firstEntityManagerFactory") EntityManagerFactory firstEntityManagerFactory) {
		return new JpaTransactionManager(firstEntityManagerFactory);
	}

}