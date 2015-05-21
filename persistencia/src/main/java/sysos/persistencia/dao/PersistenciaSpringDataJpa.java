package sysos.persistencia.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;
import org.springframework.data.repository.NoRepositoryBean;

import sysos.persistencia.entidade.EntidadeJPA;

@NoRepositoryBean
public interface PersistenciaSpringDataJpa <Entidade extends EntidadeJPA> extends JpaRepository<Entidade, Long>, QueryDslPredicateExecutor<Entidade> {

}
