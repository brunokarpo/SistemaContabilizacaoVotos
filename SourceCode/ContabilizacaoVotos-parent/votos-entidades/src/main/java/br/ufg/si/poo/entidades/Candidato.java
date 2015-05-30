package br.ufg.si.poo.entidades;

/**
 * @author Bruno Nogueira<br>
 *
 * <p>Entidade que comporta as informações referente a um candidato;
 *
 * @version 1.0.0
 */
public class Candidato {

	private String cargoPolitico;
	private String nome;
	private String numero;
	private String siglaPartido;

	/**
	 * @return the cargoPolitico
	 */
	public String getCargoPolitico() {
		return cargoPolitico;
	}
	/**
	 * @param cargoPolitico the cargoPolitico to set
	 */
	public void setCargoPolitico(String cargoPolitico) {
		this.cargoPolitico = cargoPolitico;
	}
	/**
	 * @return the nome
	 */
	public String getNome() {
		return nome;
	}
	/**
	 * @param nome the nome to set
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}
	/**
	 * @return the numero
	 */
	public String getNumero() {
		return numero;
	}
	/**
	 * @param numero the numero to set
	 */
	public void setNumero(String numero) {
		this.numero = numero;
	}
	/**
	 * @return the siglaPartido
	 */
	public String getSiglaPartido() {
		return siglaPartido;
	}
	/**
	 * @param siglaPartido the siglaPartido to set
	 */
	public void setSiglaPartido(String siglaPartido) {
		this.siglaPartido = siglaPartido;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Candidato [cargoPolitico=" + cargoPolitico + ", nome=" + nome
				+ ", numero=" + numero + ", siglaPartido=" + siglaPartido + "]";
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((cargoPolitico == null) ? 0 : cargoPolitico.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		result = prime * result + ((numero == null) ? 0 : numero.hashCode());
		result = prime * result
				+ ((siglaPartido == null) ? 0 : siglaPartido.hashCode());
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
		Candidato other = (Candidato) obj;
		if (cargoPolitico == null) {
			if (other.cargoPolitico != null)
				return false;
		} else if (!cargoPolitico.equals(other.cargoPolitico))
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		if (numero == null) {
			if (other.numero != null)
				return false;
		} else if (!numero.equals(other.numero))
			return false;
		if (siglaPartido == null) {
			if (other.siglaPartido != null)
				return false;
		} else if (!siglaPartido.equals(other.siglaPartido))
			return false;
		return true;
	}


}
