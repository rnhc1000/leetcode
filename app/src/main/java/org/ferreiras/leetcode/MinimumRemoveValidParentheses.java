package org.ferreiras.leetcode;

import java.util.ArrayDeque;
import java.util.Deque;

/*
Given a string s of '(' , ')' and lowercase English characters.

Your task is to remove the minimum number of parentheses ( '(' or ')', in any positions )
so that the resulting parentheses string is valid and return any valid string.

Formally, a parentheses string is valid if and only if:

It is the empty string, contains only lowercase characters, or
It can be written as AB (A concatenated with B), where A and B are valid strings, or
It can be written as (A), where A is a valid string.


Example 1:

Input: s = "lee(t(c)o)de)"
Output: "lee(t(c)o)de"
Explanation: "lee(t(co)de)" , "lee(t(c)ode)" would also be accepted.
Example 2:

Input: s = "a)b(c)d"
Output: "ab(c)d"
Example 3:

Input: s = "))(("
Output: ""
Explanation: An empty string is also valid.


Constraints:

1 <= s.length <= 105
s[i] is either'(' , ')', or lowercase English letter.
We can just use stack to peek() whether there is any trailing
( before adding ) so that we can just pop() that thing out of it

so basically you're going to add the indexes on the stack whenever you realize a close )
does not have any open ( ,if there is a pair available just pop() the pair.
This can be done,whenever you see a close with trailing open just pop() open and move further

then just append the whole string except the indexes which are present inside the stack
they are the indexes which do not form a pair
 */
public class MinimumRemoveValidParentheses {
  public static void main(String[] args) {
    String s = "lee(t(c)o)de)";
    String t = minRemoveToMakeValid(s);
    System.out.println(s);
    System.out.println(t);
  }

  public static String minRemoveToMakeValid(String s) {
    Deque<Integer> stack = new ArrayDeque<>();
    int sizeOf = s.length();
    for (int i = 0; i < sizeOf; i++) {
      if (s.charAt(i) == '(') {
        stack.push(i);
      } else if (s.charAt(i) == ')') {
        if (!stack.isEmpty() && s.charAt((int) stack.peek()) == '(') {
          stack.pop();
        } else {
          stack.push(i);
        }
      } else continue;
    }

    System.out.println(stack);

    StringBuilder sb = new StringBuilder();
    for (int i = sizeOf - 1; i >= 0; i--) {
      if (!stack.isEmpty() && (int) stack.peek() == i) {
        stack.pop();
        continue;
      } else {
        sb.append(s.charAt(i));
      }
    }
    return sb.reverse().toString();
  }
}
