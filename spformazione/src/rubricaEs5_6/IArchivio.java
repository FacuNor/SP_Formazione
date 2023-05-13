package rubricaEs5_6;

public interface IArchivio {
		
	void insert(IScheda s) throws ArchiveException;
	void delete(IScheda s) throws ArchiveException;
	IScheda[] search(String s);
}
