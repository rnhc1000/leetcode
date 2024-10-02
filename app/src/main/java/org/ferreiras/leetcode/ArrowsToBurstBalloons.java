package org.ferreiras.leetcode;

/*
 * There are some spherical balloons taped onto a flat wall that represents the XY-plane.
 * The balloons are represented as a 2D integer array points where points[i] =
 * [xstart, xend] denotes a balloon whose horizontal diameter stretches between
 * xstart and xend. You do not know the exact y-coordinates of the balloons.
 * Arrows can be shot up directly vertically (in the positive y-direction) from different
 * points along the x-axis. A balloon with xstart and xend is burst by an arrow shot at
 * x if xstart <= x <= xend. There is no limit to the number of arrows that can be shot.
 * A shot arrow keeps traveling up infinitely, bursting any balloons in its path.
 * Given the array points, return the minimum number of arrows that must be shot to burst all balloons.
 * Example 1:
 * Input: points = [[10,16],[2,8],[1,6],[7,12]]
 * Output: 2
 * Explanation: The balloons can be burst by 2 arrows:
 * - Shoot an arrow at x = 6, bursting the balloons [2,8] and [1,6].
 * - Shoot an arrow at x = 11, bursting the balloons [10,16] and [7,12].
 * Example 2:
 * Input: points = [[1,2],[3,4],[5,6],[7,8]]
 * Output: 4
 * Explanation: One arrow needs to be shot for each balloon for a total of 4 arrows.
 * Example 3:
 * Input: points = [[1,2],[2,3],[3,4],[4,5]]
 * Output: 2
 * Explanation: The balloons can be burst by 2 arrows:
 * - Shoot an arrow at x = 2, bursting the balloons [1,2] and [2,3].
 * - Shoot an arrow at x = 4, bursting the balloons [3,4] and [4,5].
 * Sorting by column
 * Arrays.sort(array, (a,b) -> Integer.compare(a[col], b[col])); increasing order
 * Arrays.sort(array, (a,b) -> Integer.compare(b[col], v[col])); descending order
 */

import java.util.Arrays;


@ClassPreamble (
        author = "Ricardo Ferreira",
        date = "10/01/2024",
        currentRevision = 7,
        lastModified = "10/01/2024",
        lastModifiedBy = "Ricardo Ferreira",
        reviewers = {}
)

public class ArrowsToBurstBalloons {
  public static void main(String[] args) {
    int[][] balloons = {
            {10, 16},
            {2, 8},
            {1, 6},
            {7, 12}
    };

    String[][] strings = {
            {"Ricardo", "Ferreira"},
            {"Perpetua", "Costa"},
            {"Henrique", "Camargo"},
            {"Nathalia", "Camargo"}
    };

    int response = findMinArrowShots(balloons);
    System.out.println(response);
    handlingArraysSorting(balloons);
    handlingArraysSorting(strings);
  }


  public static int findMinArrowShots(int[][] points) {
    if (points.length < 2)
      return 1;

    Arrays.sort(points, (a, b) -> a[1] - b[1]);
    int arrow = 1, prevEndPoint = points[0][1];
    for (int i = 1; i < points.length; i++) {
      if (points[i][0] <= prevEndPoint && prevEndPoint <= points[i][1])
        continue;
      else {
        arrow++;
        prevEndPoint = points[i][1];
      }
    }
    return arrow;
  }


  public static void handlingArraysSorting(int[][] numbers) {
    Arrays.sort(numbers, (b, a) -> b[1] - a[1]);
    for (int[] number : numbers) {
      System.out.println(Arrays.toString(number));
    }
  }
  public static void handlingArraysSorting(String[][] strings) {

    for (String[] string : strings) {
      Arrays.sort(string);
      System.out.println(Arrays.toString(string));
    }
  }

}
