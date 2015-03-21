package tsi.too.app;

public class VetorApp {

	public static void main(String[] args) {
		
		/*
		 * 		Define dois arrays de String.
		 * 		O primeiro array é inicializado com Strings literais (Em java, string literal é um objeto do tipo String.).
		 * 		O segundo array é iniciado com 3 strings.
		 * 		Todo array em java é um objeto.
		 */
		String[] vogais = {"A","E","I","O","U"},
					trimestre = {"Janeiro", "Fevereiro","Março"};
		
		int numero[], //Define uma referência para um array de números inteiros.
			 n1;	//Variável do tipo inteiro.
		
		//Cria um array de 10 números inteiros.
		numero = new int[10];
		
		/*
		 * 		Preenche um vetor de inteiros. Todo array em java é uma referência para um objeto, portanto 
		 * 		possuem alguns métodos predefinidos. No exemplo abaixo é usado o método lenght que retorna
		 * 		o número de elemento do array. 
		 */
		for(int indice = 0; indice < numero.length; indice++)
			 numero[indice] = indice + 1;
				
		//Imprime o conteúdo do array números
		printArray(numero);
		
		//Imprime o conteúdo do array digitos.
		printArray(trimestre);
		
		//Modifica um elemento do array numeros.
		replace(numero, 0, 23);
		
		printArray(numero);
		
		//	Modifica todos os elementos do array de String  trimestre.
		replace(trimestre, "Alface");
		
		printArray(trimestre);
	}//main

	//Exibe o conteúdo de um array de inteiros.
	private static void printArray(int[] array){		
		/*
		 * 		Usa o loop for aprimorado (introduzino no Java 1.5) para exiibir todos os elementos do array.
		 *		
		 *		Usando o loop for tradicional seria:
		 *			
		 *			for(int indice = 0; indice < array.lenght; indice++)
		 *				System.out.printf("%d",array[indice]);	
		 */		
		for(int numero : array)
			System.out.printf("%d", numero);
		System.out.println();
	}
	
	//Exibe o conteúdo de um array de Strings.
	private static void printArray(String[] array){	
		//	Usa o loop for aprimorado (introduzino no Java 1.5) para exiibir todos os elementos do array.
		for(String digitos : array)
			System.out.printf("%s",digitos);
		System.out.println();
	}
	
	//	Substitui o elemento do array na posição especificada pelo parâmetro indice, com o parâmetro novo.
	private static void replace(int[] array, int indice, int novoElemento){
		//	Verifica se o indice passado por parâmetro é válido, caso seja, substitui o elemento da posição especificada pelo novo.
		if(indice >= 0 && indice < array.length) 
			array[indice] = novoElemento;		
	}
	
	//	Substitui todas as Strings pela nova String.
	private static void replace(String[] array, String novaString){
			for(int indice = 0; indice < array.length; indice++)
				array[indice] = novaString;
	}
}//class ArrayApp
