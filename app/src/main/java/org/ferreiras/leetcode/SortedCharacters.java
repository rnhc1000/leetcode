package org.ferreiras.leetcode;

import java.util.*;


/**
 * Given a string s, sort it in decreasing order based on the frequency of the characters.
 * The frequency of a character is the number of times it appears in the string.
 * Return the sorted string. If there are multiple answers, return any of them.
 * Example 1:
 * Input: s = "tree"
 * Output: "eert"
 * Explanation: 'e' appears twice while 'r' and 't' both appear once.
 * So 'e' must appear before both 'r' and 't'. Therefore "eetr" is also a valid answer.
 * Example 2:
 * Input: s = "cccaaa"
 * Output: "aaaccc"
 * Explanation: Both 'c' and 'a' appear three times, so both "cccaaa" and "aaaccc" are valid answers.
 * Note that "cacaca" is incorrect, as the same characters must be together.
 * Example 3:
 * Input: s = "Aabb"
 * Output: "bbAa"
 * Explanation: "bbaA" is also a valid answer, but "Aabb" is incorrect.
 * Note that 'A' and 'a' are treated as two different characters.
 */
public class SortedCharacters {
  public static void main(String[] args) {
    String s = "tree";
    String t = frequencySort(s);
  }

  public static String frequencySort(String s) {
    String response = "OK!";
    Map<Character, Integer> map = new LinkedHashMap<>();
    char[] c = s.toCharArray();
    for (char x : c) {
      map.put(x, map.getOrDefault((x), 0) + 1);
    }
    Queue<Map.Entry<Character, Integer>> queue = new PriorityQueue<>(
            (a, b) -> b.getValue() - a.getValue()
    );
    queue.addAll(map.entrySet());
    StringBuilder sb = new StringBuilder();

    while (!queue.isEmpty()) {
      Map.Entry<Character, Integer> entry = queue.poll();
      sb.append(String.valueOf(entry.getKey()).repeat(entry.getValue()));
//      int k = entry.getValue();
//      while (k > 0) {
//        sb.append(entry.getKey());
//        k--;
//      }
    }
    String r = sb.toString();
    System.out.println(r);
    System.out.println(map);
    return response;
  }
  public String frequencySortx(String s) {
    // Step 1: Count the frequency of each character
    Map<Character, Integer> charCount = new HashMap<>();
    for (char c : s.toCharArray()) {
      charCount.put(c, charCount.getOrDefault(c, 0) + 1);
    }

    // Step 2: Sort characters based on their frequency in descending order
    List<Character> sortedChars = new ArrayList<>(charCount.keySet());
    Collections.sort(sortedChars, (a, b) -> charCount.get(b) - charCount.get(a));

    // Step 3: Build the result string by repeating characters according to their frequency
    StringBuilder result = new StringBuilder();
    for (char c : sortedChars) {
      result.append(String.valueOf(c).repeat(charCount.get(c)));
    }

    // Step 4: Return the final sorted string
    return result.toString();
  }
}

