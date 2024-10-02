package org.ferreiras.leetcode;

import java.util.*;
import java.util.stream.Stream;

/*
Balanced strings are those that have an equal quantity of 'L' and 'R' characters.

Given a balanced string s, split it into some number of substrings such that:

Each substring is balanced.
Return the maximum number of balanced strings you can obtain.



Example 1:

Input: s = "RLRRLLRLRL"
Output: 4
Explanation: s can be split into "RL", "RRLL", "RL", "RL", each substring contains same number of 'L' and 'R'.
Example 2:

Input: s = "RLRRRLLRLL"
Output: 2
Explanation: s can be split into "RL", "RRRLLRLL", each substring contains same number of 'L' and 'R'.
Note that s cannot be split into "RL", "RR", "RL", "LR", "LL", because the 2nd and 5th substrings are not balanced.
Example 3:

Input: s = "LLLLRRRR"
Output: 1
Explanation: s can be split into "LLLLRRRR".


Constraints:

2 <= s.length <= 1000
s[i] is either 'L' or 'R'.
s is a balanced string.
 */
public class StringBalancedStrip {
  public static void main(String[] args) {
    String s = "RLRRRLLRLL";
    int response = balancedStringSplit(s);
    System.out.println(response);
  }

  public static int balancedStringSplit(String s) {
    int count = 0;
    Stream<char[]> st = Stream.of(s.toCharArray());
    //st.forEach(System.out::println);
    Deque<Character> queue = new ArrayDeque<>();
    char[] ch = s.toCharArray();
    for (char c : ch) {
      queue.offer(c);
    }
    System.out.println(queue);
    char c = queue.remove(); //R

    while ((!queue.isEmpty())) {

      assert queue.peek() != null;
      if (!queue.peek().equals(c)) {
        count++;
        queue.remove();
      }
      c = queue.remove();
    }


    return count;
  }

  public static int StringSplitBalanced(String s) {
    int response = 0, count = 0;
    for (int i = 0; i < s.length(); i++) {
      count += s.charAt(i) == 'L' ? 1 : -1;
      if (count == 0) response++;
    }
    return response;
  }
}
