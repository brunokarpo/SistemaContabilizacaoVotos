package br.ufg.si.poo.votoFila;

import br.ufg.si.poo.entidades.Candidato;
import br.ufg.si.poo.votoFila.exceptions.FilaVaziaException;
import br.ufg.si.poo.votoFila.exceptions.InserirNaFilaException;

/**
 * @author Bruno Nogueira<br>
 *
 * <p> Interface que providencia os mecanismos principais para o funcionamento dos mecanismos de pilha funcionar
 *
 * @version 1.0.0
 *
 */
public interface IMecanismoFila {

	/**
	 * Coloca um voto na fila para processamento;
	 * @param voto
	 * @throws {@link}InserirNaFilaException Exceção lançada por problema de inserção na fila;
	 */
	public void colocarNaFila(Candidato voto) throws InserirNaFilaException;

	/**
	 * @return um voto que está presente na fila;
	 * @throws {@link}FilaVaziaException Exceçãolançada quando a fila está vazia;
	 */
	public Candidato retirarDaFila() throws FilaVaziaException;

}
