package tsi.too.app;

public class MatrizApp {

	public static void main(String[] args) {
		
		//Define uma refêrencia para um array multidimencional de duas dimensões.
		int[][] matriz2x2;
		
		//Cria uma matriz 2 x 2.
		matriz2x2 = new int[2][2];
		
		//Inicializa o matriz 2x2.
		for(int linha = 0; linha < matriz2x2.length; linha++)
			for(int coluna = 0; coluna < matriz2x2[linha].length; coluna++)
				matriz2x2[linha][coluna] = (linha + 1) * (coluna + 1);
		
		int numero, //Variável primitiva do tipo int.
					//Define e inicializa uma matriz 3x3 de números inteiros.
					matriz3x3[][] = {{1, 5, 8}, 	//Conteúdo da linha 0. 
										  {3, 4, 6},	//Conteúdo da linha 1.
										  {7, 2, 9}};	//Conteúdo da linha 2.
		
		/*
		 * 		Em java, uma matriz pode ter o número de linhas diferentes do número de colunas.
		 * 		Define uma referência para matriz e cria a primeira dimensão com 5 linhas.
		 * 		
		 * 		12
		 * 		16	22
		 * 		23	87	91
		 * 		45	76	87	41
		 * 		13	17	67	56	28 
		 */
		int matrizEscala[][] = new int[5][];
		
		/*
		 * 		Define número diferente de colunas para cada linha da matriz. Logo após inicializa cada posição com seus
		 * 		respectivos valores.		 * 		
		 */
				for(int linha = 0; linha < matrizEscala.length; linha++){
					matrizEscala[linha] = new int[linha + 1];
					for(int coluna = 0; coluna < matrizEscala[linha].length; coluna++)
						matrizEscala[linha][coluna] = coluna + linha + 1;
				}
					
		
		//Exibe o conteúdo de um array multidimencional de números inteiros.
		printArray("**********  Matriz 2 x 2 de inteiros  **********",matriz2x2);
		printArray("**********  Matriz 3 x 3 de inteiros  **********", matriz3x3);
		printArray("**********  Matriz Escada de inteiros  **********", matrizEscala);
	}//main
	
	//Exibe o conteúdo de um array multidimencional.
	private static void printArray(String mensagem, int[][] array){
		//Exibe uma mensagem na tela.
		System.out.println(mensagem);
		
		/*
		 * 		Obtém o conteúdo de cada linha da matriz. Lembre que uma matriz é 
		 * 		um vetor de vetor, portando uma linha da matriz de inteiros é um vetor
		 * 		de inteiros.
		 */
		for(int[] num: array){
			//	Percorre todos as colunas do vetor de inteiros, ou seja, da linha.
			for(int n: num)
				System.out.printf("%d ",n);
			System.out.println();
		}
		System.out.println();
	}
}// class MatrizApp
