package sysos.persistencia.boot;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;
import org.springframework.transaction.annotation.Transactional;

import sysos.persistencia.config.SpringPersistenciaConfig;
import sysos.persistencia.dao.MenuPrincipalDAO;
import sysos.persistencia.dao.UsuarioSistemaDAO;
import sysos.persistencia.entidade.MenuPrincipal;
import sysos.persistencia.entidade.QUsuarioSistema;
import sysos.persistencia.entidade.UsuarioSistema;


@Import({SpringPersistenciaConfig.class})
@ComponentScan({"sysos.persistencia.*"})
public class Boot implements CommandLineRunner {
	
	private static final Logger log = Logger.getLogger(Boot.class);
	
	public static void main(String[] args) {
		SpringApplication.run(Boot.class, args);
	}

	@Override
	public void run(String... arg0) throws Exception {
		log.info("Inicializando Camada Persistência ... ");
		teste();
	}
	
	
	@Autowired
	UsuarioSistemaDAO userDao;
	
	@Autowired
	MenuPrincipalDAO menuDao;
	
	static QUsuarioSistema qUser = QUsuarioSistema.usuarioSistema;
	
	@Transactional
	void teste() {
		
		MenuPrincipal menu = new MenuPrincipal("MenuAdminstrador");
		menuDao.save(menu);
		
		UsuarioSistema user = new UsuarioSistema("Daniel", "Sava Pupak", "123456" ,"danielsavas@gmail.com", menu);
		userDao.save(user);
		
		for (UsuarioSistema u : userDao.findAll(qUser.nome.containsIgnoreCase("dan"))) {
			System.out.println(" Nome: " + u.getNome());
			System.out.println(" SobreNome: " + u.getSobrenome());
			System.out.println(" Senha: " + u.getSenhaHash());
			System.out.println(" Email: " + u.getEmail());
		}
		
		
		
	}

}
