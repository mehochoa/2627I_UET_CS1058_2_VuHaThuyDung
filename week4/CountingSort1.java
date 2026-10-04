import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CountingSort1 {
  public static void printCountingSort(List<Integer> arr) {
    Map<Integer, Integer> counts = new HashMap<>();
    for (int num: arr) {
      counts.put(num, counts.getOrDefault(num, 0) + 1);
    }
    for (int i = 0; i < 100; i++) {
      int count = counts.getOrDefault(i, 0);
      System.out.print(count + " ");
    }
    System.out.println();
  }
  public static void main(String[] args) {
    List<Integer> arr = Arrays.asList(1, 1, 3, 2, 1, 99, 5, 0, 99);

    System.out.println("Kết quả đếm:");
    printCountingSort(arr);
  }
}
