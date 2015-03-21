package tsi.too.app;

public class AutoboxingUnboxing {

	public static void main(String[] args) {
		//	Cria e inicia o objeto Intenger.
		Integer numero = new Integer(27),
		
		/*
		 * 		Usa o recurso autoboxing introduzido a partir do java 1.5 para iniciar um valor a  objeto
		 * 		utilizando um tipo primitivo.
		 */
		num = 15; //Equivale a num = new Intenger(15).
		
		// Cria uma variável do tipo primitivo int e a inicia com o valor do objeto Intenger. (Unboxing)
		int number = numero; // Equivale a: number = numero.intValue()
				
		//	Exibe o valor do objeto número utilizando uma chamada implicita ao método toString.
		System.out.println("Número: " + numero);
		
		//	Exibe o valor do objeto número utiliznado o método intValue() que retorna o valor armazenado.
		System.out.println("Número: " + numero.intValue());
		
		// 	Exibe o valor atribuido através do recurso unboxing da variável do tipo primitivo int number.
		System.out.printf("Número: %d\n", number);
		
		System.out.println("Número: " + num);

		/*
		 * 		Usar o unboxing para obter os números inteiros e realizar a soma, depois utiliza o autoboxing
		 * 		para armazenar a soma.
		 */
		num = num+numero;
		System.out.printf("\nSoma: %d", num);
	}

}
