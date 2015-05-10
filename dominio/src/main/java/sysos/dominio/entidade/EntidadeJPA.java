package sysos.dominio.entidade;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.Version;

import org.apache.commons.lang.builder.ReflectionToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

@MappedSuperclass
public abstract class EntidadeJPA implements Serializable {

	private static final long serialVersionUID = 1L;
	
	// Retirado do projeto Spring Java8Auditing Example. Verificar como é gerado isso no postgress
	//	 @Id @GeneratedValue
	//	 private Long id;
	
	//
	// Obriga a implementar um ID do tipo BigInteger
	public abstract Long getId();
	
	// Controle de concorrencia otimista
	@Version
	@Column(nullable = false, name = "VERSAO_CONTRL_ENTIDADE")
	private Long versaoControleEntidade;
		

	// Descrição Resumida da Entidade para mostrar em notificações.
	public abstract String descricaoResumida();
	
	
//	@Override
//	public int hashCode() {
//		return this.getId().hashCode();
//	}

//	@Override
//	public boolean equals(Object obj) {
//		if ((obj == null) 							    // Se o obj for nulo 
//				|| (this.getClass() != obj.getClass())  // Se não for da mesma Entidade 
//				|| ((EntidadeJPA) obj).getId() == null  // Se o Id for null
//			) return false;
//		
//		EntidadeJPA outraEntidade = (EntidadeJPA) obj;
//		return this.getId().equals(outraEntidade.getId());
//	}
//	
//	public int compareTo (EntidadeJPA e) {
//		return this.getId().compareTo(e.getId());
//	}
	
	@Override
	public String toString() {
		return ReflectionToStringBuilder.toString(this, ToStringStyle.SHORT_PREFIX_STYLE);
	}

	public Long getVersaoControleEntidade() {
		return versaoControleEntidade;
	}

	public void setVersaoControleEntidade(Long versaoControleEntidade) {
		this.versaoControleEntidade = versaoControleEntidade;
	}
	
}
