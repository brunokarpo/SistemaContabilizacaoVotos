package processadorVotos;

import java.util.ArrayList;
import java.util.List;

import negocio.Candidato;

public class ProcessadorVotos {

	private static ProcessadorVotos processador;

	private List<Candidato> deputadoFederal;
	private List<Candidato> deputadoEstadual;
	private List<Candidato> senador;
	private List<Candidato> governador;
	private List<Candidato> presidente;

	public static ProcessadorVotos getProcessador() {
		if(processador == null) {
			processador = new ProcessadorVotos();
		}
		return processador;
	}

	private ProcessadorVotos() {
		deputadoFederal = new ArrayList<Candidato>();
		deputadoEstadual = new ArrayList<Candidato>();
		senador = new ArrayList<Candidato>();
		governador = new ArrayList<Candidato>();
		presidente = new ArrayList<Candidato>();
	}

	public void acrescentarVoto(Candidato candidato) {
		if(candidato.getCargoPolitico().equalsIgnoreCase("Deputado Federal")) {
			acrescentarVotoDeputadoFederal(candidato);
		} else if(candidato.getCargoPolitico().equalsIgnoreCase("Deputado Estadual")) {
			acrescentarVotoDeputadoEstadual(candidato);
		} else if(candidato.getCargoPolitico().equalsIgnoreCase("Senador")) {
			acrescentarVotoSenador(candidato);
		} else if(candidato.getCargoPolitico().equalsIgnoreCase("Governador")) {
			acrescentarVotoGovernador(candidato);
		} else if(candidato.getCargoPolitico().equalsIgnoreCase("Presidente")) {
			acrescentarVotoPresidente(candidato);
		}
	}

	public void computarEleicao() {
		StringBuilder sb = new StringBuilder();
		sb.append("Deputado Estadual mais votado: " + getCandidatoGanhador(deputadoEstadual) + "\n");
		sb.append("Deputado Federal mais votado: " + getCandidatoGanhador(deputadoFederal) + "\n");
		sb.append("Senador mais votado: " + getCandidatoGanhador(senador) + "\n");
		sb.append("Governador mais votado: " + getCandidatoGanhador(governador) + "\n");
		sb.append("Presidente mais votado: " + getCandidatoGanhador(presidente) + "\n");

		System.out.println(sb.toString());
	}

	private void acrescentarVotoDeputadoFederal(Candidato candidato) {
		if( !deputadoFederal.contains(candidato) ) {
			deputadoFederal.add(candidato);
		}

		deputadoFederal.get( deputadoFederal.indexOf(candidato) ).adicionarVoto();
	}

	private void acrescentarVotoDeputadoEstadual(Candidato candidato) {
		if( !deputadoEstadual.contains(candidato) ) {
			deputadoEstadual.add(candidato);
		}

		deputadoEstadual.get( deputadoEstadual.indexOf(candidato) ).adicionarVoto();
	}

	private void acrescentarVotoSenador(Candidato candidato) {
		if( !senador.contains(candidato) ) {
			senador.add(candidato);
		}

		senador.get( senador.indexOf(candidato) ).adicionarVoto();
	}

	private void acrescentarVotoGovernador(Candidato candidato) {
		if( !governador.contains(candidato) ) {
			governador.add(candidato);
		}

		governador.get( governador.indexOf(candidato) ).adicionarVoto();
	}

	private void acrescentarVotoPresidente(Candidato candidato) {
		if( !presidente.contains(candidato) ) {
			presidente.add(candidato);
		}

		presidente.get( presidente.indexOf(candidato) ).adicionarVoto();
	}

	private String getCandidatoGanhador(List<Candidato> listaProposta) {
		Candidato temp = new Candidato();
		for(Candidato candidato : listaProposta) {
			if(candidato.getVotos() > temp.getVotos()) {
				temp = candidato;
			}
		}
		return temp.toString();
	}

}
