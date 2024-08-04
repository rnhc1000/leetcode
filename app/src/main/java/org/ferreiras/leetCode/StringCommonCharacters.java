package org.ferreiras.leetCode;

import java.util.*;

/*
Given a string array words, return an array of all characters that show up in all strings
within the words (including duplicates).
You may return the answer in any order.

Example 1:

Input: words = ["bella","label","roller"]
Output: ["e","l","l"]
Example 2:

Input: words = ["cool","lock","cook"]
Output: ["c","o"]

Constraints:

1 <= words.length <= 100
1 <= words[i].length <= 100
words[i] consists of lowercase English letters.
 */
public class StringCommonCharacters {
  public static void main(String[] args) {
    String[] words = {"cool", "lock", "cook"};
    List<String> response = commonChars(words);
    System.out.println(response);
  }

  public static List<String> commonChar(String[] words) {
    List<String> result = new ArrayList<>();

    for (char ch = 'a'; ch <= 'z'; ch++) {
      int minCount = Integer.MAX_VALUE;

      for (String word : words) {
        int count = 0;
        for (char c : word.toCharArray()) {
          if (c == ch) {
            count++;
          }
        }
        minCount = Math.min(minCount, count);
      }

      for (int i = 0; i < minCount; i++) {
        result.add(String.valueOf(ch));
      }
    }

    return result;
  }

  public static List<String> commonChars(String[] words) {

    Map<String, Integer> map = new LinkedHashMap<>();
    long start = System.nanoTime();
    for (String word : words) {

      int sizeOfWord = word.length();

      for (int i = 0; i < sizeOfWord; i++) {
        map.put(String.valueOf(word.charAt(i)), map.getOrDefault(String.valueOf(word.charAt(i)), 0) + 1);
      }

    }

    System.out.println(map);
    long end = System.nanoTime();
    List<String> response = new LinkedList<>();
    System.out.println("Execution time: " + (end - start) / 1_000_000 + " ms");
    for (Map.Entry<String, Integer> entry : map.entrySet()) {
      if (entry.getValue() >= words.length) response.add(entry.getKey());
      if (entry.getValue() / words.length > 1) response.add(entry.getKey());
    }
    return response;
  }
}
