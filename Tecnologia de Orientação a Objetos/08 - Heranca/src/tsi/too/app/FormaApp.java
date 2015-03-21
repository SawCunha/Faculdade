package tsi.too.app;

import tsi.too.tipo.Forma;
import tsi.too.tipo.Forma2D;
import tsi.too.tipo.Forma3D;

public class FormaApp {

	public static void main(String[] args) {
		Forma forma = new Forma();
		Forma2D forma2D = new Forma2D(), quadrado;
		Forma3D forma3D = new Forma3D(), cubo;
		
		//Atribui a referência dos objetos instânciados.
		quadrado = forma2D;
		cubo = forma3D;
		
		//Configura os atributos do objeto quadrado da subclasse Forma2D.
		quadrado.setNome("Quadrado");
		quadrado.setLargura(5);
		quadrado.setComprimento(7);
		
		//Configura os atributos do objeto cubo da subclasse Forma3D.
		cubo.setNome("Cubo");
		cubo.setComprimento(10);
		cubo.setLargura(10);
		cubo.setAltura(10);
		
		//Exibe os atributos dos objetos utilizando a chamada implicita ao método toString de cada Classe.
		System.out.println(forma);
		System.out.println(forma2D);
		System.out.println(forma3D);
		System.out.println(quadrado);
		System.out.println(cubo);
		
		/*
		 * Como todo objeto da subclasse é um objeto da superclasse podemos atribuir 
		 * a referência da subclasse a referência da superclasse.
		 */
		forma = forma2D;
		
		//Exibe os atributos do objeto da subclasse forma2D usando a referência da subclasse.
		System.out.println(forma);
		
		//	Verifica se a referência de forma é compatível e o mesmo tipo de dado da classe Forma2D
		if(forma instanceof Forma2D)
			forma2D =  (Forma2D) forma;
		else
			System.out.println("O objeto forma não é uma instância de forma2D");
		
	}//	main(String[] args)

}//	class FormaApp
