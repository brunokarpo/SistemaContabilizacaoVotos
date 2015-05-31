package br.ufg.si.poo.procesadorEntrada.implArquivo;

import br.ufg.si.poo.procesadorEntrada.AbstractProcessadorEntrada;
import br.ufg.si.poo.procesadorEntrada.IMecanismoEntrada;

public class ArquivoProcessadorEntrada extends AbstractProcessadorEntrada {

	@Override
	protected IMecanismoEntrada getMecanismoEntrada() {
		return new ArquivoMecanismoEntrada();
	}

}
