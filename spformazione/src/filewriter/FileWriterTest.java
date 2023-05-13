package filewriter;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

public class FileWriterTest {

	public static void main(String[] args) {
		FileWriterTest main = new FileWriterTest();
		main.init();
	}

	private void init() {
		File fileIn = new File("Copio.txt");

		FileWriter fw;
		try {
			fw = new FileWriter(fileIn);
		} catch (IOException e1) {
			e1.printStackTrace();
			return;
		}
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(fw);
		String input;
		try {
			while(!(input=br.readLine()).equalsIgnoreCase("stop")) {
				//System.out.println(input);
				bw.write(input+"\n");
			}
		} catch (IOException e) {
			System.err.println("Errore lettura input");
			e.printStackTrace();
		}finally {
			try {
				br.close();
				fw.flush();
				bw.close();
				fw.close();
			} catch (IOException e) {
				System.err.println("Errore chiusure");
				e.printStackTrace();
			}
			
		}
		System.out.println("END.");
	}
}
