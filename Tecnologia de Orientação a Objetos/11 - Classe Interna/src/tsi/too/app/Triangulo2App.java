package tsi.too.app;

import tsi.too.tipo.Triangulo2;

public class Triangulo2App {

	public static void main(String[] args) {
		/*
		 * Os objetos da classe Ponto que não representam os valores do triãngulo são criados sem
		 * usar a referência da classe externa a classe interna Ponto é estático.
		 */
		Triangulo2.Ponto v1 = new Triangulo2.Ponto(2,2), 
				  				   v2 = new Triangulo2.Ponto(8,8),
				  				   v3 = new Triangulo2.Ponto(8,16);
		
		Triangulo2 triangulo = new Triangulo2(2,4);
		
		//Exibe os vertices do objeto triangulo.
		System.out.printf("v1: %s, v2: %s, v3: %s\n", triangulo.getVertice1(), 
																				triangulo.getVertice2(), 
																				triangulo.getVertice3());
		
		//Define os vertices do objeto triangulo usando os objetos da classe Ponto.
		triangulo.setVertice1(v1);
		triangulo.setVertice2(v2);
		triangulo.setVertice3(v3);
		
		//Exibe os vertices do objeto triangulo.
		System.out.printf("v1: %s, v2: %s, v3: %s\n", triangulo.getVertice1(), 
																				triangulo.getVertice2(), 
																				triangulo.getVertice3());
		
		//Exibe os atributos do objeto triangulo chamando o método toString.
		System.out.println(triangulo);
	}	//static void main(String[] args)

}//class FormaApp
