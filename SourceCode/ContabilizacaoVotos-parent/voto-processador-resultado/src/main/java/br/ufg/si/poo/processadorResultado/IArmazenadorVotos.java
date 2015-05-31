package br.ufg.si.poo.processadorResultado;

import br.ufg.si.poo.entidades.Candidato;
import br.ufg.si.poo.processadorResultado.modeloLocal.Voto;

public interface IArmazenadorVotos {

	/**
	 * Valida se o candidato ja foi votado anteriormente
	 * @param voto
	 */
	boolean candidatoJaVotado(Candidato candidatoVotado);

	/**
	 * Se o candidato nunca tiver sido votado, deve incrementar um voto para ele;
	 * @param voto
	 */
	void adicionarNovoVoto(Voto voto);

	/**
	 * Incrementa um voto para candidato já votado
	 * @param candidato
	 */
	void incrementarUmVotoParaCandidato(Candidato candidato);

}
