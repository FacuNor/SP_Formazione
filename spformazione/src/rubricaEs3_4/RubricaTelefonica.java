package rubricaEs3_4;

import java.util.Arrays;

public class RubricaTelefonica implements IRubrica {

	private SchedaPersona[] rubrica;
	private int numAttuale;

	public RubricaTelefonica(int maxNumeri) {
		super();
		this.rubrica = new SchedaPersona[maxNumeri];
		this.numAttuale = 0;
	}

	@Override
	public boolean insert(SchedaPersona s) {
		if (s == null) {
			return false;
		}
		if (numAttuale == rubrica.length) {
			return false;
		}
		for (int i = 0; i < numAttuale; i++) {
			if (rubrica[i].equals(s)) {
				return false;
			}
		}
		rubrica[numAttuale] = s;
		numAttuale++;
		return true;
	}

	@Override
	public SchedaPersona[] search(String s) {
		if (s == null || s.isBlank() || s.isEmpty()) {
			return new SchedaPersona[0];
		}
		SchedaPersona[] result = new SchedaPersona[numAttuale];
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
	public boolean delete(SchedaPersona s) {
		if (s == null) {
			return false;
		}
		for (int i = 0; i < numAttuale; i++) {
			if (rubrica[i].equals(s)) {
				this.remove(i);
				return true;
			}
		}
		return false;
	}

	private void remove(int i) {
		for (int j = i; j < numAttuale - 1; j++) {
			rubrica[j] = rubrica[j + 1];
		}
		numAttuale--;
		rubrica[numAttuale] = null;
	}

}
