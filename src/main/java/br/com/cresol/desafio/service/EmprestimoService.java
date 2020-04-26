package br.com.cresol.desafio.service;

import java.math.BigInteger;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.cresol.desafio.dto.SimularEmprestimoPayload;
import br.com.cresol.desafio.model.Cliente;
import br.com.cresol.desafio.model.ContratarEmprestimo;
import br.com.cresol.desafio.model.ParcelaEmprestimo;
import br.com.cresol.desafio.model.SimulacaoEmprestimo;
import br.com.cresol.desafio.repository.EmprestimoRepository;
import br.com.cresol.desafio.repository.IClienteJPARepository;
import br.com.cresol.desafio.repository.IClienteRepository;
import br.com.cresol.desafio.repository.IEmprestimoJPARepository;
import br.com.cresol.desafio.repository.IEmprestimoRepository;
import br.com.cresol.desafio.repository.IParcelaJPARepository;
import br.com.cresol.desafio.repository.IParcelaRepository;
import br.com.cresol.desafio.repository.ISimulacaoEmprestimoJPARepository;
import br.com.cresol.desafio.repository.ISimulacaoEmprestimoRepository;
import br.com.cresol.desafio.repository.ParcelaRepository;
import br.com.cresol.desafio.repository.SimulacaoEmprestimoRepository;

/**
 * @author fernando
 *
 */

@Service
public class EmprestimoService {

	 @Autowired
	 private IClienteRepository clienteRepository;
	 
	 @Autowired
	 private ISimulacaoEmprestimoRepository simulacaoRepository;
	 
	 @Autowired
	 private IEmprestimoRepository emprestimoRepository;
	 
	 @Autowired
	 private IParcelaRepository parcelaRepository;
	 
	 @PersistenceContext
	 private EntityManager entityManager;

	 /**
	  * Cria e salva simulacao de emprestimo.
	  *
	  * @return SimulacaoEmprestimo the SimulacaoEmprestimo 
	  */
	 public SimulacaoEmprestimo simular(SimularEmprestimoPayload payload) {
		 SimulacaoEmprestimo simulacaoEmprestimo = SimulacaoEmprestimo.get(payload, sequence());
		 Cliente cliente = Cliente.get(payload);
		
		 clienteRepository.salvar(cliente);
		 
		 simulacaoRepository.salvar(simulacaoEmprestimo);
		 
		 return simulacaoEmprestimo;
	 }
	 
	 /**
	  * Retorna Sequence.
	  *
	  * @return sequence the sequence 
	  */
	 private Long sequence() {
	     Query query = entityManager.createNativeQuery("SELECT nextval('serial');");

	     return ((BigInteger)query.getSingleResult()).longValue();

	 }
		
	 /**
	  * Contrata Emprestimo.
	  *
	  * @param payload the payload 
	  */
	 public ContratarEmprestimo contratar(SimulacaoEmprestimo payload) {
		 ContratarEmprestimo emprestimo = ContratarEmprestimo.get(payload);
		 List<ParcelaEmprestimo> parcelas = ParcelaEmprestimo.get(payload);
		 
		 emprestimoRepository.salvar(emprestimo);
		 
		 parcelas.stream().forEach(parcela -> salvarParcela(parcela));
		 
		 return emprestimo;
	 }
	 
	 /**
	  * Salva Parcela.
	  *
	  * @param parcela the parcela 
	  */
	 public void salvarParcela(final ParcelaEmprestimo parcela) {
		 parcelaRepository.salvar(parcela);
	 }

	 /**
	  * Deleta Simulacao.
	  *
	  * @param numeroContrato the numeroContrato 
	  */
	 public void deletarSimulacao(final Long numeroContrato) {
		 simulacaoRepository.deletarPorId(numeroContrato);
	 }
}
