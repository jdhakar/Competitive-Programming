import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class A_Solution {

	// Complete the solve function below.
	static String solve(List<List<Integer>> grid) {
		Map<Integer, Set<Integer>> xMap = new HashMap<Integer, Set<Integer>>();
		Map<Integer, Set<Integer>> yMap = new HashMap<Integer, Set<Integer>>();
		Integer xTri=null, yTri=null;

		for(List<Integer> l: grid){
			int x = l.get(0);
			int y = l.get(1);
			if(!xMap.containsKey(x)) {
				xMap.put(x, new HashSet<Integer>());
			}
			if(!yMap.containsKey(y)) {
				yMap.put(y, new HashSet<Integer>());
			}
			xMap.get(x).add(y);
			yMap.get(y).add(x);
		}
		for(int k: xMap.keySet()) {
			if(xMap.get(k).size()==3) {
				xTri=k;
			}
		}
		for(int k: yMap.keySet()) {
			if(yMap.get(k).size()==3) {
				yTri=k;
			}
		}
		if(xTri!=null && yTri!=null) {
			int xT=xTri.intValue(), yT=yTri.intValue(); 
		}

		return "No";

	}

	public static void main(String[] args) throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

		int t = Integer.parseInt(bufferedReader.readLine().trim());

		IntStream.range(0, t).forEach(tItr -> {
			try {
				List<List<Integer>> points = new ArrayList<>();

				IntStream.range(0, 5).forEach(i -> {
					try {
						points.add(
								Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
								.map(Integer::parseInt)
								.collect(toList())
								);
					} catch (IOException ex) {
						throw new RuntimeException(ex);
					}
				});

				String result = solve(points);

				bufferedWriter.write(result);
				bufferedWriter.newLine();
			} catch (IOException ex) {
				throw new RuntimeException(ex);
			}
		});

		bufferedReader.close();
		bufferedWriter.close();
	}
}
