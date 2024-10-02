package org.ferreiras.leetcode;

import java.util.ArrayDeque;
import java.util.Deque;

/*
Given a rows x cols binary matrix filled with 0's and 1's, find the largest rectangle
containing only 1's and return its area.
Example 1:
Input: matrix = {
  {"1","0","1","0","0"},
  {"1","0","1","1","1"},
  {"1","1","1","1","1"},
  {"1","0","0","1","0"}
 }
Output: 6
Explanation: The maximal rectangle is shown in the above picture.
Example 2:

Input: matrix = [["0"]]
Output: 0
Example 3:

Input: matrix = [["1"]]
Output: 1


Constraints:

rows == matrix.length
cols == matrix[i].length
1 <= row, cols <= 200
matrix[i][j] is '0' or '1'.

Intuition by
Let's break down the solution process into two distinct sub-processes:
Processing Height Array and Max Area Calculation.

Processing Height Array✅:
Initialization:

Create an array height initialized with zeros, with length equal to the number of
columns in the matrix. This array will represent the heights of bars in a histogram.
Processing Each Row:

For each row currRow in the 2D matrix:
Traverse through each element of currRow.
If the element is 1, increment the corresponding index in the height array.
If the element is 0, reset the corresponding index in the height array to 0.

Max Area Calculation (Naive Approach)🤓:
Now that we got height array assume that you are solving Leetcode Problem 84.
Largest Rectangle in Histogram where we are given an array of integers heights
representing the histogram's bar height where the width of each bar is 1.
We want to find and return the area of the largest rectangle in the histogram.

Approach:

Iterate over all possible pairs of bars (i, j) where i < j.
For each pair (i, j), determine the minimum height h between the bars from index i to j.
Calculate the area of the rectangle formed by this pair of bars, which is area = h * (j - i + 1).
Keep track of the maximum area found during these iterations.
 */
public class MaximumRectangle {
  public int maximalRectangle(char[][] matrix) {

    if (matrix == null || matrix.length == 0 || matrix[0].length == 0)
      return 0;

    int rows =    matrix.length;
    int columns = matrix[0].length;
    int[] height = new int[columns + 1];
    int maximumArea = 0;

    for (char[] row : matrix) {
      for (int i = 0; i < columns; i++) {
        height[i] = (row[i] == '1') ? height[i] + 1 : 0;
      }

      int n = height.length;

      for (int i = 0; i < n; i++) {

        int minimumHeight = Integer.MAX_VALUE;

        for (int j = i; j < n; j++) {

          minimumHeight = Math.min(minimumHeight, height[j]);
          int area = minimumHeight * (j - i + 1);
          maximumArea = Math.max(maximumArea, area);

        }
      }
    }

    return maximumArea;
  }

  public static int getMaximumArea(int[] height) {
    Deque<Integer> stack = new ArrayDeque<>();
    int area = 0;
    for (int i = 0; i <= height.length; i++) {
      while (!stack.isEmpty() && (i == height.length || height[stack.peek()] >= height[i])) {
        int newHeight = height[stack.pop()];
        int width = stack.isEmpty() ? i : i - stack.peek() - 1;
        area = Math.max(area, width * newHeight);
      }
      stack.push(i);
    }
    return area;
  }

  public int maximumRectangle(char[][] matrix) {
    int area = 0;
    int[] height = new int[matrix[0].length];
    for (int i = 0; i < matrix.length; i++) {
      for (int j = 0; j < matrix[0].length; j++) {
        if (matrix[i][j] == '0') {
          height[j] = 0;
        } else if (matrix[i][j] == '1') {
          height[j]++;
        }
      }

      int currentMaximumArea = getMaximumArea(height);
      area = Math.max(area, currentMaximumArea);
    }
    return area;
  }

  public static void getLeftBound(char[] matrix, int[] leftBound, int[] height, int left) {
    for (int i = 0; i < height.length; i++) {
      if (matrix[i] == '1') {
        height[i]++;
        leftBound[i] = Math.max(leftBound[i], left);
      } else {
        height[i] = 0;
        leftBound[i] = 0;
        left = i + 1;
      }
    }
  }

  public static void getRightBound(char[] matrix, int[] rightBound, int right) {
    for (int i = rightBound.length - 1; i >= 0; i--) {
      if (matrix[i] == '1') {
        rightBound[i] = Math.min(rightBound[i], right);
      } else {
        rightBound[i] = right;
        right = i;
      }
    }
  }

  public static int getMaximumArea(int[] height, int[] leftBound, int[] rightBound, int area) {
    for (int i = 0; i < height.length; i++) {
      int width = rightBound[i] - leftBound[i];
      area = Math.max(area, height[i] * width);
    }
    return area;
  }
}
