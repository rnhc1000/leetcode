package org.ferreiras.leetCode;

import java.util.LinkedList;
import java.util.List;

/*
Given an array of integers arr.

We want to select three indices i, j and k where (0 <= i < j <= k < arr.length).

Let's define a and b as follows:

a = arr[i] ^ arr[i + 1] ^ ... ^ arr[j - 1]
b = arr[j] ^ arr[j + 1] ^ ... ^ arr[k]
Note that ^ denotes the bitwise-xor operation.

Return the number of triplets (i, j and k) Where a == b.

Example 1:

Input: arr = [2,3,1,6,7]
Output: 4
Explanation:
The triplets are (0,1,2), (0,2,2), (2,3,4) and (2,4,4)

Example 2:

Input: arr = [1,1,1,1,1]
Output: 10


Constraints:

1 <= arr.length <= 300
1 <= arr[i] <= 108
 */
public class ArrayTripletsEqualXor {

  public static void main(String[] args) {
    int[] array = { 2,3,1,6,7 };
    List<List<Integer>> result = triplets(array);
    System.out.println(result);
  }
  public static int countTriplets(int[] arr) {
    int count = 0;
    int size = arr.length;

    for (int i = 0; i < size; i++) {
      int value = arr[i];

      for (int k = i + 1; k < size; k++) {
        value = value ^ arr[k];

        if (value == 0) {
          count += (k - i);
        }
      }
    }

    return count;
  }

  public static List<List<Integer>> triplets(int[] arr) {
    int count = 0;
    int size = arr.length;
    List<List<Integer>> triplets = new LinkedList<>();

    for (int i = 0; i < size; i++) {
      int value = arr[i];
      List<Integer> triplet = new LinkedList<>();
      for (int k = i + 1; k < size; k++) {
        value = value ^ arr[k];
        System.out.printf("%d ",value);
        if (value == 0) {
          triplet.add(k-i);
          count += (k - i);
          System.out.println("Count: " + count);
        }

      }
      triplets.add(triplet);

    }

    return triplets;
  }
}
