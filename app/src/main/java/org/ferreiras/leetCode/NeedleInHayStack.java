package org.ferreiras.leetCode;

/*
Given two strings needle and haystack, return the index of the
first occurrence of needle in haystack or -1 if needle is not
part of haystack.
Example 1:
Input:
haystack = "sabbutsad"
needle = "sad"
Output: 0

 */
public class NeedleInHayStack {
  public static void main(String[] args) {
    String needle = "sad";
    String haystack = "dasbutdassad";
    int index = needleInHaystack(needle, haystack);
    System.out.println(index);
  }

  public static int needleInHaystack(String needle, String haystack) {
    int jump = needle.length();
    String temp = "";
    if (needle.equals(haystack)) return 0;
    int sizeStack = haystack.length();
    for (int i = 0; i <= sizeStack - jump; i++) {
      temp = haystack.substring(i, i+jump);
      if (temp.equals(needle)) return haystack.indexOf(needle);
    }

    return -1;
  }
}
