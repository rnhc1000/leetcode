package org.ferreiras.leetcode;

import java.util.ArrayDeque;
import java.util.Deque;
/*
Given string num representing a non-negative integer num, and an integer k,
return the smallest possible integer after removing k digits from num.

Example 1:

Input: num = "1432219", k = 3
Output: "1219"
Explanation:
Remove the three digits 4, 3, and 2 to form the new number 1219 which is the smallest.

Example 2:

Input: num = "10200", k = 1
Output: "200"
Explanation:
Remove the leading 1 and the number is 200. Note that the output must not contain leading zeroes.
Example 3:

Input: num = "10", k = 2
Output: "0"
Explanation:
Remove all the digits from the number and it is left with nothing which is 0.


Constraints:

1 <= k <= num.length <= 105
num consists of only digits.
num does not have any leading zeros except for the zero itself.
 */
public class RemoveKDigits {
  public static void main(String[] args) {
    String number = "10200";
    int k = 1;

    String response = removeKdigits(number, k);
    System.out.println(response);

  }
  public static String removeKdigits(String num, int k) {
    Deque<Character> deque = new ArrayDeque<>();

    for (char ch : num.toCharArray()) {
      while (!deque.isEmpty() && k > 0 && deque.peek() > ch) {
        deque.pop();
        k--;
      }
      deque.push(ch);
    }

//    while (k > 0 && !deque.isEmpty()) {
//      deque.pop();
//      k--;
//    }

    StringBuilder sb = new StringBuilder();
    while (!deque.isEmpty()) {
      sb.append(deque.pop());
    }
    sb.reverse();

    while (!sb.isEmpty() && sb.charAt(0) == '0') {
      sb.deleteCharAt(0);
    }

    return !sb.isEmpty() ? sb.toString() : "0";
  }
}
