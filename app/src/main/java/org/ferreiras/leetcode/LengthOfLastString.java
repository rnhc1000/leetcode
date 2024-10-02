package org.ferreiras.leetcode;

import java.util.*;

/*
Given a string s consisting of words and spaces, return the length of the last word in the string.
A word is a maximal
substring consisting of non-space characters only.
Example 1:

Input: s = "Hello World"
Output: 5
Explanation: The last word is "World" with length 5.
Example 2:

Input: s = "   fly me   to   the moon  "
Output: 4
Explanation: The last word is "moon" with length 4.
Example 3:

Input: s = "luffy is still joyboy"
Output: 6
Explanation: The last word is "joyboy" with length 6.

 */
public class LengthOfLastString {
  public static void main(String[] args) {
    String s = "   fly me   to   the moon  ";
    int r = LengthOfLastString.lengthOfLastWord(s);
    System.out.println(r);
  }
  public static int lengthOfLastWord(String s) {
    String regex = "\\W+";
    s = s.replaceAll("\\W+", " ").trim();
    regex = "\\s+";
    String[] str = s.split(regex);
//    s = s.replaceAll(regex,"");

    int size = str.length-1;
    System.out.println(Arrays.toString(str));
    for (int i = 0; i < str.length; i++) {
      // You may want to check for a non-word character before blindly
      // performing a replacement
      // It may also be necessary to adjust the character class
      str[i] = str[i].replaceAll("[^\\w]", "");
    }
    System.out.println(Arrays.toString(str));
    return str.length;
  }

  public static int lengthOfLastWords(String s) {
    StringTokenizer token = new StringTokenizer(s);
    String lastWord = "";
    while (token.hasMoreTokens()) {
      lastWord = token.nextToken();
    }
    return lastWord.length();
  }
}
