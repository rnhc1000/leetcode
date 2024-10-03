package ferreiras.leetcode;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Given an array of n integers nums, a 132 pattern is a subsequence of three
 * integers nums[i], nums[j] and nums[k] such that
 * i < j < k and nums[i] < nums[k] < nums[j].
 * Return true if there is a 132 pattern in nums, otherwise, return false.
 * Example 1:
 * Input: nums = [1,2,3,4]
 * Output: false
 * Explanation: There is no 132 pattern in the sequence.
 * Example 2:
 * Input: nums = [3,1,4,2]
 * Output: true
 * Explanation: There is a 132 pattern in the sequence: [1, 4, 2].
 * Example 3:
 * Input: nums = [-1,3,2,0]
 * Output: true
 * Explanation: There are three 132 patterns in the sequence: [-1, 3, 2], [-1, 3, 0] and [-1, 2, 0].
 */
public class Pattern123 {
  public static void main(String[] args) {
    int[] numbers = {3, 4, 5, 6, 4};
    boolean r = find132pattern(numbers);
    System.out.println(r);
  }

  public static boolean find132pattern(int[] nums) {
    int size = nums.length;
    Deque<Integer> queue = new ArrayDeque<>();
    int x = Integer.MIN_VALUE;
    for (int i = size - 1; i >= 0; i--) {
      if(nums[i] < x) return true;
      while (!queue.isEmpty() && nums[i] > queue.peek()) {
        x = queue.peek();
        queue.pop();
      }
      queue.push(nums[i]);
    }
       return false;
  }
}
