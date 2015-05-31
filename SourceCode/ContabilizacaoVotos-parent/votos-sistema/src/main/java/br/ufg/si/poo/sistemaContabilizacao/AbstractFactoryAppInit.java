package br.ufg.si.poo.sistemaContabilizacao;

import br.ufg.si.poo.procesadorEntrada.AbstractProcessadorEntrada;
import br.ufg.si.poo.processadorResultado.AbstractProcessadorVotos;
import br.ufg.si.poo.votoFila.AbstractEnfilerador;

public interface AbstractFactoryAppInit {

	public AbstractEnfilerador criarFilas() ;

	public AbstractProcessadorEntrada criarMecanismoEntrada() ;

	public AbstractProcessadorVotos criarProcessadorVotos() ;

}
