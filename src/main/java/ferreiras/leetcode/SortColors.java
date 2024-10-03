package ferreiras.leetcode;

import java.util.Arrays;

/*
quicksort algo using two pointers and recursion
int[] numbers = {9,4,8,2,7,0,6,1,5}
 */
public class SortColors {
  public static void main(String[] args) {
    int[] numbers = {9, 4, 8, 2, 7, 3, 0, 6, 1, 5};
//    [0, 4, 1, 2, 3, 5, 6, 7, 8, 9]
    int left = 0, right = numbers.length - 1;
    int[] response = quicksort(numbers, left, right);
    System.out.println(Arrays.toString(response));
  }

  public static int[] quicksort(int[] array, int left, int right) {
    if (left < right) {

      int pivot = partition(array, left, right);
      quicksort(array, left, pivot - 1);
      quicksort(array, pivot + 1, right);

    }
    return array;
  }

  public static int partition(int[] array, int left, int right) {

    int pivot = array[right];
    int i = left - 1;
    for (int j = left; j < right; j++) {

      if (array[j] <= pivot) {
        i += 1;
        int temp = array[j];
        array[j] = array[i];
        array[i] = temp;

      }
    }
    // position pivot on the right place;
    int temp = array[i + 1];
    array[i + 1] = array[right];
    array[right] = temp;

    return i + 1; // pivot position
  }
}
