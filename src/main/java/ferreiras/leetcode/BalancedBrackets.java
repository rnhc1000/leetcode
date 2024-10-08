package ferreiras.leetcode;

import java.util.ArrayDeque;
import java.util.Deque;

/*
You are given a 0-indexed string s of even length n. The string consists of exactly n / 2 opening brackets
 '[' and n / 2 closing brackets ']'.

A string is called balanced if and only if:

It is the empty string, or
It can be written as AB, where both A and B are balanced strings, or
It can be written as [C], where C is a balanced string.
You may swap the brackets at any two indices any number of times.

Return the minimum number of swaps to make s balanced.



Example 1:

Input: s = "][]["
Output: 1
Explanation: You can make the string balanced by swapping index 0 with index 3.
The resulting string is "[[]]".
Example 2:

Input: s = "]]][[["
Output: 2
Explanation: You can do the following to make the string balanced:
- Swap index 0 with index 4. s = "[]][][".
- Swap index 1 with index 5. s = "[[][]]".
The resulting string is "[[][]]".
Example 3:

Input: s = "[]"
Output: 0
Explanation: The string is already balanced.


Constraints:

n == s.length
2 <= n <= 106
n is even.
s[i] is either '[' or ']'.
The number of opening brackets '[' equals n / 2, and the number of closing brackets ']' equals n / 2.
 */
public class BalancedBrackets {

  public static void main(String[] args) {
    String s = "][][";
    int response = minSwaps(s);
    System.out.println(response);
    response = minimumSwaps((s));
    System.out.println(response);
  }

  public static int minSwaps(String s) {

    Deque<Character> stack = new ArrayDeque<>();
    int size = s.length();
    if (size % 2 != 0) return 0;
    int count = 0;


    for (int i = 0; i < size; i++) {
      char ch = s.charAt(i);
      if (ch == '[') {
        stack.push(ch);
      } else if (!stack.isEmpty() && stack.peek() == '[') {
        stack.pop();
      } else {
        stack.push(ch);
      }
    }

    int unbalancedPairs = stack.size() / 2;

    System.out.println(stack.size());

    int swaps = Math.ceilDiv(unbalancedPairs , 2);
    return swaps;
  }

  public static int minimumSwaps(String s) {
    int swap = 0;
    int size = s.length();

    for (int i = 0; i < size; i++) {
      char ch = s.charAt(i);
      if (ch == '[') swap++;
      else if(swap > 0) swap--;
    }
    return ( swap + 1 ) / 2;
  }
}
