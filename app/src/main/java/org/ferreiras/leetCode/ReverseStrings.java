package org.ferreiras.leetCode;

import java.util.Arrays;

public class ReverseStrings {

  public static void main(String[] args) {
    String s = "    The quick brown  fox dog jumps over    the    lazy          dog    ";
    String reverse = reverseStrings(s);
    System.out.println(s);
    System.out.println(reverse);
  }

  public static String reverseStrings(String s) {
    String reverse = "";
    String regex = "\\s{2,}";
    s = s.replaceAll(regex, " ");
    String[] c = s.split(" ");
    StringBuilder sb = new StringBuilder();
    for (int i = c.length-1; i >= 0; i--) {
      sb.append(c[i]).append(" ");
    }
    return sb.toString().trim();
  }
}
