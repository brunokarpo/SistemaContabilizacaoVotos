package br.ufg.si.poo.votoFila;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import br.ufg.si.poo.entidades.Candidato;
import br.ufg.si.poo.votoFila.exceptions.FilaVaziaException;
import br.ufg.si.poo.votoFila.exceptions.InserirNaFilaException;

/**
 * @author Bruno Nogueira<br>
 *
 * <p>Classe abstrata responsável por implementar o mecanismo de fila usando o pattern Factory Method;
 *
 * @version 1.0.0
 *
 */
public abstract class AbstractEnfilerador {

	private static final Logger LOG = LoggerFactory.getLogger(AbstractEnfilerador.class);

	/**
	 * Método que delega a implementação da fila para a subclasse;
	 * @return mecanismo de fila utilizado na execução do programa;
	 */
	protected abstract IMecanismoFila getFila() ;

	/**
	 * <p>Metodo responsavel por enfileirar um voto.<br>
	 * Deve conter uma implementacao que impeca a perda do voto caso o mesmo nao possa ser inserido
	 * @param voto a ser inserido
	 */
	public final void enfileirarVoto(Candidato voto) {
		try {
			LOG.info("Inserindo voto na fila para processamento");
			getFila().colocarNaFila(voto);
			LOG.info("Voto inserido com sucesso");
		} catch (InserirNaFilaException e) {
			LOG.error("Problema ao inserir voto na fila", e);
			enfileirarVoto(voto); // Nao eh a melhor estrategia forcar a insercao, mas por enquanto vamos usa-la
		}
	}

	/**
	 * <p>Metodo responsavel por pegar um candidato votado da fila para procesar
	 * @return Candidato que recebeu o voto
	 * @throws FilaVaziaException lancada quando nao existe nenhum candidato na fila;
	 */
	public final Candidato desinfileiraVoto() throws FilaVaziaException {
		return getFila().retirarDaFila();
	}

}
