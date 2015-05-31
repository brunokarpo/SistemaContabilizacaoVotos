package br.ufg.si.poo.sistemaContabilizacao.implementacaoBasica;

import br.ufg.si.poo.procesadorEntrada.AbstractProcessadorEntrada;
import br.ufg.si.poo.procesadorEntrada.implArquivo.ArquivoProcessadorEntrada;
import br.ufg.si.poo.processadorResultado.AbstractProcessadorVotos;
import br.ufg.si.poo.processadorResultado.armazenadorMemoriaImpl.ProcessadorVotosMemoria;
import br.ufg.si.poo.sistemaContabilizacao.AbstractFactoryAppInit;
import br.ufg.si.poo.votoFila.AbstractEnfilerador;
import br.ufg.si.poo.votoFila.filaMemoriaImp.EnfileradorLista;

public class ConcretFactoryBasica implements AbstractFactoryAppInit {

	public AbstractEnfilerador criarFilas() {
		return new EnfileradorLista();
	}

	public AbstractProcessadorEntrada criarMecanismoEntrada() {
		return new ArquivoProcessadorEntrada();
	}

	public AbstractProcessadorVotos criarProcessadorVotos() {
		return new ProcessadorVotosMemoria();
	}

}
