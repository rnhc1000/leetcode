package ferreiras.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

/**
 * You are given a 0-indexed integer array nums. Rearrange the values of nums according
 * to the following rules:
 * Sort the values at odd indices of nums in non-increasing order.
 * For example, if nums = [4,1,2,3] before this step, it becomes [4,3,2,1] after.
 * The values at odd indices 1 and 3 are sorted in non-increasing order.
 * Sort the values at even indices of nums in non-decreasing order.
 * For example, if nums = [4,1,2,3] before this step, it becomes [2,1,4,3] after. T
 * he values at even indices 0 and 2 are sorted in non-decreasing order.
 * Return the array formed after rearranging the values of nums.
 * Example 1:
 * Input: nums = [4,1,2,3]
 * Output: [2,3,4,1]
 * Explanation:
 * First, we sort the values present at odd indices (1 and 3) in non-increasing order.
 * So, nums changes from [4,1,2,3] to [4,3,2,1].
 * Next, we sort the values present at even indices (0 and 2) in non-decreasing order.
 * So, nums changes from [4,1,2,3] to [2,3,4,1].
 * Thus, the array formed after rearranging the values is [2,3,4,1].
 * Example 2:
 * Input: nums = [2,1]
 * Output: [2,1]
 * Explanation:
 * Since there is exactly one odd index and one even index, no rearrangement of values takes place.
 * The resultant array formed is [2,1], which is the same as the initial array.
 * //9,46,15,45,15,41,27,34,32,31,33,31,36,26,36,16,44,6
 */
public class SortEvenOdd {
  public static void main(String[] args) {
    int[] numbers = {36, 45, 32, 31, 15, 41, 9, 46, 36, 6, 15, 16, 33, 26, 27, 31, 44, 34};
    int[] response = sortEvenOdds(numbers);
    System.out.print("[");
    for (int r : response) {
      System.out.print(" " + r);
    }
    System.out.print(" ]");
  }

  public static int[] sortEvenOdd(int[] nums) {

    int odd = 1, even = 0;
    List<Integer> odds = new ArrayList<>();
    List<Integer> evens = new ArrayList<>();
    int size = nums.length;

    for (int i = 0; i < size; i++) {
      if (i % 2 == 0) {
        evens.add(nums[i]);
      } else {
        odds.add(nums[i]);
      }
    }
    evens.sort(Integer::compareTo);
    odds.sort((x, y) -> y.compareTo(x));
    int[] response = new int[size];
//    if (evens.get(0) < odds.get(odds.size()-1)) {
    int j = 0;
    for (int i = 0; i < size - 1; i += 2) {
      response[i] = evens.get(j);
      response[i + 1] = odds.get(j);
      j++;
    }
    return response;
  }
  public static int[] sortEvenOdds(int[] nums) {

    PriorityQueue<Integer> even = new PriorityQueue<>((a, b) -> (a - b));
    PriorityQueue<Integer> odd =  new PriorityQueue<>((a, b) -> (b - a));
    int size = nums.length;

    for (int i = 0; i < size; ++i) {
      if (i % 2 == 0) {
        even.add(nums[i]);
      } else {
        odd.add(nums[i]);
      }
    }

    for (int i = 0; i < size; ++i) {
      if (i % 2 == 0) {
        nums[i] = even.poll();
      } else {
        nums[i] = odd.poll();
      }
    }
    return nums;
  }
}
