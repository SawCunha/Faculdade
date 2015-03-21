package tsi.too.app;

import java.util.EnumSet;

public class MesApp {
	//Define um conjunto de constantes enumeradas chamado de enumeração.
	enum Mes {janeiro, fevereiro, marco, abril, maio, junho, julho, 
		   				agosto, setembro, outubro, novembro, dezembro};
	
	public static void main(String[] args) {
		String meses[] = {"janeiro", "fevereiro", "marco", "abril", "maio", "junho", "julho", 
								   "agosto", "setembro", "outubro", "novembro", "dezembro"};
		
		//Solução 1: Uso do loop for tradicional
		for(int mes = Mes.janeiro.ordinal(); mes <= Mes.dezembro.ordinal(); mes++)
			System.out.printf(" %d - %s ",mes + 1, meses[mes]);
		System.out.printf("\n");
		
		//Solução 2: Uso do for aprimorado.
		for(Mes mes : Mes.values())
			System.out.printf(" %d - %s ", mes.ordinal() + 1, mes);
		System.out.printf("\n");
		
		/*
		 * Solução 3: Uso do for aprimorado para exibir os meses do primeiro semestre. O método estático
		 * range da classe java.util EnumSet retorna um objeto0 EunSet, ou seja, um subconjunto de constantes
		 * enumeradas. O subconjunto é definido pelos dois parâmetros passados ao método range.
		 */
		System.out.println("Semestres do ano");
		for(Mes mes : EnumSet.range(Mes.janeiro, Mes.junho))
			System.out.printf(" %d - %s ", mes.ordinal() + 1, mes);
	}//main(String[] args)
}//class MesApp
