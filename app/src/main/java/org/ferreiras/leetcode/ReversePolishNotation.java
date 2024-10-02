package org.ferreiras.leetcode;

import java.util.*;

/**
 * You are given an array of strings tokens that represents an arithmetic expression
 * in a Reverse Polish Notation.
 * Evaluate the expression.
 * Return an integer that represents the value of the expression.
 * Note that:
 * The valid operators are '+', '-', '*', and '/'.
 * Each operand may be an integer or another expression.
 * The division between two integers always truncates toward zero.
 * There will not be any division by zero.
 * The input represents a valid arithmetic expression in a reverse polish notation.
 * The answer and all the intermediate calculations can be represented in a 32-bit integer.
 * Example 1:
 * Input: tokens = ["2","1","+","3","*"]
 * Output: 9
 * Explanation: ((2 + 1) * 3) = 9
 * Example 2:
 * <p>
 * Input: tokens = ["4","13","5","/","+"]
 * Output: 6
 * Explanation: (4 + (13 / 5)) = 6
 * Example 3:
 * Input: tokens = ["10","6","9","3","+","-11","*","/","*","17","+","5","+"]
 * Output: 22
 * Explanation: ((10 * (6 / ((9 + 3) * -11))) + 17) + 5
 * = ((10 * (6 / (12 * -11))) + 17) + 5
 * = ((10 * (6 / -132)) + 17) + 5
 * = ((10 * 0) + 17) + 5
 * = (0 + 17) + 5
 * = 17 + 5
 * = 22
 */
public class ReversePolishNotation {
  public static void main(String[] args) {
    String[] tokens = {"10","6","9","3","+","-11","*","/","*","17","+","5","+"};
    String[] tokensOne = { "4","13","5","/","+"};
    int response = evalRPNN(tokensOne);
    System.out.println(response);

  }
  public static int evalRPNN(String[] tokens) {
    Deque<Long> queue = new ArrayDeque<>();
    for (String token : tokens) {
      if (token.length() == 1 && token.charAt(0) < 48 && token.charAt(0) > 41) {
        long integer2 = queue.pop();
        long integer1 = queue.pop();
        char operator = token.charAt(0);
        long resolvedAns = calculate(integer1, integer2, operator);
        queue.push(resolvedAns);
      } else {
        queue.push(Long.parseLong(token));
      }
    }
    return queue.pop().intValue();
  }
  public static int evalRPN(String[] tokens) {

    Queue<Long> queue = new LinkedList<>();
    for (String token : tokens) {
      if (token.length() == 1 && token.charAt(0) < 48 && token.charAt(0) > 41) {
        long operandTwo = queue.remove();
        long operandOne = queue.remove();
        char operator = token.charAt(0);
        long partialSum = calculate(operandOne, operandTwo, operator);
        queue.offer(partialSum);
      } else {
        queue.offer(Long.parseLong(token));
      }
    }
    return queue.remove().intValue();
    }
  public static long calculate(long x, long y, char operator) {
    long result = 0L;
    switch(operator) {
      case '+' -> result =  (x + y);
      case '-' -> result =  (x - y);
      case '*' -> result =  (x * y);
      case '/' -> result =  (x / y);
      default -> {
      }
    }
    return result;
  }

}
