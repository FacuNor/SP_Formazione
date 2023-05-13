package demo;

import java.util.Collection;
import java.util.HashMap;
import java.util.Scanner;

public class ContaOccorenzeParole {

	public static void main(String[] args) {
		// Scanner che mi serve per l'input
		Scanner scanner = new Scanner(System.in);
		//Booleano che fa terminare il ciclo di acquisizione parole
		boolean cicla = true;
		//Mappa dove vengono salvate le parole inserite con le relative occorrenze
		HashMap<String, Integer> paroleHM = new HashMap<>();
		//numero totale delle parole inserite
		int numParole = 0;

		//Cicclo di acquisizione parole
		while (cicla) {

			System.out.println("Inserisci una parola:");
			System.out.println("END per terminare l'acquisizione.");
			String stringa = scanner.next();
			
			if(stringa.equals("END")) {
				cicla = false;
				continue;
			}
			
			if (paroleHM.keySet().contains(stringa)) {
				// Incremento il valore di una parola esistente
				int i = paroleHM.get(stringa);
				i++;
				paroleHM.put(stringa, i);
				numParole++;
			} else {
				paroleHM.put(stringa, 1);
				numParole++;
			}
			//-----------------------------------------------------------------
			//Ciclo che serve al menù per continuare a ciclare o terminare + tutti i relativi controlli di input
			/*
			boolean ciclaComando = true;
			while(ciclaComando) {
				System.out.println("Vuoi inserire un'altra parola?\n1 per SI 0 per NO");
				if(scanner.hasNextInt()) {
					int continuo = scanner.nextInt();
					if(continuo==0) {
						ciclaComando=false;
						cicla = false;
					}else if (continuo == 1) {
						ciclaComando=false;
					}else {
						System.out.println("Inserito un valore non valido");
					}
				}else {
					System.out.println("Inserito un valore errato");
					scanner.next();
				}
			}
			*/
		}
		scanner.close();

		// Stampo il numero di parole inserite
		System.out.println("\nHai inserito " + numParole + " parole.");

		// Unisco le parole separate da spazi
		StringBuilder stringBuilder = new StringBuilder();

		for (String parola : paroleHM.keySet()) {
			stringBuilder.append(parola);
			stringBuilder.append(" ");
		}
		System.out.println("\nHai inserito le seguenti parole:");
		System.out.println(stringBuilder);

		// Stampo il numero di ocorrenze di ogni parola trovata
		System.out.println("\nElenco parole con relative occorrenze:");
		for (String string : paroleHM.keySet()) {
			System.out.println("Hai inserito la parola " + string + " " + paroleHM.get(string) + " volte.");
		}
		
		// Stampo la/le parola/e con più occorrenze
		int maxOccorrenze = max(paroleHM.values());
		System.out.println("\nEcco la/le parola/e con più occorrenze:");
		for (String string : paroleHM.keySet()) {
			if (paroleHM.get(string) == maxOccorrenze) {
				System.out.println("Parola: " + string + " Occorrenze: " + paroleHM.get(string));
			}
		}
	}

	/**
	 * @param collezione di interi POSITIVI
	 * @return il valore massimo del vettore
	 */
	public static int max(Collection<Integer> vettore) {
		// inizializzo a -1 perché il vettore avrà solo valori positivi
		int max = -1;
		for (int i : vettore) {
			if (i > max) {
				max = i;
			}
		}
		return max;
	}

}
