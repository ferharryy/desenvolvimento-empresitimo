package br.com.cresol.desafio.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import br.com.cresol.desafio.model.Cliente;

@Repository
public class ClienteRepository implements IClienteRepository{

	@Autowired
	private IClienteJPARepository repository;
	
	@Override
	public void salvar(Cliente c) {
		repository.save(c);
	}
}
