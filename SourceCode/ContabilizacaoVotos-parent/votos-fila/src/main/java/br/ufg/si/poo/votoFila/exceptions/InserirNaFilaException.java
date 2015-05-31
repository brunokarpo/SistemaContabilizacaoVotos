package br.ufg.si.poo.votoFila.exceptions;

/**
 * @author Bruno Nogueira<br>
 *
 * <p>Exception gerada quando o mecanismo de fila não consegue
 *
 */
public class InserirNaFilaException extends FilaException {

	/**
	 *
	 */
	private static final long serialVersionUID = 8562140304012327819L;

	public InserirNaFilaException() {
		super();
	}

	public InserirNaFilaException(String message) {
		super(message);
	}

}
