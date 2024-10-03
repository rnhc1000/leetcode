package ferreiras.leetcode;

/*
 * Given a string s, return the number of palindromic substrings in it.
 * A string is a palindrome when it reads the same backward as forward.
 * A substring is a contiguous sequence of characters within the string.
 * Example 1:
 * Input: s = "abc"
 * Output: 3
 * Explanation: Three palindromic strings: "a", "b", "c".
 * Example 2:
 * Input: s = "aaa"
 * Output: 6
 * Explanation: Six palindromic strings: "a", "a", "a", "aa", "aa", "aaa".
 */

public class PalindromicSubstrings {
  public static void main(String[] args) {
    String s = "baab";
    int response = countSubstringx(s);
    System.out.println(response);
  }

  public static int check(String s, int i, int j) {
    int ans = 0;
    while (i >= 0 && j < s.length() && s.charAt(i) == s.charAt(j)) {
      System.out.println(s.charAt(i));
      ans++;
      i--;
      j++;
    }
    return ans;
  }

  public static int countSubstringx(String s) {
    int ans = 0;
    for (int i = 0; i < s.length(); i++) {
      ans += check(s, i, i);
      ans += check(s, i, i + 1);
    }
    return ans;
  }

  public int countSubstringss(String s) {
    int count = 0;
    int n = s.length();
    for (int i = 0; i < n; i++) {
      count++;
      for (int j = 1; i - j >= 0 && i + j < n; j++) {
        if (s.charAt(i - j) == s.charAt(i + j)) {
          count++;
        } else {
          break;
        }
      }
      for (int j = 0; i - j >= 0 && i + 1 + j < n; j++) {
        if (s.charAt(i - j) == s.charAt(i + 1 + j)) {
          count++;
        } else {
          break;
        }
      }
    }
    return count;
  }
  public static int countSubstrings(String s) {
    int n = s.length();
    int ans = 0;

    if (n == 0)
      return 0;

    boolean[][] dp = new boolean[n][n];

    for (int i = 0; i < n; ++i, ++ans)
      dp[i][i] = true;

    for (int i = 0; i < n - 1; ++i) {
      dp[i][i + 1] = (s.charAt(i) == s.charAt(i + 1));
      ans += (dp[i][i + 1] ? 1 : 0);
    }

    for (int len = 3; len <= n; ++len)
      for (int i = 0, j = i + len - 1; j < n; ++i, ++j) {
        dp[i][j] = dp[i + 1][j - 1] && (s.charAt(i) == s.charAt(j));
        ans += (dp[i][j] ? 1 : 0);
      }
    return ans;
  }
}
