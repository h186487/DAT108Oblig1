package oppgave1;

import java.util.function.BiFunction;
import java.util.function.BinaryOperator;

public class Oppg1b {
	
	public static int beregn(int a, int b, BiFunction<Integer, Integer, Integer> funksjon) {
		return funksjon.apply(a,  b);
	}
	
	public static int beregn2(int a, int b, BinaryOperator<Integer> funksjon) {
		return funksjon.apply(a, b);
	}

	public static void main(String[] args) {
		
		BiFunction<Integer, Integer, Integer> sumFunksjon = (a, b) -> a + b;
		BiFunction<Integer, Integer, Integer> maksFunksjon = (a, b) -> Math.max(a, b);
		BiFunction<Integer, Integer, Integer> avstandFunksjon = (a, b) -> Math.abs(a - b);
		
		BinaryOperator<Integer> sum2Funksjon = (a, b) -> a + b;
		BinaryOperator<Integer> maks2Funksjon = (a, b) -> Math.max(a, b);
		BinaryOperator<Integer> avstand2Funksjon = (a, b) -> Math.abs(a - b);
		
		int suma = beregn(12, 13, sumFunksjon);
		int sumb = beregn(-5, 3, maksFunksjon);
		int sumc = beregn(54, 45, avstandFunksjon);
		
		int suma2 = beregn(12, 13, sum2Funksjon);
		int sumb2 = beregn(-5, 3, maks2Funksjon);
		int sumc2 = beregn(54, 45, avstand2Funksjon);
		
		String[] resultatnavn = {"suma", "suma2", "sumb", "sumb2", "sumc", "sumc2"};
		int[] resultat = {suma, suma2, sumb, sumb2, sumc, sumc2};
		
		
		for (int i = 0; i < resultat.length; i++) {
			System.out.println(resultatnavn[i] + " = " + resultat[i]);
		}
		
	}
}
