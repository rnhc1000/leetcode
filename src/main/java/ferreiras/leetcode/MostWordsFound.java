package ferreiras.leetcode;

import java.util.Arrays;
/**
 * A sentence is a list of words that are separated by a single space with no leading or trailing spaces.
 * You are given an array of strings sentences, where each sentences[i] represents a single sentence.
 * Return the maximum number of words that appear in a single sentence.
 * Example 1:
 *
 * Input: sentences = ["alice and bob love leetcode", "i think so too", "this is great thanks very much"]
 * Output: 6
 */
public class MostWordsFound {

  public static void main(String[] args) {
    String[] sentences = {
            "alice and bob love leetcode",
            "i think so too",
            "this is great thanks very much"
    };
    System.out.println(mostWordsFound(sentences));
  }
  public static int mostWordsFound(String[] sentences) {
    int maxWords = Integer.MIN_VALUE;
    for (String sentence : sentences) {
      String[] phrase = sentence.split(" ");
      System.out.println(Arrays.toString(phrase));
      if (phrase.length > maxWords) {
        maxWords = phrase.length;
      }
    }
    return maxWords;
  }
  
  public static int longestPhrases(String[] sentences) {
    return Arrays.stream(sentences).mapToInt(x -> x.split(" ").length).max().getAsInt();
  }
}
