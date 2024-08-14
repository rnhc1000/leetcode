package org.ferreiras.leetCode;

import java.util.Arrays;

public class ArrayKthSmallestPairDistance {

  public int smallestDistancePair(int[] numbers, int k) {
    Arrays.sort(numbers);
    int minimumDistance = 0, maximumDistance = numbers[numbers.length - 1] - numbers[0];

    while (minimumDistance < maximumDistance) {
      int middleDistance = minimumDistance + (maximumDistance - minimumDistance) / 2;
      int countPairs = countPairsWithinDistance(numbers, middleDistance);

      if (countPairs < k) {
        minimumDistance = middleDistance + 1;
      } else {
        maximumDistance = middleDistance;
      }
    }

    return minimumDistance;
  }

  private int countPairsWithinDistance(int[] numbers, int targetDistance) {
    int countPair = 0, left = 0, size = numbers.length;

    for (int right = 1; right < size; right++) {
      while (numbers[right] - numbers[left] > targetDistance) {
        left++;
      }
      countPair += right - left;
    }

    return countPair;
  }
}
