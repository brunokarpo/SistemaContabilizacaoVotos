package br.ufg.si.poo.processadorResultado.armazenadorMemoriaImpl;

import java.util.ArrayList;
import java.util.List;

import br.ufg.si.poo.entidades.Candidato;
import br.ufg.si.poo.processadorResultado.IArmazenadorVotos;
import br.ufg.si.poo.processadorResultado.modeloLocal.Voto;

public class ArmazenadorVotosMemoria implements IArmazenadorVotos {

	private static ArmazenadorVotosMemoria memoria;

	private List<Voto> votosProcessados;

	private ArmazenadorVotosMemoria() {
		votosProcessados = new ArrayList<Voto>();
	}

	public static ArmazenadorVotosMemoria getArmazenadorVotosMemoria() {
		if(memoria == null) {
			memoria = new ArmazenadorVotosMemoria();
		}
		return memoria;
	}

	public boolean candidatoJaVotado(Candidato candidatoVotado) {
		Voto temp = new Voto(candidatoVotado);

		if(votosProcessados.contains(temp)) {
			return true;
		}

		return false;
	}

	public void adicionarNovoVoto(Voto voto) {
		votosProcessados.add(voto);
	}

	public void incrementarUmVotoParaCandidato(Candidato candidato) {
		Voto temp = new Voto(candidato);
		Voto determinante = votosProcessados.get( votosProcessados.indexOf(temp) );
		determinante.incrementarVotoEmUm();
	}

}
