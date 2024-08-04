package org.ferreiras.leetCode;

/*
Given the binary representation of an integer as a string s, return the number of steps
to reduce it to 1 under the following rules:

If the current number is even, you have to divide it by 2.

If the current number is odd, you have to add 1 to it.

It is guaranteed that you can always reach one for all test cases.

Example 1:

Input: s = "1101"
Output: 6
Explanation: "1101" corresponds to number 13 in their decimal representation.
Step 1) 13 is odd, add 1 and obtain 14.
Step 2) 14 is even, divide by 2 and obtain 7.
Step 3) 7 is odd, add 1 and obtain 8.
Step 4) 8 is even, divide by 2 and obtain 4.
Step 5) 4 is even, divide by 2 and obtain 2.
Step 6) 2 is even, divide by 2 and obtain 1.
Example 2:

Input: s = "10"
Output: 1
Explanation: "10" corresponds to number 2 in their decimal representation.
Step 1) 2 is even, divide by 2 and obtain 1.
Example 3:

Input: s = "1"
Output: 0


Constraints:

1 <= s.length <= 500
s consists of characters '0' or '1'
s[0] == '1'

Intuition
The problem requires simulating the process of converting a binary number to 1 by
repeatedly performing the following operations:

If the number is even, divide it by 2.
If the number is odd, add 1 to it.
Given that the input is a binary string, we can leverage the properties of binary numbers
and their bits to efficiently determine the steps required.
The key insight is to start from the least significant bit (rightmost bit) and move towards
the most significant bit (leftmost bit), while maintaining a carry to handle the addition
of 1 when the number is odd.

Approach
Initialize steps to 0 and carry to 0.
Iterate through the binary string from the least significant bit (rightmost bit) to the second
most significant bit (leftwards).
For each bit, check if the bit plus the carry equals 1:
If it equals 1, it means the bit was 0 and we added 1 (carry was 1) or the bit was 1 and no carry:
Increment steps by 2 (one step for the addition, and one for the division).
Set carry to 1 because adding 1 to an odd number results in an even number with a carry.
Otherwise, just increment steps by 1 because we simply divided an even number by 2.
After the loop, add the carry to steps to account for any remaining carry at the end.
Return the total number of steps
 */
public class StringStepsBinary {

  public static void main(String[] args) {
    String s = "1101";
    int response = numSteps(s);
    System.out.println(response);
  }

  public static int numSteps(String s) {

    int steps = 0;
    int carry = 0;
    for (int i = s.length() - 1; i > 0; i--) {
      if (s.charAt(i) - '0' + carry == 1) {
        carry = 1;
        steps += 2;
      } else {
        steps += 1;
      }
    }
    return steps + carry;
  }
//    Character.getNumericValue(s.charAt(0))
}
