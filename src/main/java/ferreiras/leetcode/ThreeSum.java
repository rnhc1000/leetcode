package ferreiras.leetcode;

import java.util.HashMap;
import java.util.Map;

/*
Given an integer array arr, and an integer target, return the number of tuples i, j, k
such that i < j < k and arr[i] + arr[j] + arr[k] == target.

As the answer can be very large, return it modulo 109 + 7.



Example 1:

Input: arr = [1,1,2,2,3,3,4,4,5,5], target = 8
Output: 20
Explanation:
Enumerating by the values (arr[i], arr[j], arr[k]):
(1, 2, 5) occurs 8 times;
(1, 3, 4) occurs 8 times;
(2, 2, 4) occurs 2 times;
(2, 3, 3) occurs 2 times.
Example 2:

Input: arr = [1,1,2,2,2,2], target = 5
Output: 12
Explanation:
arr[i] = 1, arr[j] = arr[k] = 2 occurs 12 times:
We choose one 1 from [1,1] in 2 ways,
and two 2s from [2,2,2,2] in 6 ways.
Example 3:

Input: arr = [2,1,3], target = 6
Output: 1
Explanation: (1, 2, 3) occured one time in the array so we return 1.


Constraints:

3 <= arr.length <= 3000
0 <= arr[i] <= 100
0 <= target <= 300
 */
public class ThreeSum {

  public static void main(String[] args) {
    int[] arr = {1,1,2,2,3,3,4,4,5,5};
    int target = 8;
    int response = threeSumMultiple(arr, target);
    System.out.println(response);

  }
  public static int threeSumMulti(int[] arr, int target) {


    int size = arr.length, count = 0;

    for (int i = 0; i < size; i++) {
      for (int j = i + 1; j < size; j++) {
        for (int k = j + 1; k < size; k++) {
          long sum = arr[i] + arr[j] + arr[k];
          if (sum == target) count++;
        }
      }
    }

    return count;
  }

  public static int threeSumMultiple(int[] arr, int target) {
    Map<Integer, Integer> map = new HashMap<>();

    int response = 0;
    int mod = 1_000_000_007;
    for (int i = 0; i < arr.length; i++) {
      response = (response + map.getOrDefault(target - arr[i], 0)) % mod;

      for (int j = 0; j < i; j++) {
        int temp = arr[i] + arr[j];
        map.put(temp, map.getOrDefault(temp, 0) + 1);
      }
    }
    return response;
  }

}
