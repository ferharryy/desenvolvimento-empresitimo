package br.com.cresol.desafio.repository;

import org.springframework.stereotype.Component;

import br.com.cresol.desafio.model.SimulacaoEmprestimo;

@Component
public interface ISimulacaoEmprestimoRepository {
	
	public void salvar(SimulacaoEmprestimo s);
	
	public void deletarPorId(Long numeroContrato);

}
