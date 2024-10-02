package org.ferreiras.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class CloseStrings {
  public static void main(String[] args) {
    String s = "cabbba";
    String t = "abbccc";
    boolean response = closestStrings(s, t);
    System.out.println(response);
  }

  public static boolean closeStrings(String word1, String word2) {
    if (word1.length() < word2.length()) return false;
    Map<Integer, Character> mapOne = new HashMap<>();
    Map<Integer, Character> mapTwo = new HashMap<>();

    for (int i = 0; i < word1.length(); i++) {
      mapOne.put(i, word1.charAt(i));
    }

    String word3 = "";
    for (int i = 0; i < word1.length(); i++) {
      for (int j = 0; j < word2.length(); j++) {
      }
      return false;
    }
    return true;
  }

  public static boolean closestStrings(String word1, String word2) {
    int lenWord1 = word1.length();
    int lenWord2 = word2.length();

    if (lenWord1 != lenWord2)
      return false;

    int[] charOne = new int[26];
    int[] charTwo = new int[26];

    for (char c : word1.toCharArray()) {
      charOne[c - 'a']++;
    }

    for (char c : word2.toCharArray()) {
      if (charOne[c - 'a'] == 0)
        return false;
      charTwo[c - 'a']++;
    }

    Arrays.sort(charOne);
    Arrays.sort(charTwo);

    return Arrays.equals(charOne, charTwo);

  }
}
