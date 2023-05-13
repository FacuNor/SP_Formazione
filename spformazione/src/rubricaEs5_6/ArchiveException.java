package rubricaEs5_6;

public abstract class ArchiveException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private IScheda schedaInErrore;
	
	public ArchiveException(IScheda schedaInErrore) {
		this.schedaInErrore=schedaInErrore;
	}
	public IScheda getSchedaErrore() {
		return schedaInErrore;
	}

	public abstract String toString();
}
