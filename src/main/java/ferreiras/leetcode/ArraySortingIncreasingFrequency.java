package ferreiras.leetcode;

import java.util.*;

import static java.util.Collections.reverseOrder;


/*
Given an array of integers nums, sort the array in increasing order based on the frequency of the values.
If multiple values have the same frequency, sort them in decreasing order.

Return the sorted array.

Example 1:

Input: nums = [1,1,2,2,2,3]
Output: [3,1,1,2,2,2]
Explanation:
'3' has a frequency of 1, '1' has a frequency of 2, and '2' has a frequency of 3.

Example 2:

Input: nums = [2,3,1,3,2]
Output: [1,3,3,2,2]
Explanation:
'2' and '3' both have a frequency of 2, so they are sorted in decreasing order.

Example 3:

Input: nums = [-1,1,-6,4,5,-6,1,4,1]
Output: [5,-1,4,4,-6,-6,1,1,1]


Constraints:

1 <= nums.length <= 100
-100 <= nums[i] <= 100

 */
public class ArraySortingIncreasingFrequency {

  public static void main(String[] args) {
    int[] nums = {1,1,2,2,2,3};
    int[] response =  frequencySorting(nums);
    System.out.println(Arrays.toString(response));

  }
  public static int[] frequencySort(int[] nums) {

    Map<Integer, Integer> map = new TreeMap<>();

    for (int num : nums) {
      map.put(num, map.getOrDefault(num, 0) + 1);
    }
    List<Integer> count = new ArrayList<>();

    for (int num : nums) {
      count.add(num);
    }

    Integer[] numbers = Arrays.stream(nums).boxed().toArray(Integer[]::new);
    System.out.println(Arrays.toString(numbers));

    Arrays.sort(numbers, (a, b) -> {
      if (Objects.equals(count.get(a), count.get(b))) {
        return b - a;
      }
      return a - b;
    });

    System.out.println(Arrays.toString(numbers));

    return Arrays.stream(numbers).mapToInt(x -> x).toArray();
  }

    public static int[] frequencySorting(int[] nums) {
//      Map<Integer, Integer> frequencyMap = new HashMap<>();
      long start = System.currentTimeMillis();
      //{1=2, 2=3, 3=1}
      Map<Integer, Integer> frequencyMap = new HashMap<>();
      for (int num : nums) {
        frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
      }

      System.out.println(frequencyMap);
      Integer[] numsArray = Arrays.stream(nums).boxed().toArray(Integer[]::new);

      Arrays.sort(numsArray, (a, b) -> {
        if (!frequencyMap.get(a).equals(frequencyMap.get(b))) {
          return frequencyMap.get(a) - frequencyMap.get(b);
        } else {
          return b - a;
        }
      });

      long end = System.currentTimeMillis();
      System.out.println(end - start + " ms");
      return Arrays.stream(numsArray).mapToInt(Integer::intValue).toArray();
    }

}
