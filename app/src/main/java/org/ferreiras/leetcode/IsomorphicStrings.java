package org.ferreiras.leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Two strings are isomorphic if one-to-one mapping is possible for every character
 * of the first string to every character of the second string.
 * <p>
 * For example, consider the two strings: “ACAB” and “XCXY”.
 * We can map the characters of the first string to the characters of the second string
 * as follows:
 * <p>
 * ‘A’ maps to ‘X’.
 * ‘C’ maps to ‘C’.
 * ‘B’ maps to ‘Y’.
 * Hence, the two strings are isomorphic.
 * <p>
 * Now, consider the strings “AAB” and “XYZ”. These are not isomorphic since ‘A’ cannot
 * have a mapping to both ‘X’ and ‘Y’.
 */
public class IsomorphicStrings {
  public static void main(String[] args) {
    String s = "EGG";
    String t = "ADD";
    if (isIsoMorphic(s, t)) {
      System.out.print(s + " and " + t + " are isomorphic\n");
    } else {
      System.out.print(s + " and " + t + " are not isomorphic\n");
    }
  }

  public static boolean isIsoMorphic(String s, String t) {
    if (s.length() != t.length()) return false;
    Map<Character, Character> map = new HashMap<>();
    Set<Character> set = new HashSet<>();
    char[] stringOne = s.toCharArray();
    char[] stringTwo = t.toCharArray();
    for (int i = 0; i < s.length(); i++) {
      if (map.containsKey(stringOne[i])) {
        if (map.get(stringOne[i]) != stringTwo[i]) {
          return false;
        }
      } else {
        if (set.contains(stringTwo[i])) {
          return false;
        }
        map.put(stringOne[i], stringTwo[i]);
        set.add(stringTwo[i]);
      }
    }
    return true;
  }
}
