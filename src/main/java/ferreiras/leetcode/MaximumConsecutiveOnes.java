package ferreiras.leetcode;

/**
 * Given a binary array nums and an integer k, return the maximum number of consecutive 1's
 * in the array if you can flip at most k 0's.
 * Example 1:
 * Input: nums = [1,1,1,0,0,0,1,1,1,1,0], k = 2
 * Output: 6
 * Explanation: [1,1,1,0,0,1,1,1,1,1,1]
 * Example 2:
 * Input: nums = [0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1], k = 3
 * Output: 10
 * Explanation: [0,0,1,1,1,1,1,1,1,1,1,1,0,0,0,1,1,1,1]
 */
public class MaximumConsecutiveOnes {
  public static void main(String[] args) {
//    int[] nums = {0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1};
    int[] nums = {0, 1, 1, 1, 0, 0};

    int k = 2;
    int numberOfOnes = sizeOfOnes(nums, k);
    System.out.println(numberOfOnes);
  }

  public static int sizeOfOnes(int[] nums, int k) {
    int size = nums.length;
    int countZeros = 0;
    int left = 0;
    int maxNumberOfOnes = 0;

    for (int right = 0; right < size; right++) {
      countZeros += (nums[right] == 0) ? 1 : 0;
/*
       Incrementing the left pointer until the zero
       count comes back right to the permissible range.
*/
      while (countZeros > k) {
        countZeros -= (nums[left] == 0) ? 1 : 0;
        left++;
      }
      maxNumberOfOnes = Math.max(maxNumberOfOnes, right - left + 1);
    }
    return maxNumberOfOnes;
  }

  public static int longestOnes(int[] nums, int k) {
    int size = nums.length;
    int maxCountOnes = 0, maxCountZeros = 0;
    int countOnes = 0, countZeros = 0;
    for (int num : nums) {
      if (num == 1) {
        countOnes++;
        countZeros = 0;
        if (countOnes > maxCountOnes)
          maxCountOnes = countOnes;
      } else {
        countOnes = 0;
        countZeros++;
        if (countZeros > maxCountZeros)
          maxCountZeros = countZeros;
      }
    }
    if (maxCountZeros >= k) return maxCountOnes + k;
    return maxCountOnes;
  }
}
