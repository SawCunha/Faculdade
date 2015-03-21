package tsi.too.app;

import static javax.swing.JOptionPane.*;

/*
 * Este programa executa a soma de vários números reais. Os parâmetros a serem usados na
 * linha de comando do sistema operacional são:
 * 
 * Sintaxe: soma <N1> <N2> . . . <Nn> [/h | /?] [/g]
 * 
 * Onde:
 * 
 * 		<N1> <N2> . . . <Nn> = representa os números a serem somados;
 *  	/h ou /? = apresenta um texto de ajuda do programa. 
 *  	/g = exibe o resultado da soma ou o texto de ajuda (se /h ou /? for usado) em uma interface gráfica.
 *  
 *  Notação: 
 *  
 *  	<> = valores a serem substituídos pelos parâmetros;
 *  	[ ] = indica o uso opcional de parâmetro;
 *  	| = este símbolo representa uma escolha, ou exclusivo, ou usa a opção /h ou /?.
 *  
 *  Exemplos em Java:
 *  	c:\> java -jar soma.jar /h
 *   	c:\> java -jar soma.jar 2 3 /g      
 *  	c:\> java -jar soma.jar 9.92 3.75 1578
 */
public class Soma {
	private static double numeros[]; // Números a serem somados.
	private static boolean ajuda, // Se true exibe a tela de ajuda; false não.
	 							  gui; // Se true exibe o resultado na GUI; false exibe no console. 

	// Inicia o aplicativo Java.
	public static void main(String[] args) {
		final String MSG_ERRO = "Você deve digitar pelo menos 2 números a serem " +
			      "somados ou /h para obter a ajuda.";
		int numeroOpcoes = 0;

		// Verifica se o usuário forneceu algum argumento para o programa.
		if (args.length > 0) {
			/* 
			 * Percorre o vetor args verificando quais as opções (/h, /? e /g) que foram passadas 
			 * como argumento para o programa. 
			 */
			for (String argumento : args) 
			{
				switch (argumento.toLowerCase()) {
				// /h = exibe tela de ajuda.
				case "/h": 
				case "/?":	ajuda = true;
				numeroOpcoes++;
				break;

				// /g = exibe o resultado via GUI.
				case "/g":  gui = true;
				numeroOpcoes++;
				break;
				} // switch
			} // for

			/*
			 *  A quantidade de números é igual a quantidade total de argumentos passados para 
			 *  o programa menos o total de opções  (/h, /? e /g).
			 */
			int quantidadeNumeros = args.length - numeroOpcoes;

			/*
			 * Verifica se dentre os argumentos passados para o programa existe uma quantidade
			 * de "valores numéricos" suficientes para realizar a soma.
			 */
			if (quantidadeNumeros > 1) 
			{
				// Cria o array para receber os números passados como argumento. 
				numeros = new double[quantidadeNumeros];

				// Obtém os números do array args e converte para valores numéricos reais (double).
				for (int indice = 0; indice< quantidadeNumeros; indice++) 
					numeros[indice] = Double.parseDouble(args[indice]);

				// Exibe o resultado.
				exibirResultado();
			}
			else
				// Usuário passou um argumento, portanto verifica se é /h. 
				if (ajuda) 
				{
					// Verifica se a saída é no console ou GUI.
					if (gui)
						showMessageDialog(null, obterAjuda(), "Soma", INFORMATION_MESSAGE);
					else
						System.out.println(obterAjuda());
				}
				else 
				{
					System.out.println(MSG_ERRO);
					showMessageDialog(null, MSG_ERRO, "Soma", INFORMATION_MESSAGE);
				}
		} // if (args.length > 0) 
		else 
		{
			System.out.println(MSG_ERRO);
			showMessageDialog(null, MSG_ERRO, "Soma", INFORMATION_MESSAGE);
		}

		// Finaliza o aplicativo Java GUI corretamente.
		System.exit(0);
	} // main()
	
	// Calcula a soma dos números armazenados no array numeros.
	private static double soma() {
		double sum = 0;
		
		// Calcula a soma dos números do array.
		for (double numero : numeros)
			sum += numero;

		return sum;
	} // soma()

	// Exibe o resultado no console ou GUI segundo o valor definido para gui.
	private static void exibirResultado() {
		String resultado;
		
		// Constrói o resultado para exibição no console ou GUI.
		resultado = "A soma = " + soma();
		
		if (ajuda)
			resultado += obterAjuda();
				
		// Exibe a saída na GUI.
		if (gui)
			showMessageDialog(null, resultado, "Soma", INFORMATION_MESSAGE);
		else
			// Exibe a saída no console.
			System.out.println(resultado); 
	} // exibirResultado()

	// Exibe um texto de ajuda do programa.
	private static String obterAjuda() {
		return "\nEste programa executa a soma de vários números reais.\n" + 
				"\nSintaxe: soma <N1> <N2> . . . <Nn> [/h | /?] [/g]\n" + 
				"\nParâmetros:\n"+
				"  <N1> <N2> . . . <Nn> = representa os números a serem somados\n" +
				"  /h ou /? = apresenta um texto de ajuda do programa.\n" + 
				"  /g = exibe o resultado da soma ou o texto de ajuda (se /h ou /? for usado) em uma "
				+ "interface gráfica.\n" +
				"\nExemplos em Java:\n" +
				"  c:\\> java -jar soma.jar /h\n" +
				"  c:\\> java -jar soma.jar 2 3 /g\n" +      
				"  c:\\> java -jar soma.jar 9.92 3.75 1578\n\n"; 
	}
} // class Soma
