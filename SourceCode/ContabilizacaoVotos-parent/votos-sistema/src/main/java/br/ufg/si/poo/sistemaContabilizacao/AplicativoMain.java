package br.ufg.si.poo.sistemaContabilizacao;

import br.ufg.si.poo.procesadorEntrada.AbstractProcessadorEntrada;
import br.ufg.si.poo.processadorResultado.AbstractProcessadorVotos;
import br.ufg.si.poo.sistemaContabilizacao.implementacaoBasica.ConcretFactoryBasica;
import br.ufg.si.poo.votoFila.AbstractEnfilerador;

public class AplicativoMain {

	private AbstractEnfilerador fila;
	private AbstractProcessadorEntrada mecanismoEntrada;
	private AbstractProcessadorVotos processadorVotos;

	private void init(AbstractFactoryAppInit factory) {
		fila = factory.criarFilas();
		mecanismoEntrada = factory.criarMecanismoEntrada();
		processadorVotos = factory.criarProcessadorVotos();

		new Thread( new ThreadMecanismoEntrada(mecanismoEntrada, fila) ).start();
		new Thread( new ThreadMecanismoProcessamento(processadorVotos, fila) ).start();

	}

	public static void main(String[] args) {
		AbstractFactoryAppInit factory = new ConcretFactoryBasica();
		new AplicativoMain().init(factory);
	}

}
