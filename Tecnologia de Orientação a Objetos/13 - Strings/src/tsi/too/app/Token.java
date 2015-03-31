package tsi.too.app;

import static javax.swing.JOptionPane.*;

import java.util.StringTokenizer;

public class Token {

	public static void main(String[] args) {
		String frase;
		
		// Lê a frase que será usada para obter os tokens (palavras e símbolos).
		frase = showInputDialog(null, "Frase:", "Tokens", QUESTION_MESSAGE);
		
		// Verifica se o usuário clicou no botão Cancelar. 
		if (frase == null) System.exit(0);
		
		showMessageDialog(null, obterTokens(frase, ", ;."), "Tokens", INFORMATION_MESSAGE);
		
		// Finaliza o aplicativo Java GUI.
		System.exit(0);
	} // main()
	
	// Obtém e retorna os tokens (palavras e símbolos) do parâmetro frase.
	private static String obterTokens(String frase, String separador) {
		StringTokenizer  tokens = new StringTokenizer(frase, separador);
		String saida = "Número de Tokens: " + tokens.countTokens() + "\n\n";
		
		// Obtém todo os tokens da string frase.
		while (tokens.hasMoreTokens())
			saida += tokens.nextToken() + "\n";
		
		return saida;
	} // obterTokens()
} // class Tokens
