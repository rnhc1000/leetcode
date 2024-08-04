package org.ferreiras.leetCode;

import java.util.*;

/*
Given a string s and a dictionary of strings wordDict, add spaces in s to construct a sentence
where each word is a valid dictionary word. Return all such possible sentences in any order.
Note that the same word in the dictionary may be reused multiple times in the segmentation.

Example 1:

Input: s = "catsanddog", wordDict = ["cat","cats","and","sand","dog"]
Output: ["cats and dog","cat sand dog"]
Example 2:

Input: s = "pineapplepenapple", wordDict = ["apple","pen","applepen","pine","pineapple"]
Output: ["pine apple pen apple","pineapple pen apple","pine applepen apple"]
Explanation: Note that you are allowed to reuse a dictionary word.

Example 3:

Input: s = "catsandog", wordDict = ["cats","dog","sand","and","cat"]
Output: []


Constraints:

1 <= s.length <= 20
1 <= wordDict.length <= 1000
1 <= wordDict[i].length <= 10
s and wordDict[i] consist of only lowercase English letters.
All the strings of wordDict are unique.
Input is generated in a way that the length of the answer doesn't exceed 105.
 */
public class StringWordBreakTwo {


  public static void main(String[] args) {
    String s = "catsanddog";
    List<String> wordDict = List.of("cat","cats","and","sand","dog");
    List<String> response = wordBreak(s, wordDict);
  }


  public static List<String> wordBreak(String s, List<String> wordDict) {
    Set<String> hashSet = new HashSet<>(wordDict);
    return helper(s, 0, hashSet);
  }

  private static List<String> helper(String string, int start, Set<String> hashSet) {
    List<String> sentences = new ArrayList<>();

    if (start == string.length())
      sentences.add("");
    for (int end = start + 1; end <= string.length(); end++) {
      String prefix = string.substring(start, end);
      if (hashSet.contains(prefix)) {
        List<String> suffixes = helper(string, end, hashSet);
        for (String suffix : suffixes) {
          sentences.add(prefix + (suffix.isEmpty() ? "" : " ") + suffix);
        }
      }
    }
    System.out.println(sentences);
    return sentences;
  }
}
