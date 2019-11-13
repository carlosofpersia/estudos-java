package agosto;

import java.util.Iterator;
import java.util.Arrays;

public class Onze {
	public static void main(String[] args) {

		//String[] str = {"Carlos", "Eduardo"};
		Iterator<String> str;
		for (Iterator<String> iter = str.iterator(); iter.hasNext();) {
			String s = iter.next();
			System.out.print(s);
		}

		System.out.println("-------------------------");
	
		String[] words = {"ball", "book", "computer", "car", "elephant", "nice"};		
		Arrays.sort(words, (first, second) -> Integer.compare(first.length(), second.length()));
		for(String word : words) {
			System.out.println(word);
		}
	}
}
