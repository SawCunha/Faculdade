package tsi.too.app;

import tsi.too.tipo.Triangulo1;
import tsi.too.tipo.Triangulo1.Ponto;

public class Triangulo1App {

	public static void main(String[] args) {
		Triangulo1 triangulo = new Triangulo1();
		
		/*
		 * Como a classe interna Ponto NÃO é estática, deve-se criar uma instância da classe
		 * externa Triângulo para ser usada para criar um objeto da classe Ponto. Se a classe externa
		 * ponto fosse estática, a criação do objeto da classe Ponto poderia ser feita de modo tradicional:
		 * 
		 * 		Ex: Ponto p = new Ponto(2,2);
		 */
		Ponto v1 = triangulo.new Ponto(2,2), 
				  v2 = triangulo.new Ponto(8,8),
				  v3 = triangulo.new Ponto(8,16);
		
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
