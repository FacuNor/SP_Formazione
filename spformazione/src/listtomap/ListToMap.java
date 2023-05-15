package listtomap;

import java.util.DoubleSummaryStatistics;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class ListToMap implements IListMap{

	@Override
	public Map<String, Book> listToMapOldStyle(List<Book> list) {
		Map<String, Book> result = new HashMap<>();
		for (Book book : list) {
			result.put(book.getIsbn(), book);
		}
		return result;
	}

	@Override
	public Map<String, Book> listToMapWithLambda(List<Book> list) {
//		Map<String, Book> result = new HashMap<>();
//		list.stream().forEach(s->{
//			result.put(s.getIsbn(), s);
//		});
//		return result;
		
	 	return list.stream().collect(Collectors.toMap(b -> b.getIsbn(), b-> b));
	}

	@Override
	public Map<String, Book> listToMapWithReference(List<Book> list) {
		return list.stream().collect(Collectors.toMap(Book::getIsbn, b->b));
	}

	@Override
	public Map<String, Book> listToMapWithFunctionIdentity(List<Book> list) {
		return list.stream().collect(Collectors.toMap(Book::getIsbn, Function.identity()));
	}

	@Override
	public Map<String, List<Book>> listToMapWithNoDuplicateList(List<Book> list) {
//		Map<String, List<Book>> result = new HashMap<>();	
//		
//		list.stream().forEach(s->{
//			if(result.containsKey(s.getIsbn())) {
//				result.get(s.getIsbn()).add(s);
//			}else {
//				result.put(s.getIsbn(), new ArrayList<>());
//				result.get(s.getIsbn()).add(s);
//			}
//		});
//		return result;
		
		return list.stream().collect(Collectors.groupingBy(Book::getIsbn));
	}

	@Override
	public Map<String, Book> listToMapWithNoDuplicate(List<Book> list) {
		return list.stream().collect(Collectors.toMap(Book::getIsbn,
														Function.identity(),
														(first,second)->first));
	}

	@Override
	public Map<String, List<Book>> listToMapIsbnGreaterThen(List<Book> books, String isbn) {
		return books.stream()
						.filter(s-> (s.getIsbn().compareToIgnoreCase(isbn))>0)
						.collect(Collectors.groupingBy(Book::getIsbn));
	}

	@Override
	public String bookNamesJoined(List<Book> books) {
		return books.stream().map(s -> s.getDesc()).collect(Collectors.joining(", ","[","]"));
	}

	@Override
	public double averageBookPrize(List<Book> books) {
		//return books.stream().mapToDouble(s -> s.getPrice()).average().getAsDouble();
		return books.stream().collect(Collectors.averagingDouble(s -> s.getPrice()));
	}

	@Override
	public double totalCost(List<Book> books) {
		//return books.stream().mapToDouble(s-> s.getPrice()).sum();
		return books.stream().collect(Collectors.summingDouble(s -> s.getPrice()));
	}

	@Override
	public DoubleSummaryStatistics bookStatistics(List<Book> books) {
		return books.stream().mapToDouble(s -> s.getPrice()).summaryStatistics();
	}

	@Override
	public String[] bookAuthors(List<Book> books) {
		return books.stream()
						.map(s -> s.getAuthor())
						.distinct()
						.collect(Collectors.toList())
						.toArray(new String[0]);
	}

	@Override
	public String[] bookAuthors(List<Book> books, String nazione) {
		return books.stream()
						.filter(s -> s.getNazione().equalsIgnoreCase(nazione))
						.map(s -> s.getAuthor())
						.collect(Collectors.toList())
						.toArray(new String[0]);
	}

}
