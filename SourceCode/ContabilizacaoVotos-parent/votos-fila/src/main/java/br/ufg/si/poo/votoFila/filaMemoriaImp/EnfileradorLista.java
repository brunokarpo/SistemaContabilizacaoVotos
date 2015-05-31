package br.ufg.si.poo.votoFila.filaMemoriaImp;

import br.ufg.si.poo.votoFila.AbstractEnfilerador;
import br.ufg.si.poo.votoFila.IMecanismoFila;

public class EnfileradorLista extends AbstractEnfilerador {

	@Override
	protected IMecanismoFila getFila() {
		return MecanismoLista.getFilaVotos();
	}

}
