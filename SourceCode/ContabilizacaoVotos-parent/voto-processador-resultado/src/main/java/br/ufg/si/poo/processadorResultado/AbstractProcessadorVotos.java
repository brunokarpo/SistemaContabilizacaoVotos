package br.ufg.si.poo.processadorResultado;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import br.ufg.si.poo.entidades.Candidato;
import br.ufg.si.poo.processadorResultado.modeloLocal.Voto;
import br.ufg.si.poo.votoFila.AbstractEnfilerador;
import br.ufg.si.poo.votoFila.exceptions.FilaVaziaException;

public abstract class AbstractProcessadorVotos {

	private static final Logger LOG = LoggerFactory.getLogger(AbstractProcessadorVotos.class);
	private boolean ativo = true;
	private int tempoInativo = 0; // Esse cara aqui vai monitorar o tempo que a thread passou sem processar
									// caso seja de 1 minuto, finalizar o programa.

	protected abstract IArmazenadorVotos getArmazenadorVotos() ;

	public final void processarVotos(AbstractEnfilerador enfileirador) {

		LOG.info("Iniciando processamento de votos");
		Candidato candidatoVotado = null;

		while(ativo) {

			try {
				LOG.info("Retirando um voto da fila de processamento");
				candidatoVotado = enfileirador.desinfileiraVoto();
				LOG.debug("Voto capturado: " + candidatoVotado);

				if( !getArmazenadorVotos().candidatoJaVotado(candidatoVotado) ) {
					LOG.info("Esse candidato não tinha sido votado anteriormente. Vou criar um voto para ele");
					Voto voto = new Voto(candidatoVotado);
					getArmazenadorVotos().adicionarNovoVoto(voto);
				}

				LOG.info("Contabilizando o voto desse candidato");
				getArmazenadorVotos().incrementarUmVotoParaCandidato(candidatoVotado);

				tempoInativo = 0;
			} catch (FilaVaziaException e) {
				LOG.warn("No momento a fila está vazia. Vamos aguardar 10 segundos antes de tentarmos processar novamente");
				try {
					Thread.sleep(100000);
					tempoInativo++;

					if(tempoInativo > 10) {
						ativo = false;
					}
				} catch (InterruptedException e1) {
					LOG.error("Nao consigo aguardar. Vou voltar a processar", e);
				}
				e.printStackTrace();
			}

		}

	}

}
