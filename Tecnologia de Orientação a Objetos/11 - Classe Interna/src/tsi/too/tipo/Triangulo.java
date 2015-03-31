package tsi.too.tipo;

public class Triangulo extends Forma2D {
	/*
	 * Dimensões básicas de todas as fomas geométricas de 2 dimensões.
	 * y = altura
	 * x = base
	 */
	
		public Triangulo() {
			super("Triângulo");
		}
	
		public Triangulo(float altura, float base) {
			super("Triângulo",altura, base);
		}
	
		public Triangulo(String nome, float altura, float base) {
			super(nome, altura, base);
		}
	
		public Triangulo(String nome) {
			super(nome);
		}
		
		public void setAltura(float altura){
			setY(altura);
		}
		
		public float getAltura(){
			return y;
		}
		
		public void setBase(float base){
			setX(base);
		}
		
		public float getBase() {
			return x;
		}
			
		@Override
		public String toString() {
			return nome + " Altura: " + y + ", Base: " + x;
		}
	
		@Override
		public float area() {
			return x * y / 2;
		}
		@Override
		public float volume() {
			return 0;
		}
	
		@Override
		public void desenhar() {
	
		}
		
		@Override
		public boolean lerDimensoes() {
			return true;
		}
		
}
