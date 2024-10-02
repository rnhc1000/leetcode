package org.ferreiras.leetcode;

import java.util.ArrayDeque;
import java.util.Deque;

/*
You are given a string s that consists of lower case English letters and brackets.

Reverse the strings in each pair of matching parentheses, starting from the innermost one.

Your result should not contain any brackets.



Example 1:

Input: s = "(abcd)"
Output: "dcba"
Example 2:

Input: s = "(u(love)i)"
Output: "iloveu"
Explanation: The substring "love" is reversed first, then the whole string is reversed.
Example 3:

Input: s = "(ed(et(oc))el)"
Output: "leetcode"
Explanation: First, we reverse the substring "oc", then "etco", and finally, the whole string.


Constraints:

1 <= s.length <= 2000
s only contains lower case English characters and parentheses.
It is guaranteed that all parentheses are balanced.
 */
public class StringReverseParentheses {
  public static void main(String[] args) {
    String s = "(abcd)";
    String r = reverseParentheses(s);
    System.out.println(r);
  }

  public static String reverseParentheses(String s) {
    Deque<Integer> stack = new ArrayDeque<>();
    StringBuilder sb = new StringBuilder();

    for (char c : s.toCharArray()) {
      if (c == '(') {
        stack.push(sb.length());
      } else if (c == ')') {
        int start = stack.pop();
        String reversed = new StringBuilder(sb.substring(start)).reverse().toString();
        sb.replace(start, sb.length(), reversed);
      } else {
        sb.append(c);
      }
    }

    return sb.toString();
  }
}
