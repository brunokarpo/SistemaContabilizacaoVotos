package br.ufg.si.poo.votoFila.filaMemoriaImp;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

import br.ufg.si.poo.entidades.Candidato;
import br.ufg.si.poo.entidades.builderUtils.CandidatoBuilder;
import br.ufg.si.poo.votoFila.AbstractEnfilerador;
import br.ufg.si.poo.votoFila.exceptions.FilaVaziaException;

public class EnfileradorListaTeste {

	private AbstractEnfilerador enfileirador;
	private Candidato candidato;

	@Before
	public void criarMecanismoDeFilaUsandoLista() {
		enfileirador = new EnfileradorLista();
		candidato = new CandidatoBuilder()
							.comNome("Larissa Ferreira")
							.comCargoPolitico("Deputado Federal")
							.comNumero(1456)
							.comSiglaPartido("PV")
							.construir();
	}

	@Test
	public void deveEnfileirarEDesinfeleirarCandidato() {
		enfileirador.enfileirarVoto(candidato);
		Candidato resultado = null;

		try {
			resultado = enfileirador.desinfileiraVoto();
		} catch (FilaVaziaException e) {
			// se a fila esta vazia entao significa que o candidato nao foi enfileirado. Falhar teste
			fail();
		}

		assertEquals(candidato, resultado);

	}

	@Test(expected = FilaVaziaException.class)
	public void deveRetornarExcecaoDeFilaVaziaSeNaoTiverNadaNaFila() throws FilaVaziaException {
		enfileirador.desinfileiraVoto();
	}
}
