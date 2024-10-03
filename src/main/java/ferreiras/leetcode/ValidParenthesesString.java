package ferreiras.leetcode;

import java.util.ArrayDeque;
import java.util.Deque;

/*
Given a string s containing only three types of characters: '(', ')' and '*',
return true if s is valid.

The following rules define a valid string:

Any left parenthesis '(' must have a corresponding right parenthesis ')'.
Any right parenthesis ')' must have a corresponding left parenthesis '('.
Left parenthesis '(' must go before the corresponding right parenthesis ')'.
'*' could be treated as a single right parenthesis ')' or a single left
parenthesis '(' or an empty string "".


Example 1:

Input: s = "()"
Output: true
Example 2:

Input: s = "(*)"
Output: true
Example 3:

Input: s = "(*))"
Output: true

Constraints:

1 <= s.length <= 100
s[i] is '(', ')' or '*'
 */
public class ValidParenthesesString {
  public static void main(String[] args) {
    String s = "((*))";
    boolean f = checkValidString(s);
    System.out.println(f);
  }
  public static boolean checkValidParentehses(String s) {

    Deque<Character> stack = new ArrayDeque<>();
    boolean flag = false;
    int count = 0;
    for (char ch : s.toCharArray()) {

      if (ch == '(') {
        stack.push(ch);
        count++;
      } else if (!stack.isEmpty() && ch == ')' && stack.peek() == '(') {
        stack.pop();
        count--;
      }  else {
        count--;
      }
    }
    if ( count == 0 ) flag = true;

    return flag;
  }

  public static boolean checkValidString(String s) {
    int left = 0, right = 0;

    for (char ch : s.toCharArray()) {

      if (ch == '(') {
        left++;
        right++;
      } else if (ch == ')') {
        left--;
        right--;
      } else {
        left--;
        right++;
      }

      if (right < 0)
        return false;

      if (left < 0)
        left = 0;
    }

    return left == 0;
  }
}
