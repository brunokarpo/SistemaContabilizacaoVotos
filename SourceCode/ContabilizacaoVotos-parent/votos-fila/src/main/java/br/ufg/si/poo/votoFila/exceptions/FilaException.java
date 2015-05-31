package br.ufg.si.poo.votoFila.exceptions;

/**
 * @author Bruno Nogueira<br>
 *
 * <p>Exception base da estrutura de exceptions das Filas;
 *
 * @version 1.0.0
 */
public class FilaException extends Exception {

	/**
	 *
	 */
	private static final long serialVersionUID = -6928475051000401348L;

	public FilaException() {
		super();
	}

	public FilaException(String message) {
		super(message);
	}
}
