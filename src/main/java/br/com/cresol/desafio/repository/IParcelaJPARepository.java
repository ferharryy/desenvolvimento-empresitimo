package br.com.cresol.desafio.repository;

import org.springframework.data.repository.CrudRepository;

import br.com.cresol.desafio.model.ParcelaEmprestimo;

/**
 * @author fernando
 *
 */
public interface IParcelaJPARepository extends CrudRepository<ParcelaEmprestimo, Long> {
}