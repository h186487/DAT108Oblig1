package oppgave3;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Oppg3 {

	public static void main(String[] args) {
		
		
		List<Ansatt> ansatte = new ArrayList<>();
		ansatte.add(new Ansatt("Jenny", "Hopland", Kjonn.KVINNE, "Utvikler", 500000));
		ansatte.add(new Ansatt("Marte", "Sævig", Kjonn.KVINNE, "Chief financial officer", 500100));
		ansatte.add(new Ansatt("Nadia", "Lambrecht", Kjonn.KVINNE, "Utvikler", 500200));
		ansatte.add(new Ansatt("Andreas", "Ødegard", Kjonn.MANN, "Utvikler", 400900));
		ansatte.add(new Ansatt("Bashar", "Mohamad", Kjonn.MANN, "Chief technical officer", 500300));

		System.out.println("Original lønn");
		ansatte.forEach(System.out::println);
		
		//a
		List<String> etternavnList = ansatte.stream()
				.map(a -> a.getEtternavn())
				.collect(Collectors.toList());
		
		System.out.println("\nListe med etternavn:");
		etternavnList.forEach(System.out::println);
		
		//b
		
		long antallKvinner = ansatte.stream()
				.filter(Ansatt::erKvinne)
				.count();
		
		System.out.println("\nAntall kvinner: " + antallKvinner);
		
		//c
		int totalKvinnerLonn = ansatte.stream()
				.filter(Ansatt::erKvinne)
//				.mapToInt(a -> a.getaarsLonn())
				.mapToInt(Ansatt::getaarsLonn)
				.sum();
		
		System.out.println("\nGjennomsnittslønn kvinner: " + totalKvinnerLonn/antallKvinner);
		
		//d

		List<Ansatt> lonnsokningSjefer = ansatte.stream()
				.map(a -> Ansatt.erSjef(a)
					? new Ansatt(a.fornavn, a.etternavn, a.kjonn, a.stilling, (a.getaarsLonn()* 107/100))
					: a)
				.collect(Collectors.toList());
		
		System.out.println("\nListe med ansatte etter lønnsøkning på sjefer:");
		lonnsokningSjefer.forEach(System.out::println);
		
		//e
		long tjenerOver800k = ansatte.stream()
				.filter(a -> a.getaarsLonn() > 800000)
				.count();
		
		System.out.println("\nLønn over 800.000: " + tjenerOver800k);
		
		//f
		List<Ansatt> listeAnsatte = ansatte.stream()
			.collect(Collectors.toList());
		
		System.out.println("Liste med ansatte uten for loop:");
		listeAnsatte.forEach(System.out::println);
		
		//g
//		Optional<Ansatt> lavesteLonn = ansatte.stream()
//			.reduce((a, b) -> a.getaarsLonn() < b.getaarsLonn() ? a : b);
		
		Ansatt lavestLonn = ansatte.stream()
				.min(Comparator.comparingInt(Ansatt::getaarsLonn))
				.get();
		
		System.out.println("\nLavest lønn: " + lavestLonn);
		
		//h
		System.out.println("\nTall delelige med 3 eller 5:");
		int[] talldelelige = IntStream.range(1, 999)
			.filter(a -> a % 3 == 0 || a % 5 == 0)
			.toArray();
		
		//oversiktlig print loop
		for (int i = 0; i < talldelelige.length; i++) {
		    System.out.printf("%4d ", talldelelige[i]);     
		    if ((i + 1) % 20 == 0) System.out.println();
		}  

	}
	
	

}
