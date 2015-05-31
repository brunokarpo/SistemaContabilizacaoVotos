package br.ufg.si.poo.procesadorEntrada;

import java.util.List;

import br.ufg.si.poo.entidades.Candidato;
import br.ufg.si.poo.votoFila.AbstractEnfilerador;

/**
 * @author Bruno Nogueira<br>
 *
 * <p>Classe abstrata responsavel por fazer o procesamento dos dados recebidos na entrada;
 *
 * @version 1.0.0
 *
 */
public abstract class AbstractProcessadorEntrada {

	/**
	 * Metodo responsavel por pegar a implementacao de mecanismo de fila da aplicacao
	 * @return implementacao de IMecanismoEntrada
	 */
	protected abstract IMecanismoEntrada getMecanismoEntrada() ;

	public final void processar(AbstractEnfilerador enfileirador) {

		List<Candidato> votos = getMecanismoEntrada().capturarEntrada();

		for(Candidato voto : votos) {
			enfileirador.enfileirarVoto(voto);
		}
	}

}
