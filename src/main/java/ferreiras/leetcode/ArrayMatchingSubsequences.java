package ferreiras.leetcode;

import java.util.LinkedHashMap;
import java.util.Map;

/*
Given a string s and an array of strings words, return the number of words[i] that is a subsequence of s.

A subsequence of a string is a new string generated from the original string with some characters
(can be none) deleted without changing the relative order of the remaining characters.

For example, "ace" is a subsequence of "abcde".

Example 1:

Input: s = "abcde", words = ["a","bb","acd","ace"]
Output: 3
Explanation:
There are three strings in words that are a subsequence of s: "a", "acd", "ace".
Example 2:

Input: s = "dsahjpjauf", words = ["ahjpjau","ja","ahbwzgqnuk","tnmlanowax"]
Output: 2


Constraints:

1 <= s.length <= 5 * 104
1 <= words.length <= 5000
1 <= words[i].length <= 50
s and words[i] consist of only lowercase English letters.
 */
public class ArrayMatchingSubsequences {
  public static void main(String[] args) {
    String s = "abcde";
    String[] words = {"a", "bb", "acd", "ace"};
    int response = ArrayMatchingSubsequences.numMatchingSubsequence(s, words);
    System.out.println(response);
  }

  public static int numMatchingSubsequence(String s, String[] words) {
    Map<String, Integer> map = new LinkedHashMap<>();
    int response = 0;
    for (String word : words) {
      map.put(word, map.getOrDefault(word, 0) + 1);
    }
    System.out.println(map);

    for (String word : map.keySet()) {
      int i = 0, j = 0;
      while (i < s.length() && j < word.length()) {
        if (s.charAt(i) == word.charAt(j)) {
          i++;
          j++;
        } else {
          i++;
        }
      }
      if (j == word.length()) response += map.get(word);
    }

    return response;
  }
}
