package tsi.too.app;

import tsi.too.tipo.Disciplina;

public class DisciplinaApp {

	public static void main(String[] args) {
		/*
		 * Erro: não se pode instanciar uma enumeração. Por isso seus construtores devem sempre ser de acesso privado.
		 *  Disciplina disciplina = new Disciplina();
		 */
		
		//Atribui um valor a uma constante da Enumeração Disciplina.
		Disciplina.MAT.setCreditos(2);
		Disciplina.MAT.setCargaHoraria(80);
		Disciplina.MAT.setNome("Matemática");
		
		//Utilizando o loop for aprimorado para exibir as cosntantes.
		for(Disciplina disciplina : Disciplina.values())
			System.out.println(disciplina.toString());
	}//	main
}// class DisciplinaApp
