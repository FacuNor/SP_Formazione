package rubricaEs3_4;

public interface IRubrica {

	public boolean insert(SchedaPersona s);

	public SchedaPersona[] search(String s);

	public String toString();

	public boolean delete(SchedaPersona s);
}
