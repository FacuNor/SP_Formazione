package rubricaEs5_6;

import java.util.Arrays;

public class RubricaTelefonica implements IArchivio {

	private IScheda[] rubrica;
	private int numAttuale;

	public RubricaTelefonica(int maxNumeri) {
		super();
		this.rubrica = new IScheda[maxNumeri];
		this.numAttuale = 0;
	}

	@Override
	public void insert(IScheda s) throws ArchiveException{
		if (s == null) {
			return;
		}
		if (numAttuale == rubrica.length) {
			throw new ArchiveFullException(s);
		}
		for (int i = 0; i < numAttuale; i++) {
			if (rubrica[i].equals(s)) {
				throw new ElementAlreadyInArchiveException(s);
			}
		}
		rubrica[numAttuale] = s;
		numAttuale++;
	}

	@Override
	public IScheda[] search(String s) {
		if (s == null || s.isBlank() || s.isEmpty()) {
			return new SchedaPersona[0];
		}
		IScheda[] result = new IScheda[numAttuale];
		int j = 0;
		for (int i = 0; i < numAttuale; i++) {
			if (rubrica[i].contains(s)) {
				result[j] = rubrica[i];
				j++;
			}
		}
		return Arrays.copyOfRange(result, 0, j);
	}

	@Override
	public String toString() {
		StringBuilder result = new StringBuilder("Rubrica:\n");
		for (int i = 0; i < numAttuale; i++) {
			result.append(rubrica[i].toString());
			result.append("\n");
		}
		return result.toString();
	}

	@Override
	public void delete(IScheda s) throws ArchiveException{
		if (s == null) {
			return;
		}
		for (int i = 0; i < numAttuale; i++) {
			if (rubrica[i].equals(s)) {
				this.remove(i);
				return;
			}
		}
		throw new ElementNotInArchiveException(s);
	}

	private void remove(int i) {
		for (int j = i; j < numAttuale - 1; j++) {
			rubrica[j] = rubrica[j + 1];
		}
		numAttuale--;
		rubrica[numAttuale] = null;
	}

}
