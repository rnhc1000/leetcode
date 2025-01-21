package ferreiras.leetcode;
/*
You are given a 2D integer array intervals where intervals[i] = [lefti, righti] represents the
inclusive interval [lefti, righti].

You have to divide the intervals into one or more groups such that each interval is in exactly one group,
and no two intervals that are in the same group intersect each other.

Return the minimum number of groups you need to make.

Two intervals intersect if there is at least one common number between them.
For example, the intervals [1, 5] and [5, 8] intersect.



Example 1:

Input: intervals = [[5,10],[6,8],[1,5],[2,3],[1,10]]
Output: 3
Explanation: We can divide the intervals into the following groups:
- Group 1: [1, 5], [6, 8].
- Group 2: [2, 3], [5, 10].
- Group 3: [1, 10].
It can be proven that it is not possible to divide the intervals into fewer than 3 groups.
Example 2:

Input: intervals = [[1,3],[5,6],[8,10],[11,13]]
Output: 1
Explanation: None of the intervals overlap, so we can put all of them in one group.


Constraints:

1 <= intervals.length <= 105
intervals[i].length == 2
1 <= lefti <= righti <= 106
 */

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

public class ArrayDivideMinimumNumberGroups {

  private static final Logger logger = LoggerFactory.getLogger(ArrayDivideMinimumNumberGroups.class);
  public static void main(String[] args) {
    int[][]  intervals = {
            {1,3},
            {5,6},
            {8,10},
            {11,13}
    };
    int response = minGroups(intervals);
   logger.info("Return -> {}", response);
  }

  public static int minGroups(int[][] intervals) {
    Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
    Queue<Integer> pqueue = new PriorityQueue<>();
    for (int[] interval : intervals) {
      int start = interval[0];
      int end = interval[1];
      if (!pqueue.isEmpty() && pqueue.peek() < start) pqueue.poll();
      pqueue.add(end);
    }

    boolean a = true;
    if( a = false ) logger.info("inside if");
    else logger.info("inside else");
    return pqueue.size();
  }
}
