package sysos.persistencia.entidade;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;

@Entity 
@Table (name="USUARIO")
public class UsuarioSistema extends EntidadeJPA {
	
	private static final long serialVersionUID = 1L;
	
	private static final String NOME_SEQ = "USUARIO_SEQ";
	
	@Id
	@SequenceGenerator(name=NOME_SEQ, sequenceName=NOME_SEQ)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator=NOME_SEQ)
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
	
	public UsuarioSistema() {
	}
	
	public UsuarioSistema(String nome, String sobrenome, String senha, String email, MenuPrincipal menu) {
		super();
		this.nome = nome;
		this.sobrenome = sobrenome;
		this.senhaHash = senha;
		this.email = email;
		this.menuPrincipal = menu;
	}
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSobrenome() {
		return sobrenome;
	}

	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}

	public String getSenhaHash() {
		return senhaHash;
	}

	public void setSenhaHash(String senhaHash) {
		this.senhaHash = senhaHash;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public MenuPrincipal getMenuPrincipal() {
		return menuPrincipal;
	}

	public void setMenuPrincipal(MenuPrincipal menuPrincipal) {
		this.menuPrincipal = menuPrincipal;
	}

	public byte[] getFoto() {
		return foto;
	}

	public void setFoto(byte[] foto) {
		this.foto = foto;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Override
	public Long getId() {
		return id;
	}

	@Override
	public String descricaoResumida() {
		return null;
	}

}
