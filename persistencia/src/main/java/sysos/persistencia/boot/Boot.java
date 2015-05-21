package sysos.persistencia.boot;

import org.apache.log4j.Logger;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;

import sysos.persistencia.config.SpringPersistenciaConfig;


@Import({
	SpringPersistenciaConfig.class
	})
@ComponentScan({
	"sysos.persistencia.*"
	})
public class Boot implements CommandLineRunner {
	
	private static final Logger log = Logger.getLogger(Boot.class);
	
	public static void main(String[] args) {
		SpringApplication.run(Boot.class, args);
	}

	@Override
	public void run(String... arg0) throws Exception {
		log.info("Inicializando Camada Persistência ... ");
	}

}
