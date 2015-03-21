package tsi.too.app;

//	Importa todos os membros static da classe JOptinPane.
import static javax.swing.JOptionPane.*;

public class OperacoesMatematicas {

	public static void main(String[] args) {
		menu();
	}//	Fim do método psvm()

	//	Exibe um menu de opções, lê, valida e executar a opção escolhida pelo usuário.
	public static void menu(){
		String opcao;
		
		menu: // Define um bloco associado ao loop do while() mais externo;
		do{
			/*
			 * Verifica e válida a opção digitada pelo usuário. Evita que ele digite um String vazia (dê enter sem excrever uma opção).
			 */
			do{
				opcao = showInputDialog(null, "1 - Exponenciação\n2 - Raiz Quadrada\n3 - PI\n4 - Número "
						+ "E\n5 - Sair", "Operações Matemáticas", QUESTION_MESSAGE);
				
				/*	Verifica se o botão verificar da caixa de saida foi precionado. Caso seja e o usuário não tenha digitado 
				 * 	nenhuma opção, encerra o loop do while e encerra o programa.
				 * */
				if (opcao == null)	break menu; //	Encerra o bloco menu caso a opção seja digitada inválida. 
				
				//	Verifica se o usuário digitou uma opção.
				if(opcao.equals(""))
					exibirMensagemErro("Você deve escolher uma opção.");
			}while(opcao.equals(""));
			
				//	Se a opção é válida, executa a opção selecionada.
				switch(opcao.charAt(0)){
					case '1': exponenciacao(); break;
					case '2': raizQuadrada(); break;
					case '3': exibirMensagem("Valor do número PI = " + Math.PI, "Número PI"); break;
					case '4': exibirMensagem("Valor do número E = " + Math.E, "Número E"); break;
					default: 
						if(opcao.charAt(0) != '5') exibirMensagemErro("Opção Inválida.");
				}
				
		}while(opcao.charAt(0) != '5');
		
		System.exit(0);
	}//Menu()
	
	/*	O método exibirMensagem recebe dois argumentos, a mensagem que será exibida e o título da janela
	 * 	que será exibida.
	 * */
	private static void exibirMensagem(String mensagem, String titulo) {
		showMessageDialog(null, mensagem, titulo, INFORMATION_MESSAGE);
	}
	
	
	public static void exponenciacao(){
		//	Define uma referência para um objeto Double.
		Double expoente;
		
		expoente = lerNumeroReal("Expoente: ", "Digite o valor para o cálculo:");
		
		//Verifica se o expoente for diferente de null, calcula o valor, caso contrário não executa a operação.
		if(expoente != null)
			exibirMensagem(String.format("O resultado é = %1.6f", Math.exp(expoente)), "Exponênciação");
	}
	
	/*
	 * 	Lê e valida o número real do usuário. Retorna null se o usuário cancelar a opção.
	 * 	Os parâmetros são:
	 * 		 
	 * Este método utiliza o recurso AUTOBOXING e UNBOXING que foi introduzido a partir do Java 1.5.
	 * 
	 * Autoboxing: Converte automaticamente o valor de um tipo primitivo em objeto.
	 * 		Ex: Double numero = 0.5; // Double = double.
	 * 
	 * Unboxing: Converte automaticamente o valor de um objeto em um tipo primitivo.
	 * 		Ex: double n = numero; //Tipo primitivo para um objeto. (double = Double)
	 */
	private static Double lerNumeroReal(String mensagem, String titulo) {
		
		//	Cria uma referência para um objeto do tipo Double e inicia com null (que é uma refeência inválida).
		Double numero = null;
		String valor;
		
		// Exibe uma caixa e lê o número real e retorna para o local de retorno. 
		do{
			valor = showInputDialog(null, mensagem, titulo, QUESTION_MESSAGE); 
			
			//	Retorna null caso o usuário não digite nada.
			if(valor == null) return numero;
			
			//	Exibe uma mensagem de erro caso o usuário não digitar um número.
			if(valor.equals(""))
				exibirMensagemErro("Você deve digitar um número.");
			
		}while(valor.equals(""));
		
		//	Converte a String lida para Double.
		return Double.parseDouble(valor);
	}

	public static void raizQuadrada(){
		//	Define uma referência para um objeto Double.
		Double raizQuadrada;
		
		raizQuadrada = lerNumeroReal("Número real: ", "Digite o valor para o cálculo:");
		
		//Verifica se o expoente for diferente de null, calcula o valor, caso contrário não executa a operação.
		if(raizQuadrada != null)
			if(raizQuadrada > 0)
				exibirMensagem(String.format("O resultado é = %1.2f", Math.sqrt(raizQuadrada)), "Raiz Quadrada: ");
			else
				exibirMensagemErro("Você deve digitar um número positivo.");
	}
	
	
	public static void exibirMensagemErro(String mensagem){
		showMessageDialog(null, mensagem, "Erro", ERROR_MESSAGE);
	}
}//OperacoesMatematicas
