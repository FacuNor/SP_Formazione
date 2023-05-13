package serializzazione;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import rubricaEs3_4.SchedaPersona;

public class Serializzazione {

	public static void main(String[] args) {
		
		Serializzazione m = new Serializzazione(); 
		m.creoSerializzazione();
		m.prendoSerializzazione();
	}

	private void creoSerializzazione() {
		SchedaPersona schedaPersona = new SchedaPersona("Facundo Acosta", "Corso bramnde 5 torino", "3277699832");
		
		try {
			ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream("Serializzazione.obj"));
			os.writeObject(schedaPersona);
			os.close();
			System.out.println("Oggetto serializzato");
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

	private void prendoSerializzazione() {
		
		try {
			ObjectInputStream os = new ObjectInputStream(new FileInputStream("Serializzazione.obj"));
			
//			Object object = os.readObject();
//			SchedaPersona s = (SchedaPersona)object;
			
			SchedaPersona s = (SchedaPersona)os.readObject();
			
			System.out.println("Ho trovato: "+s.toString());
			os.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
	}

}
