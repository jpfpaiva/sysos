package sysos.persistencia.entidade;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.Version;

import org.apache.commons.lang.builder.ReflectionToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

@MappedSuperclass
public abstract class EntidadeJPA implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Version
	@Column(nullable = false, name = "VERSAO_CONTRL_ENTIDADE")
	private Long versaoControleEntidade;
		
	public abstract String descricaoResumida();
	
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
