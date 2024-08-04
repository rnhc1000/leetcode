package org.ferreiras.leetCode;
/*
You are given a sorted integer array arr containing 1 and prime numbers,
where all the integers of arr are unique.
You are also given an integer k.

For every i and j where 0 <= i < j < arr.length, we consider the
fraction arr[i] / arr[j].

Return the kth smallest fraction considered.
Return your answer as an array of integers of size 2,
where answer[0] == arr[i] and answer[1] == arr[j].

Example 1:

Input: arr = [1,2,3,5], k = 3
Output: [2,5]
Explanation:
The fractions to be considered in sorted order are:
1/5, 1/3, 2/5, 1/2, 3/5, and 2/3.
The third fraction is 2/5.

Example 2:

Input: arr = [1,7], k = 1
Output: [1,7]

We have arr = [1, 2, 3, 5] and k = 3.
The function initializes n = 4 (size of arr), left = 0, right = 1, and mid is not initialized yet.
The while loop starts with the condition left <= right which is true initially.
Inside the loop, we calculate mid = left + (right - left) / 2 = 0 + (1 - 0) / 2 = 0.5.
We initialize j = 1, total = 0, num = 0, den = 0, and maxFrac = 0.
We enter the for loop with i = 0.
Since arr[0] = 1 and arr[1] = 2, we have arr[0] > arr[1] * mid which is 1 > 2 * 0.5 which is true.
So, we increment j to 2.
Since arr[0] = 1 and arr[2] = 3, we have arr[0] > arr[2] * mid which is 1 > 3 * 0.5 which is false.
So, we update total += n - j = 4 - 2 = 2.
We also update maxFrac = arr[i] * 1.0 / arr[j] = 1 * 1.0 / 3 = 0.33333....
We update num = 0 and den = 2.
We move to the next iteration of the for loop with i = 1.
Since arr[1] = 2 and arr[2] = 3, we have arr[1] > arr[2] * mid which is 2 > 3 * 0.5 which is true.
So, we increment j to 3.
Since arr[1] = 2 and arr[3] = 5, we have arr[1] > arr[3] * mid which is 2 > 5 * 0.5 which is false.
So, we update total += n - j = 2 + (4 - 3) = 3.
We also update maxFrac = arr[i] * 1.0 / arr[j] = 2 * 1.0 / 5 = 0.4.
We update num = 1 and den = 3.
We move to the next iteration of the for loop with i = 2.
Since arr[2] = 3 and arr[3] = 5, we have arr[2] > arr[3] * mid which is 3 > 5 * 0.5 which is true.
So, we increment j to 4 (which is out of bounds).
We update total += n - j = 3 + (4 - 4) = 3.
maxFrac remains unchanged at 0.4.
num and den remain unchanged at 1 and 3, respectively.
We move to the next iteration of the for loop with i = 3, but since i is now equal to n, the loop terminates.
Since total == k (3 == 3), we update res = {arr[num], arr[den]} = {arr[1], arr[3]} = {2, 5}.
The while loop terminates, and the function returns res = {2, 5}.
 */


import java.util.*;



public class ArrayPrimeFraction {
  static class Pair<T, S> implements Comparable<Pair<T, S>> {
    double fraction;
    int p1, p2;

    public Pair(double fraction, int p1, int p2) {
      this.fraction = fraction;
      this.p1 = p1;
      this.p2 = p2;
    }


    @Override
    public int compareTo(Pair<T, S> pair) {

      return Double.compare(this.fraction, pair.fraction);
    }

    @Override
    public String toString() {
      return "Pair{" +
             "fraction=" + fraction +
             ", p1=" + p1 +
             ", p2=" + p2 +
             '}';
    }

  }
  public static void main(String[] args) {
    int[] array = {1, 2, 3, 5};
    int k = 3;
    int[] response = kthSmallestPrimeFractions(array, k);
    System.out.println(Arrays.toString(response));
  }

  public static int[] kthSmallestPrimeFraction(int[] arr, int k) {

    StringBuilder sb = new StringBuilder();
    List<String> strings = new ArrayList<>();
    for (int i = 0; i < arr.length; i++) {
      for (int j = i + 1; j < arr.length; j++) {
        sb.append(arr[i]).append('/').append(arr[j]);
        strings.add(sb.toString());
        sb.setLength(0);
      }
    }
    System.out.println(strings);
    List<Double> d = new ArrayList<>();

    for (String s : strings) {

      d.add(Double.parseDouble(s));

    }
    System.out.println(d);
//    List<String> str = strings.stream().map(x ->x).sorted(Comparator.naturalOrder()).toList();
//    System.out.println(str);

    return new int[]{};

  }

  public static int[] kthSmallestPrimeF(int[] arr, int k) {

    int n = arr.length;
    double left = 0, right = 1, mid;
    int[] res = new int[2];

    while (left <= right) {
      mid = left + (right - left) / 2;
      int j = 1, total = 0, num = 0, den = 0;
      double maxFrac = 0;
      for (int i = 0; i < n; ++i) {
        while (j < n && arr[i] > arr[j] * mid) {
          ++j;
        }

        total += n - j;

        if (j < n && maxFrac < arr[i] * 1.0 / arr[j]) {
          maxFrac = arr[i] * 1.0 / arr[j];
          num = i;
          den = j;
        }
      }

      if (total == k) {
        res[0] = arr[num];
        res[1] = arr[den];
        break;
      }

      if (total > k) {
        right = mid;
      } else {
        left = mid;
      }
    }

    return res;
  }



  public static int[] kthSmallestPrimeFractions(int[] arr, int k) {
    int [] response = new int[2];
    PriorityQueue<Pair> queue = new PriorityQueue<>();
    System.out.println(Arrays.toString(arr));
    for (int i = 0; i < arr.length; i++) {
      for (int j = i + 1; j < arr.length; j++) {
        queue.offer(new Pair((double) arr[i] / arr[j], i, j));
      }
    }
    System.out.println(queue);
    for (int i = 0; i < k - 1; i++) {
      queue.remove();
    }
    System.out.println(queue);
    Pair pair = queue.remove();
    System.out.println(pair);
    response[0] = arr[pair.p1];
    response[1] = arr[pair.p2];
    return response;
  }
}