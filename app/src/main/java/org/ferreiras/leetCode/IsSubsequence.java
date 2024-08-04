package org.ferreiras.leetCode;

import java.util.*;

/*
 * Given two strings s and t, return true if s is a subsequence of t, or false otherwise.
 * A subsequence of a string is a new string that is formed from the original string by
 * deleting some (can be none) of the characters without disturbing the relative positions
 * of the remaining characters. (i.e., "ace" is a subsequence of "abcde" while "aec" is not).
 * Example 1:
 * Input: s = "abc", t = "ahbgdc"
 * Output: true
 * Example 2:
 * Input: s = "axc", t = "ahbgdc"
 * Output: false
 * Intuition
 * As position is maintained we just need to keep track of chars visited in t from s.
 * Nice explanation by
 * <a href="https://leetcode.com/surajcode/">...</a>
 * Approach
 * Iterate through both the strings, if char matches increment both the counter else just
 * increment counter of t string.
 * Complexity
 * Time complexity:
 * O(n)
 * Space complexity:
 * O(1)
 */
public class IsSubsequence {

  public static void main(String[] args) {
    String s = "aec";
    String t = "ahbgdc";
    boolean response = subSequence(s, t);
    if (response) {
      System.out.println("String s is a subsequence os String t");
    } else {
      System.out.println("String s is NOT a subsequence os String t");
    }
  }

  public static boolean subSequence(String s, String t) {
    char[] sToChar = s.toCharArray();
    char[] tToChar = t.toCharArray();
    int lenOfsToChar = sToChar.length;
    int lenOftToChar= tToChar.length;
    int indexOfS = 0, indexOfT = 0;
    while (indexOfS < lenOfsToChar && indexOfT < lenOftToChar) {
      if (sToChar[indexOfS] == tToChar[indexOfT]) {
        indexOfS++;
        indexOfT++;
      } else {
        indexOfT++;
      }
    }
    return indexOfS == lenOfsToChar;
  }
  public static boolean isSubsequence(String s, String t) {
    char[] sOne = s.toCharArray();
    char[] sTwo = t.toCharArray();
    List<Integer> index = new ArrayList<>();
    int size = sOne.length;
    int j = 0;
    if (sOne.length > sTwo.length) return false;
    Map<Integer, Character> map = new HashMap<>();
    for (int i = 0; i < sTwo.length; i++) {
      map.put(i, sTwo[i]);
    }
    while (size > 0) {
      for (Map.Entry<Integer, Character> entry : map.entrySet()) {
        char key = sOne[j];
        if (entry.getValue() == key) {
          index.add(entry.getKey());
          break;
        }
      }
      j+=1;
      size--;
    }
    System.out.println(index);
    if (index.size() != sOne.length) return false;
    List<Integer> check = new ArrayList<>(index);
    Collections.sort(check);
    return check.equals(index);
  }
}
