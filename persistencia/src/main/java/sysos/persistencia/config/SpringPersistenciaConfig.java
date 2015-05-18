package sysos.persistencia.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;



@Configuration
@Import({DatasourcePostgresqlConfig.class})
public class SpringPersistenciaConfig {
	

}
