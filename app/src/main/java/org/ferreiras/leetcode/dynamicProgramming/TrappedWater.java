package br.dev.ferreiras.challenges.leetCode.dynamicProgramming;
/**
 * Given an array arr[] of N non-negative integers representing the height of blocks.
 * If width of each block is 1, compute how much water can be trapped between the blocks
 * during the rainy season.
 * Example 1:
 * Input:
 * N = 6
 * arr[] = {3,0,0,2,0,4}
 * Output:
 * 10
 */

import java.util.Arrays;

public class TrappedWater {
  public static void main(String[] args) {
    int[] tank = {3, 0, 0, 2, 0, 4};
    int n = 6;
    long response = trappingWater(tank, n);
  }

  public static long trappingWater(int[] arr, int n) {
    // Your code here
    int sum = 0, count = 0, max = Integer.MIN_VALUE, left = 0, right = 0;
    right = n - 1;

    for (int num : arr) {
      if (num == 0) {
        count++;
      }
      if (num > max) {
        max = num;
      }
    }

    Arrays.sort(arr);
    max = arr[n - 1];
    sum = count * max;
    while (left < right - 1) {
      int diff = arr[right - 1] - arr[left];
      int heightMin = Math.min(arr[left], arr[right]);
      max = Math.max(max, heightMin += (arr[right] - arr[left]));
      left++;
      right--;
    }
    return max;
  }
}
