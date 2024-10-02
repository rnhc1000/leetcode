package org.ferreiras.leetcode;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class SmallestInfiniteSet {
  static Set<Integer> set = new HashSet<>();

  public SmallestInfiniteSet() {
  }

  public int popSmallest() {
    int min = Integer.MAX_VALUE;
    for(Integer s : set) {
      if (s < min) {
        min = s;
      }
    }
    return min;
  }

  public void addBack(int num) {
    set.add(num);
  }

  public static void main(String[] args) {
    SmallestInfiniteSet smallestInfiniteSet = new SmallestInfiniteSet();
    Random random = new Random();
    int size = random.nextInt(1,20);
    for (int i = 0; i < size; i++) {
      set.add(random.nextInt(0, 99));
    }
    smallestInfiniteSet.addBack(90);
    int min = smallestInfiniteSet.popSmallest();
    System.out.println(min);
  }
}
