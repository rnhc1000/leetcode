package ferreiras.leetcode;

/*
You are given a string s consisting of lowercase letters and an integer k.
We call a string t ideal if the following conditions are satisfied:

t is a subsequence of the string s.
The absolute difference in the alphabet order of every two adjacent letters in t
is less than or equal to k.
Return the length of the longest ideal string.

A subsequence is a string that can be derived from another string by deleting some or
no characters without changing the order of the remaining characters.

Note that the alphabet order is not cyclic. For example, the absolute difference in
the alphabet order of 'a' and 'z' is 25, not 1.



Example 1:

Input: s = "acfgbd", k = 2
Output: 4
Explanation: The longest ideal string is "acbd". The length of this string is 4, so 4 is returned.
Note that "acfgbd" is not ideal because 'c' and 'f' have a difference of 3 in alphabet order.
Example 2:

Input: s = "abcd", k = 3
Output: 4
Explanation: The longest ideal string is "abcd". The length of this string is 4, so 4 is returned.
 */
public class LongestIdealSubsequence {

  public static void main(String[] args) {
    String s = "pvjcci";
    int k = 4;


    int response = longestString(s, k);
    System.out.println(response);
  }

  public static int longestIdealString(String s, int k) {
    int left = 0;
    int right = 1;

    StringBuilder sb = new StringBuilder();
    char[] c = s.toCharArray();
    int size = c.length;
//    Arrays.sort(c);
//    String t = new String(c);
    sb.append(c[left]);
    while (right < size) {
      int diff = Math.abs((c[right] - '0') - (c[left] - '0'));
      if (diff <= k) {
        sb.append(c[right]);
        left++;
        right++;
      } else {
        right++;
      }
    }

    return sb.toString().length();
  }

  public static int longestString(String s, int k) {
    int[] dp = new int[26];
    for (int i = s.length() - 1; i >= 0; i--) {
      int current = s.charAt(i) - 'a';
      int start = Math.max(current - k, 0);
      int end = Math.min(current + k, 25);
      int currentMax = 0;
      for (int j = start; j <= end; j++) {
        currentMax = (int) Math.max(currentMax, dp[j]);
      }
      dp[current] = currentMax + 1;
    }
    int max = 1;
    for (int d : dp)
      max = Math.max(max, d);

    return max;
  }
}
