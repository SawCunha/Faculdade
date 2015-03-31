package tsi.too.tipo;

public interface OperacaoForma {
	
	/*
	 * As constantes definidas na interface são implícitamente publicas (public), estáticas (static) e final.
	 * 
	 * 	public static final String FORMA_GEOMETRICA = "Formas Geométricas";
	 * 
	 * 		equivale:
	 * 
	 * String FORMA_GEOMETRICA = "Formas Geométricas";
	 */
	public static final String FORMA_GEOMETRICA = "Formas Geométricas";
	
	/*
	 * Os métodos abstratos devem ser implementados nas classes que implementam está
	 * interface. 
	 */
	public abstract float area();
	public abstract boolean lerDimensoes();
	public abstract float volume();
	public abstract void desenhar();	
}
