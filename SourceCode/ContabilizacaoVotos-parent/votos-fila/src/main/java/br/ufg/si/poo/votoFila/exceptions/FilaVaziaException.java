package br.ufg.si.poo.votoFila.exceptions;

/**
 * @author Bruno Nogueira<br>
 *
 * <p>Exceção lançada quando não existe mensagem para ser consumida da fila;
 *
 * @version 1.0.0
 *
 */
public class FilaVaziaException extends FilaException {

	/**
	 *
	 */
	private static final long serialVersionUID = -8969396664207009916L;

	public FilaVaziaException() {
		super();
	}

	public FilaVaziaException(String message) {
		super(message);
	}

}
