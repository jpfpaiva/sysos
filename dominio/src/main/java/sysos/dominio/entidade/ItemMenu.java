package sysos.dominio.entidade;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity 
@Table (name="ITEM_MENU")
public class ItemMenu extends EntidadeJPA {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name = "ID")
	private Long id;
	
	@Column(name= "NOME", nullable=false, unique=true)
	private String nome;
	
	@OneToOne
	@JoinColumn(name="ID_TELA")
	private Tela tela;
	
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
