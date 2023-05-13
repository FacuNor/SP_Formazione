package rubricaEs5_6;

public class ElementAlreadyInArchiveException extends ArchiveException{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ElementAlreadyInArchiveException(IScheda schedaInErrore) {
		super(schedaInErrore);
	}
	
	@Override
	public String toString() {
		return "Errore: ELEMENTO "+this.getSchedaErrore().toString()+" GIA' IN ARCHIVIO.\n"+this.getStackTrace();
	}

}
