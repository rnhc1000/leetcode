package ferreiras.leetcode;

/**
 * This is the DSA, Sliding window and Two pointers lessons
 * by https://leetcode.com available on DSA course...
 * Example 1:
 * Given an array of positive integers nums and an integer k, find the length of the
 * longest subarray whose sum is less than or equal to k.
 * Sliding window is key to solve it...
 * Iterate over the array and track currentSum that can not be larger
 * than k... keep moving right and when that happens, move left...
 *
 */

public class TwoPointers {

  public static void main(String[] args) {
    String s = "anana";
    String t = "ana";
    boolean response = checkIfPalindrome(s);
    if (response) {
      System.out.println("Yes...it is a palindrome");
    } else {
      System.out.println("It is NOT a palindrome!");
    }

    s = "ace";
    t = "abcde";
    response = isSubsequence(s,t);
    if (response) {
      System.out.println("Yes...it is a subsequence");
    } else {
      System.out.println("It is NOT a subsequence!");
    }

    int[] nums = {1, 2, 4, 6, 8, 9, 14, 15};
    int k = 13;
    response = checkForTarget(nums, k);
    if (response) {
      System.out.println("Yes...sum of items == target");
    } else {
      System.out.println("Not possible!");
    }
    nums = new int[] {3, 1, 2, 7, 4, 2, 1, 1, 5};
    k = 8;

    int answer = maxSubArray(nums,k);
    System.out.println(answer);

  }
  public static boolean checkIfPalindrome(String s) {
    int left = 0;
    int right = s.length() - 1;

    while (left < right) {
      if (s.charAt(left) != s.charAt(right)) {
        return false;
      }
      left++;
      right--;
    }
    return true;
  }
  public static boolean isSubsequence(String s, String t) {
    int i = 0;
    int j = 0;

    while (i < s.length() && j < t.length()) {
      if (s.charAt(i) == t.charAt(j)) {
        i++;
      }
      j++;
    }

    return i == s.length();
  }
  public static boolean checkForTarget(int[] nums, int target) {
    int left = 0;
    int right = nums.length - 1;

    while (left < right) {
      // curr is the current sum
      int currentSum = nums[left] + nums[right];
      if (currentSum == target) {
        return true;
      }
      if (currentSum > target) {
        right--;
      } else {
        left++;
      }
    }
    return false;
  }

  public static int maxSubArray(int[] nums, int k) {
    int left = 0;
    int len = nums.length-1;
    int sizeOfMaxSubArray = 0;
    int response = 0;
    int currentSum = 0;
    for (int right = 0; right < len; right++) {
      currentSum+=nums[right];
      while(currentSum > k) {
        currentSum-=nums[left];
        left++;
      }
      sizeOfMaxSubArray = right-left+1;
    }
    return Math.max(response,sizeOfMaxSubArray);
  }
}
