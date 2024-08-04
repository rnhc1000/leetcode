package org.ferreiras.leetCode;

import java.util.LinkedHashSet;
import java.util.Set;

/*
Given a string s which consists of lowercase or uppercase letters, return the length of the
longest palindrome that can be built with those letters.

Letters are case sensitive, for example, "Aa" is not considered a palindrome.

Example 1:

Input: s = "abccccdd"
Output: 7
Explanation: One longest palindrome that can be built is "dccaccd", whose length is 7.
Example 2:

Input: s = "a"
Output: 1
Explanation: The longest palindrome that can be built is "a", whose length is 1.


Constraints:

1 <= s.length <= 2000
s consists of lowercase and/or uppercase English letters only.
 */
public class PalindromeLongest {
  public static void main(String[] args) {
    String s = "abccccdd";
    int response = longestPalindrome(s);
    System.out.println(response);
  }
  public static int longestPalindrome(String s) {
    Set<Character> set = new LinkedHashSet<>();
    int countOfPalindromes = 0;
    for (int i = 0; i < s.length(); i++) {

      if (!set.contains(s.charAt(i))) {
        set.add(s.charAt(i));
        System.out.println(set);
      } else {
        set.remove(s.charAt(i));
        countOfPalindromes+=2;
        System.out.println(set);
      }
    }
    System.out.println(set);
    if(!set.isEmpty())
      return countOfPalindromes+1;
    return countOfPalindromes;
  }
}
