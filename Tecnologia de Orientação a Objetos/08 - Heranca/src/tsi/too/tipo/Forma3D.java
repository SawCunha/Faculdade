package tsi.too.tipo;

public class Forma3D extends Forma2D {
	/*
	 * Dimensões básicas de todas as fomas geométricas de 3 dimensões.
	 * As dimensões largura e comprimento são herdadas da superclasse Forma2D.
	 */
	protected int altura;
	
	public Forma3D() {
		super("Forma Tridimensional");
	}
	
	public Forma3D(String nome) {
		/*
		 * Chama o construtor sobrecarregado da superclasse Forma2D. A primeira instrução
		 * sempre deve ser a chamada do construtor da superclasse.
		 */
		super(nome);
	}

	public Forma3D(int largura, int comprimento, int altura) {
		super("Forma Tridimensional", largura, comprimento);
		setAltura(altura);
	}

	public Forma3D(String nome, int largura, int comprimento, int altura) {
		super(nome, largura, comprimento);
		setAltura(altura);
	}

	public int getAltura() {
		return altura;
	}

	public void setAltura(int altura) {
		if(altura > 0) this.altura = altura;
		else this.altura = 0;
	}
	
	@Override
	public String toString() {
		//Chama o método toString da superclasse Forma para obter a representação string da mesma.
		return super.toString() + ", Altura: " + altura;
	}
	
}// class Forma3D extends Forma
