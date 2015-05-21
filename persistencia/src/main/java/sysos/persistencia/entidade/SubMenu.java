package sysos.persistencia.entidade;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity 
@Table (name="SUBMENU")
public class SubMenu extends EntidadeJPA {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name = "ID")
	private Long id;
	
	@Column(name= "NOME", nullable=false, unique=true)
	private String nome;
	
	@Column(name= "ICONE_CSS")
	private String iconeCss;
	
	@Column(name= "CSS_CLASSE")
	private String cssClasse;
	
	@ManyToOne
	@JoinColumn (name="ID_SUBMENU_PAI")
	private SubMenu menuPai; // Representa o MenuPai, do qual ele é filho. É opcional, pois ele pode ser o MenuTop (pai de todos)
	
	@OneToMany
	private Set<SubMenu> subMenus; // Representa os menus filho deste menu. Opcional.
	
	@OneToMany
	@JoinColumn(name="ID_SUBMENU")
	private Set<ItemMenu> itens;
	
	@Override
	public Long getId() {
		return null;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Set<ItemMenu> getItens() {
		return itens;
	}

	public void setItens(Set<ItemMenu> itens) {
		this.itens = itens;
	}

	public SubMenu getMenuPai() {
		return menuPai;
	}

	public void setMenuPai(SubMenu menuPai) {
		this.menuPai = menuPai;
	}

	public Set<SubMenu> getSubMenus() {
		return subMenus;
	}

	public void setSubMenus(Set<SubMenu> subMenus) {
		this.subMenus = subMenus;
	}

	public String getIconeCss() {
		return iconeCss;
	}

	public void setIconeCss(String iconeCss) {
		this.iconeCss = iconeCss;
	}

	public String getCssClasse() {
		return cssClasse;
	}

	public void setCssClasse(String cssClasse) {
		this.cssClasse = cssClasse;
	}

	@Override
	public String descricaoResumida() {
		// TODO Auto-generated method stub
		return null;
	}
}
