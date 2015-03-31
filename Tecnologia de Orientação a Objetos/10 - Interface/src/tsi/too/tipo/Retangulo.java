package tsi.too.tipo;

//	Uma classe final não pode ser estendida, ela não admite subclasse. 
 
public final class Retangulo extends Forma2D {
	
	/*
	 * Dimensões básicas de todas as fomas geométricas de 2 dimensões.
	 * y = altura
	 * x = base
	 */
	
	public Retangulo() {
		super("Retângulo");
	}

	public Retangulo(int largura, int comprimento) {
		super("Retângulo", largura, comprimento);
	}

	public Retangulo(String nome, int largura, int comprimento) {
		super(nome, largura, comprimento);
	}

	public Retangulo(String nome) {
		super(nome);
	}
	
	public void setBase(float base) {
		setX(base);
	}
	
	public float getBase() {
		return x;
	}
	
	public float getAltura() {
		return y;
	}
	public void setAltura(float altura) {
		setY(altura);
	}
	
	@Override
	public String toString() {
		return nome + ", Base: " + x + ", Altura: " + y;
	}
	
	
	@Override
	public float area() {
		return y * x;
	}

	@Override
	public float volume() {
		return 0;
	}

	@Override
	public void desenhar() {	}
	
}
