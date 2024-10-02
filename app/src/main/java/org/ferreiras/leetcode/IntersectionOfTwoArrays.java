package org.ferreiras.leetcode;

import java.util.*;

/*
Given two integer arrays nums1 and nums2, return an array of their intersection.
Each element in the result must be unique and you may return the result in any order.

Example 1:

Input: nums1 = [1,2,2,1], nums2 = [2,2]
Output: [2]
Example 2:

Input: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
Output: [9,4]
Explanation: [4,9] is also accepted.


Constraints:

1 <= nums1.length, nums2.length <= 1000
0 <= nums1[i], nums2[i] <= 100
 */
public class IntersectionOfTwoArrays {
  public static void main(String[] args) {
    int[] nums1 = {4, 9, 5};
    int[] nums2 = {9, 4, 9, 8, 4};

    int[] response = dynamicProgrammingIntersection(nums1, nums2);
    System.out.println(Arrays.toString(response));

  }

  public static int[] intersections(int[] nums1, int[] nums2) {
    Map<Integer, Integer> map = new HashMap<>();
    Set<Integer> list = new LinkedHashSet<>();
    for (int num1 : nums1) {
      map.put(num1, map.getOrDefault((num1), 0) + 1);
    }

    for (int num2 : nums2) {

      if (map.containsKey(num2)) {
        list.add(num2);
      }
    }
    System.out.println(map);
    return list.stream().mapToInt(Integer::intValue).toArray();
  }

  public static int[] dynamicProgrammingIntersection(int[] nums1, int[] nums2) {

    int[] freq = new int[1001];
    int[] ans = new int[1001];
    int j = 0;

    for (int num1 : nums1) {

      freq[num1] = -1;

    }

    for (int num2 : nums2) {

      if (freq[num2] == -1) {
        ans[j++] = num2;
        freq[num2] = 1;
      }

    }
    int[] res = new int[j];
    System.arraycopy(ans, 0, res, 0, res.length);

    return res;
  }


  public static int[] intersection(int[] nums1, int[] nums2) {
    int size1 = nums1.length;
    int size2 = nums2.length;
    Set<Integer> set = new LinkedHashSet<>();

    for (int num1 : nums1) {

      for (int num2 : nums2) {

        if (num1 == num2) {
          set.add(num1);
        }

      }

    }

    return set.stream().mapToInt(Integer::intValue).toArray();
//     return list.stream().mapToInt( (Integer i) -> i).toArray();
//    return list.stream().mapToInt( (Integer i) -> i.intValue() ).toArray();
  }
}
