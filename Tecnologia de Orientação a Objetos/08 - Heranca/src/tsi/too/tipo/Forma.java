package tsi.too.tipo;

public class Forma {
	protected String nome;

	public Forma() {
		nome = "Forma";
	}

	public Forma(String nome) {
		setNome(nome);
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
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
		
}//class Forma
