package interpretedstream;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FileCreaDataOutputStream {

	private static final int EOF = -1;

	private char lineSeparator = System.getProperty("line.separator").charAt(0);

	public static void main(String[] args) {

		FileCreaDataOutputStream main = new FileCreaDataOutputStream();
		main.scrivo();
		main.leggo();
		main.leggoScanner();
		
	}

	private void leggo() {
		List<Double> prices = new ArrayList<>();
		List<Integer> units = new ArrayList<>();
		List<String> desc = new ArrayList<>();

		DataInputStream in;
		try {
			in = new DataInputStream(new FileInputStream("Fatture.txt"));
			boolean cicla = true;
			while (cicla) {
				prices.add(in.readDouble());
				units.add(in.readInt());
				StringBuffer s = new StringBuffer();
				char c;
				while ((c = in.readChar()) != lineSeparator && c != EOF) {
					s.append(c);
				}
				desc.add(s.toString());
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (EOFException e) {
			// SE FINISCE QUA DENTRO E' OK!
			System.out.println("Ho trovato: ");
			for (int i = 0; i < prices.size(); i++) {
				System.out.print(prices.get(i) + " " + units.get(i) + " " + desc.get(i));
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void scrivo() {
		try {
			DataOutputStream out = new DataOutputStream(new FileOutputStream("Fatture.txt"));

			double[] prices = { 19.99, 9.99, 15.99, 3.99, 4.99 };
			int[] units = { 12, 8, 13, 29, 50 };
			String[] desc = { "T-shirt", "Mug", "Duke", "Pin", "Key-Chain" };

			for (int i = 0; i < prices.length; i++) {
				out.writeDouble(prices[i]);
				out.writeInt(units[i]);
				out.writeChars(desc[i]);
				out.writeChar('\n');
				out.writeChar(lineSeparator);
			}
			out.close();

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	private void leggoScanner() {
		// PER LEGGERE E SALVARE IN UNA STRUTTURA
//		List<Double> prices = new ArrayList<>();
//		List<Integer> units = new ArrayList<>();
//		List<String> desc = new ArrayList<>();
//		
//		File input = new File("InScanner.txt");
//		File output = new File("OutScanner");  
//		
//		try {
//			Scanner s = new Scanner(input);
//			while(s.hasNextLine()) {
//				if(!s.hasNextDouble()) {
//					System.err.println("HALO1");
//				}
//				prices.add(s.nextDouble());
//				if(!s.hasNextInt()) {
//					System.err.println("HALO2");
//				}
//				units.add(s.nextInt());
//				if(!s.hasNext()) {
//					System.err.println("HALO3");
//				}
//				desc.add(s.next());
//			}
//			s.close();
//		} catch (FileNotFoundException e) {
//			System.err.println("Errore scanner");
//			e.printStackTrace();
//			return;
//		} catch (IOException e) {
//			e.printStackTrace();
//		}

		// PER COPIARE UN FILE
		File input = new File("InScanner.txt");
		File output = new File("OutScanner.txt");

		try {
			Scanner s = new Scanner(input);
			FileWriter fw = new FileWriter(output);
			int i = 0;
			while (s.hasNextLine()) {
				if (i++ != 0) {
					fw.write('\n');
				}
				fw.write(s.nextLine());
				//i++;
			}
			s.close();
			fw.flush();
			fw.close();
		} catch (FileNotFoundException e) {
			System.err.println("Errore scanner");
			return;
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}
