package org.ferreiras.leetCode;
/*
Given an array nums of n integers, return an array of all the unique quadruplets [nums[a], nums[b], nums[c], nums[d]] such that:

0 <= a, b, c, d < n
a, b, c, and d are distinct.
nums[a] + nums[b] + nums[c] + nums[d] == target
You may return the answer in any order.



Example 1:

Input: nums = [1,0,-1,0,-2,2], target = 0
Output: [[-2,-1,1,2],[-2,0,0,2],[-1,0,0,1]]
Example 2:

Input: nums = [2,2,2,2,2], target = 8
Output: [[2,2,2,2]]


Constraints:

1 <= nums.length <= 200
-109 <= nums[i] <= 109
-109 <= target <= 109
 */

import java.util.*;

public class FourSum {

  public static void main(String[] args) {
    int[] numbers = {1, 0, -1, 0, -2, 2};
    int target = 0;
    List<List<Integer>> response = sumFour(numbers, target);

    for (List<Integer> r : response) {
      for (int s  : r) {
        System.out.print(" " + s);
      }
      System.out.println();
    }
//    if (response.length > 0) {
//      System.out.println("Nothing to return here!");
//    }

  }


  public static int[][] fourSum(int[] numbers, int target) {
    int[][] check = new int[][]{{}};
    int[][] sumToZero = new int[4][target];
//    arraysOne.sort(numbers);
    System.out.println(Arrays.toString(numbers));
    int size = numbers.length;
    if (size <= target) return check;
    int pointer = 0;
    for (int i = 0; i < sumToZero.length; i++) {
      for (int k = 0; k < sumToZero[i].length; k++) {
        sumToZero[i][k] = numbers[pointer];
        pointer++;
      }
      pointer = i;
    }
    for (int[] d : sumToZero) {
      System.out.println(Arrays.toString(d));
    }
    List<Integer> w = new ArrayList<>();
    List<List<Integer>> a = new ArrayList<>(); //Use Arraylist inside

    for (int i = 0; i < size; i++) {
      for (int j = i; j < size; j++) {
        for (int k = i; k <= j; k++) {
          w.add(numbers[k]);
          a.add(new ArrayList<>(w));
          System.out.print(numbers[k] + " ");
        }
      }
/*        while (w.size() != 4) {
          continue;
        }

    }
    */


      for (int[] x : sumToZero) {
        for (int y : x) {
          w.add(y);
          if (w.size() != 4) continue;
          a.add(new ArrayList<>(w));
        }
      }
//    System.out.println(w);
//    System.out.println(a);
    }
    return check;
  }

  public static List<List<Integer>> sumFour(int[] numbers, int target) {

    Set<List<Integer>> set = new HashSet<>(); // Use a set to store unique quadruplets.
    int n = numbers.length;

    for (int i = 0; i < n; i++) {
      for (int j = i + 1; j < n; j++) {
        Set<Long> hash = new HashSet<>(); // Use a set to store unique sums.

        for (int k = j + 1; k < n; k++) {
          long sum = (long) numbers[i] + numbers[j] + numbers[k];
          long forth = (long) target - sum;

          if (hash.contains(forth)) {
            List<Integer> temp = Arrays.asList(numbers[i], numbers[j], numbers[k], (int) forth);
            Collections.sort(temp);
            set.add(temp);
          }
          hash.add((long) numbers[k]);
        }
      }
    }

    System.out.println(set);
    int size = set.size();
    System.out.println(size);
    int[][] response = new int[size][4];
    int i=0;
    for (List<Integer> list : set) {
      for(int j=0; j<list.size(); j++) {
        response[i][j] = list.get(j);
      }
      i++;

    }
    System.out.println(Arrays.toString(response));
//    ArrayList arrayList = new ArrayList<>(set.values());
//    return arrayList;
    return new ArrayList<>(set);
  }
}
