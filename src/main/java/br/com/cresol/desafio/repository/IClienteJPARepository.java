package br.com.cresol.desafio.repository;

import org.springframework.data.repository.CrudRepository;

import br.com.cresol.desafio.model.Cliente;

/**
 * @author fernando
 *
 */
public interface IClienteJPARepository extends CrudRepository<Cliente, Long> {
}