package org.ferreiras.leetcode;

/**
 * Given an integer n, break it into the sum of k positive integers, where k >= 2,
 * and maximize the product of those integers.
 * Return the maximum product you can get.
 * Example 1:
 * Input: n = 2
 * Output: 1
 * Explanation: 2 = 1 + 1, 1 × 1 = 1.
 * Example 2:
 * Input: n = 10
 * Output: 36
 * Explanation: 10 = 3 + 3 + 4, 3 × 3 × 4 = 36.
 */
public class IntegerBreak {
  public static void main(String[] args) {
    int n = 10;
    System.out.println(integerBreak(n));

  }
  public static int integerBreak(int n) {

    if (n == 2 || n == 3) return (n-1);

// Keep removing parts of size 3 while n is greater than 4
    int res = 1;
    while (n > 4)
    {
      n -= 3;
      res *= 3; // Keep multiplying 3 to res
    }
    return (n * res);

  }
}
