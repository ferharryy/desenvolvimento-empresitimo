package br.com.cresol.desafio.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import br.com.cresol.desafio.model.ContratarEmprestimo;

@Repository
public class EmprestimoRepository implements IEmprestimoRepository{
	
	@Autowired
	IEmprestimoJPARepository repository;

	@Override
	public void salvar(ContratarEmprestimo e) {
		repository.save(e);
	}

}
