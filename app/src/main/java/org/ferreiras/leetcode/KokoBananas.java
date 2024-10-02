package org.ferreiras.leetcode;

/**
 * Koko loves to eat bananas. There are n piles of bananas, the ith pile has piles[i] bananas.
 * The guards have gone and will come back in h hours.
 * Koko can decide her bananas-per-hour eating speed of k.
 * Each hour, she chooses some pile of bananas and eats k bananas from that pile.
 * If the pile has less than k bananas, she eats all of them instead and will not eat any more
 * bananas during this hour.
 * Koko likes to eat slowly but still wants to finish eating all the bananas before the guards return.
 * Return the minimum integer k such that she can eat all the bananas within h hours.
 * Example 1:
 * Input: piles = [3,6,7,11], h = 8
 * Output: 4
 * Example 2:
 * Input: piles = [30,11,23,4,20], h = 5
 * Output: 30
 * Example 3:
 * Input: piles = [30,11,23,4,20], h = 6
 * Output: 23
 */
public class KokoBananas {
  public static void main(String[] args) {
    int[] piles = {1,2,3,4,5,6,7,8};
    int k = 8;
    System.out.println(minEatingSpeed(piles, k));
    System.out.println(hoursPerPile(piles, k));
  }


  public static final int minEatingPile(int[] piles, int h) {
    int low = 1;
    int high = Integer.MIN_VALUE;
    for (int pile : piles) {
      high = Math.max(high, pile);
    }
    while (low <= high) {
      int mid = low + (high - low) / 2;
      long total = hoursPerPile(piles, mid);
      if (total <= h) {
        high = mid - 1;
      } else {
        low = mid + 1;
      }
    }
    return low;
  }
  public static int minEatingSpeed(int[] piles, int hours) {
    int speed = Integer.MIN_VALUE;
    int max = Integer.MIN_VALUE;
    for (int i : piles) {
      max = Math.max(max, i);
    }
    System.out.println(max);

    return speed;
  }

  public static long hoursPerPile(int[] piles, int hours) {
    long hoursPerPile = 0L;
    for (int pile : piles) {
      hoursPerPile += (pile + hours -1)/hours;
    }
    return hoursPerPile;
  }
}
