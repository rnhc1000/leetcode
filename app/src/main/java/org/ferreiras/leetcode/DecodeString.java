package org.ferreiras.leetcode;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

import static java.lang.Character.isDigit;

/**
 * Given an encoded string, return its decoded string.
 * The encoding rule is: k[encoded_string], where the encoded_string inside
 * the square brackets is being repeated exactly k times.
 * Note that k is guaranteed to be a positive integer.
 * You may assume that the input string is always valid; there are no extra white spaces,
 * square brackets are well-formed, etc. Furthermore, you may assume that the original
 * data does not contain any digits and that digits are only for those repeat numbers, k.
 * For example, there will not be input like 3a or 2[4].
 * The test cases are generated so that the length of the output will never exceed 105.
 * Example 1:
 * Input: s = "3[a]2[bc]"
 * Output: "aaabcbc"
 * Example 2:
 * Input: s = "3[a2[c]]"
 * Output: "accaccacc"
 * Example 3:
 * Input: s = "2[abc]3[cd]ef"
 * Output: "abcabccdcdcdef"
 */

import java.util.Arrays;
public class DecodeString {

  public static void main(String[] args) {
    String s = "2[abc]3[cd]ef";
//    String s = "a4b4c4";
    String response = decoder(s);

    System.out.println(response);
  }

  public static String decodeString(String s) {
    String clearText = "";

    Stack<Character> stack = new Stack<>();
    for (int i = 0; i < s.length(); i++) {
      if (isDigit(s.charAt(i))) {
      }
      stack.push(s.charAt(i));
    }
    return clearText;
  }

public static final String decoder(String s) {
  Deque<String> deque = new ArrayDeque<>();
  StringBuilder multiplier = new StringBuilder();
  StringBuilder str = new StringBuilder();
  for (char c : s.toCharArray()) {
    if (Character.isDigit(c)) {
      if (!str.isEmpty()) {
        deque.push(str.toString());
        str = new StringBuilder();
      }
      multiplier.append(c);
    } else if (c == '[') {
      deque.push(multiplier.toString());
      multiplier = new StringBuilder();
    } else if (c == ']') {
      while (!deque.isEmpty() && !Character.isDigit(deque.peek().charAt(0))) {
        str.insert(0, deque.pop());
      }
      deque.push(str.toString().repeat(Integer.parseInt(deque.pop())));
      str = new StringBuilder();
    } else {
      str.append(c);
    }
  }
  while (!deque.isEmpty()) {
    str.insert(0, deque.pop());
  }
  return str.toString();
}
  public static String digits(String s) {
    // Defining String

    String result = "";
    int count = 0;

    String ss = "a4b4c4";
    char[] c = s.toCharArray();
    char myCh = c[0];
    System.out.print(" " + Arrays.toString(c));
    for (char r: c) {
      System.out.print(" " + Character.digit(r, 10));
    }
    char cx = '2';
    int k = Character.digit(cx, 10);
    System.out.print("\n"+ k);
    // Iterating over the string
    for (int i = 1; i < s.length(); i++) {
      // If the digit is found, we have to add myCh the digit times to result
      if (Character.isDigit(s.charAt(i))) {
        // Calculating the count needed
        count = count * 10 + Character.digit(s.charAt(i), 10);
        do {
          // Appending it to result
          result += myCh;
          count--;
        } while (count > 0);
      } else {
        // Setting myCh to next character
        count = 0;
        myCh = s.charAt(i);
      }
    }
    // Printing the result
    System.out.println(result);
    return result;
  }
}
