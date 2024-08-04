package org.ferreiras.leetCode;

import java.util.ArrayList;
import java.util.List;

/*
For two strings s and t, we say "t divides s" if and only if s = t + ... + t
(i.e., t is concatenated with itself one or more times).

Given two strings str1 and str2, return the largest string x such that x divides
both str1 and str2.
Example 1:
Input: str1 = "ABCABC", str2 = "ABC"
Output: "ABC"

Example 2:
Input: str1 = "ABABAB", str2 = "ABAB"
Output: "AB"

Example 3:
Input: str1 = "LEET", str2 = "CODE"
Output: ""
 */
public class DivisorOfStrings {
  public static void main(String[] args) {
    String one = "ABCABC";
    String two = "ABC";
    System.out.println(greaterCommonDivider(one,two));
    System.out.println(greatestCommonDivider(64, 28));
  }

  public static String greaterCommonDivider(String str1, String str2) {
    String response = "";
    int lengthOfStrOne = str1.length();
    int lengthOfStrTwo = str2.length();
    if (!(str1 + str2).equals(str2 + str1)) return response;
    int commonDivider = greatestCommonDivider(lengthOfStrOne, lengthOfStrTwo);
    response = str1.substring(0,commonDivider);
    return response;
  }

  private static int greatestCommonDivider(int lenOne, int lenTwo) {
    return lenTwo == 0 ? lenOne : greatestCommonDivider(lenTwo, lenOne % lenTwo);
  }

  public static String gcdOfStrings(String str1, String str2) {

    int lenOfStr1 = str1.length();
    int lenOfStr2 = str2.length();
    List<Character> list = new ArrayList<>();
    char[] s1 = str1.toCharArray();
    char[] s2 = str2.toCharArray();
    int k = 0;
    while (lenOfStr2 > 0 ) {
      if (!list.contains(s2[k])) {
        list.add(s2[k]);
      }
      k++;
      lenOfStr2--;
    }
    StringBuilder sb = new StringBuilder();
    for (Character c : list) {
      sb.append(c);
    }
    str2 = sb.toString();
    s2 = str2.toCharArray();
    lenOfStr2 = str2.length();
    System.out.println(list);
    int size = Math.min(lenOfStr1, lenOfStr2);
    int i = 0;
    StringBuilder gcd = new StringBuilder();
    while (size > 0 ) {
     if( s1[i] == s2[i] ) {
        gcd.append(s2[i]);
     }
     size--;
     i++;
    }
    String response = gcd.toString();
    System.out.println(response);
    return gcd.toString();
  }
}
