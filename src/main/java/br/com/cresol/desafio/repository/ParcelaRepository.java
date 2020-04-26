package br.com.cresol.desafio.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import br.com.cresol.desafio.model.ParcelaEmprestimo;

@Repository
public class ParcelaRepository implements IParcelaRepository{
	
	@Autowired
	IParcelaJPARepository repository;

	@Override
	public void salvar(ParcelaEmprestimo p) {
		repository.save(p);
	}

}
