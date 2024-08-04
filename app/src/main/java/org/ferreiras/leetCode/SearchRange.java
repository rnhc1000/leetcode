package org.ferreiras.leetCode;

import java.util.*;

public class SearchRange {

  public static void main(String[] args) {
    int[] numbers = {5, 7, 7,8, 10};
    int target = 8;
    System.out.println(Arrays.toString(searchRange(numbers, target)));
  }

  public static int[] searchRange(int[] nums, int target) {
    List<Integer> response = new ArrayList<>();
    int left = 0, right = 0, middle = 0;
    right = nums.length - 1;
    while (left <= right) {
      middle = left + (right - left) / 2;

      if (nums[middle] == target) {
        response.add(middle);
        left++;
      } else if (nums[middle] < target) {
        left = middle + 1;
      } else if (nums[middle] > target){
        right = middle - 1;
      }
    }
    if (response.isEmpty()) {
      return new int[]{-1, -1};
    } else {
      int[] rt = new int[response.size()];

      for (int i = 0; i < response.size(); i++) {
        rt[i] = response.get(i);

      }
      return rt;
    }

  }
}
