package org.ferreiras.leetCode;

import java.util.ArrayList;
import java.util.List;

public class SmallestInfiniteSetOne {
  boolean[] list;
  int nums;
  public SmallestInfiniteSetOne() {
    this.nums = 1;
    this.list = new boolean[1001];
  }

  public int popSmallest() {

    for(int x = nums; x < list.length; x++)
    {
      if(!list[x])
      {
        list[x] = true;
        nums = x;
        break;
      }
    }
    return nums;
  }

  public void addBack(int num) {
    list[num] = false;
    nums = Math.min(num, nums);
  }
}
