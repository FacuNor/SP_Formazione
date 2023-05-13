package rubricaEs5_6;

public class ArchiveFullException extends ArchiveException {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ArchiveFullException(IScheda schedaInErrore) {
		super(schedaInErrore);
	}

	@Override
	public String toString() {
		return "Errore: ARCHIVIO PIENO.\n" + "IMPOSSIBILE INSERIRE: " + this.getSchedaErrore().toString() + "\n"
				+ this.getStackTrace();
	}
	
}
