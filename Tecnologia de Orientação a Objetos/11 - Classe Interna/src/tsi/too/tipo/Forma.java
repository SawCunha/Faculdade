package tsi.too.tipo;

/*
 * Toda classe que implementa uma interface deve implementar todos os métodos abstratos da interface.
 * Se a classe for abstrata, as subclasses desta classe abstrata devem implementar estes métodos.
 * Toda classe que implementa uma inteface possui o relacionamento "é um" com a interface.
 */
public abstract class Forma implements OperacaoForma {
	protected String nome;

	public Forma() {
		nome = "Forma";
	}

	public Forma(String nome) {
		setNome(nome);
	}
	
	/*
	 * Um método final não pode ser sobrescrito, ou seja, a subclasse não pode fornecer uma nova
	 * implementação para um método final definido na superclasse.
	 */
	public final String getNome() {
		return nome;
	}

	public final void setNome(String nome) {
		this.nome = nome;
	}
	
	/*
	 * A implementação abaixo do método toString representa uma sobreposição (override) do método toString 
	 * definido na superclasse (Object) mas adaptado a necessidade da subclasse (implementação diferente).
	 * (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Nome: " + nome;
	}
	
	@Override
	protected void finalize() {
		System.err.println("Objeto Forma removido da memória.");
	}
}//class Forma
