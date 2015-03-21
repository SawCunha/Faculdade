package tsi.too.tipo;

public abstract class Forma {
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

	/*
	 * Os métodos abstratos devem ser implementados nas subclasses. Se um método abstrato
	 * não é implementado em uma subclasse, essa deve ser declarada como abstrata.
	 */
	public abstract float area();
	public abstract float volume();
	public abstract void desenhar();	
}//class Forma
