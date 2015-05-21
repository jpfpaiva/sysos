package sysos.persistencia.entidade;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;

@Entity 
@Table (name="USUARIO")
public class UsuarioSistema extends EntidadeJPA {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name = "ID")
	private Long id;
	
	@NotNull (message="Nome é obrigatorio")
	@Size(max=20, message="Nome maior que o permitido")
	@Column(name = "NOME", nullable=false)
	private String nome;
	
	@Column(name = "SOBRENOME", nullable=false)
	private String sobrenome;
	
	@NotNull
	@Column(name = "SENHA_HASH", nullable=false)
	private String senhaHash;
	
	@Email
	@Column(name = "EMAIL")
	private String email;
	
	@ManyToOne
	@JoinColumn(name="ID_MENU_PRINCIPAL", nullable=false)
	private MenuPrincipal menuPrincipal;
	
    //Na JPA @lob transforma em Blob, se for array de bytes, ou Clob, se for array de char
	// Interessante armazenar dados Lob em outras tabelas, por serem muito grandes, e marcar com o atributo lazy.
	// Prime - StreamContent. Dela pegar o InputStrem. Usar o método da commons-io IOUtils.toByteArray (inputstream) da Apache
	@Lob
	@Column(name = "FOTO")
	@Basic (fetch=FetchType.LAZY)
	private byte [] foto;
	
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
