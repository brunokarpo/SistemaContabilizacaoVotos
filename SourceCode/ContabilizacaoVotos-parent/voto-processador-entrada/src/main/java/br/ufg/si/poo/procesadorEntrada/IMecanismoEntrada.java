package br.ufg.si.poo.procesadorEntrada;

import java.util.List;

import br.ufg.si.poo.entidades.Candidato;

public interface IMecanismoEntrada {

	/**
	 * Método responsável por ler a fonte de entrada e retornar um buffer com todas as entradas disponíveis;
	 * @return Buffer de memoria com os Candidatos;
	 */
	List<Candidato> capturarEntrada() ;

}
