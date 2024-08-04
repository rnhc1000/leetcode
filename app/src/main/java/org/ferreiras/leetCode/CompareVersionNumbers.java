package org.ferreiras.leetCode;

import java.util.Arrays;

/*
Given two version numbers, version1 and version2, compare them.

Version numbers consist of one or more revisions joined by a dot '.'.
Each revision consists of digits and may contain leading zeros.
Every revision contains at least one character.
Revisions are 0-indexed from left to right, with the leftmost revision being revision 0,
the next revision being revision 1, and so on.
For example 2.5.33 and 0.1 are valid version numbers.

To compare version numbers, compare their revisions in left-to-right order.
Revisions are compared using their integer value ignoring any leading zeros.
This means that revisions 1 and 001 are considered equal.
If a version number does not specify a revision at an index, then treat the
revision as 0. For example, version 1.0 is less than version 1.1 because their
revision 0s are the same, but their revision 1s are 0 and 1 respectively, and 0 < 1.

Return the following:

If version1 < version2, return -1.
If version1 > version2, return 1.
Otherwise, return 0.


Example 1:

Input: version1 = "1.01", version2 = "1.001"
Output: 0
Explanation: Ignoring leading zeroes, both "01" and "001" represent the same integer "1".
Example 2:

Input: version1 = "1.0", version2 = "1.0.0"
Output: 0
Explanation: version1 does not specify revision 2, which means it is treated as "0".
Example 3:

Input: version1 = "0.1", version2 = "1.1"
Output: -1
Explanation: version1's revision 0 is "0", while version2's revision 0 is "1". 0 < 1, so version1 < version2.


Constraints:

1 <= version1.length, version2.length <= 500
version1 and version2 only contain digits and '.'.
version1 and version2 are valid version numbers.
All the given revisions in version1 and version2 can be stored in a 32-bit integer.
 */
public class CompareVersionNumbers {
  public static void main(String[] args) {
    String version1 = "0.1", version2 = "1.1";
    int response = compareVersions(version1, version2);
    System.out.println(response);

  }

  public static int compareVersions(String version1, String version2) {

    int p1 = 0, p2 = 0;
    int s1 = version1.length(), s2 = version2.length();
    int numberOne = 0, numberTwo = 0;
    while (p1 < s1 || p2 < s2) {

      while (p1 < s1 && version1.charAt(p1) != '.') {
        numberOne = numberOne * 10 + (version1.charAt(p1++) + '0');
      }

      while (p2 < s2 && version2.charAt(p2) != '.') {
        numberTwo = numberTwo * 10 + (version2.charAt(p2++) + '0');
      }

      if (numberOne > numberTwo) {
        return 1;
      }
      if (numberOne < numberTwo) {
        return -1;
      }

      p1++;
      p2++;
    }
    return 0;

  }

  public static int compareVersion(String version1, String version2) {
// Input: version1 = "1.01", version2 = "1.001"
    String regex = "\\.";
    String[] v1 = version1.split(regex);
    String[] v2 = version2.split(regex);
    int s1 = v1.length - 1, s2 = v2.length - 1;

    System.out.println(Arrays.toString(v1));
    System.out.println(Arrays.toString(v2));
    int j = Math.min(s1, s2);
    for (int i = 0; i < j; i++) {

      if (Integer.parseInt(v1[i]) == Integer.parseInt(v2[i])) {
        return 0;
      } else if (Integer.parseInt(v1[i]) > Integer.parseInt(v2[i])) {
        return 1;
      } else {
        return -1;
      }
    }
    return -1;
  }
}
