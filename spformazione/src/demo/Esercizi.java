package demo;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Esercizi {
	// 27/04/2023
	// ES01
	// Metodo per verificare che una stringa sia palindroma
	public static boolean isPalindroma(String string) {
		// "Pulizia" della stringa
		String parola = string.replaceAll("\\s", "");
		parola = parola.toUpperCase();

		// Ciclo di controllo
		for (int i = 0; i < parola.length() / 2; i++) {
			if (parola.charAt(i) != parola.charAt(parola.length() - 1 - i)) {
				return false;
			}
		}
		return true;
	}

	// ES02
	// Metodo che ordina un array
	public static void mySort(int[] vettore) {
		for (int i = 0; i < vettore.length - 1; i++) {
			for (int j = i + 1; j < vettore.length; j++) {
				if (vettore[j] < vettore[i]) {
					int temp = vettore[j];
					vettore[j] = vettore[i];
					vettore[i] = temp;
				}
			}
		}
	}

	// 28/04/2023
	// ES03
	// Ricerca dicotomica(binaria)
	public static boolean myBinarySearch(int[] vettore, int cerco) {
		if (vettore == null || vettore.length == 0) {
			return false;
		}
		if (vettore[vettore.length / 2] == cerco) {
			return true;
		}
		if (vettore.length == 1) {
			return false;
		}
		if (cerco > vettore[vettore.length / 2]) {
			return myBinarySearch(Arrays.copyOfRange(vettore, vettore.length / 2 + 1, vettore.length), cerco);
		} else {
			return myBinarySearch(Arrays.copyOfRange(vettore, 0, vettore.length / 2), cerco);
		}

	}

	// ES04
	// Riceve una stringa e usando lo Scanner deve estrarre un valore intero, una
	// stringa, un double restituisce un boolean (OK !OK)
	public static boolean leggoStringa(String stringa) {
		// Controlli sulla stringa
		if (stringa == null || stringa.isEmpty() || stringa.isBlank()) {
			return false;
		}
		// Prendo lo scanner
		Scanner scanner = new Scanner(stringa);
		while (scanner.hasNext()) {
			// Controllo se la stringa contiene un intero
			if (!scanner.hasNextInt()) {
				scanner.close();
				return false;
			}
			scanner.nextInt();
			// Controllo se la stringa contiene una stringa
			if (!scanner.hasNext()) {
				scanner.close();
				return false;
			}
			if (scanner.hasNextBoolean() || scanner.hasNextDouble() || scanner.hasNextFloat() || scanner.hasNextInt()
					|| scanner.hasNextLong() || scanner.hasNextShort()) {
				scanner.close();
				return false;
			}
			scanner.next();
			// Controllo se la stringa contiene un double
			if (!scanner.hasNextDouble()) {
				scanner.close();
				return false;
			}
			scanner.nextDouble();
		}
		scanner.close();
		return true;
	}

	// 02/05/2023
	// ES 05
	public int[][] leggiMatrice() {

		int[] dimensioni = new int[2];
		leggiDimensioni(dimensioni);

		int righe = dimensioni[0], colonne = dimensioni[1];

		int[][] matrice = new int[righe][colonne];

		caricaMatrice(matrice, dimensioni);
		//Ciclo che cancella i "numeri in più" (Quando la dimensione data da tastiera è più grande di quella salvata su file
		int[][] temp = new int[dimensioni[0]][dimensioni[1]];
		for (int i = 0; i < dimensioni[0]; i++) {
			for (int j = 0; j < dimensioni[1]; j++) {
				if(matrice[i][j]!=0) {
					temp[i][j]=matrice[i][j];
				}else {
					temp[i][j]=-1;
				}
			}
		}
		matrice=temp;
		//**********
		stampaMatrice(matrice, dimensioni);
		return matrice;

	}

	//Metodo che legge da tastiera le dimensioni della matrice e le salva in un array passato tramite parametro
	private void leggiDimensioni(int[] dimensioni) {
		// int[] dimensioni = new int[2]; // Vettore dove verranno salvate le dimensioni
		Scanner input = new Scanner(System.in); // Scanner per leggere input da tastiera
		boolean cicla = true; // variabile di controllo per rimanere all'interno del ciclo di lettura

		do {// Ciclo che riceve tramite input da tastiera la dimensione delle righe
			System.out.println("Inserisci il numero di righe: ");
			dimensioni[0] = input.nextInt();
			if (dimensioni[0] < 1) {
				System.out.println("Hai inserito un valore non valido: devi inserire un valore positivo.");
			} else {
				cicla = false;
			}
		} while (cicla);

		cicla = true;

		do {// Ciclo che riceve tramite input da tastiera la dimensione delle colonne
			System.out.println("Inserisci il numero di colonne: ");
			dimensioni[1] = input.nextInt();
			if (dimensioni[1] < 1) {
				System.out.println("Hai inserito un valore non valido: devi inserire un valore positivo.");
			} else {
				cicla = false;
			}
		} while (cicla);

		input.close();
	}

	//Metodo che legge la matrice dal file "matrice.txt"
	//Il file DEVE avere lo stesso numero di interi in ogni riga per funzionare
	private void caricaMatrice(int[][] matrice, int[] dimensioni) {
		int righe = dimensioni[0], colonne = dimensioni[1];

		try {

			File input = new File("matrice.txt"); // Apro il file
			Scanner scanner = new Scanner(input); // Scanner per la lettura del file (riga x riga)

			for (int i = 0; i < righe && scanner.hasNextLine(); i++) {
				String riga = scanner.nextLine();
				Scanner leggoRiga = new Scanner(riga);
				for (int j = 0; j < colonne && leggoRiga.hasNextInt(); j++) {
					matrice[i][j] = leggoRiga.nextInt();
					dimensioni[1] = j + 1;
				}
				leggoRiga.close();
				dimensioni[0] = i + 1;
			}
			scanner.close();
		} catch (FileNotFoundException e) {
			System.err.println("Errore apertura file: " + e.getMessage());
		}

	}

	//Metodo che stampa in console la matrice che riceve tramite parametro
	private void stampaMatrice(int[][] matrice, int[] dimensioni) {
		for (int i = 0; i < dimensioni[0]; i++) {
			for (int j = 0; j < dimensioni[1]; j++) {
				System.out.print(matrice[i][j] + " ");
			}
			System.out.println("");
		}
	}
	
	//08/05/2023
	//ES 06
	//Differeze ArrayList e LinkedList
	public void diffArrayListLinkedList() {
		List<Integer> arrayList = new ArrayList<>();
		List<Integer> linkedList = new LinkedList<>();
		
		long time0 = System.currentTimeMillis();
		for(int i=0; i<1000000; i++) {
			arrayList.add(i);
		}
		long time1 = System.currentTimeMillis();
		System.out.println("Per caricare l'arrayList ci sono voluti "+(time1-time0)+" millisecondi");
		
		time0 = System.currentTimeMillis();
		for(int i=0; i<1000000; i++) {
			linkedList.add(i);
		}
		time1 = System.currentTimeMillis();
		System.out.println("Per caricare la linkedList ci sono voluti "+(time1-time0)+" millisecondi");
		
		time0 = System.currentTimeMillis();
		arrayList.add(arrayList.size()-2,-1);
		time1 = System.currentTimeMillis();
		System.out.println("Per inserire un nuovo elemento nell'arrayList ci sono voluti "+(time1-time0)+" millisecondi");
		
		time0 = System.currentTimeMillis();
		linkedList.add(linkedList.size()-2, -1);
		time1 = System.currentTimeMillis();
		System.out.println("Per inserire un nuovo elemento nella linkedList ci sono voluti "+(time1-time0)+" millisecondi");
	}
	
	
	
	
}
