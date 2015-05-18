package sysos.persistencia.config;

import java.sql.SQLException;
import java.util.Properties;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.apache.log4j.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.orm.hibernate4.HibernateExceptionTranslator;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;

import com.mchange.v2.c3p0.ComboPooledDataSource;

	
public abstract class DataSourceConfig {

	
	private static final Logger log = Logger.getLogger(DataSourceConfig.class);

	// EntityManagerFactory
	@Bean
	public EntityManagerFactory entityManagerFactory(DataSource dataSource, JpaConfig jpaConfig) throws SQLException {
		
		log.info(" Inicializando Bean EntityManager Factory ... ");

		// Provedor JPA - Neste caso o Hibernate
		HibernateJpaVendorAdapter jpaVendorAdapter = new HibernateJpaVendorAdapter();
		jpaVendorAdapter.setGenerateDdl(jpaConfig.isGerarDDL());
		jpaVendorAdapter.setShowSql(jpaConfig.isShowSQL());
		jpaVendorAdapter.setDatabasePlatform(jpaConfig.getDialect());

		// Configura��es adicionais da JPA
		Properties configJpaHibernate = new Properties();
		configJpaHibernate.put("hibernate.hbm2ddl.auto", jpaConfig.getAutoCreate());
		configJpaHibernate.put("hibernate.format_sql", jpaConfig.isFormatSQL());
		configJpaHibernate.put("hibernate.show_sql", jpaConfig.isShowSQL());
		configJpaHibernate.put("hibernate.dialect", jpaConfig.getDialect());
		
		// EntityManagerFactory
		LocalContainerEntityManagerFactoryBean factory = new LocalContainerEntityManagerFactoryBean();
		factory.setJpaVendorAdapter(jpaVendorAdapter);
		factory.setPackagesToScan(jpaConfig.getPacoteRaizEntidades());
		factory.setDataSource(dataSource);
		factory.setJpaProperties(configJpaHibernate);
		factory.afterPropertiesSet();
		
		return factory.getObject();
	}
	
	
	protected ComboPooledDataSource getDataSourceDefault() {
		return new ComboPooledDataSource();
	}

	
	// EntityManger - save, merge, update, delete
	@Bean
	public EntityManager entityManager(EntityManagerFactory entityManagerFactory) throws SQLException {
		log.info(" Inicializando Bean EntityManager ... ");
		return entityManagerFactory.createEntityManager();
	}

	
	// @Transaction
	@Bean
	public PlatformTransactionManager transactionManager(EntityManagerFactory entityManagerFactory) throws SQLException {
		log.info(" Inicializando Bean Transaction ... ");
		return new JpaTransactionManager(entityManagerFactory);
	}

	
	// Exception Hibernate Translator do Spring
	@Bean
	public HibernateExceptionTranslator hibernateExceptionTranslator() {
		log.info(" Inicializando Bean Hibernate Exception ... ");
		return new HibernateExceptionTranslator();
	}
	
	

}
