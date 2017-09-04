package project.navn;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Application {

	public static void main(String[] args) {
		System.out.println("Starting Program");

		List<Character> tl1 = new ArrayList<Character>();
		List<Character> tl2 = new ArrayList<Character>();
		List<Character> tl3 = new ArrayList<Character>();
		List<Character> tl4 = new ArrayList<Character>();

		tl1.add('q');
		tl1.add('w');
		tl1.add('e');
		tl1.add('r');
		tl1.add('t');
		tl1.add('y');
		tl1.add('u');
		tl1.add('i');
		tl1.add('o');
		tl1.add('p');
		tl2.add('a');
		tl2.add('s');
		tl2.add('d');
		tl2.add('f');
		tl2.add('g');
		tl2.add('h');
		tl2.add('j');
		tl2.add('k');
		tl2.add('l');
		tl3.add('z');
		tl3.add('x');
		tl3.add('c');
		tl3.add('v');
		tl3.add('b');
		tl3.add('n');
		tl3.add('m');
		tl4.add('a');
		tl4.add('s');

		List<ArrayList> tastaturLinjer = new ArrayList<ArrayList>();
		tastaturLinjer.add((ArrayList<Character>) tl1);
		tastaturLinjer.add((ArrayList<Character>) tl2);
		tastaturLinjer.add((ArrayList<Character>) tl3);
		tastaturLinjer.add((ArrayList<Character>) tl4);

		String fileName = "C:\\workspace\\project.navn\\src\\main\\resources\\navn.csv";
		File file = new File(fileName);

		List<String> lines = new ArrayList<String>();
		Scanner inputStream;

		try {
			inputStream = new Scanner(file);

			while (inputStream.hasNext()) {
				String line = inputStream.next();
				lines.add(line);
			}

			inputStream.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		for (int k = 0; k < lines.size(); k++) {

			for (int i = 0; i < tastaturLinjer.size(); i++) {
				if (sjekkNavn(lines.get(k), tastaturLinjer.get(i))) {

					System.out.println(lines.get(k));
				}
			}

		}
	}

	public static boolean containsChar(String s, char search) {
		if (s.length() == 0)
			return false;
		else
			return s.charAt(0) == search || containsChar(s.substring(1), search);
	}

	public static boolean sjekkTastaturLinje(char search, List<Character> tastaturlinje) {
		search = Character.toLowerCase(search);
		return tastaturlinje.contains(search);
	}

	public static boolean sjekkNavn(String navn, List<Character> tastaturlinje) {
		boolean kanSkrives = true;

		for (int i = 0; i < navn.length(); i++) {
			char bokstav = navn.charAt(i);
			if (sjekkTastaturLinje(bokstav, tastaturlinje)) {
				// System.out.println("Bokstav ok: " + bokstav);
			} else {
				kanSkrives = false;
				// System.out.println("Bokstav finnes ikkje på linje: " + bokstav);
				break;
			}
			if (i == navn.length()) {
				System.out.print(navn);

			}

		}
		if (kanSkrives) {
			// System.out.println("navn: " + navn);
		}
		return kanSkrives;
	}
}
