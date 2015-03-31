package tsi.too.app;

import static javax.swing.JOptionPane.ERROR_MESSAGE;
import static javax.swing.JOptionPane.showInternalMessageDialog;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import tsi.too.gui.Janela;
import tsi.too.tipo.Circulo;
import tsi.too.tipo.Forma;
import tsi.too.tipo.OperacaoForma;

public class FormaApp {
	private Janela janela;
	private Forma forma = new Circulo();
	
	//Cria e exibe a inteface gráfica do aplicativo.
	public FormaApp() {
		janela = new Janela();
		adicionarForma();
	}

	public static void main(String[] args) {
		new FormaApp();
	}//public static void main(String[] args)
	
	/*
	 * Este método adiciona um botão na janela do aplicativo para cada forma geométrica
	 * localizada no pacote tsi.too.tipo.
	 */
	private void adicionarForma() {
		
		//Idenfica os nomes das formas geométricas.
		String formas[] = {"Círculo", "Retângulo", "Triângulo"};
		
		//Cria um array de objetos da classe javax.swing.JButton
		JButton botoes[] = new JButton[formas.length];
		
		/*
		 * Define o gerenciador de layout a ser usado na janela do aplicativo. O gerenciador
		 * de layout é usado para definir a organização dos componentes na interface gráfica
		 * do programa. O java.awt.FlowLayout organiza os componentes como uma linha de
		 * texto, ou seja, os componentes são colocados no container da janela da esquerda para
		 * direita.
		 */
		janela.setLayout(new FlowLayout());
		
		/*
		 * Cria os botões e adiciona-os ao painel de conteúdo da Janela.
		 * 		(Contêiner - java.awt.Container)
		 * Registra o tratador de evento para cada botão criado.
		 */
		for(int indice = 0; indice < botoes.length; indice++){
			botoes[indice] = new JButton(formas[indice]);
			janela.add(botoes[indice]);
			/*
			 * Define quem é o objeto responsável por tratar os eventos de cada botão da janela 
			 * usando um objeto da classe interna anônima. A criação da classe interna anônima 
			 * abaixo equivale a:
			 * 
			 * 		private class <ClasseInterna> implements ActionListener{
			 * 			
			 * 			public void actionPerformed(ActionEvent arg0) {
			 *		
			 *			}
			 * 		}//class <ClasseInterna> implements ActionListener
			 * 
			 * Objeto a ser passado para o método addActionListener é o objeto de uma classe que
			 * implementa a interface ActionListener, portanto é um objeto da classe interna que 
			 * implementa ActionListener.
			 */
			botoes[indice].addActionListener(
					new ActionListener() {//Inicio do corpo da classe interna anônima.
						
					/*
					 * Exibe uma caixa de diálogo para ler as dimensões da forma geométrica e em seguida
					 * desenha a forma usando os valores das dimensões fornecidos pelo usuário.
					 */
					public void actionPerformed(ActionEvent event) {

						// Verifica se forma é uma instância de um objeto Forma. 
						if(forma instanceof Forma)
							//if(forma.lerDimensoes()) forma.desenhar();
							showInternalMessageDialog(janela.getContentPane(),"Este forma geométrica é " + event.getActionCommand(), 
																		  OperacaoForma.FORMA_GEOMETRICA, ERROR_MESSAGE);
						else
								showInternalMessageDialog(janela.getContentPane(),"Este objeto não é uma forma geométrica", 
																			OperacaoForma.FORMA_GEOMETRICA, ERROR_MESSAGE);
					}//void actionPerformed(ActionEvent arg0) 
				}//Fim do corpo da classe interna anônima
			);//Fim da chamada ao método addActionListener
		}//For
	}
	
}//class FormaApp
