package ferreiras.leetcode;

import java.util.*;

/**
 * You have been given a string of lowercase letters.
 * Write a function called firstNonRepeatingChar(String) that finds the
 * first non-repeating character in the given string using a hash table (HashMap).
 * If there is no non-repeating character in the string, the function should return null.
 * For example, if the input string is "leetcode", the function should return "l" because
 * "l" is the first character that appears only once in the string.
 * Similarly, if the input string is "hello", the function should return "h" because "h"
 * is the first non-repeating character in the string.
 * Return type: Character
 */
public class FirstNonRepeatingCharacter {
  public static void main(String[] args) {
    String s = "cocada";
    char r = firstNonRepeatingChar(s);
    System.out.println(r);

  }

  public static char firstNonRepeatingChar(String s) {

    Map<Character, Integer> map = new LinkedHashMap<>();
    char[] c = s.toCharArray();
    char response;
    for (char x : c) {
      {
        map.put(x, map.getOrDefault((x), 0) + 1);
      }
    }
    System.out.println(map);
    List<Integer> list = new ArrayList<>(map.values());
    System.out.println(list);
    for (Map.Entry<Character, Integer> entry : map.entrySet()) {
      if (entry.getValue() == 1) {
        return entry.getKey();
      }
    }
    System.out.println(map);
    return '0';
  }
}
