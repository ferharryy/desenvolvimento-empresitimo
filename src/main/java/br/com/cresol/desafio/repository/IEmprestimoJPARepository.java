package br.com.cresol.desafio.repository;

import org.springframework.data.repository.CrudRepository;

import br.com.cresol.desafio.model.ContratarEmprestimo;

/**
 * @author fernando
 *
 */
public interface IEmprestimoJPARepository extends CrudRepository<ContratarEmprestimo, Long> {
}