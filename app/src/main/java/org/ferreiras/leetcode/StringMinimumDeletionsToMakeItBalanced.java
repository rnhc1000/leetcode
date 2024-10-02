package org.ferreiras.leetcode;
/*
You are given a string s consisting only of characters 'a' and 'b'

You can delete any number of characters in s to make s balanced.
s is balanced if there is no pair of indices (i,j) such that i < j and s[i] = 'b' and s[j]= 'a'.

Return the minimum number of deletions needed to make s balanced.



Example 1:

Input: s = "aababbab"
Output: 2
Explanation: You can either:
Delete the characters at 0-indexed positions 2 and 6 ("aababbab" -> "aaabbb"), or
Delete the characters at 0-indexed positions 3 and 6 ("aababbab" -> "aabbbb").
Example 2:

Input: s = "bbaaaaabb"
Output: 2
Explanation: The only solution is to delete the first two characters.


Constraints:

1 <= s.length <= 105
s[i] is 'a' or 'b'
 */
public class StringMinimumDeletionsToMakeItBalanced {

  public static void main(String[] args) {
    String s = "aababbab";

    int response = minimumDeletions(s);
    System.out.println(response);


  }

  public static int minimumDeletions(String s) {
    int size = s.length();
    int[] dp = new int[size+1];
    int count = 0;
    for (int i = 1; i < size; i++) {

      if (s.charAt(i-1) == 'b') {
        dp[i] = dp[i-1];
        ++count;
      } else {
        dp[i] = Math.min(dp[i-1] + 1, count);
      }

    }

    return dp[size];
  }

}
