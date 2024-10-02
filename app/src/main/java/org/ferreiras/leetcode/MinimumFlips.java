package org.ferreiras.leetcode;
/*
Given 3 positives numbers a, b and c. Return the minimum flips required in some bits
of a and b to make ( a OR b == c ). (bitwise OR operation).
Flip operation consists of change any single bit 1 to 0 or change the bit 0 to 1 in
their binary representation.

Nice explanation of the solution provided by
https://leetcode.com/Aman_Raj_Sinha/
Intuition
The intuition behind the above solution is to compare the bits of a, b, and c to determine
the number of flips required to make (a OR b) == c.

Approach
Initialize a variable flips to keep track of the total number of flips required.
Iterate through the bits of a, b, and c by performing a bitwise AND operation with 1 (a & 1, b & 1, c & 1).
Compare the rightmost bits of a and b with the rightmost bit of c.
If (bitA | bitB) != bitC, it means flipping is required.
If bitC is 0, it implies that the corresponding bit of c is 0.
In this case, both bitA and bitB should be flipped to 1, so increment flips by (bitA + bitB).
If bitC is 1, it implies that the corresponding bit of c is 1.
In this case, at least one of bitA or bitB should be flipped to 1, so increment flips by 1.
Right shift a, b, and c by 1 bit to move to the next bit.
Repeat steps 2-6 until all bits have been processed.
Return the final value of flips.
Complexity
Time complexity:
The time complexity of the solution is O(log(max(a, b, c))) since
we iterate through the bits of a, b, and c using the right shift operation.
Space complexity:
The space complexity is O(1) since we use a constant amount of space to store
the variables flips, bitA, bitB, and bitC.
Approach
We know the property of OR:
If either of the input is 1, the result will be 1
This means, in order to get a | b = c,
If the i-th bit of c is 0, both the i-th bits of a and b must be 0.
If the i-th bit of c is 1, at least one of the i-th bits of a or b must be 1.
To obtain the bits that are set in a but not in c, we can use a & ~c.
We need to change these bits to 0.
Similarly, to obtain the bits that are set in b but not in c, we can use b & ~c.
We also need to change these bits to 0.
To find the bits that are set in c but not in a | b, we can use ~(a | b) & c.
We have to change these bits to 1.
On adding these, we will get our answer.
Complexity
Time complexity: O(1)O(1)O(1)
Space complexity: O(1)O(1)O(1)

return Integer.bitCount(c ^= a | b) + Integer.bitCount(a & b & c);
 */
public class MinimumFlips {
  public static void main(String[] args) {
    int a = 2, b =6, c = 5;
    Integer response = minFlips(a,b,c);
    System.out.println(response);
  }
  public static int minFlips(int a, int b, int c) {
//    return Integer.bitCount(c ^= a | b) + Integer.bitCount(a & b & c);
    return Integer.bitCount(a & ~c) +  Integer.bitCount(~(a | b) & c) + Integer.bitCount(b & ~c);

  }
}
