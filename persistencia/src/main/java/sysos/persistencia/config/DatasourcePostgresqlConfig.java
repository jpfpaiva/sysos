package sysos.persistencia.config;

import java.beans.PropertyVetoException;

import javax.sql.DataSource;

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
	
	
	@Bean
	public DataSource getDataSourcePostgresSQL() throws PropertyVetoException {
		
		
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
		
		 JpaConfig jpaVendor = new JpaConfig();
         jpaVendor.setDialect("org.hibernate.dialect.PostgreSQLDialect");  // org.hibernate.dialect.Oracle10gDialect; org.hibernate.dialect.OracleDialect 
         jpaVendor.setPacoteRaizEntidades("sysos.dominio.entidade");  // Entidades JPA - aceita vários valores
         jpaVendor.setAutoCreate(EnumAutoCreateJpa.VALIDATE);
         jpaVendor.setFormatSQL(false);
         jpaVendor.setShowSQL(false);
         jpaVendor.setGerarDDL(false);
         
         return jpaVendor;
	}

}
