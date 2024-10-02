package org.ferreiras.leetcode;

import java.util.*;
import java.util.function.Function;
import java.util.logging.Logger;
import java.util.stream.Collectors;

/*
Given an array of integers arr, replace each element with its rank.

The rank represents how large the element is. The rank has the following rules:

Rank is an integer starting from 1.
The larger the element, the larger the rank. If two elements are equal, their rank must be the same.
Rank should be as small as possible.


Example 1:

Input: arr = [40,10,20,30]
Output: [4,1,2,3]
Explanation:
40 is the largest element. 10 is the smallest. 20 is the second smallest.
30 is the third smallest.
Example 2:

Input: arr = [100,100,100]
Output: [1,1,1]
Explanation: Same elements share the same rank.

Example 3:

Input: arr = [37,12,28,9,100,56,80,5,12]
Output: [5,3,4,2,8,6,7,1,3]


Constraints:

0 <= arr.length <= 105
-109 <= arr[i] <= 109
 */
public class ArrayRank {

  private static final Logger logger = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);
  public static void main(String[] args) {
    int[] arr = {40,10,20,30 };
    int[] response = arrayRankTransform(arr);

    System.out.println(Arrays.toString(response));

  }

  public static int[] arrayRankTransform(int[] arr) {

    String s = "aaaeiou";
    Map<Integer, Long> map = s.chars().boxed().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
    Set<Integer> set = new TreeSet<>(Arrays.stream(arr).boxed().toList());

    Map<Integer, Integer> rank = new LinkedHashMap<>();
    int count = 0;

    for (Integer integer : set) {
      count+=1;
      rank.put(integer, count);
    }


    for (Integer integer: set) {
      System.out.print(" " + integer);
    }
    count = 0;
    List<Long> list = new LinkedList<>();
    for (Map.Entry<Integer, Long> entrySet : map.entrySet()) {

      Integer key = entrySet.getKey();
      Long value = entrySet.getValue();
      list.add(value);

    }
//    System.out.println(map);
//    System.out.println(rank);
//
//
//    for (int i = 0; i < arr.length; i++) {
//      arr[i] = rank.get(arr[i]);
//    }

    return list.stream().mapToInt(Math::toIntExact).toArray();
  }
}
