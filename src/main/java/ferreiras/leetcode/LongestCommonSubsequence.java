package ferreiras.leetcode;

/**
 * Given two strings text1 and text2, return the length of their longest common
 * subsequence. If there is no common subsequence, return 0.
 * A subsequence of a string is a new string generated from the original string
 * with some characters (can be none) deleted without changing the relative order
 * of the remaining characters.
 * For example, "ace" is a subsequence of "abcde".
 * A common subsequence of two strings is a subsequence that is common to both strings.
 * Example 1:
 * Input: text1 = "abcde", text2 = "ace"
 * Output: 3
 * Explanation: The longest common subsequence is "ace" and its length is 3.
 * Example 2:
 * Input: text1 = "abc", text2 = "abc"
 * Output: 3
 * Explanation: The longest common subsequence is "abc" and its length is 3.
 * Example 3:
 * Input: text1 = "abc", text2 = "def"
 * Output: 0
 * Explanation: There is no such common subsequence, so the result is 0
 * Nice explanation by:
 * <a href="https://leetcode.com/thestutirajeev/">...</a>
 * Approach
 *         Key Idea:
 *
 Use a 1D array dp to store the length of the LCS for the current prefixes of the two strings.
 Iterate through the characters of the strings, updating dp based on matches and maintaining the length of the LCS.
 Dynamic Programming Iteration:
 Use two nested loops:
 Outer loop (i): Iterate through the characters of the longer string.
 Inner loop (j): Iterate through the characters of the shorter string.
 At each iteration, update dp[j] based on the matching characters:
 If characters at large[i - 1] and small[j - 1] match:
 Update dp[j] to prev + 1, where prev is the previous value of dp[j].
 If characters do not match:
 Update dp[j] by taking the maximum of the previous values (temp and dp[j-1]).
 This process efficiently finds the length of the LCS for each prefix of the two strings.
 Complexity
 Time complexity:
 O(n*m)
 Space complexity:
 O(n)
 Code uses 1D dp Array
 *
 */
public class LongestCommonSubsequence {
  public int longestCommonSubsequence(String text1, String text2) {
    int sizeOne = text1.length();
    int sizeTwo = text2.length();

    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < sizeOne; i++) {
      for (int j = 0; j < sizeTwo; j++) {
        if (text1.charAt(i) == text2.charAt(j)) {
          sb.append(text1.charAt(i));
        }
      }
    }
    return sb.length();
  }
  public int longestCommonSubsequences(String text1, String text2) {
    int sizeOne = text1.length(), sizeTwo = text2.length();
    char[] larger, smaller;
    if (sizeOne > sizeTwo) {
      larger = text1.toCharArray();
      smaller = text2.toCharArray();
    } else {
      larger  = text2.toCharArray();
      smaller = text1.toCharArray();
      //swap lengths to store larger length in 'n'
      sizeOne = sizeOne ^ sizeTwo;
      sizeTwo = sizeOne ^ sizeTwo;
      sizeOne = sizeOne ^ sizeTwo;
    }
    int[] dp = new int[sizeOne + 1];

    for (int i = 1; i <= sizeOne; i++) {
      int prev = dp[0];  // store the value before updating dp[j]
      for (int j = 1; j <= sizeTwo; j++) {
        int temp = dp[j];
        if (larger[i - 1] == smaller[j - 1]) {
          dp[j] = prev + 1;
        } else {
          dp[j] = Math.max(dp[j], dp[j - 1]);
        }
        prev = temp; // update prev for the next iteration
      }
    }
    return dp[sizeTwo];
  }
}

// 2DP Array
class Solution {
  public int longestCommonSubsequence(String text1, String text2) {
    int n = text1.length(), m =  text2.length();
    char[] s1 = text1.toCharArray();
    char[] s2 = text2.toCharArray();

    int[][] dp = new int[n+1][m+1];
    for(int i = 1; i <= n; i++){
      for(int j = 1; j <= m; j++){
        if(s1[i-1] == s2[j-1]){
          dp[i][j] = dp[i-1][j-1]+1;
        }else{
          dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
        }
      }
    }
    return dp[n][m];
  }
}