package tsi.too.app;

import java.util.Scanner;

public class SwitchComString {

	public static void main(String[] args) {
		
		/*
		 * 		Cria uma refêrencia para um objeto da classe java.util.Scanner para ler valores do teclado.
		 * 		O teclado é identificado pelo objeto padrão de entrada de dados (System.in).
		 */
		Scanner teclado = new Scanner(System.in);
		
		/*
		 * 		A classe String é a única classe do java que pode ser usada para criar um objeto
		 * 		sem usar o operador de alocação dinâmica new. Considerando o recurso autoboxing e
		 * 		unboxing, as classes empacotadoras (Double, Float, etc), a partir da versão 1.5 do Java, 
		 * 		também pode ser utilizado para esta. 
		 */
		String dia = "";
		
		do{	System.out.println("Palavra mágica: ");
		
		//Valida a String fornecida pelo usuário.
		}while(dia.equalsIgnoreCase("fim"));
	}

}
