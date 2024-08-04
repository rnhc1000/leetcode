package org.ferreiras.leetCode;
/**
 *Given an array of intervals where intervals[i] = [starti, endi],
 * return the minimum number of intervals you need to remove to make
 * the rest of the intervals non-overlapping.
 * Example 1:
 * Input: intervals = [[1,2],[2,3],[3,4],[1,3]]
 * Output: 1
 * Explanation: [1,3] can be removed and the rest of the intervals are non-overlapping.
 * Example 2:
 *
 * Input: intervals = [[1,2],[1,2],[1,2]]
 * Output: 2
 * Explanation: You need to remove two [1,2] to make the rest of the intervals
 * non-overlapping.
 * Example 3:
 * Input: intervals = [[1,2],[2,3]]
 * Output: 0
 * Explanation: You don't need to remove any of the intervals since they're already
 * non-overlapping.
 * Constraints:
 * 1 <= intervals.length <= 105
 * intervals[i].length == 2
 * -5 * 104 <= starti < endi <= 5 * 104
 *
 * Nice explanation given by:
 * https://leetcode.com/rahulvarma5297/
 * Intuition:
 * Minimum number of intervals to remove .
 * Which is nothing but maximum number of intervals we should keep.
 * Then it comes under Maximum Meeting we can attend.
 * In Detail
 * Explanation:
 * Imagine we have a set of meetings, where each meeting is represented by
 * an interval [start_time, end_time]. The goal is to find the maximum number
 * of non-overlapping meetings we can attend.
 *
 * Sorting by end times (cmp function):
 * The function first sorts the intervals based on their end times in ascending
 * order using the custom comparator cmp. This sorting is crucial because it allows
 * us to prioritize intervals that finish early, giving us more opportunities to
 * accommodate additional meetings later on.
 * Initializing variables:
 * The function initializes two variables, prev and count. The prev variable is used
 * to keep track of the index of the last processed interval, and count is used to
 * store the number of non-overlapping meetings found so far. We start count with 1
 * because the first interval is considered non-overlapping with itself.
 * Greedy approach:
 * The function uses a greedy approach to find the maximum number of non-overlapping
 * meetings. It iterates through the sorted intervals starting from the second interval
 * (index 1) because we've already counted the first interval as non-overlapping.
 * For each interval at index i, it checks if the start time of the current interval
 * (intervals[i][0]) is greater than or equal to the end time of the previous interval
 * (intervals[prev][1]). If this condition is true, it means the current interval does
 * not overlap with the previous one, and we can safely attend this meeting.
 * In that case, we update prev to the current index i and increment count to reflect that
 * we have attended one more meeting.
 * Return result:
 * Finally, the function returns the number of intervals that need to be removed to make
 * the remaining intervals non-overlapping. Since we want to maximize the number of meetings
 * we can attend, this value is calculated as n - count, where n is the total number of
 * intervals.
 */

import java.util.Arrays;
import java.util.Comparator;

public class EraseIntervals {
  public static void main(String[] args) {
//    int[][] intervals = {{1,2},{2,3},{3,4},{1,3}};
    int[][] intervals = {{1,2},{1,2},{1,2}};

    int response = EraseIntervals.eraseOverlapIntervals(intervals);

    System.out.println(response);
  }
  public static int eraseOverlapIntervals(int[][] intervals) {
    int size = intervals.length;
    Arrays.sort(intervals, Comparator.comparingInt(x -> x[1]));
    int prev = 0;
    int count = 1;
    for (int i = 1; i < size; i++) {
      if (intervals[i][0] >= intervals[prev][1]) {
        prev = i;
        count++;
      }
    }
    return size - count;
  }
}
