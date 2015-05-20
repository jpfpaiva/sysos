package sysos.dominio.entidade;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity 
@Table (name="MENU_PRINCIPAL")
public class MenuPrincipal extends EntidadeJPA {
	
	private static final long serialVersionUID = 1L;
	
	
	@Id
	@Column(name = "ID")
	private Long id;
	
	@Column(name = "NOME", nullable=false, unique=true)
	private String nome;
	
	@OneToMany
	@JoinColumn (name="ID_MENU_PRINCIPAL")  // Será permitido apenas submenus, e não itens também, no menu principal por questões de organição.
	private Set<SubMenu> subMenus; 			// Um Item deverá estar dentro um submenu (Contas, Oficina, Vendas) 

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
