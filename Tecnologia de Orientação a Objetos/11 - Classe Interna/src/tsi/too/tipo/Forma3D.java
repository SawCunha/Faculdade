package tsi.too.tipo;

public abstract class Forma3D extends Forma2D {
	/*
	 * Dimensões básicas de todas as fomas geométricas de 2 dimensões.
	 * y = altura
	 * x = base
	 * z = profundidade.
	 */
	/*
	 * Dimensões básicas de todas as fomas geométricas de 3 dimensões.
	 * As dimensões largura e comprimento são herdadas da superclasse Forma2D.
	 */
	protected float z; //Profundidade
	
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

	public Forma3D(float largura, float comprimento, float z) {
		super("Forma Tridimensional", largura, comprimento);
		setZ(z);
	}

	public Forma3D(String nome, float altura, float base, float profundidade) {
		super(nome, altura, base);
		setZ(profundidade);
	}

	public float getAltura() {
		return z;
	}

	public void setZ(float z) {
		if(z > 0) this.z = z;
		else this.z = 0;
	}
	
	@Override
	public String toString() {
		//Chama o método toString da superclasse Forma para obter a representação string da mesma.
		return super.toString() + ", Profundidade: " + z;
	}

	@Override
	protected void finalize() {
		System.err.printf("Objeto forma2D %s removido da memória.", nome);
		super.finalize();
	}
	
}// class Forma3D extends Forma
