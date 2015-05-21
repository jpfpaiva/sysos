package sysos.persistencia.entidade;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity 
@Table (name="MENU_PRINCIPAL")
public class MenuPrincipal extends EntidadeJPA {
	
	private static final long serialVersionUID = 1L;
	
	private static final String NOME_SEQ = "MENU_PRINCIPAL_SEQ";

	@Id
	@SequenceGenerator(name=NOME_SEQ, sequenceName=NOME_SEQ)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator=NOME_SEQ)
	@Column(name = "ID")
	private Long id;
	
	@Column(name = "NOME", nullable=false, unique=true)
	private String nome;
	
	@OneToMany
	@JoinColumn (name="ID_MENU_PRINCIPAL")  // Será permitido apenas submenus, e não itens também, no menu principal por questões de organição.
	private Set<SubMenu> subMenus; 			// Um Item deverá estar dentro um submenu (Contas, Oficina, Vendas)
	
	public MenuPrincipal() { 
	}
	
	public MenuPrincipal(String nome) {
		super();
		this.nome = nome;
	}

	@Override
	public Long getId() {
		return id;
	}

	@Override
	public String descricaoResumida() {
		// TODO Auto-generated method stub
		return null;
	}

}
