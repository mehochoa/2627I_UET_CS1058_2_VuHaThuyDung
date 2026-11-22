import java.util.HashSet;
import java.util.Set;

public class Pairs {
  public static int countPairs(int k, int[] arr) {
    Set<Integer> set = new HashSet<>();
    for (int num : arr) {
      set.add(num);
    }

    int count = 0;
    for (int num : arr) {
      if (set.contains(num + k)) {
        count++;
      }
    }

    return count;
  }
}