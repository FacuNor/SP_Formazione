package rubricaEs5_6;

public class ElementNotInArchiveException extends ArchiveException {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public ElementNotInArchiveException(IScheda schedaInErrore) {
		super(schedaInErrore);
	}

	@Override
	public String toString() {
		return "Errore: ELEMENTO "+this.getSchedaErrore().toString()+" NON IN ARCHIVIO.\n"+this.getStackTrace();
	}

}
