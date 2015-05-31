package br.ufg.si.poo.processadorResultado.armazenadorMemoriaImpl;

import br.ufg.si.poo.processadorResultado.AbstractProcessadorVotos;
import br.ufg.si.poo.processadorResultado.IArmazenadorVotos;

public class ProcessadorVotosMemoria extends AbstractProcessadorVotos {

	@Override
	protected IArmazenadorVotos getArmazenadorVotos() {
		return ArmazenadorVotosMemoria.getArmazenadorVotosMemoria();
	}

}
