package tsi.too.tipo;

/**
 * Classe base para representar as formas geométricas.
 * 
 * @author Wagner
 * @version 0.1
 */

public abstract class Forma {
	/**
	 * Nome da forma geométrica.
	 */
	protected String nome;
	
	/**
	 * Define o nome da forma geométrica.
	 */
	public Forma() {
		nome = "Forma";
	}
	
	/**
	 * Define o nome para a forma geométrica.
	 * @param nome <code>String</code> com o nome da Forma Geométrica.
 	 */
	
	public Forma(String nome) {
		setNome(nome);
	}
	
	/**
	 * Obtém o nome da forma geométrica.
	 * @return um <code>String</code> com o nome da forma geométrica.
	 */
	
	/*
	 * Um método final não pode ser sobrescrito, ou seja, a subclasse não pode fornecer uma nova
	 * implementação para um método final definido na superclasse.
	 */
	public final String getNome() {
		return nome;
	}
	
	/**
	 * Define o nome de forma geométrica.
	 * 
	 * @param nome <code> String </code> com o nome da forma geométrica.
	 */
	public final void setNome(String nome) {
		this.nome = nome;
	}
	
	/**
	 * Obtém uma representação <code> String </code> do objeto <code> Forma</code>
	 * @return <code>String</code> com o nome da forma geométrica.
	 */
	@Override
	public String toString() {
		return "Nome: " + nome;
	}
	
	/**
	 *	Exibe uma mensagem <i>Console</i> quando um objeto é removido da memória. 
	 */
	@Override
	protected void finalize() {
		System.err.println("Objeto Forma removido da memória.");
	}

	/**
	 * Calcula á área de uma forma geométrica.
	 * 
	 *  @return um <code> float </code> com o valor da área de um objeto <code>Forma</code>.
	 */
	public abstract float area();
	
	/**
	 * Calcula o volume de uma forma geométrica.
	 * 
	 *  @return um <code> float </code> com o volume de um objeto <code>Forma</code>.
	 */
	public abstract float volume();
	
	/**
	 * Desenha uma forma geométrica.
	 */
	public abstract void desenhar();	
}//class Forma
