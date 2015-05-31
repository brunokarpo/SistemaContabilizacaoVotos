package br.ufg.si.poo.entidades.builderUtils;

import br.ufg.si.poo.entidades.Candidato;
/**
 * @author Bruno Nogueira<br>
 *
 * <p>Classe utilitaria para construir candidatos utilizando o pattern Builder
 *
 * @version 1.0.0
 */
public class CandidatoBuilder {

	private Candidato instancia;

	public CandidatoBuilder() {
		instancia = new Candidato();
	}

	/**
	 * Coloca o nome na instancia de candidato a ser construido
	 * @param nome do candidato
	 * @return ConstrutorBuilder
	 */
	public CandidatoBuilder comNome(String nome) {
		instancia.setNome(nome);
		return this;
	}

	/**
	 * Coloca o cargo politico na instancia do candidato a ser construido
	 * @param cargoPolitico
	 * @return ConstrutorBuilder
	 */
	public CandidatoBuilder comCargoPolitico(String cargoPolitico) {
		instancia.setCargoPolitico(cargoPolitico);
		return this;
	}

	/**
	 * Coloca o numero na instancia do candidato a ser construido
	 * @param numero em formato String
	 * @return ConstrutorBuilder
	 */
	public CandidatoBuilder comNumero(String numero) {
		instancia.setNumero(numero);
		return this;
	}

	/**
	 * Coloca o numero na instancia do candidato a ser construido
	 * @param numero no formato integer
	 * @return CandidatoBuilder
	 */
	public CandidatoBuilder comNumero(int numero) {
		return this.comNumero( String.valueOf(numero) );
	}

	/**
	 * Coloca a sigla do partido na instancia de candidato a ser construido
	 * @param siglaPartido
	 * @return CandidatoBuilder
	 */
	public CandidatoBuilder comSiglaPartido(String siglaPartido) {
		instancia.setSiglaPartido(siglaPartido);
		return this;
	}

	/**
	 * Devolve a instancia do candidato construida por esse Builder
	 * @return Candidato
	 */
	public Candidato construir() {
		return this.instancia;
	}

}
