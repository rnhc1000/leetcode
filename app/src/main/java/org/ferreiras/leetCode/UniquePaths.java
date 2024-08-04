package org.ferreiras.leetCode;

/**
 * There is a robot on an m x n grid. The robot is initially located at the top-left
 * corner (i.e., grid[0][0]). The robot tries to move to the bottom-right corner
 * (i.e., grid[m - 1][n - 1]). The robot can only move either down or right at any
 * point in time.
 * Given the two integers m and n, return the number of possible unique paths that
 * the robot can take to reach the bottom-right corner.
 * The test cases are generated so that the answer will be less than or equal
 * to 2 * 109.
 * Input: m = 3, n = 7
 * Output: 28
 * Example 2:
 * Input: m = 3, n = 2
 * Output: 3
 * Explanation: From the top-left corner, there are a total of 3 ways to reach the
 * bottom-right corner:
 * 1. Right -> Down -> Down
 * 2. Down -> Down -> Right
 * 3. Down -> Right -> Down
 * <p>
 * Nice explanation by:
 * <a href="https://leetcode.com/Mohamed-Afzal_Nandolia/">...</a>
 * Intuition
 * The code is designed to solve the unique paths problem, which is often presented as
 * a grid with dimensions 'm' rows and 'n' columns. The goal is to find the number of
 * unique paths to reach the bottom-right corner from the top-left corner of the grid
 * while only moving either down or right.
 * Approach
 * The code initializes a 2D array arr of size m x n to store the number of unique paths
 * to each cell.
 * It starts by initializing the last row of arr with all 1s because there is only one way
 * to reach any cell in the last row: by moving right.
 * Then, it iterates through the remaining rows and columns of the grid, starting from the
 * second-to-last row and moving upwards. For each cell, it calculates the number of unique
 * paths to that cell by summing the values from the cell directly below it and the cell to
 * its right. This is done through the formula arr[i][j] = arr[i + 1][j] + arr[i][j + 1].
 * After completing this loop, the arr array will contain the number of unique paths for each
 * cell in the grid, with the top-left cell (arr[0][0]) containing the total number of
 * unique paths to reach the destination.
 * The code returns the value stored in arr[0][0], which represents the number of unique
 * paths to reach the bottom-right corner of the grid.
 * Complexity
 * Time complexity:
 * Time Complexity: The code uses two nested loops to fill the arr array, resulting in a
 * time complexity of O(m * n), where 'm' is the number of rows and 'n' is the number of
 * columns in the grid.
 * Space complexity:
 * Space Complexity: The code uses additional space to store the arr array, which has a
 * space complexity of O(m * n) as well, since it has the same dimensions as the input grid.
 * After the loops
 * m = 3, n = 7
 * [28,21,15,10,6,3,1]
 * [7,6,5,4,3,2,1]
 * [1,1,1,1,1,1,1]
 * return arr[0][0];//we return the 1st element
 * ----
 * A pure mathematics solution for people who are interested.
 * This can be seen as a counting problem in discrete math.
 * If we can only travel down or right, then every path from the starting point to
 * the ending point is of fixed length m+n.
 * In this m+n steps we need to make m rightward steps and n downward steps.
 * The difference between each path is at each point whether you choose to go down or right.
 * Therefore, out of m+n steps to take, we have to choose m steps to go right, and the
 * others go down. There are C(m+n, m) number of ways to do this, where C stands for the mathematics
 * combination.
 * (Official definition for C(m+n,m): the number of subsets of length m of a set that has
 * m+n elements)
 * Using the formula for combinations, C(n, r) = n! / (r!(n - r)!),
 * we can express C(m + n, n) and C(m + n, m) as follows:
 * C(m + n, n) = (m + n)! / (n!(m + n - n)!) = (m + n)! / (n!m!)
 * C(m + n, m) = (m + n)! / (m!(m + n - m)!) = (m + n)! / (m!n!)
 */
public class UniquePaths {
  public static void main(String[] args) {
    int m = 4, n = 2;
    int response = fatorial(m);
    System.out.println(response);
  }

  public static int uniquePaths(int m, int n) {
    int[][] uniquePath = new int[m][n];
    for (int i = m - 1; i >= m - 1; i--) {
      for (int j = n - 1; j >= 0; j--) {
        uniquePath[i][j] = 1;
      }
    }

    for (int i = m - 2; i >= 0; i--) {
      for (int j = n - 1; j >= 0; j--) {
        if (j == n - 1) {
          uniquePath[i][j] += uniquePath[i + 1][j];
        } else {
          uniquePath[i][j] = uniquePath[i + 1][j] + uniquePath[i][j + 1];
        }
      }
    }

    return uniquePath[0][0];//we return the 1st element
  }

  public static int uniquePathss(int m, int n) {
    long response = 1;
    for (int i = 1; i <= m - 1; i++) {
      response = response * (n - 1 + i) / i;
    }
    return (int) response;
  }

  public static int uniquePathx(int m, int n) {
    int j = factorial(m + n);
    int k = factorial(n);
    int l = factorial(m);

    return j / (k * l);
  }

  public static int factorial(int n) {
    if (n <= 1) {
      return n;
    }
    int fat = 1;
    for (int i = n; i > 0; i--) {
      fat *= i;
    }

    return fat;
  }

  public static int fatorial(int n) {
    if (n == 0) {
      return 1;
    }
    return n * fatorial(n - 1);
  }
}