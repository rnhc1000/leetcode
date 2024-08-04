package org.ferreiras.leetCode;

import java.util.*;

/**
 * Given a string s and an integer k, return the maximum number of vowel letters
 * in any substring of s with length k.
 * Vowel letters in English are 'a', 'e', 'i', 'o', and 'u'.
 * Example 1:
 * Input: s = "abciiidef", k = 3
 * Output: 3
 * Explanation: The substring "iii" contains 3 vowel letters.
 * Example 2:
 * Input: s = "aeiou", k = 2
 * Output: 2
 * Explanation: Any substring of length 2 contains 2 vowels.
 * Example 3:
 * Input: s = "leetcode", k = 3
 * Output: 2
 * Explanation: "lee", "eet" and "ode" contain 2 vowels.
 */

public class MaximumNumberOfVowels {

  public static void main(String[] args) {
    String s = "aecou";
    int k = 2;
    int response = maxNumberOfVowels(s, k);
    System.out.println("Response: " + response);
  }

  public static int maxVowels(String s, int k) {
    s = s.toLowerCase();
    char[] c = s.toCharArray();
    int size = c.length;
    int right = k;
    int countList = 0;
    Set<Character> vowels = new HashSet<>();
    vowels.add('a');
    vowels.add('e');
    vowels.add('i');
    vowels.add('o');
    vowels.add('u');
    Map<Character, Integer> total = new HashMap<>();
    List<List<Character>> lists = new ArrayList<>();
    for (int i = 0; i <= size - k; i++) {
      List<Character> list = new ArrayList<>();
      for (int j = countList; j < right; j++) {
        list.add(c[j]);
      }
      countList++;
      right += 1;
      lists.add(list);
    }
    for (List<Character> g : lists) {
      System.out.println(g);
    }
    int count = 0;
    for (List<Character> x : lists) {
      for (char y : x) {
        if (vowels.contains(y)) {
          total.put(y, total.getOrDefault(y, 0) + 1);
        }
      }
      if (total.size() > 1) {
        count++;
        total.clear();
      }
    }
    return count;
  }

  public static int maxNumberOfVowels(String s, int k) {
    int[] position = new int[s.length()];
    for (int i = 0; i < s.length(); i++) {
      char ch = s.charAt(i);
      switch (ch) {
        case 'a', 'e', 'i', 'o', 'u' -> {
          if (i == 0) {
            position[i] = 1;
          } else {
            position[i] = position[i - 1] + 1;
          }
        }
        default -> {
          if (i == 0) {
            position[i] = 0;
          } else {
            position[i] = position[i - 1];
          }
        }
      }
    }
    int max = Integer.MIN_VALUE;
    for (int i = 0; i < s.length() - k + 1; i++) {
      int end = i + k - 1;
      if (i == 0) {
        max = Math.max(max, position[end]);
      } else {
        max = Math.max(max, position[end] - position[i - 1]);
      }
    }
    return max;
  }
}
