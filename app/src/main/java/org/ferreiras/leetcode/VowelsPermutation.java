package org.ferreiras.leetcode;

/*
Given an integer n, your task is to count how many strings of length n can be
formed under the following rules:

Each character is a lower case vowel ('a', 'e', 'i', 'o', 'u')
Each vowel 'a' may only be followed by an 'e'.
Each vowel 'e' may only be followed by an 'a' or an 'i'.
Each vowel 'i' may not be followed by another 'i'.
Each vowel 'o' may only be followed by an 'i' or a 'u'.
Each vowel 'u' may only be followed by an 'a'.
Since the answer may be too large, return it modulo 10^9 + 7.

Example 1:
Input: n = 1
Output: 5
Explanation:
All possible strings are: "a", "e", "i" , "o" and "u".

Example 2:
Input: n = 2
Output: 10
Explanation:
All possible strings are: "ae", "ea", "ei", "ia", "ie", "io", "iu", "oi", "ou" and "ua".

Example 3:
Input: n = 5
Output: 68

Constraints:

1 <= n <= 2 * 10^4

Intuition
This solution is based on a mathematical approach to count the number of valid
strings of length 'n' that can be formed using the given vowel rules.
The idea is to iteratively calculate the number of valid strings for each vowel
at each length. By updating the counts for each vowel based on the rules,
we can find the total count of valid strings of length 'n' that follow the rules.

Approach
1. Initialize variables 'a', 'e', 'i', 'o', and 'u' to 1.
2. These variables will represent the count of valid strings ending with each vowel at length 1.
Iterate from length 2 to 'n':
Calculate the new count for each vowel based on the following rules:
'a' can be followed by 'e', 'u', or 'i'.
'e' can be followed by 'a' or 'i'.
'i' can be followed by 'e' or 'o'.
'o' can be followed by 'i'.
'u' can be followed by 'a' or 'i'.
Update the counts for 'a', 'e', 'i', 'o', and 'u' with the new counts.
Calculate the total count by summing up 'a', 'e', 'i', 'o', and 'u'.
Return the total count modulo 10^9 + 7 as the answer.
Complexity
Time complexity:
The time complexity of this solution is O(n) because we iterate through the range
from 2 to 'n' once, updating the counts for each vowel at each length.

Space complexity:
The space complexity is O(1) as we use a constant amount of extra space to store
the counts for each vowel and a few additional variables.
 */
public class VowelsPermutation {

  public static void main(String[] args) {
    int n = 10;
    int r = countVowelPermutation(n);
    System.out.println(r);
  }
  public static int countVowelPermutation(int n) {

    final int MOD = 1000000007;
    long a = 1, e = 1, i = 1, o = 1, u = 1;

    for (int len = 2; len <= n; len++) {
      long new_a = (e + u + i) % MOD;
      long new_e = (a + i) % MOD;
      long new_i = (e + o) % MOD;
      long new_o = (i) % MOD;
      long new_u = (o + i) % MOD;

      a = new_a;
      e = new_e;
      i = new_i;
      o = new_o;
      u = new_u;
    }

    long count = (a + e + i + o + u) % MOD;

    return (int) count;
  }
}
