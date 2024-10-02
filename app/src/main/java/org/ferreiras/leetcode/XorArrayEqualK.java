package org.ferreiras.leetcode;

/*
You are given a 0-indexed integer array nums and a positive integer k.

You can apply the following operation on the array any number of times:

Choose any element of the array and flip a bit in its binary representation.
Flipping a bit means changing a 0 to 1 or vice versa.
Return the minimum number of operations required to make the bitwise XOR of
all elements of the final array equal to k.

Note that you can flip leading zero bits in the binary representation of elements.
For example, for the number (101)2 you can flip the fourth bit and obtain (1101)2.

Example 1:

Input: nums = [2,1,3,4], k = 1
Output: 2
Explanation:
We can do the following operations:
- Choose element 2 which is 3 == (011)2, we flip the first bit and we obtain (010)2 == 2.
nums becomes [2,1,2,4].
- Choose element 0 which is 2 == (010)2, we flip the third bit and we obtain (110)2 = 6.
nums becomes [6,1,2,4].
The XOR of elements of the final array is (6 XOR 1 XOR 2 XOR 4) == 1 == k.
It can be shown that we cannot make the XOR equal to k in less than 2 operations.

Example 2:

Input: nums = [2,0,2,0], k = 0
Output: 0
Explanation:
The XOR of elements of the array is (2 XOR 0 XOR 2 XOR 0) == 0 == k.
So no operation is needed.

Constraints:

1 <= nums.length <= 105
0 <= nums[i] <= 106
0 <= k <= 106
Intuition by
https://leetcode.com/Mohammed_Raziullah_Ansari

Thinking Behind the Solution:
Calculate XOR of all elements:
Compute the XOR of all elements in the array and store it as final_xor.

Iterate through binary representations:
Iterate through the binary representations of final_xor and k.

Compare bits and perform operations:
At each position, compare the corresponding bits of final_xor and k.
If they don't match, increment a counter indicating the number of operations
required to make them match.

Return the final count:
After iterating through all bits, return the final count, which represents the
minimum number of operations required.

✅Approach:
Calculate XOR of nums[]:

Initialize final_xor to 0.
Iterate through each element n in nums[].
Update final_xor by performing bitwise XOR (^) with each element n.
After this loop, final_xor will contain the XOR of all integers in the array.
Iterate to Compare Bits:

Initialize count to 0.
Start a while loop which continues until either k or final_xor becomes zero.
Within the loop:
Compare the rightmost bits of k and final_xor.
If the rightmost bits are not equal, increment the count by 1.
This indicates that an operation is required to make the bits match.
Right shift k and final_xor by 1 to remove the rightmost bit.
Return the Count:

Once the while loop finishes, return the count, which represents the minimum
number of operations required to make the XOR of the array equal to k.
Let's walkthrough🚶🏻‍♂️ the implementation process with an example for better understanding🎯:
Let's walk through the code step by step with the given input nums = [2,1,3,4] and k = 1.

Initialization:
Initialize final_xor to 0.
Initialize count to 0.
nums = [2, 1, 3, 4]
k = 1
final_xor = 0
count = 0
Calculate final_xor:
Perform XOR operation on all integers in the array to get final_xor.
final_xor = 0 ^ 2 ^ 1 ^ 3 ^ 4
final_xor = 0 ^ 2 = 2
final_xor = 2 ^ 1 = 3
final_xor = 3 ^ 3 = 0
final_xor = 0 ^ 4 = 4
Iteration:
Enter the while loop.
Loop until either k or final_xor becomes zero.
while k or final_xor:
Iteration 1:
At this step, k is 1 and final_xor is 4.
Check if the rightmost bits of k and final_xor are different.
Increment count if they are different.
if (k % 2) != (final_xor % 2):
    (1 % 2) != (4 % 2)
    1 != 0
    count += 1
    count = 1
Right shift k and final_xor to remove their rightmost bits.
k //= 2   # k becomes 0
final_xor //= 2   # final_xor becomes 2
Iteration 2:
At this step, k is 0 and final_xor is 2.
Check if the rightmost bits of k and final_xor are different.
Increment count if they are different.
if (k % 2) != (final_xor % 2):
    (0 % 2) != (2 % 2)
    0 != 0  # Rightmost bits match, so no increment.
Right shift k and final_xor to remove their rightmost bits.
k //= 2   # k remains 0
final_xor //= 2   # final_xor becomes 1
Iteration 3:
At this step, k is 0 and final_xor is 1.
Check if the rightmost bits of k and final_xor are different.
Increment count if they are different.
if (k % 2) != (final_xor % 2):
    (0 % 2) != (1 % 2)
    0 != 1
    count += 1
    count = 2
Right shift k and final_xor to remove their rightmost bits.
k //= 2   # k remains 0
final_xor //= 2   # final_xor becomes 0
Iteration 4:

At this step, k is 0 and final_xor is 0.
Both k and final_xor are now 0, so exit the while loop.
Return result:

Return the final value of count.
return count   # count is 2
So, the output for the given input nums = [2,1,3,4], k = 1 is 2.
 */
public class XorArrayEqualK {
  public static void main(String[] args) {
    int[] numbers = {2, 1, 3, 4};
    int k = 2;

    int response = minOperations(numbers, k);
    System.out.println(response);

  }

  public static int minOperations(int[] nums, int k) {

    int size = nums.length;
    int xor = 0;
    int count = 0;
//    String binary = Integer.toBinaryString(xor);
//    System.out.println(binary);
    for (int i = 0; i < size; i++) {
      xor = nums[i] ^ xor;
    }
//    while (k || xor)
    while (k != 0 || xor != 0) {
      // k % 2 returns the rightmost bit in k,
      // finalXor % 2 returns the rightmost bit in finalXor.
      // Increment counter, if the bits don't match.
      if (k % 2 != xor % 2) {
        count += 1;
      }
      // Remove the last bit from both integers.

      k /= 2;
      xor /= 2;

    }
    System.out.println((xor));

    return count;

  }
}
