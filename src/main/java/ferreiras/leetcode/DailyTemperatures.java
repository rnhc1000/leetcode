package ferreiras.leetcode;

import java.util.PriorityQueue;
import java.util.Queue;

/*
Given an array of integers temperatures represents the daily temperatures, return an array answer
such that answer[i] is the number of days you have to wait after the ith day to get a warmer temperature.
If there is no future day for which this is possible, keep answer[i] == 0 instead.
Example 1:
Input: temperatures = [73,74,75,71,69,72,76,73]
Output: [1,1,4,2,1,1,0,0]
Example 2:
Input: temperatures = [30,40,50,60]
Output: [1,1,1,0]
Example 3:
Input: temperatures = [30,60,90]
Output: [1,1,0]
Monotonic Stack
Whenever a problem requires enumerating values for indices on the basis of other
values in an array, one should think of including a stack in the solution!
And that too, a monotonic stack. It is simply a stack which contains values in
a monotonic order; i.e either increasing or decreasing.
Imagine there is a data structure which contains the indices whose temperatures
are in an increasing order. Then, enumerating the next index which has a greater
temperature will be easy: we simply pop the elements till the top element has a greater
temperature than the current index!
 */
public class DailyTemperatures {
  public static void main(String[] args) {
    int[] temperatures = {73, 74, 75, 71, 69, 72, 76, 73};
    int[] waitingLine = dailyTemperatures(temperatures);
    for (int days : waitingLine) {
      System.out.print(" " + days);
    }
    System.out.println();

    String r = decimalToBinary(1957);
    System.out.println(r);

  }

  public static int[] dailyTemperatures(int[] temperatures) {
    int size = temperatures.length;
    int[] response = new int[size];
    Queue<Integer> q = new PriorityQueue<>();
    for (int right = size - 1; right >= 0; right--) {
      while (!q.isEmpty() && temperatures[right] >= temperatures[q.peek()]) {
        q.remove();
      }
      if (!q.isEmpty()) {
        response[right] = q.peek() - right;
      }
      q.add(right);
    }
    return response;
  }

  public static String decimalToBinary(int n) {
    StringBuilder b = new StringBuilder();
    while (n >= 1) {
      int r = n % 2;
//      System.out.print(" " + r);
      b.insert(0, r);
      n /= 2;
    }

    return b.toString();
  }
}

