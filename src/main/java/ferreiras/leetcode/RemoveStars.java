package ferreiras.leetcode;

import java.util.Stack;

/**
 * You are given a string s, which contains stars *.
 * In one operation, you can:
 * Choose a star in s.
 * Remove the closest non-star character to its left, as well as remove the star itself.
 * Return the string after all stars have been removed.
 * Note:
 * The input will be generated such that the operation is always possible.
 * It can be shown that the resulting string will always be unique.
 * Example 1:
 * Input: s = "leet**cod*e"
 * Output: "lecoe"
 * Explanation: Performing the removals from left to right:
 * - The closest character to the 1st star is 't' in "leet**cod*e". s becomes "lee*cod*e".
 * - The closest character to the 2nd star is 'e' in "lee*cod*e". s becomes "lecod*e".
 * - The closest character to the 3rd star is 'd' in "lecod*e". s becomes "lecoe".
 * There are no more stars, so we return "lecoe".
 * Example 2:
 * Input: s = "erase*****"
 * Output: ""
 * Explanation: The entire string is removed, so we return an empty string.
 */
public class RemoveStars {

  public static void main(String[] args) {
    String s = "leet**cod*e";
    String response = removeStars(s);
    System.out.println(response);
  }

  public static String removeStars(String s) {
    String response = "*";
    Stack<Character> ll = new Stack<>();
    char[] c = s.toCharArray();

    for (char cz : c) {
      if (cz == '*') {
        ll.pop();
      } else {
        ll.push(cz);
      }
    }
/*    int size = c.length;
    for (int i = 0; i < size; i++) {
      if (c[i] == '*') {
        ll.remove(c[i]);
        ll.remove(c[i - 1]);
      }
    }*/
    StringBuilder sb = new StringBuilder();
    while(!ll.isEmpty()) {
      sb.append(ll.pop());
    }
    System.out.println(sb.toString());
    /**
     * Bear in mind it is a stack so the first element pushed to
     * the stack is at the bottom....so "eocel" in stack and need to be
     * reverted to "lecoe".
     */
    String r = sb.reverse().toString();

    System.out.println(sb);
    return response;
  }

  public static String deleteStars(String s) {
    StringBuilder sb = new StringBuilder();
    for (char c : s.toCharArray()) {
      if (c != '*') {
        sb.append(c);
      } else {
        int resize = sb.length();
        sb.deleteCharAt(resize - 1);
      }
    }
    return sb.toString();
  }
}


