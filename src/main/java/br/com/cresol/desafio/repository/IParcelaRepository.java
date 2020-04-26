package br.com.cresol.desafio.repository;

import org.springframework.stereotype.Component;

import br.com.cresol.desafio.model.ParcelaEmprestimo;

@Component
public interface IParcelaRepository {

	public void salvar(ParcelaEmprestimo p); 
}
