package oppgave3;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Oppg3 {
	
	private static void skrivUtAlle(List<Ansatt> ansatte) {
		for (Ansatt a : ansatte) {
			System.out.println(a);
		}
	}

	public static void main(String[] args) {
		
		
		List<Ansatt> ansatte = new ArrayList<>();
		ansatte.add(new Ansatt("Jenny", "Hopland", Kjonn.KVINNE, "Utvikler", 500000));
		ansatte.add(new Ansatt("Marte", "Sævig", Kjonn.KVINNE, "Chief financial officer", 500100));
		ansatte.add(new Ansatt("Nadia", "Lambrecht", Kjonn.KVINNE, "Utvikler", 500200));
		ansatte.add(new Ansatt("Andreas", "Ødegard", Kjonn.MANN, "Utvikler", 400900));
		ansatte.add(new Ansatt("Bashar", "Mohamad", Kjonn.MANN, "Chief technical officer", 500300));

		//a
		List<String> etternavnList = ansatte.stream()
				.map(a -> a.getEtternavn())
				.collect(Collectors.toList());
		
		System.out.println("Liste med etternavn: " + etternavnList + "\n");
		
		//b
		long antallKvinner = ansatte.stream()
				.filter(a -> a.getKjonn() == Kjonn.KVINNE)
				.count();
		
		System.out.println("Antall kvinner: " + antallKvinner + "\n");
		
		//c
		int totalKvinnerLonn = ansatte.stream()
				.filter(a -> a.getKjonn() == Kjonn.KVINNE)
				.mapToInt(a -> a.getaarsLonn())
				.sum();
		
		System.out.println("Gjennomsnittslønn kvinner: " + totalKvinnerLonn/antallKvinner + "\n");
		
		//d
		int prosent = 7;
		
		ansatte.stream()
				.filter(a -> a.getStilling().contains("Chief"))
				.forEach(a -> a.settaarsLonn(a.getaarsLonn() * (100 + prosent) / 100));
		
		System.out.println("Liste med ansatte etter lønnsøkning på sjefer:");
		skrivUtAlle(ansatte);
		System.out.println();
		
		//e
		long tjenerOver800k = ansatte.stream()
				.filter(a -> a.getaarsLonn() > 800000)
				.count();
		System.out.println("Lønn over 800.000: " + tjenerOver800k + "\n");
		
		//f
		System.out.println("Liste med ansatte uten for loop:");
		List<Ansatt> listeAnsatte = ansatte.stream()
			.collect(Collectors.toList());
		listeAnsatte.forEach(System.out::println);
		System.out.println();
		
		//g
		Optional<Ansatt> lavestLonn = ansatte.stream()
			.reduce((a, b) -> a.getaarsLonn() < b.getaarsLonn() ? a : b);
		
		System.out.println("Lavest lønn: " + lavestLonn + "\n");
		
		//h
		System.out.println("Tall delelige med 3 eller 5:");
		int[] talldelelige = IntStream.range(1, 999)
			.filter(a -> a % 3 == 0 || a % 5 == 0)
			.toArray();
		
		for (int i = 0; i < talldelelige.length; i++) {
		    System.out.printf("%4d ", talldelelige[i]);     
		    if ((i + 1) % 20 == 0) System.out.println();
		}  

	}
	
	

}
