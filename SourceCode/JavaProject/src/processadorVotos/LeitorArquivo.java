package processadorVotos;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import negocio.Candidato;

public class LeitorArquivo {

	public void leitorArquivo() {

		File arquivo;
		InputStream in;
		InputStreamReader isr;
		BufferedReader br;

		try {
			arquivo = new File("/mnt/369AEB034FBEFEB7/Repositorio/Git/SistemaContabilizacaoVotos/SourceCode/JavaProject/src/votos.txt");
			in = new FileInputStream(arquivo);
			isr = new InputStreamReader(in);
			br = new BufferedReader(isr);

			String voto = br.readLine();

			while(voto != null) {

				if(voto.trim().equals("")) {
					// Se a linha estiver em branco, ignora essa iteração e passa para a proxima;
					voto = br.readLine();
					continue;
				}

				String[] candidatoArray = voto.split(";");

				Candidato candidato = new Candidato();
				candidato.setCargoPolitico(candidatoArray[0]);
				candidato.setNome(candidatoArray[1]);
				candidato.setNumero(candidatoArray[2]);
				if(candidatoArray.length == 4) {
					//Evitar NPE em votos Brancos;
					candidato.setSiglaPartido(candidatoArray[3]);
				}

				ProcessadorVotos.getProcessador().acrescentarVoto(candidato);

				voto = br.readLine();

			}

			br.close();
			isr.close();
			in.close();

		} catch (FileNotFoundException e) {
			System.err.println("Arquivo de votos não encontrado");
			e.printStackTrace();
		} catch (IOException e) {
			System.err.println("Problema na leitura do arquivo");
			e.printStackTrace();
		}
	}

}
