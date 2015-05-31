package br.ufg.si.poo.processadorResultado.modeloLocal;

import br.ufg.si.poo.entidades.Candidato;

public class Voto {

	private Candidato candidato;
	private int quantidadeVotosRecebidos;

	public Voto() {
		quantidadeVotosRecebidos = 0;
	}

	public Voto(Candidato candidato) {
		this.candidato = candidato;
		quantidadeVotosRecebidos = 0;
	}

	/**
	 * @return the candidato
	 */
	public Candidato getCandidato() {
		return candidato;
	}

	/**
	 * @param candidato the candidato to set
	 */
	public void setCandidato(Candidato candidato) {
		this.candidato = candidato;
	}

	/**
	 * @return the quantidadeVotosRecebidos
	 */
	public int getQuantidadeVotosRecebidos() {
		return quantidadeVotosRecebidos;
	}

	public void incrementarVotoEmUm() {
		quantidadeVotosRecebidos++;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((candidato == null) ? 0 : candidato.hashCode());
		return result;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Voto other = (Voto) obj;
		if (candidato == null) {
			if (other.candidato != null)
				return false;
		} else if (!candidato.equals(other.candidato))
			return false;
		return true;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Voto [candidato=" + candidato + ", quantidadeVotosRecebidos="
				+ quantidadeVotosRecebidos + "]";
	}


}
