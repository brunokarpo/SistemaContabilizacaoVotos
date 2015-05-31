package br.ufg.si.poo.votoFila.filaMemoriaImp;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import br.ufg.si.poo.entidades.Candidato;
import br.ufg.si.poo.votoFila.IMecanismoFila;
import br.ufg.si.poo.votoFila.exceptions.FilaVaziaException;
import br.ufg.si.poo.votoFila.exceptions.InserirNaFilaException;

/**
 * @author Bruno Nogueira<br>
 *
 * <p>Classe responsavel por criar um mecanismo de fila em memoria utilizando Listas.
 * <p>Utiliza o padrao Singleton para evitar criacao desnecessaria de filas;
 *
 * @version 1.0.0
 */
public class MecanismoLista implements IMecanismoFila {

	private static final Logger LOG = LoggerFactory.getLogger(MecanismoLista.class);
	private static MecanismoLista filaVotos;

	private List<Candidato> filaCandidatos;

	/*
	 * Singleton
	 */
	private MecanismoLista() {
		filaCandidatos = new ArrayList<Candidato>();
	}

	/**
	 * Metodo estatico responsavel por retornar a instancia do mecanismo de fila utilizando Listas em memoria
	 * @return MecanismoLista
	 */
	protected static MecanismoLista getFilaVotos() {
		if(filaVotos == null) {
			LOG.debug("Nao existe nenhum mecanismo de fila instanciado ainda. Vou instanciar um");
			filaVotos = new MecanismoLista();
		}
		return filaVotos;
	}

	public void colocarNaFila(Candidato voto) throws InserirNaFilaException {
		LOG.info("Adicionando voto a fila");
		filaCandidatos.add(voto);
		LOG.info("Log inserido com sucesso");
	}

	public Candidato retirarDaFila() throws FilaVaziaException {
		Candidato candidato;

		try {
			LOG.info("Pegando o proximo candidato da fila");
			candidato = filaCandidatos.get(0);
			LOG.info("Candidato capturado. Retirando da fila");
			filaCandidatos.remove(0);
		} catch(IndexOutOfBoundsException e) {
			LOG.warn("Nao tem nenhum voto na fila agora.");
			throw new FilaVaziaException("Nao tem nenhum voto na fila para ser consumido");
		}

		LOG.debug("Candidato capturado da fila: " + candidato);
		return candidato;
	}

}
