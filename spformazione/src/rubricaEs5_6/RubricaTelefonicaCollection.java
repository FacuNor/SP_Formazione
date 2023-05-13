package rubricaEs5_6;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class RubricaTelefonicaCollection implements IArchivio {

	private Set<IScheda> rubrica;
	
	public RubricaTelefonicaCollection() {
		super();
		this.rubrica = new LinkedHashSet<>();
	}
	
	@Override
	public void insert(IScheda s) throws ArchiveException{
		if(s==null) {
			return;
		}
		for (IScheda scheda : rubrica) {
			if(scheda.equals(s)) {
				throw new ElementAlreadyInArchiveException(s);
			}
		}
		rubrica.add(s);
	}

	@Override
	public void delete(IScheda s) throws ArchiveException{
		if(s==null) {
			return;
		}
		for (Iterator<IScheda> iterator = rubrica.iterator(); iterator.hasNext();) {
			IScheda scheda = (IScheda) iterator.next();
			if(scheda.equals(s)) {
				iterator.remove();
				return;
			}
		}
		throw new ElementNotInArchiveException(s);
	}

	@Override
	public IScheda[] search(String s) {
		List<IScheda> result=new ArrayList<>();
		if(s==null||s.isBlank()||s.isEmpty()) {
			return result.toArray(new IScheda[result.size()]);
		}
		for (IScheda scheda : rubrica) {
			if(scheda.contains(s)) {
				result.add(scheda);
			}
		}
		return result.toArray(new IScheda[result.size()]);
	}
	
	@Override
	public String toString() {
		StringBuilder result = new StringBuilder("Rubrica:\n");
		for (IScheda scheda : rubrica) {
			result.append(scheda.toString());
			result.append("\n");
		}
		return result.toString();
	}

}
