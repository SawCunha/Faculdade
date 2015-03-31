package tsi.too.tipo;

public class Circulo extends Forma2D {
	/*
	 * Dimensões básicas de todas as fomas geométricas de 2 dimensões.
	 *  	x = raio
	 */
	public Circulo() {
		super("Circulo");
		// TODO Auto-generated constructor stub
	}
	
	public Circulo(float y, float raio) {
		super("Circulo", 0, raio);
		// TODO Auto-generated constructor stub
	}
	
	public Circulo(String nome, float y, float raio) {
		super(nome, 0, raio);
		// TODO Auto-generated constructor stub
	}
	
	public Circulo(String nome) {
		super(nome);
	}
	
	public void setRaio(float raio){
		setX(raio);
	}
	
	public float getRaio(){
		return x;
	}
	
	@Override
	public float area() {
		return (float) (Math.PI * Math.pow(x, 2));
	}

	@Override
	public float volume() {
		return 0;
	}

	@Override
	public void desenhar() {

	}

	@Override
	public String toString() {
		return nome + ", Raio: " + x;
	}
	
	
}	//class Circulo extends Forma2D 
