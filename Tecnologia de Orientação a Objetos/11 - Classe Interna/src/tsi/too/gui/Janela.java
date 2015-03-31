package tsi.too.gui;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;

import tsi.too.tipo.OperacaoForma;
import static javax.swing.JOptionPane.*;

public class Janela extends JFrame {

	//Constrói e exibe uma janela JFrame
	public Janela() {
		//Define o texto da barra de título da janela.
		super(OperacaoForma.FORMA_GEOMETRICA);
		
		//Define o tamanho da janela em pixels.
		setSize(400, 200);
		
		//Posiciona a janela no centro da tela. 
		//setLocationRelativeTo(null);
		
		//Posiciona a janela de acordo com o sistema gerenciador de janelas do Sistema Operacional.
		setLocationByPlatform(true);
		
		/*
		 * Cria e Registra o tratador de eventos (Listener) da janela, ou seja, informa quem é o objeto 
		 * responsável por fornecer uma resposta aos eventos da janela.
		 */
		TrataEvento trataEvento = new TrataEvento();
		addWindowListener(trataEvento);
		
		//Exibe a janela
		setVisible(true);
	}
	
	/*
	 * Está classe interna é responsável por fornecer os métodos para tratar os enventos da classe 
	 * Janela. A classe TrataEvento utiliza a classe adaptadorta java.awt.event.WindowAdapter para 
	 * herdar as implementações defaeul da interface java.swf.event.WindowListener e sobrepor os 
	 * métodos necessários para os eventos que serão herdados na janela. Se a classe TrataEvento
	 * usa-se a interface, ela teria que implementar todos os 7 métodos definidos em WindowListener.
	 */
	private class TrataEvento extends WindowAdapter{
		
		@Override
		public void windowClosing(WindowEvent arg0) {
			System.exit(0);
		}//void windowClosing(WindowEvent arg0)

		@Override
		public void windowOpened(WindowEvent arg0) {
			/*
			 * Posiciona a caixa de diálogo em relação a janela principal do aplicativo (JFrame ou Janela).
			 * Para acessar a referência da classe externa dentro da classe interna é preciso usar a notação:
			 * 			<nome da classe externa>.this
			 * No exemplo abaixo, janela principal do aplicativo Janela (que é um JFrame) é referênciada usando
			 * esta notação:
			 * 			Janela.this
			 * 
			 * O método getContentPane() obtém o painel de conteúdo (um objeto da classe java.awt.Container)
			 * da janela principal do aplicativo para informar quem essa é a janela ao qual o frame interno irá 
			 * pertencer. O frame interno é usado nas versões do método da classe JOptionPane do tipo 
			 * showInternalXXX.
			 */
			showInternalMessageDialog(Janela.this.getContentPane(), "Seja Bem Vindo ao Programa Formas Geométricas!!!", 
											OperacaoForma.FORMA_GEOMETRICA, INFORMATION_MESSAGE);
		}//void windowOpened(WindowEvent arg0)
		
	}//class TrataEvento extends WindowAdapter
	
}//class Janela extends JFrame 
