package ferreiras.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RotatingArrays {
  public static void main(String[] args) {
    String[] strings = {"Ricardo", "Alves", "Ferreira", "Silva"};
    int[] numbers = {1, 2, 3, 4, 5, 6, 7, 8, 9};
    int k = 3;
    String[] responseOne = rotatingArrays(strings, k);
    int[] responseTwo = rotatingArraysRight(numbers, k);
    System.out.println(Arrays.toString(responseOne));
    System.out.println(Arrays.toString(responseTwo));

    rotate(numbers,k);
  }

  public static String[] rotatingArrays(String[] strings, int k) {

    int currentIndex = 0;
    int size = strings.length;

    List<String> temp = new ArrayList<>();
    for (int i = 0; i < size; i++) {
      currentIndex = (i + k) % size;
      temp.add(strings[currentIndex]);
    }

    return temp.toArray(new String[0]);
  }

  public static int[] rotatingArraysRight(int[] numbers, int k) {

    int currentIndex = 0;
    int size = numbers.length;

    long start = System.currentTimeMillis();
    List<Integer> temp = new ArrayList<>();
    for (int i = size - 1; i >= 0; i--) {

      currentIndex = (currentIndex - 1 + size) % size;
      System.out.println(currentIndex);
      temp.add(numbers[currentIndex]);

    }


    for (Integer s : temp) {
      System.out.print(s + " ");
    }
    //System.out.println(Arrays.toString(rotate));
    long end = System.currentTimeMillis();
    long diff = end - start;
    System.out.println("\n" + diff + " ms");
    return temp.stream().mapToInt(x -> x).toArray();
  }

  public static void rotate(int[] nums, int k) {

    int size = nums.length;
    k = k % size;
    reverse(nums, 0, size - 1);
    reverse(nums, 0, k - 1);
    reverse(nums, k, size - 1);
  }

  private static void reverse(int[] numbers, int start, int end) {
    while (start < end) {
      numbers[start] = numbers[start] ^ numbers[end];
      numbers[end] = numbers[end] ^ numbers[start];
      numbers[start] = numbers[start] ^ numbers[end];
      start++;
      end--;
    }
  }
}
