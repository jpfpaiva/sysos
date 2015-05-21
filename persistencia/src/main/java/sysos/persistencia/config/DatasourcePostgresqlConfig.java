package sysos.persistencia.config;

import java.beans.PropertyVetoException;

import javax.sql.DataSource;

import org.apache.log4j.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.mchange.v2.c3p0.ComboPooledDataSource;


@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(basePackages = {
		"sysos.persistencia.dao" 
		})
@ComponentScan(basePackages = {
		"sysos.persistencia.*"
})

public class DatasourcePostgresqlConfig extends DataSourceConfig {
	
	private static final Logger log = Logger.getLogger(DatasourcePostgresqlConfig.class);
	
	private static final String PACOTE_ENTIDADE_JPA = "sysos.persistencia.entidade";
	
	@Bean
	public DataSource getDataSourcePostgresSQL() throws PropertyVetoException {
		
		log.info("\n Inicializando Bean DataSource Postgresql ... \n");
		
		ComboPooledDataSource datasource = getDataSourceDefault();
		
		datasource.setDriverClass("org.postgresql.Driver"); 
		
		datasource.setJdbcUrl("jdbc:postgresql://localhost:5432/sysos");
		datasource.setUser("postgres");
		datasource.setPassword("123456");
		
		datasource.setInitialPoolSize(1);
		datasource.setMinPoolSize(0);
		datasource.setMaxPoolSize(14);
		datasource.setAcquireIncrement(1);
		datasource.setAcquireRetryAttempts(7);
		datasource.setAcquireRetryDelay(15 * 1000); // 15 s
		datasource.setIdleConnectionTestPeriod(60 * 30); // 30 min
		datasource.setMaxIdleTime(60 * 1); // 2 min
		datasource.setMaxConnectionAge(60 * 60); // 60 min
		datasource.setIdleConnectionTestPeriod(60 * 2); // 2 min
		datasource.setCheckoutTimeout(5 * 1000); // 5 seconds
		
		// datasource.setTestConnectionOnCheckin(true);
		// datasource.setPreferredTestQuery("select 1 from dual");
		// datasource.setTestConnectionOnCheckout(true);
        
        return datasource;
	}
	
	@Bean
	public JpaConfig getJpaPostgresqlConfig() {
		
		log.info("\n Inicializando Bean JpaConfig ... \n");
		
		 JpaConfig jpaVendor = new JpaConfig();
         jpaVendor.setDialect(EnumJpaDialect.POSTGRESQL); 
         jpaVendor.setPacoteRaizEntidades(PACOTE_ENTIDADE_JPA); 
         jpaVendor.setAutoCreate(EnumAutoCreateJpa.CREATE);
         jpaVendor.setFormatSQL(false);
         jpaVendor.setShowSQL(false);
         jpaVendor.setGerarDDL(false);
         
         return jpaVendor;
	}
	
}
