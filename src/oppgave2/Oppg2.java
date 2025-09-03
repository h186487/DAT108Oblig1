package oppgave2;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class Oppg2 {
	
	static int prosent = 10;
	static int prosentMann = 10;

	private static void lonnsoppgjor(List<Ansatt> ansatte, Function<Ansatt, Integer> funksjon) {
		for (Ansatt a : ansatte) {
			int nyLonn = funksjon.apply(a);
			a.settaarsLonn(nyLonn);
		}
	}
	
	private static void skrivUtAlle(List<Ansatt> ansatte) {
		for (Ansatt a : ansatte) {
			System.out.println(a);
		}
	}
	
	public static void main(String[] args) {
		Function<Ansatt, Integer> fastKroneTillegg = a -> a.getaarsLonn() + 1000;
		Function<Ansatt, Integer> fastProsentTillegg = a -> a.getaarsLonn() * (100 + prosent) / 100;
		Function<Ansatt, Integer> fastKroneTilleggLav = a -> a.getaarsLonn() * 1500;
		Function<Ansatt, Integer> fastProsentTilleggMann = a -> a.getaarsLonn() * (100 + prosentMann) / 100;
		
		List<Ansatt> ansatte = new ArrayList<>();
		ansatte.add(new Ansatt("Jenny", "Hopland", Kjonn.KVINNE, "Utvikler", 500000));
		ansatte.add(new Ansatt("Marte", "Sævig", Kjonn.KVINNE, "Utvikler", 500100));
		ansatte.add(new Ansatt("Nadia", "Lambrecht", Kjonn.KVINNE, "Utvikler", 500200));
		ansatte.add(new Ansatt("Andreas", "Ødegard", Kjonn.MANN, "Utvikler", 400900));
		ansatte.add(new Ansatt("Bashar", "Mohamad", Kjonn.MANN, "sj3ef", 500300));
		
		System.out.println("Original lønn:");
		skrivUtAlle(ansatte);

		System.out.println("\nFast kronetillegg:");
		lonnsoppgjor(ansatte, fastKroneTillegg);
		skrivUtAlle(ansatte);
		
		System.out.println("\nFast prosenttillegg:");
		lonnsoppgjor(ansatte, fastProsentTillegg);
		skrivUtAlle(ansatte);

		System.out.println("\nFast kronetillegg hvis lav lønn:");
		lonnsoppgjor(ansatte, fastKroneTilleggLav);
		skrivUtAlle(ansatte);
		
		System.out.println("\nFast prosenttillegg hvis mann:");
		lonnsoppgjor(ansatte, fastProsentTilleggMann);
		skrivUtAlle(ansatte);
		
	}
	
}
