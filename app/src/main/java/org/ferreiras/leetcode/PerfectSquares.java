package org.ferreiras.leetcode;

/**
 * Given an integer n, return the least number of perfect square numbers that sum to n.
 * A perfect square is an integer that is the square of an integer; in other words, it is
 * the product of some integer with itself. For example, 1, 4, 9, and 16 are perfect squares
 * while 3 and 11 are not.
 * Example 1:
 * Input: n = 12
 * Output: 3
 * Explanation: 12 = 4 + 4 + 4.
 * Example 2:
 * Input: n = 13
 * Output: 2
 * Explanation: 13 = 4 + 9.
 * 4-Square theorem: Every natural no is sum of 4 squares.
 * 3-Square Theorem: Every natural no is sum of 3 squares if it does not satisfy
 * 4^a (8b + 7) = N
 * So our answer will be 1, 2, 3 or 4.
 * Steps:
 * If it's perfect square, return 1
 * If it satisfies 4^a (8b + 7), return 4
 * If it's sum of 2 perfect squares, return 2
 * Otherwise, return 3
 */
public class PerfectSquares {
  public static void main(String[] args) {
    int n = 13;
    System.out.println(numSquares(n));
  }
  public static int numSquares(int n) {
    int sqrt = (int) Math.sqrt(n);

    if (sqrt * sqrt == n) // Perfect square
      return 1;

    while (n % 4 == 0) // 4^a (8b + 7)
      n = n / 4;

    if (n % 8 == 7)
      return 4;

    for (int i = 1; i * i <= n; i++) { // Sum of two perfect squares
      int square = i * i;
      int base = (int) Math.sqrt(n - square);
      if (base * base == n - square)
        return 2;
    }
    return 3;
  }
}
