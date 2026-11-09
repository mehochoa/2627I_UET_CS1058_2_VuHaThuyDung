
import java.io.*;
import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result {
  public static List<Double> runningMedian(List<Integer> a) {
    List<Double> result = new ArrayList<>();

    PriorityQueue<Integer> maxPQ =
        new PriorityQueue<>(Collections.reverseOrder());
    PriorityQueue<Integer> minPQ =
        new PriorityQueue<>();

    for (int val : a) {
      maxPQ.add(val);
      minPQ.add(maxPQ.poll());

      if (maxPQ.size() < minPQ.size()) {
        maxPQ.add(minPQ.poll());
      }

      if (maxPQ.size() > minPQ.size()) {
        result.add((double) maxPQ.peek());
      } else {
        result.add(
            (maxPQ.peek() + (double) minPQ.peek()) / 2.0
        );
      }
    }

    return result;
  }
}

public class VUHATHUYDUNG_25020063 {
  public static void main(String[] args) throws IOException {
    BufferedReader bufferedReader =
        new BufferedReader(new InputStreamReader(System.in));

    BufferedWriter bufferedWriter =
        new BufferedWriter(
            new FileWriter(System.getenv("OUTPUT_PATH"))
        );

    int aCount = Integer.parseInt(
        bufferedReader.readLine().trim()
    );

    List<Integer> a = IntStream.range(0, aCount)
        .mapToObj(i -> {
          try {
            return bufferedReader.readLine().trim();
          } catch (IOException ex) {
            throw new RuntimeException(ex);
          }
        })
        .map(Integer::parseInt)
        .collect(toList());

    List<Double> result = Result.runningMedian(a);

    bufferedWriter.write(
        result.stream()
            .map(v -> String.format(Locale.US, "%.1f", v))
            .collect(joining("\n"))
            + "\n"
    );

    bufferedReader.close();
    bufferedWriter.close();
  }
}
