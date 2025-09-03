package oppgave1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Oppg1a {

	public static void main(String[] args) {
		
		List<String> listen = Arrays.asList("10", "1", "20", "110", "21", "12");
		
		//oppretter ny liste som lagrer strings som integers for å kunne numerisk sortere senere
		List<Integer> result = new ArrayList<>();
		for (String s : listen) {
			result.add(Integer.parseInt(s));
		}
		
		//compareto er relativ til a
		//negativ: a er mindre, a kommer før b
		//equal: a er lik b, ingen endring
		//positiv: a er større, a kommer etter b
		Collections.sort(result, (a, b) -> a.compareTo(b));
		
		System.out.println("Sortert liste:");
		result.forEach(System.out::println);
		
		
		//metode uten bruk av collections som lambda uttrykk 
		
		List<Integer> result2 = listen.stream()
				.map(Integer::parseInt)
				.sorted()
				.collect(Collectors.toList());
		
		
		System.out.println("\nSortert liste (uten bruk av collections som lambda uttrykk): ");
		result2.forEach(System.out::println);
	}

}