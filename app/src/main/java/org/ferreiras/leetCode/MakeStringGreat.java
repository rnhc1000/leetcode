package org.ferreiras.leetCode;

import java.util.*;

import static java.lang.Character.codePointAt;
import static java.lang.Character.compare;

/*
Given a string s of lower and upper case English letters.

A good string is a string which doesn't have two adjacent characters s[i] and s[i + 1] where:

0 <= i <= s.length - 2
s[i] is a lower-case letter and s[i + 1] is the same letter but in upper-case or vice-versa.
To make the string good, you can choose two adjacent characters that make the string bad and
remove them. You can keep doing this until the string becomes good.

Return the string after making it good.
The answer is guaranteed to be unique under the given constraints.

Notice that an empty string is also good.
Example 1:

Input: s = "leEeetcode"
Output: "leetcode"
Explanation: In the first step, either you choose i = 1 or i = 2, both will result "leEeetcode" to be reduced to "leetcode".
Example 2:

Input: s = "abBAcC"
Output: ""
Explanation: We have many possible scenarios, and all lead to the same answer. For example:
"abBAcC" --> "aAcC" --> "cC" --> ""
"abBAcC" --> "abBA" --> "aA" --> ""
Example 3:

Input: s = "s"
Output: "s"


Constraints:

1 <= s.length <= 100
s contains only lower and upper case English letters.
 */
public class MakeStringGreat {
  public static void main(String[] args) {
    String s = "aAbBcCdDeEfFgGhHiIjJkKlLmMnNoOpPqQrRsStTuUvVwWxXyYzZ";
    String t = "leEeetcode";
    String response = makeGood(t);
    System.out.println("Good String is: -> " + response);

  }
  public static String makeGood(String s) {
    System.out.println(s);

    Deque<Character> stack = new ArrayDeque<>();
    for ( char c : s.toCharArray() ) {
      if(!stack.isEmpty() && Math.abs(c - stack.peek()) == 32) {
        stack.pop();
      } else {
        stack.push(c);
      }
    }

    Deque<Character> stackTwo = new ArrayDeque<>();
    while (!stack.isEmpty()) {
      stackTwo.push(stack.pop());
    }
    StringBuilder sb = new StringBuilder();
    while(!stackTwo.isEmpty()) {
      sb.append(stackTwo.pop());
    }
//    System.out.println("Good stack: -> " + stackTwo);
//    Queue<Character> queue = new LinkedList<>(stack);
//    System.out.println("Priority queue: -> " + queue);
//
//    Deque<Character> stackOne = new ArrayDeque<>(queue);
//    System.out.println("Second good stack: ->  " + stackOne);
//
//
//    while (!queue.isEmpty()) {
//      sb.append(queue.remove()).reverse();
//    }
//    System.out.println("Good queue: -> " + queue);
//
//    stack.clear();
//
//    while (!queue.isEmpty()) {
//      stack.push(queue.remove());
//    }
//    System.out.println(stack);
////    System.out.println(stack);
//    while(!stack.isEmpty()) {
//      sb.append(stack.pop());
//    }
//    for (int i = 0; i < s.length()-1; i++) {
//      int j = s.codePointAt(i);
//      int k = s.codePointAt(i+1);
//      if (Math.abs(k - j ) == 32 ) {
//        sb.deleteCharAt(i);
//        sb.deleteCharAt(i);
//      }
//      if (s.codePointAt(i) >= 97 && s.codePointAt(i+1) < 97) {
//          continue;
//      }
//      sb.append(ch[i]);
//    }
    return sb.toString();
  }
}
