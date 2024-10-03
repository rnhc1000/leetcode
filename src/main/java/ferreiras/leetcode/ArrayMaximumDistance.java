package ferreiras.leetcode;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/*
You are given m arrays, where each array is sorted in ascending order.

You can pick up two integers from two different arrays (each array picks one) and calculate the distance.
We define the distance between two integers a and b to be their absolute difference |a - b|.

Return the maximum distance.

Example 1:

Input: arrays = [[1,2,3],[4,5],[1,2,3]]
Output: 4
Explanation: One way to reach the maximum distance 4 is to pick 1 in the first or third array and pick 5 in the second array.
Example 2:

Input: arrays = [[1],[1]]
Output: 0


Constraints:

m == arrays.length
2 <= m <= 105
1 <= arrays[i].length <= 500
-104 <= arrays[i][j] <= 104
arrays[i] is sorted in ascending order.
There will be at most 105 integers in all the arrays.
 */
public class ArrayMaximumDistance {

  public static void main(String[] args) {

    int[][] array = {
            {1,2,3},
            {4,5},
            {1,2,3}
    };

    List<List<Integer>> arrays = new ArrayList<>(List.of());

    for (int[] arr : array) {
      List<Integer> list = new ArrayList<>();
      for(int a : arr) {
        list.add(a);
      }
      arrays.add(list);
    }

    for (List<Integer> numbers : arrays) {

      System.out.println(numbers);

    }

    int response = maxDistance(arrays);
    System.out.println(response);

  }

  public static int maxDistance(List<List<Integer>> arrays) {

    int min = Integer.MAX_VALUE, minimum = arrays.getFirst().getFirst();
    int max = Integer.MIN_VALUE, maximum = arrays.getFirst().getLast();

    for (List<Integer> array : arrays) {
      min = array.stream().min(Comparator.comparing(Integer::valueOf)).get();
      max = array.stream().max(Comparator.comparing(Integer::valueOf)).get();
      minimum = Math.min(minimum, min);
      maximum = Math.max(maximum, max);
    }

    return  Math.abs(maximum - minimum);
  }

  public static int maximumDistance(List<List<Integer>> arrays) {
    int minimum = arrays.getFirst().getFirst();
    int maximum = arrays.getFirst().getLast(), maximumValue = 0;

    for (int i = 1; i < arrays.size(); i++) {
      List<Integer> array = arrays.get(i);

      // Calculate distance using current min and max with other arrays
      maximumValue = Math.max(maximumValue, Math.max(
              Math.abs(array.getLast() - minimum),
              Math.abs(maximum - array.getFirst())
      ));

      // Update the global min and max values
      minimum = Math.min(minimum, array.getFirst());
      maximum = Math.max(maximum, array.getLast());
    }

    return maximumValue;
  }
}
