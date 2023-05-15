package stream;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
//import java.util.Map;
//import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Parole implements IParole {

	private String fileName;
//	private int count;

	public Parole(String fileName) {
		if(fileName == null || fileName.isBlank()) {
			this.fileName = "";
		}else {
			this.fileName = fileName;
		}
	}
	
	private Stream<String> getFileStrem() {
		File file = new File(fileName);
		Stream<String> fileLineStream;

		try {
			fileLineStream = Files.lines(file.toPath());
			return fileLineStream;
		} catch (IOException e) {
			return Stream.empty();
		}
	}

	@Override
	public int countAll() {
//		List<String> resultList = getFileStrem()
//								//.map(s -> s.trim())
//								.flatMap(line -> Arrays.stream(line.split("\\s+")))
//								.filter(s -> !s.isEmpty())
//								.collect(Collectors.toList());
//		return (int) resultList.stream().count();
		return (int)getFileStrem()
						//.map(s -> s.trim())
						.flatMap(line -> Arrays.stream(line.split("\\s+")))
						.filter(s -> !s.isEmpty())
						.count();
	}

	@Override
	public String[] parole() {
//		List<String> resultList = getFileStrem()
//									.map(s -> s.trim())
//									.flatMap(line -> Arrays.stream(line.split("\\s+")))
//									.filter(s -> !s.isEmpty())
//									.collect(Collectors.toList());
//		return resultList.toArray(new String[resultList.size()]);
		return getFileStrem()
				.map(s -> s.trim())
				.flatMap(line -> Arrays.stream(line.split("\\s+")))
				.filter(s -> !s.isEmpty())
				.collect(Collectors.toList())
				.toArray(new String[0]);
		
	}

	@Override
	public int count(String parola) {
		if(parola==null||parola.isBlank()||parola.isEmpty()) {
			return 0;
		}
		//SOLUZIONE 1
//		Map<String, Long> resultMap = getFileStrem()
//										.map(s -> s.trim())
//										.flatMap(line -> Arrays.stream(line.split("\\s+")))
//										.filter(s -> !s.isEmpty())
//										.map(s -> s.toLowerCase())
//										.collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
//
//		if (resultMap.containsKey(parola.toLowerCase())) {
//			return resultMap.get(parola.toLowerCase()).intValue();
//		}
//		return 0;
		//SOLUZIONE 2
//		count = 0;
//		getFileStrem()
//			.map(s -> s.trim())
//			.flatMap(line -> Arrays.stream(line.split("\\s+")))
//			.filter(s -> !s.isEmpty())
//			//.map(s -> s.toLowerCase())
//			.forEach(s-> {
//				if(s.equalsIgnoreCase(parola)) {
//					count++;
//				}
//			});
//		return count;
		//SOLUZIONE 3 
		return getFileStrem()
		.map(s -> s.trim())
		.flatMap(line -> Arrays.stream(line.split("\\s+")))
		.filter(s -> !s.isEmpty())
		.filter(s-> s.equalsIgnoreCase(parola))
		.collect(Collectors.counting()).intValue();
	}

	@Override
	public String parolaMax() {
		List<String> resultList = getFileStrem()
								.map(s -> s.trim())
								.map(s -> s.toLowerCase())
								.flatMap(line -> Arrays.stream(line.split("\\s+")))
								.filter(s -> !s.isEmpty()).sorted(new Comparator<String>() {
																						@Override
																						public int compare(String o1, String o2) {
																							return -o1.compareToIgnoreCase(o2);
																							}
																						})
								.collect(Collectors.toList());
		
		if(resultList.size()>0) {
			return resultList.get(0);
		}
		return "";
	}

	@Override
	public String[] parolaLenghtLess(int numChar) {
//		List<String> resultList = getFileStrem()
//									.map(s -> s.trim())
//									.flatMap(line -> Arrays.stream(line.split("\\s+")))
//									.filter(s -> !s.isEmpty())
//									.filter(s -> s.length() < numChar)
//									.collect(Collectors.toList());
//
//		return resultList.toArray(new String[resultList.size()]);
		
		return getFileStrem()
//				.map(s -> s.trim())
				.map(String::trim)
				.flatMap(line -> Arrays.stream(line.split("\\s+")))
				.filter(s -> !s.isEmpty())
				.filter(s -> s.length() < numChar)
				.collect(Collectors.toList())
				.toArray(new String[0]);
	}

}
