package ferreiras.leetcode;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayDeque;
import java.util.Deque;

/*
A parentheses string is valid if and only if:

It is the empty string,
It can be written as AB (A concatenated with B), where A and B are valid strings, or
It can be written as (A), where A is a valid string.
You are given a parentheses string s. In one move, you can insert a parenthesis at any position of
the string.

For example, if s = "()))", you can insert an opening parenthesis to be "(()))" or a closing parenthesis
to be "())))".
Return the minimum number of moves required to make s valid.

Example 1:
Input: s = "())"
Output: 1

Example 2:
Input: s = "((("
Output: 3

Constraints:

1 <= s.length <= 1000
s[i] is either '(' or ')'.
 */
public class ValidParentheses {
  private static final Logger logger = LoggerFactory.getLogger(ValidParentheses.class);

  public static void main(String[] args) {
    String s = "()))((";

    int response = minAddToMakeValid(s);

    logger.info("Valid -> {}",response);
  }

  public static int minAddToMakeValid(String s) {

    Deque<Character> stack = new ArrayDeque<>();

    int size = s.length();
    int count = 0;

    while (size > 0) {
      if (s.charAt(count) == '(') {
        stack.push(s.charAt(count));
      } else if (!stack.isEmpty() && stack.peek() == '(') {
        stack.pop();
      } else {
        stack.push(s.charAt(count));
      }
      count++;
      size--;
    }

    return stack.size();
  }

  public static int minAddToMakeValid(String s, boolean flag) {
    if (flag) {
      int counter = 0;
      for (char ch : s.toCharArray()) {
        if (ch == '(') counter++;
        else counter--;
      }
      if (counter < 0) return Math.abs(counter);
      else return counter;
    }
    return 0;
  }
}
