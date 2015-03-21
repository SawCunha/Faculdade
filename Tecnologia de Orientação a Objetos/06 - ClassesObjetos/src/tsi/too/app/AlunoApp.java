package tsi.too.app;

import tsi.too.tipo.Aluno;

public class AlunoApp {

	public static void main(String[] args) {
		/*
		 * 	Não é possível criar um objeto Disciplina em AlunoApp porque a classe Disciplina possui acesso de pacote.
		 * 	Só pode ser usada dentro do pacote 'tsi.too.tipo'.
		 */
		System.out.printf("Número de Alunos: %d\n", Aluno.getQuantidadeAlunos());
		
		Aluno aline = new Aluno("Aline", "Informática"),
				 pedro = new Aluno("Pedro", "Biologia"),
				 clara = new Aluno("Clara", "Física"),
				 lucas = new Aluno("Lucas", "Química");
		
		aline.definirNomeDisciplina("Lógica de programação");
		aline.definirNotaDisciplina(9.5f);
		pedro.definirNomeDisciplina("Biologia Marinha");
		pedro.definirNotaDisciplina(10.0f);
		clara.definirNomeDisciplina("Física IV");
		clara.definirNotaDisciplina(6.1f);
		lucas.definirNomeDisciplina("Química Orgânica");
		lucas.definirNotaDisciplina(6.0f);
		
		System.out.println(aline.toString());
		System.out.println(pedro.toString());
		System.out.println(clara.toString());
		System.out.println(lucas.toString());
		System.out.printf("Número de Alunos: %d\n", Aluno.getQuantidadeAlunos());
		
		/*
		 *	Marca as referências da classe Aluno para indicar que os objetos correspondentes não
		 *	serão mais usados e consequentemente podem ser eliminados. 	
		 */
		pedro = null;
		aline = null;
		clara = null;
		lucas = null;
		
		//Chama explicitamente o coletor de lixo do java.
		System.gc();
		
		/*
		 * 	O objetivo do for é provocar um atraso (delay) na execução do programa com o 
		 * 	objetivo de dar tempo de executar o coletor de lixo.
		 */
		for (long delay = 0; delay < Integer.MAX_VALUE; delay++)
		{}
	}//main

}//class AlunoApp
