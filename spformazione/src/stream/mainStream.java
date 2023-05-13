package stream;

import java.util.Arrays;

public class mainStream {

	public static void main(String[] args) {
		IParole parole = new Parole("Esempio.txt");
		
		System.out.println(Arrays.toString(parole.parolaLenghtLess(5)));

	}

}
