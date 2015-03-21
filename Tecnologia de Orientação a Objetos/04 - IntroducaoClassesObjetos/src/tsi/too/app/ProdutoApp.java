package tsi.too.app;

import tsi.too.tipo.Produto;

public class ProdutoApp {
	public static void main(String[] args){
		Produto perfume, //Referência para um objeto da classe Produto.
					 //Cria objetos da classe Produto e inicia as referências dos objetos.
					 sabonete = new Produto("Sabonete"),
					 arroz = new Produto("Arroz", 2),
					 feijao = new Produto("Feijão", 4, 9.5f);
		
		/*
		 * 		sabonete.quantidade = 10  // Erro, não é possível fazer isso, pois a variável de instância do Objeto sabonete da classe Produto é 
		 * 													  privado, isso faz com que seja possível modificar seus valores somente pelos métodos set. 
		 */
		sabonete.setQuantidade(10);
		sabonete.setPreco(1.5f);
		arroz.setPreco(5.8f);
		
		//	Cria e inicia o objeto produto.
		perfume = new Produto("", 2, 95f);
		
		//	Exibe as informações do objeto sabonete, utilizando os métodos get.
		System.out.printf("Nome %s\nQuantidade: %d\nPreço: R$ %1.2f\n\n", sabonete.getNome(),
																													  sabonete.getQuantidade(),
																													  sabonete.getPreco());
		
		//	Exibe as informações do objeto feijão, utilizando o método toString.
		System.out.printf(feijao.toString());
		
		System.out.println(arroz);
		
		System.out.println(perfume);
	}//main()
}//ProdutoApp
