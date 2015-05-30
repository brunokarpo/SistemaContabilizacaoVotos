import processadorVotos.LeitorArquivo;
import processadorVotos.ProcessadorVotos;


public class ComputadorVotos {

	public static void main(String[] args) {

		LeitorArquivo leitor = new LeitorArquivo();
		leitor.leitorArquivo();

		ProcessadorVotos.getProcessador().computarEleicao();

	}

}
