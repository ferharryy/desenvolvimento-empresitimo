package br.com.cresol.desafio.repository;

import org.springframework.stereotype.Component;

import br.com.cresol.desafio.model.ContratarEmprestimo;

@Component
public interface IEmprestimoRepository {
	
	public void salvar(ContratarEmprestimo e);

}
