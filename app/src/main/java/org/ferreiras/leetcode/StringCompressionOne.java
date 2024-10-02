package org.ferreiras.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * Run-length encoding is a string compression method that works by replacing consecutive
 * identical characters (repeated 2 or more times) with the concatenation of the character
 * and the number marking the count of the characters (length of the run).
 * For example, to compress the string "aabccc" we replace "aa" by "a2" and replace "ccc"
 * by "c3". Thus the compressed string becomes "a2bc3".
 * Notice that in this problem, we are not adding '1' after single characters.
 * Given a string s and an integer k. You need to delete at most k characters from s
 * such that the run-length encoded version of s has minimum length.
 * Find the minimum length of the run-length encoded version of s after deleting at most
 * k characters.
 */
public class StringCompressionOne {

  public static void main(String[] args) {
    String s = "aaaaggghhhjjjkkllcvbnmmmmm";
    int k = 0;
    getLengthOfOptimalCompression(s, 0);
  }

  public static int getLengthOfOptimalCompression(String s, int k) {

    int size = s.length();
    int ptrTwo = 0;
    int count = 1;
    int deletions = 0;
    Map<Character, Integer> map = new HashMap<>();
    for (int ptrOne = 1; ptrOne < size; ptrOne++) {
      if (s.charAt(ptrOne) == s.charAt(ptrTwo)) {
        if (map.containsKey(s.charAt(ptrOne))) {
          map.put(s.charAt(ptrOne), map.getOrDefault((s.charAt(ptrOne)), 1) + 1);
        } else {
          map.put(s.charAt(ptrOne), 1);
        }
      } else {
        map.put(s.charAt(ptrTwo), map.getOrDefault((s.charAt(ptrTwo)), 0) + 1);
      }
      ptrTwo = ptrOne;
    }
    System.out.println(map);
    return 0;
  }
}
