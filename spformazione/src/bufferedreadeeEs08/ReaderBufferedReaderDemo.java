package bufferedreadeeEs08;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class ReaderBufferedReaderDemo {
	
	private static final int EOF = -1;
	private static final int CR = '\r';
	private static final int LR = '\n';

	public static void main(String[] args) {
		ReaderBufferedReaderDemo main = new ReaderBufferedReaderDemo();
		main.leggoPerCarattere();
		main.leggoPerRiga();
		main.copioFile();
	}
	
	private void copioFile() {
		FileReader fr;
		FileWriter fw;
		File inFile = new File("Esempio.txt");
		File outFile = new File("Copio.txt");
		try {
			fr = new FileReader(inFile);
		} catch (FileNotFoundException e1) {
			System.err.println("File da copiare non trovato(copioFile).");
			e1.printStackTrace();
			return;
		}
		try {
			fw = new FileWriter(outFile);
		} catch (IOException e1) {
			System.err.println("Errore apertura file di backup(copioFile");
			e1.printStackTrace();
			try {
				fr.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			return;
		}
		
		BufferedReader br = new BufferedReader(fr);
		int leggo;
		try {
			while((leggo=br.read())!=EOF) {
				fw.write(leggo);
			}
		} catch (IOException e) {
			System.err.println("Errore lettura file(copioFile).");
			e.printStackTrace();
			return;
		}finally {
			try {
				br.close();
			} catch (IOException e) {
				System.err.println("Errore chiusura BufferFile letto(copioFile).");
				e.printStackTrace();
			}

			try {
				fr.close();
			} catch (IOException e) {
				System.err.println("Errore chiusura File letto(copioFile).");
				e.printStackTrace();
			}
			try {
				fw.close();
			} catch (IOException e) {
				System.err.println("Errore chiusuraFile di backup(copioFile).");
				e.printStackTrace();
			}
		}
		if(inFile.length()==outFile.length()) {
			System.out.println("File \""+inFile.getName() + "\" copiato correttamente nel file: \""+outFile.getName()+"\"");
		}
		System.out.println("File in: "+inFile.getAbsolutePath());
		System.out.println("File out: "+outFile.getAbsolutePath());
	}

	private void leggoPerRiga() {
		FileReader fr;
		try {
			fr = new FileReader(new File("Esempio.txt"));
		} catch (FileNotFoundException e1) {
			System.err.println("File non trovato(leggoPerRiga).");
			e1.printStackTrace();
			return;
		}
		BufferedReader br = new BufferedReader(fr);
		String leggo;
		try {
			while((leggo=br.readLine())!=null) {
				if(leggo.isEmpty()) {continue;}
				if(leggo.isBlank()) {continue;}
				System.out.println(leggo);
			}
		} catch (IOException e) {
			System.err.println("Errore lettura file(leggoPerRiga).");
			e.printStackTrace();
			return;
		}finally {
			try {
				br.close();
			} catch (IOException e) {
				System.err.println("Errore chiusura file(leggoPerRiga).");
				e.printStackTrace();
			}
		}
	}

	public void leggoPerCarattere() {
		FileReader fr;
		
		try {
			fr = new FileReader(new File("Esempio.txt"));
		} catch (FileNotFoundException e1) {
			System.err.println("File non trovato(leggoPerCarattere).");
			e1.printStackTrace();
			return;
		}
		
		BufferedReader br = new BufferedReader(fr);
		int leggo;
		try {
			while ((leggo = br.read()) != EOF) {
				if(leggo == CR) {continue;}
				if(leggo == LR) {continue;}
				System.out.print((char)leggo);
			}
			System.out.println("");
		} catch (IOException e) {
			System.err.println("Errore lettura file(leggoPerCarattere).");
			e.printStackTrace();
			return;
		}finally {
			try {
				br.close();
			} catch (IOException e) {
				System.err.println("Errore chiusura file(leggoPerCarattere).");
				e.printStackTrace();
			}
		}
		
	}
}
