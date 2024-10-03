package ferreiras.leetcode;
/*
Given an integer array arr, return true if there are three consecutive odd numbers in the array.
Otherwise, return false.


Example 1:

Input: arr = [2,6,4,1]
Output: false
Explanation: There are no three consecutive odds.
Example 2:

Input: arr = [1,2,34,3,4,5,7,23,12]
Output: true
Explanation: [5,7,23] are three consecutive odds.


Constraints:

1 <= arr.length <= 1000
1 <= arr[i] <= 1000
 */

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class ArrayThreeConsecutiveOdds {

  public static void main(String[] args) {
    int[] numbers = {424, 915, 193, 591, 923};
    boolean response = threeConsecutiveOdds(numbers);
    System.out.println(response);
  }

  public static boolean threeConsecutiveOdds(int[] arr) {
    System.out.println(Arrays.toString(arr));
    List<Integer> list = new LinkedList<>();
    boolean response = false;
    for (int i = 2; i < arr.length; i++) {

      if ((arr[i - 2] % 2) == 1 && (arr[i - 1]) % 2 == 1 && (arr[i] % 2) == 1) {
        list.add(arr[i - 2]);
        list.add(arr[i - 1]);
        list.add(arr[i]);
        response = true;
        return response;
      }

    }
//    int size = list.size();
//    if (size == 3) response = true;
    return response;
  }

  public boolean threeConsecutiveOdd(int[] arr) {
    int count = 0;  // Initialize count to keep track of consecutive odd numbers

    for (int j : arr) {  // Iterate through each element in the array
      if (j % 2 != 0) {  // Check if the current element is odd
        count++;  // Increment the count if it's odd
        if (count == 3) {  // If we have found three consecutive odds, return true
          return true;
        }
      } else {  // If the element is even, reset the count to 0
        count = 0;
      }
    }

    return false;  // If we finish the loop without finding three consecutive odds, return false
  }
}
