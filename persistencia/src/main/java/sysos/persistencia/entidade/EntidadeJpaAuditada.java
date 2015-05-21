package sysos.persistencia.entidade;

import java.sql.Timestamp;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import javax.persistence.PreRemove;
import javax.persistence.PreUpdate;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;

@SuppressWarnings("serial")
@MappedSuperclass
public abstract class EntidadeJpaAuditada extends EntidadeJPA {
	
	@CreatedBy
	@ManyToOne
	@JoinColumn (name="ID_USUARIO")
	private UsuarioSistema usuarioSistema;
	
	@CreatedDate
	private Date criadoData;
	
	@Column(nullable = false, name = "DATA_ULTIMA_ALTERACAO")
	private Timestamp dataUltimaAlteracao;

	@PrePersist
    protected void antesPersistir() {
        this.dataUltimaAlteracao = new Timestamp(System.currentTimeMillis());
    }

    @PreUpdate
    protected void antesAtualizar() {
    	 this.dataUltimaAlteracao = new Timestamp(System.currentTimeMillis());
    }
    
    @PreRemove
    protected void antesRemover() {
    	 this.dataUltimaAlteracao = new Timestamp(System.currentTimeMillis());
    }

}
