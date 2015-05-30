package negocio;

public class Candidato {

	private String cargoPolitico;
	private String nome;
	private String numero;
	private String siglaPartido;
	private int votos;

	/**
	 *
	 */
	public Candidato() {
		votos = 0;
	}


	/**
	 * @param cargoPolitico
	 * @param nome
	 * @param numero
	 * @param siglaPartido
	 */
	public Candidato(String cargoPolitico, String nome, String numero,
			String siglaPartido) {
		this.cargoPolitico = cargoPolitico;
		this.nome = nome;
		this.numero = numero;
		this.siglaPartido = siglaPartido;
	}


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


	/**
	 * @return the votos
	 */
	public int getVotos() {
		return votos;
	}

	/**
	 * Incrementa mais um voto para o candidato;
	 */
	public void adicionarVoto() {
		votos++;
	}


	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((numero == null) ? 0 : numero.hashCode());
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
		if (numero == null) {
			if (other.numero != null)
				return false;
		} else if (!numero.equals(other.numero))
			return false;
		return true;
	}


	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "nome = " + nome
				+ ", numero = " + numero + ", siglaPartido = " + siglaPartido
				+ ", votos = " + votos + "]";
	}
}
