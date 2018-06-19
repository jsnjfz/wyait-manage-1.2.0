package com.wyait.manage.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import java.util.Properties;

@Configuration
@EnableJpaRepositories(entityManagerFactoryRef = "mysqlEntityManagerFactory", transactionManagerRef = "jpaTransactionManager", basePackages = { "com.wyait.manage.repository" })
public class JPAConfig {
	@Bean(name = "mysqlEntityManagerFactory")
	@Autowired
	@Qualifier("testDataSource")
	public EntityManagerFactory entityManagerFactory(DataSource datasource) {
		HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
		vendorAdapter.setGenerateDdl(true);
		vendorAdapter.setShowSql(true);
		LocalContainerEntityManagerFactoryBean factory = new LocalContainerEntityManagerFactoryBean();
		factory.setJpaVendorAdapter(vendorAdapter);
		factory.setDataSource(datasource);
		factory.setPackagesToScan("com.wyait.manage.entity");
		Properties jpaProperties = new Properties();
		jpaProperties.put("hibernate.ejb.naming_strategy", "org.hibernate.cfg.ImprovedNamingStrategy");//命名策略
		factory.setJpaProperties(jpaProperties);
		factory.afterPropertiesSet();
		return factory.getObject();

	}

	@Bean(name = "testDataSource")
	@ConfigurationProperties(prefix = "slave.datasource.test")// prefix值必须是application.properteis中对应属性的前缀
	public DataSource testDataSource() {
		return DataSourceBuilder.create().build();
	}


//	@Bean(name = "mysqlTransactionManager")
//	public PlatformTransactionManager transactionManagerSecondary() {
//		JpaTransactionManager txManager = new JpaTransactionManager();
//		txManager.setEntityManagerFactory(entityManagerFactory(testDataSource()));
//		return txManager;
//	}

	@Bean
	@Qualifier(value = "jpaTransactionManager")
	public JpaTransactionManager transactionManager(EntityManagerFactory emf) {
		return new JpaTransactionManager(emf);
	}

}
