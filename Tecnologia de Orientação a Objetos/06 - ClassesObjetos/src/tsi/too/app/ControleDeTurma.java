package tsi.too.app;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import tsi.too.tipo.*;
import static javax.swing.JOptionPane.*;

public class ControleDeTurma {
	private Turma turma;
	private final String NOME_PROGRAMA = "Controle de Turma",
								  MSG_MANTER_CAMPO = "Tecle Enter se desejar manter o valor atual";
	
	public ControleDeTurma() {
		turma = new Turma();
	}
	
	//Inicia o aplicativo Java GUI. 
	public static void main(String[] args) {
		new ControleDeTurma().menu();
		
		//Finaliza corretamente o programa.
		System.exit(0);
	}//main
	
	//Exibe o menu, seleciona e executa a opção escolhida pelo usuário.
	public void menu() {
		int opcao;
		String opcoes[] = {"Cadastrar","Consultar", "Relatório", "Alterar", "Excluir", "Sair"};
		
		//Finaliza o Programa quando o usuário clicar no botão Sair ou Fechar da caixa de diálogo. 
		do{
			opcao = showOptionDialog(null, "Escolha um comando abaixo:", NOME_PROGRAMA, 
										DEFAULT_OPTION, QUESTION_MESSAGE, null, opcoes, opcoes[0]);
			
			//Executa o comando escolhido pelo usuário.
			if(opcao != CLOSED_OPTION && opcao != 5){
				
				//Verifica se é a opção cadastrar.
				if(opcao == 0){
					//Verifica se a turma ainda não atingiu sua capacidade máxima. Caso não tenha atingido, cadastra um novo aluno.
					if(turma.getQuantidadeAlunos() < turma.getNUMERO_MAXIMO_DE_ALUNOS())
						cadastrar();
					else
						msgErro("A turma está cheia. Não é possivel cadastrar novos alunos.", NOME_PROGRAMA);
				}
				else
				{
					//Verifica se a turma já possui algum aluno cadastrado.
					if(turma.getQuantidadeAlunos() >= 1)
					{
						switch (opcao) {
							case 1: consultar("Consultar"); break;
							case 2: relatorio(); break;
							case 3: alterar(); break;
							case 4: excluir(); break;
						}//switch
					}else
						msgErro("Não há nenhum aluno(a) cadastrado(a) na turma.", "Erro");
				}//else
			}
		}while(opcao != CLOSED_OPTION && opcao != 5);
		
	}//menu()
	
	/*
	 * 		Lê todos os dados do aluno e cadastra no array de objetos turma. Se a operação for cancelada
	 * 		nenhum dado é cadastrado.
	 */
	public void cadastrar() {
		String nomeAluno, nomeCurso, nomeDisciplina;
		Float nota;
		
		nomeAluno = lerString("Nome do(a) Aluno(a): ", "Você deve fornecer o nome do(a) aluno(a):", "Cadastrar Aluno(a)", false);
		if(nomeAluno == null) return;
		
		nomeCurso = lerString("Nome do Curso: ", "Você deve fornecer o nome do curso.", "Cadastrar Curso", false);
		if(nomeCurso == null) return;
		
		nomeDisciplina = lerString("Nome da Disciplina: ", "Você deve fornecer o nome da disciplina.", "Cadastrar Disciplina", false);
		if(nomeDisciplina == null) return;
		
		nota = lerNumeroReal("Nota da Disciplina: ", "Você deve fornecer a nota da disciplina.", "Cadastrar Nota", false);
		if(nota == null) return;
		
		//Cria um objeto Aluno com os dados a serem cadastrado no objeto Turma.
		Aluno aluno = new Aluno(nomeAluno,nomeCurso, nomeDisciplina, nota);
		
		//Cadastra o objeto Aluno  no array de objetos da classe turma. 
		turma.inserirAluno(aluno);
		
		//Exibe uma mensagem informando que o objeto aluno foi inserido com sucesso no objeto Turma.
		showMessageDialog(null, "Dados gravados com sucesso.", NOME_PROGRAMA + " Cadastrar", INFORMATION_MESSAGE);
	}//cadastrar()
	
	/*
	 * 		Lê o nome do aluno e pesquisa na turma. Se encontrar, exibe os dados. Caso contrário exibe
	 * 		aluno não cadastrado. O usuário poderá verificar os dados do aluno, exceto ID. Para manter o
	 * 		dado atual basta o usuário teclar Enter. Após a alteração ou confirmação dos dados pelo usuário
	 * 		os dados serão atualizados no objeto turma.
	 */
	private void alterar() {
		//Cria uma referência para um objeto aluno.
		Aluno aluno = consultar("Alterar");
		
		//Verifica se os dados não estão cadastrado. Se não estiverem 
		if(aluno == null) return;
		
		String nomeAluno, nomeCurso, nomeDisciplina;
		Float nota;
		boolean alterado = false;
		
		nomeAluno = lerString(String.format("%s\n\nNome do(a) Aluno(a): %s\n\nNovo Nome: ", MSG_MANTER_CAMPO, 
																aluno.getNome()), "", "Alterar Aluno(a)", true);
		if(nomeAluno == null) return;
		
		nomeCurso = lerString(String.format("%s\n\nNome do Curso: %s\n\nNovo Nome: ", MSG_MANTER_CAMPO, 
																aluno.getCurso()), "", "Alterar Curso", true);
		if(nomeCurso == null) return;
		
		nomeDisciplina = lerString(String.format("%s\n\nNome da Disciplina: %s\n\nNovo Nome: ", MSG_MANTER_CAMPO,
																aluno.obterNomeDisciplina()), "", "Alterar Disciplina", true);
		if(nomeDisciplina == null) return;
		
		nota = lerNumeroReal(String.format("%s\n\nNota da Disciplina: %1.1f\n\nNova Nota: ", MSG_MANTER_CAMPO, 
																aluno.obterNotaDisciplina()), "", "Alterar Notaa", true);
		
		//Altera os atributos do objeto aluno com os novos dados fornecidos pelo usuário.
		if(!nomeAluno.equals("")) {aluno.setNome(nomeAluno); alterado = true;}
		if(!nomeCurso.equals("")) {aluno.setCurso(nomeCurso); alterado = true;}
		if(!nomeDisciplina.equals("")) {	aluno.definirNomeDisciplina(nomeDisciplina); alterado = true;}
		if(nota != -1) {aluno.definirNotaDisciplina(nota);alterado = true;}
		
		//Exibe mensagem de confirmação se algum dado foi alterado.
		if(alterado)
			showMessageDialog(null, "Dados alterados com sucesso.", NOME_PROGRAMA + " Alterar", INFORMATION_MESSAGE);
		else
			showMessageDialog(null, "Dados não alterados.", NOME_PROGRAMA + " Alterar", INFORMATION_MESSAGE);
	}//alterar()
	
	/*
	 * 		Lê o nome do aluno e pesquisa na turma. Se encontrar, exibe os dados. Caso contrário exibe
	 * 		aluno não cadastrado. Uma mensagem deve solicitar a confirmação de exclusão ao usuário. Se 
	 * 		a resposta for positiva os dados serão excluídos do objeto turma, se negativa, a operação é
	 * 		cancelada.  
	 */
	private void excluir() {
		//Cria uma referência para um objeto aluno.
				Aluno aluno = consultar("Alterar");
				
				//Verifica se os dados do aluno foram obtidos.
				if(aluno == null) return;
				
				String resultado = obterDados(aluno);
				//Exibe os dados do aluno e solicita a confirmação de exclusão ao usuário.
				int resposta = showConfirmDialog(null, resultado + "\n\nDeseja excluir estes dados?", NOME_PROGRAMA + " - Excluir",
																	YES_NO_OPTION,QUESTION_MESSAGE);
				
				//Excluir os dados do aluno se a resposta for positiva.
				switch (resposta) {
				case YES_OPTION:  //Exclui os dados do aluno se a resposta for positiva.
					int posicao = turma.pesquisarAluno(aluno.getNome());
					
					if(posicao != -1){
						turma.removerAluno(posicao);
						showMessageDialog(null, "Dados do aluno excluídos com sucesso", NOME_PROGRAMA + " - Excluir", INFORMATION_MESSAGE);
					}
					else
						msgErro("Aluno não cadastrado", "Excluir");
				break;
				case NO_OPTION: 	 //Operação de exclusão cancelada pelo usuário.
					showMessageDialog(null, "Operação de exclusão cancelada", NOME_PROGRAMA + " - Excluir", INFORMATION_MESSAGE);
				break;
				case CANCEL_OPTION:	  //Usuário clicou no botão fechar.
					showMessageDialog(null, "Operação de exclusão cancelada", NOME_PROGRAMA + " - Excluir", INFORMATION_MESSAGE);
				break;	
				default:
					break;
				}
				
	}//excluir()
	
	//Exibe um relatório com todos os dados cadastrados.
	private void relatorio() {
		//Cria uma área de texto com 10 linhas e 20 colunas para exibir o relatório.
		JTextArea areaTexto = new JTextArea(10, 50);
		String resultado = "";
		
		//Obtém os dados de todos os alunos da turma
		for(int indice = 0; indice < turma.getQuantidadeAlunos(); indice++){
			resultado += turma.obterAluno(indice) + "\n";
		}
		
		//Escreve o resultado na area de texto.
		areaTexto.setText(resultado);
		
		//Torna a área de texto não editavel para o usuário não poder alterar o relatório.
		areaTexto.setEditable(false);
		
		//Exibe o resultado usando uma caixa de texto e um painel de rolagem.JScrolPanel.
		showMessageDialog(null, new JScrollPane(areaTexto), "Relatório", INFORMATION_MESSAGE);
	}//relatorio()
	
	//Lê o nome do aluno e pesquisa. Caso encontre exibe os dados e retorna a referência. Caso contrário retorna null.
	private Aluno consultar(String modulo) {
		
		/*
		 * 		Lê o nome do aluno, pesquisa na turma e caso encontrado, obtém 	e exibe todos os 
		 * 		dados do aluno na GUI, se não, exibe a mensagem:
		 * 				* Aluno(a) não cadastrado(a).
		 * 		O parâmetro módulo deve receber o nome do módulo do programa.
		 * 		Este método retorna null se o usuário cancelar a operação de leitura do nome do
		 * 		aluno, se a operação não for cancelada será retornado a referência do objeto Aluno.
		 */
		
		String nome;
		Aluno aluno = null;
		int posicao;
		
		//Lê o nome do aluno e verifica se o usuário cancelou a operação de leitura.
		nome = lerString("Nome do(a) Aluno(a): ", "Você deve fornecer o nome do(a) Aluno(a)", modulo, false);
		if(nome == null) return null;
		
		//Pesquisa o nome do aluno na turma.
		posicao = turma.pesquisarAluno(nome);
		
		//Se o nome for encontrado obtém os dados do aluno e exibe caso o módulo não seja o Alterar.
		if(posicao != -1)
		{
			//Obtém a referência do objeto aluno armazenado no ob jeto turma.
			aluno = turma.obterAluno(posicao);
			
			//Obtém e exibe os dados do aluno na GUI, mas somente se a operação for Consultar.
			if(modulo.equalsIgnoreCase("Consultar"))
				showMessageDialog(null, obterDados(aluno), modulo, INFORMATION_MESSAGE);					
		}			
		else
			msgErro("Aluno(a) não cadastrado(a).", modulo);
		return aluno;
	}
	
	/*
	 * 	Lê e valida uma string literal. Retorna a String lida. Os parâmetros são:
	 * 		1. prompt: 	o texto a ser exibido na caixa de texto.
	 * 		2. msgErro: 	a mensagem de erro a ser exibida caso o usuário forneça uma string vazia
	 * 							e o parâmetro vazia vazia seja false.
	 * 		3. modulo: 	indica o nome do módulo do programa que está usando este método, p.ex:
	 * 							Cadastrar.		
	 * 		4. vazia: 		se for true o método aceitará string vazia, se false, não aceitará.
	 * 	
	 * Retorna a string lida. Se o usuário cancelar a operação de leitura será retornado null.
	 */
	private String lerString(String prompt, String msgErro, String modulo, boolean vazia) {
		String string = null;
		
		do{
			string = showInputDialog(null, prompt, NOME_PROGRAMA +  modulo, QUESTION_MESSAGE);
			
			//verifica se o Usuário clicou no botão Cancelar.
			if(string == null) break;
			
			//Verifica se o usuário forneceu uma string vazia.
			if (string.equals("") && !vazia)
				showMessageDialog(null, msgErro, NOME_PROGRAMA + modulo,  ERROR_MESSAGE);
		}while(string.equals("") && !vazia);
		return string;
	}//ler String()
	
	/*
	 * 	Lê e valida uma string literal. Retorna o número lido. Os parâmetros são:
	 * 		1. prompt: 	o texto a ser exibido na caixa de texto.
	 * 		2. msgErro: 	a mensagem de erro a ser exibida caso o usuário forneça uma string vazia
	 * 							e o parâmetro vazia vazia seja false.
	 * 		3. modulo: 	indica o nome do módulo do programa que está usando este método, p.ex:
	 * 							Cadastrar.		
	 * 		4. vazia: 		se for true o método aceitará string vazia, se false, não aceitará.
	 * 	
	 * Retorna a string lida convertida em Float. Se o usuário cancelar a operação de leitura será retornado null.
	 * Se vazio for true e o usuário não digitar nada será retornado null.
	 */
	private Float lerNumeroReal(String prompt, String msgErro, String modulo, boolean vazio) {
		String valor = null;
		do{
			valor = showInputDialog(null, prompt, NOME_PROGRAMA + modulo, QUESTION_MESSAGE);
			
			//verifica se o Usuário clicou no botão Cancelar.
			if(valor == null) return null;
			
			//Verifica se o usuário forneceu uma string vazia.
			if (valor.equals("") && !vazio)
				showMessageDialog(null, msgErro, NOME_PROGRAMA + modulo,  ERROR_MESSAGE);
		}while(valor.equals("") && !vazio);
		
		//converter a string lida para float e retorna.
		if(!valor.equals(""))
			return Float.parseFloat(valor);
		return -1F;
	}//ler lerNumeroReal()
	
	private void msgErro(String msg, String modulo) {
		showMessageDialog(null, msg, modulo, ERROR_MESSAGE);		
	}

	//Obtém os dados do aluno armazenados no parâmetro aluno.
	private String obterDados(Aluno aluno){
		//Exibe os dados do aluno na GUI somente se a operação não for excluir.
		return "ID: " + aluno.ID + "\nNome: " + aluno.getNome() + "\nCurso: " +
				aluno.getCurso() + "\nDisciplina: " + aluno.obterNomeDisciplina() +
				String.format("\nNota: %1.1f", aluno.obterNotaDisciplina());
		
	}
}//class ControleDeNotas
