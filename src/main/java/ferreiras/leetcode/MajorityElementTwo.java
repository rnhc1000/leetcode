package ferreiras.leetcode;
/**
 * Given an integer array of size n, find all elements that appear more than ⌊ n/3 ⌋ times.
 * Example 1:
 * Input: nums = [3,2,3]
 * Output: [3]
 * Example 2:
 * Input: nums = [1]
 * Output: [1]
 * Example 3:
 * Input: nums = [1,2]
 * Output: [1,2]
 * Approach
 * Initialization:
 * We initiate two candidate variables and their respective counters.
 * These candidates will represent potential elements that could appear more
 * than n/3 times
 * Voting Mechanism:
 * As we traverse through the array:
 * If we find a number equal to either of our candidates, we increment the respective counter.
 * If one of the counters is zero, we replace the respective candidate with the current number
 * and reset the counter.
 * If the current number doesn't match either candidate, both counters are decremented.
 * Verification: The two candidates selected might not actually be numbers that appear more than
 * n/3 times. So, we need to traverse the array again to count and verify their occurrences.
 * Why It Works?
 * The Boyer-Moore Voting Algorithm leverages the fact that any number that appears more than
 * k / n times will have at most k−1 such numbers.
 * By generalizing the algorithm to maintain two candidates and counters, we can handle
 * the k = 3 case for this problem. The decrementing of counters ensures that if a number
 * truly appears more than n /3 times it will survive till the end.
 * What We Have Learned?
 * This problem teaches us the power of algorithm generalization and thinking beyond
 * straightforward hash map solutions.
 * The Boyer-Moore Voting Algorithm's extension showcases the importance of understanding
 * underlying principles and insights of algorithms, enabling us to apply them in varied scenarios.
 * Complexity
 * Time complexity:
 * O(n)O(n)O(n). We go through the list thrice: once for voting and twice for counting.
 * Space complexity:
 * O(1)O(1)O(1). Only a constant amount of extra space is used, irrespective of the input size.
 */

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class MajorityElementTwo {
  public static void main(String[] args) {
    String match = "8000863390488707.59991366095112916";
    BigDecimal r = new BigDecimal(match);
    BigDecimal s = new BigDecimal("8000863390488707.59991366095112916");
    BigDecimal max = new BigDecimal(9_999_999_999_999_999L);
    BigDecimal min = new BigDecimal(-9_999_999_999_999_999L);
    BigDecimal range = max.subtract(min);
    BigDecimal result = min.add(range.multiply(BigDecimal.valueOf(Math.random())));
    System.out.println(result);
    System.out.println(range);

    boolean test = r.equals(s);
    System.out.println(test);

  }
  public List<Integer> majorityElement(int[] nums) {
    //Boyer-Moore Voting Algo
    Integer candidateOne = null, candidateTwo = null;
    int counterOne = 0, counterTwo = 0;
    for (int num : nums) {
      if (candidateOne != null && num == candidateOne.intValue()) {
        counterOne++;
      } else if (candidateTwo != null && num == candidateTwo.intValue()) {
        counterTwo++;
      } else if (counterOne == 0) {
        candidateOne = num;
        counterOne = 1;
      } else if (counterTwo == 0) {
        candidateTwo = num;
        counterTwo = 1;
      } else {
        counterOne--;
        counterTwo--;
      }
    }

    counterOne = 0;
    counterTwo = 0;



    for (int num : nums) {
      if (candidateOne != null && num == candidateOne.intValue()) {
        counterOne++;
      }
      if (candidateTwo != null && num == candidateTwo.intValue()) {
        counterTwo++;
      }
    }

    List<Integer> result = new ArrayList<>();
    if (counterOne > nums.length / 3) result.add(candidateOne);
    if (counterTwo > nums.length / 3) result.add(candidateTwo);

    return result;
  }
}
