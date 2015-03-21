package tsi.too.tipo;

public class Turma {
	/*	
	 * 		Agregação de objetos: O objeto da classe Turma possui um objeto array de objetos da classe Aluno.
	 * 		Este relacionamento chamado de relacionamento tem um, é um exemplo de relacionamento 
	 * 		Todo-Parte.
	 * 		
	 * 		Na agregação o objeto parte (objeto do tipo Aluno) NÃO é criado dentro do objeto todo (objeto do tipo Turma).
	 * 		Portanto, quando o objeto Turma é removido da memória o objeto Aluno NÃO será	removido da memória. 
	 * 		Na agregação, o objeto parte pode ser compartilhado com outros objetos.
	 * 
	 * 		O identificados abaixo é uma referência para um array de objetos da classe Aluno.
	 */
	private Aluno turma[];
	private int quantidadeAlunos;
	private final int NUMERO_MAXIMO_DE_ALUNOS;
	
	//Cria o objeto Turma com no máximo 20 objetos do tipo Aluno.
	public Turma() {
		NUMERO_MAXIMO_DE_ALUNOS = 20;
		turma = new Aluno[NUMERO_MAXIMO_DE_ALUNOS];
	}
	
	//Cria o objeto Turma com a quantidade de referências de objetos do tipo Aluno passado por parâmetro.
	public Turma(int numeroMaximoDeAlunos) {
		NUMERO_MAXIMO_DE_ALUNOS = numeroMaximoDeAlunos;
		turma = new Aluno[NUMERO_MAXIMO_DE_ALUNOS];
	}

	public int getQuantidadeAlunos() {
		return quantidadeAlunos;
	}

	public int getNUMERO_MAXIMO_DE_ALUNOS() {
		return NUMERO_MAXIMO_DE_ALUNOS;
	}

	public String toString() {
		return "Turma [Número de Alunos: " + quantidadeAlunos
				+ ", Número Máximo de Alunos: " + NUMERO_MAXIMO_DE_ALUNOS + "]";
	}
	
	/*
	 * 	Cadastra um Objeto Aluno na Turma. Se a turma estiver cheia não cadastra e retorna false, caso
	 * 	contrário retorna true.
	 */
	public boolean inserirAluno(Aluno aluno) {
		if(quantidadeAlunos < NUMERO_MAXIMO_DE_ALUNOS)
		{
			turma[quantidadeAlunos++] = aluno;
			return true;
		}
		return false;
	}
	
	/*
	 * Obtém um objeto Aluno da Turma na posição utilizada. Retorna o objeto Aluno da posição
	 * se ela for válida, caso seja inválida retorna null.
	 */
	public Aluno obterAluno(int posicao) {
		return (posicao >= 0 && posicao < quantidadeAlunos) ? turma[posicao] : null;
	}
	
	/*
	 * Pesquisa pelo nome do aluno na turma. Se o nome foi encontrado retorna a posição do
	 * Aluno na Turma, se não retorna -1.
	 */
	public int pesquisarAluno(String nome) {
		if(quantidadeAlunos == 0) return -1;
		for(int indice = 0; indice < quantidadeAlunos; indice++)
			if(nome.equalsIgnoreCase(turma[indice].getNome()))
				return indice;
		return -1;
	}
	
	/*
	 * 	Remove o objeto Aluno do objeto Turna. Se a posição é válida o objeto é removido e o método
	 * 	retorna true, caso contrário o objeto não é removido e o método retorna false. 
	 */
	public boolean removerAluno(int posicao) {
		if(posicao >= 0 && posicao < quantidadeAlunos)
		{
			if(quantidadeAlunos > 1) 
				turma[posicao] = turma[quantidadeAlunos - 1];
			turma[--quantidadeAlunos] = null;
			return true;
		}
		return false;	
	}
}//class Turma
