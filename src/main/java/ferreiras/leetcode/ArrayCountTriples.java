package ferreiras.leetcode;
/*
Given an array of integers arr, and three integers a, b and c.
You need to find the number of good triplets.

A triplet (arr[i], arr[j], arr[k]) is good if the following conditions are true:

0 <= i < j < k < arr.length
|arr[i] - arr[j]| <= a
|arr[j] - arr[k]| <= b
|arr[i] - arr[k]| <= c
Where |x| denotes the absolute value of x.

Return the number of good triplets.



Example 1:

Input: arr = [3,0,1,1,9,7], a = 7, b = 2, c = 3
Output: 4

Explanation:
There are 4 good triplets: [(3,0,1), (3,0,1), (3,1,1), (0,1,1)].

Example 2:

Input: arr = [1,1,2,2,3], a = 0, b = 0, c = 1
Output: 0
Explanation: No triplet satisfies all conditions.


Constraints:

3 <= arr.length <= 100
0 <= arr[i] <= 1000
0 <= a, b, c <= 1000
 */
public class ArrayCountTriples {
  public static void main(String[] args) {
    int[] arr = {3,0,1,1,9,7};
    int a = 7, b = 2, c = 3;
    int response = countGoodTriplets(arr, a, b, c);
    System.out.println(response);
  }
  public static int countGoodTriplets(int[] arr, int a, int b, int c) {
    int count = 0;
    for (int i = 2; i < arr.length; i++) {

      //|arr[i] - arr[j]| <= a
      //|arr[j] - arr[k]| <= b
      //|arr[i] - arr[k]| <= c
//      System.out.printf("\ni, j, k, -> %d, %d, %d", i-2, i-1, i);
//      System.out.printf("\n");
      if(   Math.abs( arr[i-2] - arr[i-1] ) <= a

         && Math.abs( arr[i-1] - arr[i] ) <= b

         && Math.abs( arr[i] - arr[i-2] ) <= c
      ) {
        count++;
      }

    }

  return count;
  }
}
