package br.com.cresol.desafio.repository;

import org.springframework.data.repository.CrudRepository;

import br.com.cresol.desafio.model.SimulacaoEmprestimo;

/**
 * @author fernando
 *
 */
public interface ISimulacaoEmprestimoJPARepository extends CrudRepository<SimulacaoEmprestimo, Long> {
}