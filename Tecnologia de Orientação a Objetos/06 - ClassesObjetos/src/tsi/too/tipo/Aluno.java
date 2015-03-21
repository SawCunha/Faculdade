package tsi.too.tipo;

public class Aluno {
	private String nome, curso;
	/*	
	 * 		Composição de objetos: O objeto da classe Aluno possui um objeto da classe Disciplina.
	 * 		Este relacionamento chamado de relacionamento tem um, é um exemplo de relacionamento 
	 * 		Todo-Parte.
	 * 		
	 * 		Na composição o objeto parte (Disciplina) é criado dentro do objeto todo (objeto do tipo Aluno).
	 * 		Portanto, quando o objeto Aluno é removido da memória o objeto Disciplina também será
	 * 		removido da memória. Eles nascem juntos e morrem juntos. Na composição, o objeto parte não 
	 * 		pode ser compartilhado com outros objetos.
	 * 		
	 * 		O identificados abaixo é uma referência para um objeto da classe Disciplina.
	 */
	private Disciplina disciplina; 
	private static int quantidadeAlunos;
	
	//Em Java uma constante é definida usando a palavra reservada final.
	public final int ID;
	
	//Construtor default.
	public Aluno() {
		ID = ++quantidadeAlunos;
		disciplina = new Disciplina();
	}
	
	/*
	 * 		Construtor Sobrecarregado. Inicia as váriaveis de instãncia com os valores
	 * 		nome e curso passados como parâmeto.
	 */
	public Aluno(String nome, String curso) {
		this();	//Chama o construtor default para criar o objeto disciplina.
		setNome(nome);
		setCurso(curso);
	}
	
	public Aluno(String nome, String curso, String nomeDisciplina, float notaDisciplina) {
		this();	//Chama o construtor default para criar o objeto disciplina.
		setNome(nome);
		setCurso(curso);
		disciplina.nome = nomeDisciplina;
		disciplina.nota = notaDisciplina;
	}
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCurso() {
		return curso;
	}

	public void setCurso(String curso) {
		this.curso = curso;
	}
		
	public int getMatricula() {
		return ID;
	}
	
	public static int getQuantidadeAlunos() {
		return quantidadeAlunos;
	}

	public String toString() {
		//Chama implicitamente o método toString da classe Disciplina.
		return "Matricula: " + ID + ", Aluno: " + nome + ", Curso: " + curso + ", " + disciplina.toString();
	}
	
	public void definirNomeDisciplina(String nome){
		//Usa o acesso de pacote para acessar diretamente a variável de instância da classe Disciplina.
		disciplina.nome = nome;
	}
	
	public void definirNotaDisciplina(float nota) {
		//Usa o acesso de pacote para acessar diretamente a variável de instância da classe Disciplina.
		disciplina.nota = nota;
	}
	
	public String obterNomeDisciplina() {
		return disciplina.nome;
	}
	
	public float obterNotaDisciplina() {
		return disciplina.nota;
	}
	
	/*
	 * Este Método é executado pelo coletor de lixo (Garbage Colector) do Java sempre que um objeto
	 * é removido da memória. O problema é que não há garantia de quando o coletor do Java será executado.
	 * Quando for executado este método será executado, mas como não há garantia de quando isso ocorrerá, não
	 * devemos programar nenhuma função que dependa deste mecanismo.
	 */
	protected void finalize() throws Throwable {
		quantidadeAlunos--;
		System.err.printf("Objeto %s Removido da Memória.\n"
				+ "Número de Alunos: %d\n",nome,quantidadeAlunos);
	}
	
}//class Aluno

/*
 * 	Esta classe possui acesso de pacote porque não é usado nenhum especificador de acesso
 * 	antes da palavra reservada class. Todas as classes de pacote tsi.com.tipo terão acesso a esta
 * 	classe.
 */
class Disciplina {
	/*
	 * 	Variáveis de instância com acesso de pacote pode ser acessadas diretamente dentro pelas
	 * 	outras classes do mesmo pacote usando a refêrencia da classe que possui acesso de pacote.
	 */
	String nome;
	float nota;
	
	public Disciplina() {	}

	public Disciplina(String nome, float nota) {
		setNome(nome);;
		setNota(nota);
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public float getNota() {
		return nota;
	}

	public void setNota(float nota) {
		this.nota = nota;
	}

	public String toString() {
		return "Disciplina: " + nome + ", Nota: " + String.format("%.1f", nota);
	}
}
