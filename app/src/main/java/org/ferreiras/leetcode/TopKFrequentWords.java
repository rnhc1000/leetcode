package org.ferreiras.leetcode;
/**
 * Given an array of strings words and an integer k, return the k most frequent strings.
 * Return the answer sorted by the frequency from highest to lowest. Sort the words with
 * the same frequency by their lexicographical order.
 * Example 1:
 * Input: words = ["i","love","leetcode","i","love","coding"], k = 2
 * Output: ["i","love"]
 * Explanation: "i" and "love" are the two most frequent words.
 * Note that "i" comes before "love" due to a lower alphabetical order.
 * Example 2:
 * Input: words = ["the","day","is","sunny","the","the","the","sunny","is","is"], k = 4
 * Output: ["the","is","sunny","day"]
 * Explanation: "the", "is", "sunny" and "day" are the four most frequent words, with the
 * number of occurrence being 4, 3, 2 and 1 respectively.
 */

import java.util.*;

public class TopKFrequentWords {
  public static void main(String[] args) {
    String[] strings = {"i","love","leetcode","i","love","coding"};
    int k = 4;
    List<String> list = topKFrequent(strings, k);
    for(String string : list) {
      System.out.print(" " + string);
    }

    int[] dp = new int[50];
    Arrays.fill(dp,-1);
  }

  public static List<String> topKFrequent(String[] words, int k) {

    Map<String, Integer> map = new HashMap<>();
    for (String word : words) {
      map.put(word, map.getOrDefault((word), 0) + 1);
    }
    List<String> list = new ArrayList<>(map.keySet());
    list.sort((a, b) -> {
      if (Objects.equals(map.get(b), map.get(a))) {
        return a.compareTo(b);
      }
      return map.get(b) - map.get(a);
    });
    return list.subList(0, k);
  }
}
