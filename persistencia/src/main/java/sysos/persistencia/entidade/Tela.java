package sysos.persistencia.entidade;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity 
@Table (name="TELA")
public class Tela extends EntidadeJPA {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	private Long id;
	
	@Column(name= "NOME", nullable=false, unique=true)
	private String nome;
	
	@Column(name= "PATH", nullable=false, unique=true)
	private String path;
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	@Override
	public String descricaoResumida() {
		// TODO Auto-generated method stub
		return null;
	}
}
