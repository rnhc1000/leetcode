package org.ferreiras.leetcode;

import java.util.*;

public class RemoveElement {
  public static void main(String[] args) {
    int[] numbers = {1,2,3,4,5,6,7,8,7,9,9,10};
    int val = 9;
    int r = removeElement(numbers,val);
    System.out.println(r);
  }

  public static int removeElement(int[] nums, int val) {
    Deque<Integer> stack = new ArrayDeque<>();
    int size = nums.length;
    for (int num : nums) {
      stack.add(num);
    }
    List<Integer> list = new ArrayList<>();
    int count = 0;
    while (!stack.isEmpty()) {
      if (stack.peek() == val) {
        stack.pop();
        count++;
      } else {
        list.add(stack.pop());
      }
    }
    System.out.println(list);

    for (int i = 0; i < list.size(); i++) {
      nums[i] = list.get(i);
    }
    System.out.println(Arrays.toString(nums));
    return list.size();
  }

  public int removeElements(int[] nums, int val) {
    int index = 0;
    for (int num : nums) {
      if (num != val) {
        nums[index] = num;
        index++;
      }
    }
    
    return index;
  }
}
