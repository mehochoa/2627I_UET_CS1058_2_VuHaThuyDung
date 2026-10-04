import java.util.Arrays;
import java.util.Scanner;

public class W4_25020063 {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    if (!sc.hasNextInt()) return;

    int n = sc.nextInt();
    int[] arr = new int[n];
    for (int i = 0; i < n; i++) {
      arr[i] = sc.nextInt();
    }

    Arrays.sort(arr);

    int hIndex = n;
    for (int i = 0; i < n; i++) {
      if (arr[n - i - 1] >= i + 1) {
        hIndex = i + 1;
      } else {
        break;
      }
    }
    System.out.println(hIndex);
    sc.close();
  }
}
