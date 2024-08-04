package org.ferreiras.leetCode;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;

public class TwoSum {
  public static void main(String[] args) {
//    int[] numbers = {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 3};
    int[] numbers = {11, 7, 2, 3, 5};
    int k = 5;
    int[] response = twoSum(numbers, k);
    System.out.println(Arrays.toString(response));

  }

  public static int[] twoSum(int[] numbers, int target) {
    Map<Integer, Integer> map = new LinkedHashMap<>();
    int size = numbers.length;
    int[] response = new int[2];
    for (int i = 0; i < size; i++) {
      int complement = target - numbers[i];
      if (map.containsKey(complement)) {
        response[0] = map.get(complement);
        response[1] = i;
      } else {
        map.put(numbers[i], i);
      }
    }
    System.out.println(map);
    return response;
  }

  public static int[] twoSumOne(int[] numbers, int target) {
    /*
    Array DS must be sorted in ascending order to use two pointers
     */
    int left = 0, right = numbers.length - 1;
    int[] response = new int[2];
    while (left <= right) {
      if (numbers[left] + numbers[right] == target) {
        response[0] = left;
        response[1] = right;
//        left=right;// break the loop;
        break;

      } else if (numbers[left] + numbers[right] < target) {
        left++;
      } else {
        right--;
      }
    }

    return response;
  }
}
