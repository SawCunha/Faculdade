package tsi.too.app;

import tsi.too.tipo.Circulo;
import tsi.too.tipo.Forma;
import tsi.too.tipo.Retangulo;
import tsi.too.tipo.Triangulo;

import static javax.swing.JOptionPane.*;

/**
 * Está classe é responsável por iniciar o aplicativo Java GUI Forma Geométrica.
 * @author Wagner
 * @version 0.1
 */
public class FormaApp {

	/**
	 * Inicia o aplicativo Java GUI.
	 * @param args um <i>array</i> de objetos da classe <code>String</code>. Este
	 * programa não utiliza parâmetros.
	 */
	public static void main(String[] args) {
		
		/*
		 * É fundamental usar a referência de uma superclasse de uma hierarquia de
		 * classe para acessar os serviços(métodos) das subclasses, desde que a superclasse 
		 * tenha a definição destes métodos ou a declaração desses serviços como métodos
		 * abstratos. Esta técnica possibilita o polimorfismo usar a referência da superclasse
		 * para polimorficamente invocar os métodos das subclasses.
		 * 
		 * 		Erro: Forma formas = new Forma(); //Porque a classe forma é abstrata.
		 */
		
		/*
		 * A variável formas é um array de referências para a classe abstrata forma. Ele é
		 * iniciado com a criação de 3 objetos das classes concretas Retangulo, Circulo e 
		 * Triângulo.
		 */
		Forma formas[] = {new Retangulo(2,8), new Circulo(0, 5), new Triangulo(7.5f, 3.5f)};
		String resultado = "";
		
		/*
		 * Obtém os atributos e o valor da área de cada objeto das subclasses de Forma2D de
		 * modo polimorfico, ou seja, usando a referência da superclasse abstrata forma.
		 */
		for(Forma forma : formas)
			resultado += forma.toString() + "\n" + String.format("Area: %.4f\n\n", forma.area());
		showMessageDialog(null, resultado, "Polimorfismo", INFORMATION_MESSAGE);
		
		//Finalizar o aplicativo Java GUI.
		System.exit(0);
	}	//static void main(String[] args)

}//class FormaApp
