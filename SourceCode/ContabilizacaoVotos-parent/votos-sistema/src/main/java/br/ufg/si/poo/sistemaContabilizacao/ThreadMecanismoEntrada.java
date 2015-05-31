package br.ufg.si.poo.sistemaContabilizacao;

import br.ufg.si.poo.procesadorEntrada.AbstractProcessadorEntrada;
import br.ufg.si.poo.votoFila.AbstractEnfilerador;

public class ThreadMecanismoEntrada implements Runnable {

	private AbstractEnfilerador fila;
	private AbstractProcessadorEntrada mecanismoEntrada;

	ThreadMecanismoEntrada(AbstractProcessadorEntrada mecanismoEntrada, AbstractEnfilerador fila) {
		this.mecanismoEntrada = mecanismoEntrada;
		this.fila = fila;
	}

	public void run() {
		mecanismoEntrada.processar(fila);
	}

}
