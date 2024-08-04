package org.ferreiras.leetCode;

import java.util.LinkedList;
import java.util.List;
import java.util.logging.Logger;
import java.util.stream.Stream;

/*
Given an integer array nums of unique elements, return all possible subsets (the power set).

The solution set must not contain duplicate subsets. Return the solution in any order.

Example 1:

Input: nums = [1,2,3]
Output: [[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
Example 2:

Input: nums = [0]
Output: [[],[0]]


Constraints:

1 <= nums.length <= 10
-10 <= nums[i] <= 10
All the numbers of nums are unique.
Set  = [1,2,3]
power_set_size = pow(2, 3) = 8
Run for binary counter = 000 to 111
   000                    -> Empty set
   001                    -> 1
   010                    -> 2
   011                    -> 1,2
   100                    -> 3
   101                    -> 1, 3
   110                    -> 2, 3
   111                    -> 1,2,3
   Set  = [a,b,c]
power_set_size = pow(2, 3) = 8
Run for binary counter = 000 to 111

Value of Counter            Subset
   000                    -> Empty set
   001                    -> a
   010                    -> b
   011                    -> ab
   100                    -> c
   101                    -> ac
   110                    -> bc
   111                    -> abc

 If ith bit in counter is set
 Add ith element from set for this subset
      if((counter & (1 << j)) > 0){
        list.add(nums[j]);
      }
 */
public class ArrayPowerSet {
  private final static Logger logger = Logger.getLogger(ArrayPowerSet.class.getName());
  public static void main(String[] args) {
    int[] nums = {1,2,3};
    List<List<Integer>> lists = ArrayPowerSet.subsets(nums);
    for (List<Integer> list : lists) {
      System.out.print(list);
      System.out.print("\t");
    }

    Stream.of("Red","Green","Blue").map(String::toUpperCase).peek(System.out::println).count();
  }
  public static List<List<Integer>> subsets(int[] nums) {
  List<List<Integer>> listOfLists = new LinkedList<>();
  logger.info("Determination of stream size;");
  int size = nums.length;
  logger.info("Size: -> " + size );
  logger.info("PowerSet - Math.pow(2, size)");
  double powerSet = Math.pow(2, size);
  logger.info("PowerSet: -> " + powerSet);
  for (int countSet = 0; countSet < powerSet; countSet++) {
    logger.info("Iterating over the power-set " + countSet);
    List<Integer> list = new LinkedList<>();
    for (int num=0; num < size; num++) {
      logger.info("Iterating over the stream nums");

      if((countSet & (1 << num)) > 0){
        logger.info("Checking if nums[num] bit is set");
        list.add(nums[num]);
      }
    }
    listOfLists.add(list);
  }
    return listOfLists;
  }
}
