package ferreiras.leetcode;

/*
Given an array of integers nums and an integer k.
A continuous subarray is called nice if there are k odd numbers on it.

Return the number of nice sub-arrays.

Example 1:

Input: nums = [1,1,2,1,1], k = 3
Output: 2
Explanation: The only sub-arrays with 3 odd numbers are [1,1,2,1] and [1,2,1,1].


Example 2:

Input: nums = [2,4,6], k = 1
Output: 0
Explanation: There are no odd numbers in the array.
Example 3:

Input: nums = [2,2,2,1,2,2,1,2,2,2], k = 2
Output: 16


Constraints:

1 <= nums.length <= 50000
1 <= nums[i] <= 10^5
1 <= k <= nums.length

Intuition by https://leetcode.com/lancertech6
The problem requires counting the number of continuous subarrays with exactly k odd numbers.
To achieve this, we can use a prefix sum approach.
The key idea is to keep track of the number of odd numbers encountered so far while iterating
through the array, and use this information to count subarrays with the desired property efficiently.

Approach
Initialize Variables:

size: Length of the input array nums.
count: An array to keep track of the count of prefix sums (number of odd numbers encountered).
count[0]: Set to 1 initially, since a prefix sum of 0 (no odd numbers encountered) occurs once by default.
response: Variable to store the final result (number of nice subarrays).
odd: Variable to store the current count of odd numbers while iterating through the array.
Iterate Through the Array:

For each element v in nums, update the count of odd numbers (t) encountered so far.
This is done by checking if v is odd using v & 1.
Check if there exists a prefix sum t - k (i.e., a previous state where there were t - k odd numbers).
If so, add the count of such prefix sums to ans.
Increment the count of the current prefix sum (t) in the count array.
Return the Result:

After iterating through the entire array, ans will contain the number of nice subarrays.
Complexity
Time Complexity: The solution iterates through the array once and performs constant time operations in each iteration. Thus, the time complexity is (O(n)), where (n) is the length of the array.
Space Complexity: The space complexity is (O(n)) due to the additional count array used to store the count of prefix sums.
Step by Step Explanation
Example
Let's use an example to explain the approach:
nums = [1, 1, 2, 1, 1], k = 3

Index	nums[i]	Odd Count (t)	count Array (Updated)	t - k	Count of t - k in count	Result (ans)
0	    1	      1	            [1, 1, 0, 0, 0, 0]	  -2	    0	                    0
1	    1	      2	            [1, 1, 1, 0, 0, 0]	  -1	    0	                    0
2	    2	      2	            [1, 1, 2, 0, 0, 0]	  -1	    0	                    0
3 	  1	      3	            [1, 1, 2, 1, 0, 0]	   0	    1	                    1
4	    1	      4	            [1, 1, 2, 1, 1, 0]	    1	    1	                    2
*/
public class ArrayNiceSubarrays {
  public static void main(String[] args) {
    int[] nums = {1, 1, 2, 1, 1};
    int k = 3;
    int response = numberOfSubarrays(nums, k);
    System.out.println(response);
  }

  public static int numberOfSubarrays(int[] nums, int k) {
    int size = nums.length, odd = 0, response = 0;
    int[] count = new int[size + 1];
    count[0] = 1;
    for (int num : nums) {
      odd += num & 1;
      if (odd - k >= 0) {
        response += count[odd - k];
      }
      count[odd]++;
    }

    return response;
  }
}
