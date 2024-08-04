package org.ferreiras.leetCode;

/**
 * Given an integer n, return the number of ways to tile an 2 x n board.
 * Since the answer may be very large, return it modulo 109 + 7.
 * In a tiling, every square must be covered by a tile.
 * Two tilings are different if and only if there are two 4-directionally
 * adjacent cells on the board such that exactly one of the tilings has
 * both squares occupied by a tile.
 * Example 1:
 * Input: n = 3
 * Output: 5
 * Explanation: The five different ways are show above.
 * Example 2:
 * Input: n = 1
 * Output: 1
 * Constraints:
 * 1 <= n <= 1000
 * first 10 numbers output:
 * [1,2,5,11,24,53,117,258,569,1255]
 * observe the pattern 11=5x2+1, 24=11x2+2, 53=24x2+5......
 */
public class DominoTromino {
  public static void main(String[] args) {

  }

  public int numTilings(int n) {
    //int mod = 1_000_000_007;
    int mod = (int) Math.pow(10, 9) + 7;
    if (n == 1 || n == 2)
      return n;
    int[]  modes= new int[n];
    modes[0] = 1;
    modes[1] = 2;
    modes[2] = 5;
    for (int i = 3; i < n; i++) {
      modes[i] = (
              (
                      (modes[i - 1]) % mod * 2
              )
                      % mod + modes[i - 3] % mod
      ) % mod;
    }
    return modes[n - 1];
  }
}
