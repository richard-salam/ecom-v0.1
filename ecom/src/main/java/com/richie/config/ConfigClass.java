package com.richie.config;

import java.util.Properties;
import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.beans.BeanInstantiationException;
import org.springframework.beans.factory.parsing.BeanDefinitionParsingException;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBuilder;

import com.richie.entity.EntityClass;

@Configuration
@ComponentScan(basePackages = "com.richie")
public class ConfigClass {
	
	/*private static final Logger log = Logger.getLogger(ConfigClass.class);*/
	
	@Bean(name = "dataSource")
	public DataSource getDataSource() throws BeanInstantiationException, BeanDefinitionParsingException {

		DriverManagerDataSource dataSource = new DriverManagerDataSource();

		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://localhost:3306/ecom");
		dataSource.setUsername("root");
		dataSource.setPassword("open");
				
		return dataSource;

	}

	@Bean(name = "sessionFactory")
	public SessionFactory getSessionFactory() {

		Properties hibernateProperties = new Properties();
		hibernateProperties.put("hibernate.dialect", "org.hibernate.dialect.MySQL5Dialect");
		hibernateProperties.setProperty("hibernate.show_sql", "true");
		hibernateProperties.setProperty("hibernate.format_sql", "true");
		hibernateProperties.setProperty("hibernate.hbm2ddl.auto", "update");
		

		LocalSessionFactoryBuilder localSessionFactory = new LocalSessionFactoryBuilder(getDataSource());
		localSessionFactory.addProperties(hibernateProperties);
		localSessionFactory.addAnnotatedClass(EntityClass.class);

		try {

			SessionFactory sessionFactory = localSessionFactory.buildSessionFactory();
			return sessionFactory;
		}

		catch (ExceptionInInitializerError excerptionObject) {

			excerptionObject.printStackTrace();

		}

		return null;
	}

	@Bean(name = "transactionManager")
	public HibernateTransactionManager transctMgr(SessionFactory sessionFactory)
			throws BeanInstantiationException, BeanDefinitionParsingException {

		HibernateTransactionManager hibernateTransactionManager = new HibernateTransactionManager(sessionFactory);

		return hibernateTransactionManager;
	}

}
