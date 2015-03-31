package tsi.too.app;

import static javax.swing.JOptionPane.*;

public class StringImutavel {
	public static void main(String[] args) {
		String s1 = "Bom dia!", // s1 é iniciado com objeto anônimo String ("Bom dia!")
		          s2 = new String("Bom dia!"), /* s2 é iniciado com novo objeto cujo valor é igual ao 
		                                                        objeto anônimo String ("Bom dia!"). */ 
		          s3 = "Bom dia!", // s3 é iniciado com objeto anônimo String ("Bom dia!").
		          s4 = "bom dia!", // s4 é iniciado com objeto anônimo String ("bom dia!").
		          s5 = s1,
		       saida = "";
		
		// Comparando as referências s1 e s2.
		if (s1 == s2)
			saida = "s1 é igual a s2";
		else
			saida = "s1 não é igual a s2";
		
		// Comparando o conteúdo dos objetos s1 e s2.
		if (s1.equalsIgnoreCase(s2))
			saida += "\ns1 é igual a s2";
		else
			saida += "\ns1 não é igual a s2";
		
		/* Comparando as referências s1 e s3. A linguagem Java compartilha as referências dos 
		 * objetos String anônimos idênticos. */
		if (s1 == s3)
			saida+= "\ns1 é igual a s3";
		else
			saida+= "\ns1 não é igual a s3";

		/* Comparando as referências s1 e s4. A linguagem Java compartilha as referências dos 
		 * objetos String anônimos idênticos. Os objetos String anônimos s1 e s4 não são idênticos,
		 * porque o valor literal das strings é diferente, portanto possuem referências diferentes. */
		if (s1 == s4)
			saida+= "\ns1 é igual a s4";
		else
			saida+= "\ns1 não é igual a s4";
		
		// Obtém o código hash das strings s1, s2, s3 e s4. 
		saida += "\n\nCódigo Hash de s1 (\"Bom dia!\") = " + s1.hashCode() +
        				"\nCódigo Hash de s2 (\"Bom dia!\") = " + s2.hashCode() +
        				"\nCódigo Hash de s3 (\"Bom dia!\") = " + s3.hashCode() +
		                "\nCódigo Hash de s4 (\"bom dia!\") = " + s4.hashCode();
		
		/* TENTANDO modificar o valor literal (objeto String) através da referência s1. Em Java, 
		 * os objetos String são IMUTÁVEIS, portanto a instrução abaixo não modifica o objeto 
		 * referenciado por s1 ("Bom dia!"), mas cria um novo objeto anônimo ("Boa tarde!") e 
		 * coloca a referência deste em s1.  
		 */
		s1 = "Boa tarde!";
		
		if (s1 == "Boa tarde!")
			saida+= "\n\ns1 é igual a \"Boa tarde!\"";
		else
			saida+= "\n\ns1 não é igual a \"Boa tarde!\"";

		if (s1 == "boa tarde!")
			saida+= "\ns1 é igual a \"boa tarde!\"";
		else
			saida+= "\ns1 não é igual a \"boa tarde!\"";
		
		/* String literal em Java é um objeto, por isto é possível invocar o método equalsIgnoreCase 
		 * ou qualquer outro método da classe String sobre o literal "Bom dia!".
		 */
		if ("Bom dia!".equalsIgnoreCase(s1))
			saida += "\ns1 é igual a \"Bom dia!\"";
		else
			saida += "\ns1 não é igual a \"Bom dia!\"";
		
		saida += "\ns3 = " + s3 + "\ns5 = " + s5;

		// Exibe a String saida centralizada no vídeo.
		showMessageDialog(null, saida, "Strings Imutáveis", INFORMATION_MESSAGE);
		
		// Finaliza o aplicativo Java GUI.
		System.exit(0);
	} // main()
} // class StringsImutaveis 
