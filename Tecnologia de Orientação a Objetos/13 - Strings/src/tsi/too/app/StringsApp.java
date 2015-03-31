package tsi.too.app;

import static javax.swing.JOptionPane.INFORMATION_MESSAGE;
import static javax.swing.JOptionPane.showMessageDialog;

import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class StringsApp {

	public static void main(String[] args) {
		// Cria uma área de texto para exibir a saída do programa na GUI.
		JTextArea areaTexto = new JTextArea(15, 35);

		// Cria uma barra de rolagem para a área de texto (JTextArea).
		JScrollPane saidaScrollPane = new JScrollPane(areaTexto);

		String saida = "", s1 = "Fim de semana", s2 = "fim de semana",
				   s3 = "                   Hoje está nublado.                 ",
				   s4 = "\\user\\aluno\\java",
				   strings[] = {"inicializar", "iniciar", "correr", "morrer"};

		char array[],
		          // Cria um vetor de caracteres com tamanho igual ao da string s2.
		          vetor[] = new char[s2.length()];

		saida += "s1 = " + s1 + "\ns1.length() = " + s1.length() +
				"\ns2 = " + s2 + "\ns2.length() = " + s2.length() +
				"\ns3 = " + s3 + "\ns3.length() = " + s3.length() +
				"\ns4 = " + s4 + "\ns4.length() = " + s4.length() +
				"\n\n-------------------- Métodos de comparação --------------------\n" +
				"\ns1.compareTo(s2)  = " + s1.compareTo(s2) +
				"\ns1.compareToIgnoreCase(s2)  = " + s1.compareToIgnoreCase(s2) +
				"\ns2.compareTo(s1)  = " + s2.compareTo(s1) +
				"\ns2.compareToIgnoreCase(s1)  = " + s2.compareToIgnoreCase(s1) +
				"\n\n-------------------- Código hash de strings --------------------\n" +
				"\nhashcode(s1) = " + s1.hashCode() +
				"\nhashcode(s2) = " + s2.hashCode() +
				"\n\"fim de semana\".hashCode() = " + "fim de semana".hashCode() +
				"\n\n-------------------- Métodos de substituição de strings --------------------\n" +
				"\n\"\\user\\aluno\\java\".replace('\\','/') = " + "\\user\\aluno\\java".replace('\\','/') +
				"\n\"senha123456\".replace(\"123456\", \"615\") = " + 
				     "senha123456".replace("123456", "615") +
				"\n\n-------------------- Métodos diversos de strings --------------------\n" +
				"\nTamanho da string \"Hoje está frio.\" = " + "Hoje está frio.".length() + " caracteres" +
				"\ns1.toLowerCase() = " + s1.toLowerCase() +
				"\ns1.toUpperCase() = " + s1.toUpperCase() +
				"\nO carácter da posição 0 de s1 = " + s1.charAt(0) +
				"\nO carácter da posição 7 de s1 = " + s1.charAt(7) +
				"\ns3.trim() = "+ s3.trim() + "#"+
				"\nVetor de caracteres = ";

		array = s1.toCharArray();
		for (char c : array)
			saida += c + " ";

		saida += "\n\n-------------------- Métodos de pesquisa em strings --------------------\n" +
		                "\ns4.indexOf('\\') = " + s4.indexOf('\\') +
		                "\ns4.indexOf('a', 0) = " + s4.indexOf('a', 0) +
		                "\ns2.indexOf(\"semana\") = " + s2.indexOf("semana") +
		                "\ns2.indexOf(\"semana\", 0) = " + s2.indexOf("semana", 0) +
		                "\ns2.indexOf(\"semana\", 15) = " + s2.indexOf("semana", 15) +
		                "\ns4.lastIndexOf('\\') = " + s4.lastIndexOf('\\') +
		                "\ns4.lastIndexOf('a', s4.length()) = " + s4.lastIndexOf('a', s4.length()) +
		                "\ns2.lastIndexOf(\"semana\") = " + s2.lastIndexOf("semana") +
		                "\ns2.lastIndexOf(\"semana\", 6) = " + s2.lastIndexOf("semana", 6);

		// Verifica se a substring "Fim" existe na string s1.
		if (s1.regionMatches(0, "fim", 0, 3))
			saida += "\nA substring \"fim\" pertence a string s1 = " + s1;
		else
			saida += "\nA substring \"fim\" não pertence a string s1 = " + s1;

		/*
		 *  Verifica se a substring "FIM" existe na string s1. O argumento true define que o método
		 *  regionMatches não deve ser sensível ao caso, ou seja, ignorar caracteres maiúsculos e
		 *  minúsculos.
		 */
		if (s1.regionMatches(true, 0, "FIM", 0, 3))
			saida += "\nA substring \"FIM\" pertence a string s1 = " + s1;
		else
			saida += "\nA substring \"FIM\" não pertence a string s1 = " + s1;

		saida += "\ns2.substring(7) = " + s2.substring(7) +
				        "\ns2.substring(0, 3) = " + s2.substring(0, 3);

		saida += "\nStrings que começam com \"ini\" = ";
		for (int fx = 0; fx < strings.length; fx++)
			// O método startsWith testa se cada string do array strings inicia com "ini".
			if (strings[fx].startsWith("ini"))
			    saida +=  strings[fx] + "\t";

		saida += "\nStrings que terminam com \"rer\" = ";
		for (String string : strings)
			// O método endsWith testa se cada string do array strings termina com "rer".
			if (string.endsWith("rer"))
			    saida +=  string + "\t";

		// Copia o conteúdo do objeto String s2 para o array vetor.
		s2.getChars(0, s2.length(), vetor, 0);

		saida += "\nArray vetor = ";
		for (char e : vetor)
			saida += e + "  ";

		// Escreve a saída na área de texto.
		areaTexto.setText(saida);

		// Exibe a String saida centralizada no vídeo.
		showMessageDialog(null, saidaScrollPane, "Métodos da Classe String",
				INFORMATION_MESSAGE);

		// Finaliza o aplicativo Java GUI.
		System.exit(0);
	} // main()
} // class Strings
