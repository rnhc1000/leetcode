package org.ferreiras.leetcode;

import java.util.Arrays;

/**
 * Given a string s, reverse the order of characters in each word within a
 * sentence while still preserving whitespace and initial word order.
 * Example 1:
 *
 * Input: s = "Let's take LeetCode contest"
 * Output: "s'teL ekat edoCteeL tsetnoc"
 * Example 2:
 * Input: s = "Mr Ding"
 * Output: "rM gniD"
 */
public class ReverseString3 {
  public static void main(String[] args) {
    String string = "Let's take LeetCode contest";
    String reverse = reverseWords(string);
    System.out.println(reverse);
    System.out.println(revertOrder(string));
  }
  public static String reverseWords(String s) {
    int left = 0, right = s.length() - 1;
    StringBuilder sb = new StringBuilder();

    for (int i = right; i >= 0; i--) {
      sb.append(s.charAt(i));
    }

    return sb.toString();
  }

  public static String revertOrder(String string) {
    StringBuilder  response = new StringBuilder();

    String[] temp = string.split("\\s");
    char[] c = new char[string.length()];
    for (int i = 0; i < temp.length; i++) {
      char[] x = new char[temp[i].length()];
      x = temp[i].toCharArray();
      for (int j =x.length-1; j >= 0; j--) {
        response.append(x[j]);
      }
      response.append(" ");
    }

    System.out.println(Arrays.toString(temp));

    return response.toString().trim();
  }
}
