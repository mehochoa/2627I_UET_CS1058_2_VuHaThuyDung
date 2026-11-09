public class VuHaThuyDung_25020063 {
  static class Pair {
    int min;
    int max;
  }

  static Pair getMinMax(int[] arr, int left, int right) {
    Pair res = new Pair();
    Pair leftPair;
    Pair rightPair;
    int mid;

    if (left == right) {
      res.max = arr[left];
      res.min = arr[right];
      return res;
    }

    if (right == left + 1) {
      if (arr[left] > arr[right]) {
        res.max = arr[left];
        res.min = arr[right];
      } else {
        res.max = arr[right];
        res.min = arr[left];
      }
      return res;
    } else {
      mid = (left + right) / 2;

      leftPair = getMinMax(arr, left, mid);
      rightPair = getMinMax(arr, mid + 1, right);

      if (leftPair.min < rightPair.min) {
        res.min = leftPair.min;
      } else {
        res.min = rightPair.min;
      }

      if (leftPair.max > rightPair.max) {
        res.max = leftPair.max;
      } else {
        res.max = rightPair.max;
      }

      return res;
    }
  }
}
