package br.ufg.si.poo.procesadorEntrada.implArquivo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import br.ufg.si.poo.entidades.Candidato;
import br.ufg.si.poo.entidades.builderUtils.CandidatoBuilder;
import br.ufg.si.poo.procesadorEntrada.IMecanismoEntrada;

public class ArquivoMecanismoEntrada implements IMecanismoEntrada {

	private static final Logger LOG = LoggerFactory.getLogger(ArquivoMecanismoEntrada.class);

	public List<Candidato> capturarEntrada() {

		LOG.info("Inciando processo de captura de arquivo");

		List<Candidato> votos = new ArrayList<Candidato>();
		InputStream is = null;
		InputStreamReader isr =  null;
		BufferedReader br = null;

		try {
			File arquivoVotos = new File("./config/Votos.txt");
			LOG.debug("Lendo arquivo: " + arquivoVotos.getCanonicalPath() );

			is = new FileInputStream(arquivoVotos);
			isr = new InputStreamReader(is);
			br = new BufferedReader(isr);

			String voto = br.readLine();
			LOG.debug("Voto lido: " + voto);

			while(voto != null) {

				if(voto.replace(" ", "").equals("")) {
					LOG.warn("Linha em branco. Lerei a próxima linha");
					voto = br.readLine();
					continue;
				}

				LOG.info("Separando dados do voto");
				String[] votoSplit = voto.split(";");

				if(votoSplit.length == 4) {
					LOG.info("Construindo voto em um candidato");
					votos.add( construirVotoEmCandidato(votoSplit) );
				} else {
					LOG.info("Construindo voto em branco");
					votos.add( construirVotoEmBranco(votoSplit) );
				}

				voto = br.readLine();
				LOG.debug("Lendo o próximo voto: " + voto);
			}

		} catch (FileNotFoundException e) {
			LOG.error("Problema na leitura da base de dados. Arquivo não encontrado", e);
		} catch (IOException e) {
			LOG.error("Problema no mecanismo de entrada a aplicação", e);
		} finally {
			try {
				br.close();
				isr.close();
				is.close();
			} catch (IOException e) {
				LOG.error("Tentei fechar os mecanismos de entrada, mas eu problema. Não posso fazer nada mais", e);
			}

		}

		return votos;
	}

	private Candidato construirVotoEmCandidato( String[] candidatoSplit) {

		Candidato candidato = new CandidatoBuilder()
											.comCargoPolitico(candidatoSplit[0])
											.comNome(candidatoSplit[1])
											.comNumero(candidatoSplit[2])
											.comSiglaPartido(candidatoSplit[3])
											.construir();

		return candidato;
	}

	private Candidato construirVotoEmBranco( String[] candidatoSplit ) {
		Candidato candidato = new CandidatoBuilder()
									.comCargoPolitico(candidatoSplit[0])
									.comNome(candidatoSplit[1])
									.comNumero(candidatoSplit[2])
									.construir();

		return candidato;
	}

}
