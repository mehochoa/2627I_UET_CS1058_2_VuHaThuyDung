import java.util.TreeSet;

public class FindTheRunningMedian {
  public static double[] findRunningMedian(int[] arr) {
    double[] medians = new double[arr.length];
    TreeSet<int[]> lower = new TreeSet<>((a, b) -> a[0] != b[0] ? Integer.compare(a[0], b[0]) : Integer.compare(a[1], b[1]));
    TreeSet<int[]> upper = new TreeSet<>((a, b) -> a[0] != b[0] ? Integer.compare(a[0], b[0]) : Integer.compare(a[1], b[1]));

    for (int i = 0; i < arr.length; i++) {
      lower.add(new int[]{arr[i], i});
      upper.add(lower.pollLast());

      if (lower.size() < upper.size()) {
        lower.add(upper.pollFirst());
      }

      if (lower.size() > upper.size()) {
        medians[i] = lower.last()[0];
      } else {
        medians[i] = (lower.last()[0] + upper.first()[0]) / 2.0;
      }
    }

    return medians;
  }
}