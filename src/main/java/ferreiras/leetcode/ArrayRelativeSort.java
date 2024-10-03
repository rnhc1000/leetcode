package ferreiras.leetcode;

import java.util.*;
import java.util.logging.Logger;

/*
Given two arrays arr1 and arr2, the elements of arr2 are distinct,
and all elements in arr2 are also in arr1.

Sort the elements of arr1 such that the relative ordering of items in arr1 are
the same as in arr2. Elements that do not appear in arr2 should be placed at the
end of arr1 in ascending order.



Example 1:

Input: arr1 = [2,3,1,3,2,4,6,7,9,2,19], arr2 = [2,1,4,3,9,6]
Output: [2,2,2,1,4,3,3,9,6,7,19]
Example 2:

Input: arr1 = [28,6,22,8,44,17], arr2 = [22,28,8,6]
Output: [22,28,8,6,17,44]
 */
public class ArrayRelativeSort {
  private final static Logger logger = Logger.getLogger(ArrayRelativeSort.class.getName());

  public static void main(String[] args) {
    int[] arrayOne = {2, 3, 1, 3, 2, 4, 6, 7, 9, 2, 19};
    int[] arrayTwo = {2, 1, 4, 3, 9, 6};
    // 2,2,2,1,4,3,3,9,6,7,19
    System.out.println(Arrays.toString(arrayOne));
    System.out.println(Arrays.toString(arrayTwo));
    int[] response = relativeSortArray(arrayOne, arrayTwo);
    System.out.print("[ ");
    for (int r : response) {
      System.out.printf("%d ", r);
    }
    System.out.print("]");

  }

  public static int[] relativeSortArray(int[] arr1, int[] arr2) {

    List<Integer> response = new LinkedList<>();
    logger.info("Prepare return - List -> response");

    List<Integer> remaining = new LinkedList<>();
    logger.info("to make room for the numbers that are not part of array 2 - List - remaining");

    logger.info("create a map with the sequence asked...");

    Map<Integer, Integer> map = new LinkedHashMap<>();
    for (int j : arr2) {
      map.put(j, map.getOrDefault(map.get(j), 0));
    }

    for (int a : arr1) {

      if (map.containsKey(a)) {
        map.put(a, map.getOrDefault((a),0)+1);
      } else {
        remaining.add(a);
      }
    }

    logger.info("For each num in arr2 check the number of repetitions and iterate over it, adding to response list");
    for (int num : arr2) {
      for (int j=0; j < map.get(num); j++) {
        response.add(num);
      }
    }
    logger.info("response.addAll(remaining");
    response.addAll(remaining);

    logger.info("Return an array of ints using response.stream.mapToInt(k -> k).toArray()");
    return response.stream().mapToInt(k -> k).toArray();
  }
}
