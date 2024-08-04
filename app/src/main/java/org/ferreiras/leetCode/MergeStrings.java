package org.ferreiras.leetCode;

/*
You are given two strings word1 and word2. Merge the strings by adding letters in
alternating order, starting with word1. If a string is longer than the other,
append the additional letters onto the end of the merged string.
Return the merged string.
Input: word1 = "abc", word2 = "pqr"
Output: "apbqcr"
 */
public class MergeStrings {

  public static void main(String[] args) {
    String s = "abcd";
    String t = "pqrst";
    System.out.println(mergeAlternately(s,t));
  }
  public static String mergeAlternately(String word1, String word2) {
    char[] charOne = word1.toCharArray();
    char[] charTwo = word2.toCharArray();
    int sizeOfWord1 = charOne.length;
    int sizeOfWord2 = charTwo.length;
    int sizeOfMerged = sizeOfWord1 + sizeOfWord2;
    StringBuilder sb = new StringBuilder();
    int builderOne = 0, builderTwo = 0;
    while (sizeOfMerged > 0) {
      if (builderOne < sizeOfWord1) {
        sb.append(charOne[builderOne]);
      }
      if (builderTwo < sizeOfWord2) {
        sb.append(charTwo[builderTwo]);
      }
      sizeOfMerged--;
      builderOne++;
      builderTwo++;
    }
    return sb.toString();
  }
}

