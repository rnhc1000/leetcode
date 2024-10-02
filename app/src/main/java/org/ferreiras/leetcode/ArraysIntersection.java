package org.ferreiras.leetcode;

import java.util.*;

/*
Given two integer arrays nums1 and nums2, return an array of their intersection.
Each element in the result must appear as many times as it shows in both arrays
and you may return the result in any order.
Example 1:

Input: nums1 = [1,2,2,1], nums2 = [2,2]
Output: [2,2]
Example 2:

Input: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
Output: [4,9]
Explanation: [9,4] is also accepted.


Constraints:

1 <= nums1.length, nums2.length <= 1000
0 <= nums1[i], nums2[i] <= 1000


Follow up:

What if the given array is already sorted? How would you optimize your algorithm?
What if nums1's size is small compared to nums2's size? Which algorithm is better?
What if elements of nums2 are stored on disk, and the memory is limited such that you
cannot load all elements into the memory at once?
 */
public class ArraysIntersection {
  public static void main(String[] args) {
    int[] nums1 = {4,9,5}, nums2 = {9,4,9,8,4};

    int[] response = intersect(nums1, nums2);
    System.out.println(Arrays.toString(response));
  }
  public static int[] intersection(int[] nums1, int[] nums2) {
    List<Integer> list = new LinkedList<>();
    Arrays.sort(nums1);
    Arrays.sort(nums2);
    int i = 0, j = 0;

    while (i < nums1.length && j < nums2.length) {

      if (nums1[i] < nums2[j]) {
        i++;
      } else if (nums1[i] > nums2[j]) {
        j++;
      } else {
        list.add(nums1[i]);
        i++;
        j++;
      }

    }


    return list.stream().mapToInt(k->k).toArray();
  }

  public static int[] intersect(int[] nums1, int[] nums2) {
    List<Integer> list = new LinkedList<>();
    Map<Integer, Integer> map = new LinkedHashMap<>();
    for (int num1 : nums1) {
      map.put(num1, map.getOrDefault((num1),0) + 1);
    }
    System.out.println(map);
    for (int num2 : nums2) {
      if (map.containsKey(num2)) {
        map.put(num2, map.getOrDefault((num2),0) + 1);
      } else {
        map.put(num2, map.getOrDefault((num2), 1));
      }
    }

    for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
      if(entry.getValue() >= 2) {
        list.add(entry.getKey());
      }
    }
    System.out.println(map);
    return list.stream().mapToInt(i->i).toArray();
  }
}
