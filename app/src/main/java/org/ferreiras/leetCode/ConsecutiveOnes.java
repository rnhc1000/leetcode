package org.ferreiras.leetCode;

/**
 * Given a positive integer n, return the number of the integers in the range [0, n]
 * whose binary representations do not contain consecutive ones.
 * Example 1:
 * Input: n = 5
 * Output: 5
 * Explanation:
 * Here are the non-negative integers <= 5 with their corresponding binary representations:
 * 0 : 0
 * 1 : 1
 * 2 : 10
 * 3 : 11
 * 4 : 100
 * 5 : 101
 * Among them, only integer 3 disobeys the rule (two consecutive ones) and the other
 * 5 satisfy the rule.
 * Example 2:
 * Input: n = 1
 * Output: 2
 * Example 3:
 * Input: n = 2
 * Output: 3
 * Constraints:
 * 1 <= n <= 109
 */
public class ConsecutiveOnes {
  public static void main(String[] args) {
    int n = 7;
    System.out.println(findIntegers(n));

  }
  public static int findIntegers(int n) {
    String binary = Integer.toBinaryString(n);
    int size = binary.length();
    int[] fib = new int[size + 1];
    fib[0] = 1;
    fib[1] = 2;
    for (int i = 2; i <= size; i++) {
      fib[i] = fib[i - 1] + fib[i - 2];
    }
    boolean lastBitOne = false;
    int response = 1;
    int bit = size - 1;
    while (bit >= 0) {
      if ((n & (1 << bit)) == 0) {
        lastBitOne = false;
      } else {
        response += fib[bit];
        if (lastBitOne) {
          return response;
        }
        lastBitOne = true;
      }
      bit--;
    }

    return response;
  }
}
