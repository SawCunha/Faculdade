package tsi.too.tipo;

public enum Disciplina {
	BIO(),
	MAT("Matemática", 100),
	LP("Linguagem de Programação", 4, 80),
	SO("Sistemas Operacionais", 2, 100),
	LPV("Linguagem de Programação Visual", 4, 60),
	TOO("Tecnologia de Orientação a Objetos", 4, 120);
	
	private String nome;
	private int creditos, cargaHoraria; 
	
	private Disciplina() { }
	
	private Disciplina(String nome, int cargaHoraria) {
		this.nome = nome;
		this.cargaHoraria = cargaHoraria;
	}

	private Disciplina(String nome, int creditos, int cargaHoraria) {
		this.nome = nome;
		this.creditos = creditos;
		this.cargaHoraria = cargaHoraria;
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public int getCreditos() {
		return creditos;
	}
	
	public void setCreditos(int creditos) {
		this.creditos = creditos;
	}
	
	public int getCargaHoraria() {
		return cargaHoraria;
	}
	
	public void setCargaHoraria(int cargaHoraria) {
		this.cargaHoraria = cargaHoraria;
	}
	
	public  String toString() {
		return "Matéria: " + nome + ", Créditos: " + creditos + ", Carga horária: " + cargaHoraria;
	}
}//enum Disciplina
