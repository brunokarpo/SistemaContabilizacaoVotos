package br.ufg.si.poo.votoFila.testes;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import br.ufg.si.poo.entidades.Candidato;
import br.ufg.si.poo.entidades.builderUtils.CandidatoBuilder;
import br.ufg.si.poo.votoFila.AbstractEnfilerador;
import br.ufg.si.poo.votoFila.exceptions.FilaVaziaException;

public class AbstractEnfileiradorTest {

	private Candidato candidato;
	private AbstractEnfilerador enfileirador;

	@Before
	public void construirVoto() {
		candidato = new CandidatoBuilder()
							.comCargoPolitico("Deputado Federal")
							.comNome("Larissa Ferreira")
							.comNumero(2022)
							.comSiglaPartido("PV")
							.construir();
	}

	@Test
	public void deveEnfileirarEDesinfileirarVoto() {
		enfileirador.enfileirarVoto(candidato);

		Candidato teste = null;
		try {
			teste = enfileirador.desinfileiraVoto();
		} catch (FilaVaziaException e) {
			// Se der retornod e fila vazia eh porque o negocio nao funcionou. Falhar teste
			fail();
		}

		assertNotNull(teste);
		assertEquals(candidato, teste);

	}

	@Test(expected = FilaVaziaException.class)
	public void deveRetornarExcecaoQuandoFilaEstiverVazia() throws FilaVaziaException {
		enfileirador.desinfileiraVoto();
	}



}
