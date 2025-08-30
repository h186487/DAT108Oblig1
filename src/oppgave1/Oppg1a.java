package oppgave1;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Oppg1a {

	public static void main(String[] args) {
		
		List<String> listen = Arrays.asList("10", "1", "20", "110", "21", "12");

		//compare string->int a - b (result relative to a)
		//equal: no change in order
		//negative: a is smaller, a comes before b
		//positive: a is bigger, a comes after b
		Comparator<String> comparator = (a, b) -> Integer.parseInt(a) - Integer.parseInt(b); 
		
		Collections.sort(listen, comparator);
		
		System.out.println(listen);
		
	}

}
