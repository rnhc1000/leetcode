package org.ferreiras.leetcode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/*
The array-form of an integer num is an array representing its digits in left to right order.

For example, for num = 1321, the array form is [1,3,2,1].
Given num, the array-form of an integer, and an integer k,
return the array-form of the integer num + k.

Example 1:
Input: num = [1,2,0,0], k = 34
Output: [1,2,3,4]
Explanation:
1200 + 34 = 1234

Example 2:
Input: num = [2,7,4], k = 181
Output: [4,5,5]
Explanation: 274 + 181 = 455
Example 3:

Input: num = [2,1,5], k = 806
Output: [1,0,2,1]
Explanation: 215 + 806 = 1021


Constraints:

1 <= num.length <= 104
0 <= num[i] <= 9
num does not contain any leading zeros except for the zero itself.
1 <= k <= 104
 */

@ClassPreamble (
        author = "Ricardo Ferreira",
        date = "25/08/2023",
        currentRevision = 7,
        lastModified = "02/05/2024",
        lastModifiedBy = "Ricardo Ferreira",
        reviewers = {}
)
public class ArrayFormInteger {

  public static void main(String[] args) {
    int[] numbers = {2,1,4,7,4,8,3,6,4};
    int k = 34;
    System.out.println(Integer.MAX_VALUE);
    List<Integer> list = addToArrayForm(numbers, k);
    for (Integer l : list) {
      System.out.print(l + " ");
    }
  }

  public static List<Integer> addToArrayForm(int[] num, int k) {
    Deque<Integer> queue = new ArrayDeque<>();
    StringBuilder sb = new StringBuilder();
    System.out.println((Integer.MAX_VALUE));
    for (int n : num) {
      sb.append(String.valueOf(n));
    }
    if (Integer.parseInt(sb.toString()) == Integer.MAX_VALUE) return new ArrayList<>(Integer.MAX_VALUE);
    int temp = Integer.parseInt(sb.toString()) + k;
    System.out.println(temp);
    while (temp != 0) {
      int t = temp % 10;
      queue.push(t);
      temp /= 10;

    }
    System.out.println(queue);

    return new ArrayList<>(queue);
  }
}
