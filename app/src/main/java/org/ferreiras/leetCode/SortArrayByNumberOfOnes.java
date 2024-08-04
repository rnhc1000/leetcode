package org.ferreiras.leetCode;

import java.util.*;

/*
You are given an integer array arr. Sort the integers in the array in ascending order
by the number of 1's in their binary representation and in case of two or more integers
have the same number of 1's you have to sort them in ascending order.

Return the array after sorting it.
Example 1:

Input: arr = [0,1,2,3,4,5,6,7,8]
Output: [0,1,2,4,8,3,5,6,7]
Explanation:
[0] is the only integer with 0 bits.
[1,2,4,8] all have 1 bit.
[3,5,6] have 2 bits.
[7] has 3 bits.
The sorted array by bits is [0,1,2,4,8,3,5,6,7]

Example 2:
Input: arr = [1024,512,256,128,64,32,16,8,4,2,1]
Output: [1,2,4,8,16,32,64,128,256,512,1024]
Explanation:
All integers have 1 bit in the binary representation, you should just sort them in ascending order.

Constraints:

1 <= arr.length <= 500
0 <= arr[i] <= 104
 */
public class SortArrayByNumberOfOnes {
  public static void main(String[] args) {

    int[] arr = {1633,2181,7558,2650,1920,809,4903,2223,4271,4110,
            7564,5428,1730,5970,9640,3185,7564,5040,4344,9479,2070,
            6569,9849,73,2961,7991,9419,7946,3293,882,4714,3813,278,
            6121,9244,8248,5424,2377,4270,7656,1983,2928,2876,4746,
            129,5971,522,349,1239,9493,4777,1421,1763,8419,5696,726,
            6130,9164,5290,6793,3670,3090,3395,5597,7557,6246,956,7791,
            677,2284,7280,5309,8274,1760,2383,7003,4094,1681,8885,3010,
            1551,7419,813,9937,7054,9615,8126,2739,3255,334,587,634,3382,
            3316,4630,6077,4687,2226,8910,8357,1961,1454,6416,8838,6295,
            4523,9736,6165,2849,7877};
    int[] response = sortByBits(arr);
    for (int r : response) {
      System.out.print(" " + r);
    }
  }

  public static int[] sortByBits(int[] arr) {
    int[] r = new int[arr.length];
    String[] s = new String[arr.length];
    if (arr[0] == arr[1]) {
      return arr;
    }
    int index = 0, count = 0;
    List<Integer> list = new LinkedList<>();
    Map<Integer, Integer> map = new TreeMap<>();

    for (int num : arr) {
      StringBuilder bin = new StringBuilder();

//      if (num == 0) {
//
//        s[index] = String.valueOf(num);
//        index++;
//      }

      while (num >= 1) {
        int x = num % 2;
        if (x == 1) count++;
        bin.insert(0, x);
        num /= 2;
      }
      map.put(arr[index], count);
      s[index] = bin.toString();
      count = 0;
      index++;
    }
    Integer i= 0;
    Integer c = 0;


      List<Map.Entry<Integer,Integer>> lists = new LinkedList<>(map.entrySet());
      System.out.println(lists);
      lists.sort((x, y) -> x.getValue().compareTo(y.getValue()));
      System.out.println(lists);
      for (Map.Entry<Integer,Integer> entry :lists) {

        list.add(entry.getKey());

      }

    System.out.println(list);
    System.out.println(Arrays.toString(s));
    System.out.println(map);

    return list.stream().mapToInt(x -> x).toArray();
  }
}
