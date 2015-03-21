package tsi.too.tipo;

public abstract class Forma2D extends Forma {
	/*
	 * Dimensões básicas de todas as fomas geométricas de 2 dimensões.
	 * y = altura
	 * x = base
	 */
	protected float y, 	//Altura 
							  x;	//Base

	public Forma2D() {
		//Chamada implícita ao contrutor default da superclasse Forma.
		nome = "Forma Bidimensional";
	}//	public Forma2D()

	public Forma2D(String nome) {
		/*
		 * Chama o construtor sobrecarregado da superclasse Forma. A primeira instrução
		 * sempre deve ser a chamada do construtor da superclasse.
		 */
		super(nome);
	}//	public Forma2D(String nome)
	
	//Construtor sobrecarregado da subclasse Forma2D.
	public Forma2D(float altura, float base) {
		this("Forma Bidimensional");
		setY(altura);
		setX(base);
	}
	
	//Construtor sobrecarregado da subclasse Forma2D.
	public Forma2D(String nome, float altura, float base) {
		super(nome);
		setY(altura);
		setX(base);
	}

	public float getY() {
		return y;
	}

	public void setY(float y) {
		if(y >= 0) this.y = y;
		else	this.y = 0;
	}

	public float getX() {
		return x;
	}

	public void setX(float x) {
		if(x >= 0) this.x = x;
		else this.x = 0;
	}

	@Override
	public String toString() {
		//Chama o método toString da superclasse Forma para obter a representação string da mesma.
		return super.toString() + ", y: " + y + ", x: " + x;
	}
	
	
	@Override
	protected void finalize() {
		System.err.printf("Objeto forma3D %s removido da memória.", nome);
		super.finalize();
	}
	
}// class Forma2D extends Forma 
