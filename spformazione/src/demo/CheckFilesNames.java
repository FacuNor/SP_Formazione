package demo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class CheckFilesNames {

	private String input;
	private int numFileDiscarded;
	private int numFileOK;
	private ArrayList<Files> files;

	/**
	 * 
	 * @param input Stringa con elenco di nomi di files separati da spazi
	 */
	public CheckFilesNames(String input) {
		super();
		this.input = input;
		this.numFileDiscarded = 0;
		this.numFileOK = 0;
		this.files = new ArrayList<Files>();
	}

	/**
	 * 
	 * @return una string con "NO FILES" se non ci sono file, il numero di file che
	 *         sono OK o "INVALID INPUT" se la stringa ha un formato sbagliato
	 */
	public String checkFiles() {
		if (input == null || input.equals("")) {
			return "INVALID INPUT";
		}

		Scanner leggoInput = new Scanner(input);

		while (leggoInput.hasNext()) {
			// Controllo sulla data
			LocalDate data = ottieniData(leggoInput.next());
			if (data == null) {
				leggoInput.close();
				return "INVALID INPUT";
			}

			// Controllo sulla grandezza
			if (!leggoInput.hasNextInt()) {
				leggoInput.close();
				return "INVALID INPUT";
			}
			int size = leggoInput.nextInt();

			// Controllo sul nome file
			if (!leggoInput.hasNext()) {
				leggoInput.close();
				return "INVALID INPUT";
			}
			String nomeFile = leggoInput.next();
			// Controllo se il nome del file è corretto ("nomeFile.estensione" con
			// estensione = ["rar","zip","tgz"]
			if (!checkNomeFile(nomeFile)) {
				leggoInput.close();
				return "INVALID INPUT";
			}
			// Faccio il controllo sulla data e sulla grandezza
			if (data.isBefore(LocalDate.of(1995, 10, 13)) && size <= 240 * 1024) {

				numFileOK++;
			} else {
				numFileDiscarded++;
				continue;
			}
			// Salvo il file
			files.add(new Files(nomeFile, size, data));

		}
		leggoInput.close();

		// Ritorno "NO FILES" se ci sono solo file scartati oppure il numerro di file
		// salvati
		if (numFileOK != 0) {
			return "" + numFileOK;
		} else {
			return "NO FILES";
		}
	}

	/**
	 * 
	 * @param d stringa in formato "yyyy-mm-dd"
	 * @return la data in formato LocalDate o "null" se la stringa inserita ha un
	 *         formato non valido
	 */
	private LocalDate ottieniData(String d) {
		// Se la stringa è vuota o bianca o null ritorno null
		if (d == null || d.isBlank() || d.isEmpty()) {
			return null;
		}
		try {
			// Dalla stringa prendo i valori numerici
			String[] dataString = d.split("-");
			
			// Se non ci sono 3 campi int ritorno null
			if (dataString.length != 3) {
				return null;
			}

			int yyyy = Integer.parseInt(dataString[0]);
			int mm = Integer.parseInt(dataString[1]);
			int dd = Integer.parseInt(dataString[2]);

			LocalDate result = LocalDate.of(yyyy, mm, dd);
			return result;
		} catch (NumberFormatException e) {
			// Catturo l'errore possibile di parseInt() e ritorno null
			System.err.println("Formato data non corretto!");
			return null;
		} catch (java.time.DateTimeException e) {
			// Catturo l'errore di una data errata (Es. 31 Febbraio) e ritorno null
			System.err.println("Data inserita non esistente!");
			return null;
		}
	}

	/**
	 * 
	 * @param s stringa da controllare
	 * @return true se si tratta del nome di un file rar, zip o tgz, false
	 *         altrimenti
	 */
	private boolean checkNomeFile(String s) {

		String[] nomeFile = s.split("\\.");
		if (nomeFile.length != 2) {
			return false;
		}
		if (nomeFile[1].equals("rar") || nomeFile[1].equals("zip") || nomeFile[1].equals("tgz")) {
			return true;
		}
		return false;
	}

	/**
	 * 
	 * @return il numero di file scartati perché troppo grandi o troppo nuovi
	 */
	public int filesDiscardedCount() {
		return this.numFileDiscarded;
	}

	/**
	 * 
	 * @return ritorna la lista di file salvati attraverso un array
	 */
	public CheckFilesNames.Files[] fileGood() {
		return files.toArray(new Files[files.size()]);
	}

	/**
	 * Stampa la lista dei file ed il loro contenuto
	 */
	public void stampaFiles() {
		for (Files files2 : files) {
			System.out.println(files2.toString());
		}
	}

	/**
	 * 
	 * @author Utente Classe che serve per il salvataggio dei file che la classe
	 *         Outer (CheckFilesNames) riceve come parametro
	 */
	class Files {
		String nome;
		int grandezza;
		LocalDate data;

		// Costruttore
		public Files(String nome, int grandezza, LocalDate data) {
			super();
			this.nome = nome;
			this.grandezza = grandezza;
			this.data = data;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj) {
				return true;
			}
			if (obj == null) {
				return false;
			}
			if (this.getClass() != obj.getClass()) {
				return false;
			}

			Files other = (Files) obj;
			return this.data.equals(other.data) && this.grandezza == other.grandezza && this.nome.equals(other.nome);
		}

		@Override
		public String toString() {
			return "Files [nome=" + nome + ", grandezza=" + grandezza + ", data=" + data + "]";
		}

	}

}
