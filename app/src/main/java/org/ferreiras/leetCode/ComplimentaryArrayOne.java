package org.ferreiras.leetCode;

import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;

public class ComplimentaryArrayOne {

  public static void main(String[] args) {
    int[] numbers = {1,2,1,2};
    int limit = 2;
    System.out.println(minMoves(numbers,limit));
  }
    public static int minMoves(int[] nums, int limit) {
      int[] delta = new int[2 * limit + 2];
      List<Integer> deltax = new ArrayList<>();
      Arrays.fill(delta, 0);
      int n = nums.length;
      for (int i = 0; i < n / 2; i++) {
        int a = nums[i], b = nums[n - 1 - i];
        delta[2] += 2;
        delta[Math.min(a, b) + 1]--;
        delta[a + b]--;
        delta[a + b + 1]++;
        delta[Math.max(a, b) + limit + 1]++;
      }
      int res = 2 * n, curr = 0;
      for (int i = 2; i <= 2 * limit; i++) {
        curr += delta[i];
        res = Math.min(res, curr);
      }
      return res;
    }
  }

