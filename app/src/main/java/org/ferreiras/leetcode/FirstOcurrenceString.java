package org.ferreiras.leetcode;

/*
Given two strings needle and haystack, return the index of the first occurrence
of needle in haystack, or -1 if needle is not part of haystack.



Example 1:

Input: haystack = "sadbutsad", needle = "sad"
Output: 0
Explanation: "sad" occurs at index 0 and 6.
The first occurrence is at index 0, so we return 0.
Example 2:

Input: haystack = "leetcode", needle = "leeto"
Output: -1
Explanation: "leeto" did not occur in "leetcode", so we return -1.


Constraints:

1 <= haystack.length, needle.length <= 104
haystack and needle consist of only lowercase English characters.
 */
public class FirstOcurrenceString {
  public static void main(String[] args) {
    String haystack = "dasbutdassad", needle = "sad";
    int r = strStr(haystack, needle);
    System.out.println(r);
  }

  public static int strStr(String haystack, String needle) {
    int r = -1;
    int right = haystack.length();
    int left  = needle.length();

    if (haystack.equals(needle)) return 0;

    for (int i = 0; i <= right - left; i++) {

      if (needle.equals(haystack.substring(i, i + left))) {
        return haystack.indexOf(needle);
      }

    }

    return r;
  }
}
