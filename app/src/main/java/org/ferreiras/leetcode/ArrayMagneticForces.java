package org.ferreiras.leetcode;

import java.util.Arrays;

/*
In the universe Earth C-137, Rick discovered a special form of magnetic force between two balls
if they are put in his new invented basket. Rick has n empty baskets, the ith basket is at position[i],
Morty has m balls and needs to distribute the balls into the baskets such that the minimum magnetic
force between any two balls is maximum.

Rick stated that magnetic force between two different balls at positions x and y is |x - y|.

Given the integer array position and the integer m. Return the required force.



Example 1:


Input: position = [1,2,3,4,7], m = 3
Output: 3
Explanation: Distributing the 3 balls into baskets 1, 4 and 7 will make the magnetic force between
ball pairs [3, 3, 6]. The minimum magnetic force is 3.
We cannot achieve a larger minimum magnetic force than 3.
Example 2:

Input: position = [5,4,3,2,1,1000000000], m = 2
Output: 999999999
Explanation: We can use baskets 1 and 1000000000.


Constraints:

n == position.length
2 <= n <= 105
1 <= position[i] <= 109
All integers in position are distinct.
2 <= m <= position.length
 */
public class ArrayMagneticForces {
  public static void main(String[] args) {
    int[] position = {1, 2, 3, 4, 7};
    int m = 3;
    int result = maximumDistance(position, m);
    System.out.println(result);
  }

  public static int maxDistance(int[] position, int m) {

    Arrays.sort(position);
    int left = 0, right = position.length - 1, medium = 0;
    if (m > position.length) return 0;

    while (left <= right) {
      medium = (left + (right - left) / 2);


      if (position[medium] == m) return medium;

      if (position[medium] < m) {
        left = medium + 1;
      } else {
        right = medium - 1;
      }
    }
    return medium;
  }

  public static int maximumDistance(int[] position, int m) {
    Arrays.sort(position);
    int left = 1, right = position[position.length - 1], response = 1;
    right = (right - position[0]) / (m - 1);
    while (left <= right) {
      int middle = left + (right - left) / 2;
      if (isShot(position, middle, m)) {
        response = middle;
        left = middle+1;
      } else {
        right = middle-1;
      }
    }
    return response;
  }

  private static boolean isShot(int[] positions, int distance, int balls) {
    int count = 1, last = positions[0];
    for (int i=0; i<positions.length; i++) {
      if (positions[i] - last >= distance) {
        count++;
        last = positions[i];
      }
      if (count >= balls) {
        return true;
      }
    }
    return false;
// > monitor traffic  interface et-0/0/0.3026 size 9999 no-resolve matching "host 10.255.255.252 && tcp port 179" detail
  }
}
