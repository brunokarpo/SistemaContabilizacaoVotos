package entidades;

import org.junit.Test;
import static org.junit.Assert.*;

import br.ufg.si.poo.entidades.Candidato;
import br.ufg.si.poo.entidades.builderUtils.CandidatoBuilder;

public class CandidatoTeste {

	@Test
	public void deveCriarCandidatoAceitandoNumeroString() {
		Candidato candidato = new CandidatoBuilder()
									.comNumero("1456")
									.construir();

		assertEquals("1456", candidato.getNumero());
	}

	@Test
	public void deveCriarCandidatoAceitandoNumeroEmFormatoInteger() {
		Candidato candidato = new CandidatoBuilder()
									.comNumero(1456)
									.construir();

		assertEquals("1456", candidato.getNumero());
	}

}
