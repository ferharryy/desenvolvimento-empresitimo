package br.com.cresol.desafio.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import br.com.cresol.desafio.model.SimulacaoEmprestimo;

@Repository
public class SimulacaoEmprestimoRepository implements ISimulacaoEmprestimoRepository{

	@Autowired
	ISimulacaoEmprestimoJPARepository repository;
	
	@Override
	public void salvar(SimulacaoEmprestimo s) {
		repository.save(s);
	}

	@Override
	public void deletarPorId(Long numeroContrato) {
		repository.deleteById(numeroContrato);
	}

}
