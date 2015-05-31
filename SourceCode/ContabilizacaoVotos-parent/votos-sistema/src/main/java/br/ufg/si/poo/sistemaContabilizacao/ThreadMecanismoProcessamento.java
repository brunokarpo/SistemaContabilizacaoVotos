package br.ufg.si.poo.sistemaContabilizacao;

import br.ufg.si.poo.processadorResultado.AbstractProcessadorVotos;
import br.ufg.si.poo.votoFila.AbstractEnfilerador;

public class ThreadMecanismoProcessamento implements Runnable {

	private AbstractEnfilerador fila;
	private AbstractProcessadorVotos processadorVotos;

	public ThreadMecanismoProcessamento(AbstractProcessadorVotos processadorVotos, AbstractEnfilerador fila) {
		this.fila = fila;
		this.processadorVotos = processadorVotos;
	}

	public void run() {
		processadorVotos.processarVotos(fila);
	}

}
