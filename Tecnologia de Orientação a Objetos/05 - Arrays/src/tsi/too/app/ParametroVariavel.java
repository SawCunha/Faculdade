package tsi.too.app;

public class ParametroVariavel {

	public static void main(String[] args) {
		
		soma(1,2,3,4,5,6,7,8,9,10);
		soma(1,2,3,7,5);
		soma(Math.PI,Math.E);
		
		media(8.5, 5, 10);
		media(3,5,6,7,9,5,3);
		media(27, 32, 22.5);
		
	}//main()
	
	/*
	 * 		Em Java, um array pode receber um número variável de parâmetros do mesmo tipo de dados.
	 * 		o parâmetro formal numeros do método abaixo será criado como um array de números double.
	 */
	private static void soma(double... numeros){
		double soma = 0;
		
		for(double  valor: numeros)
			soma += valor;
		System.out.printf("Soma = %1.2f",soma);
		System.out.println();
	}//soma
	
	private static void media(double... media){
		double soma = 0;
		for(double valor: media)
			soma += valor;
		
		System.out.printf("Media = %.2f", soma / media.length);
		System.out.println();
	}
	
}//class ParametroVariavel
