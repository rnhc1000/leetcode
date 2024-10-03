package ferreiras.leetcode;

import java.util.ArrayDeque;
import java.util.Deque;

/*
Given two positive integers n and k, the binary string Sn is formed as follows:

S1 = "0"
Si = Si - 1 + "1" + reverse(invert(Si - 1)) for i > 1
Where + denotes the concatenation operation, reverse(x) returns the reversed string x,
and invert(x) inverts all the bits in x (0 changes to 1 and 1 changes to 0).

For example, the first four strings in the above sequence are:

S1 = "0"
S2 = "011"
S3 = "0111001"
S4 = "011100110110001"
Return the kth bit in Sn. It is guaranteed that k is valid for the given n.
Example 1:

Input: n = 3, k = 1
Output: "0"
Explanation: S3 is "0111001".
The 1st bit is "0".
Example 2:

Input: n = 4, k = 11
Output: "1"
Explanation: S4 is "011100110110001".
The 11th bit is "1".


Constraints:

1 <= n <= 20
1 <= k <= 2n - 1
Intuition by https://leetcode.com/itsarvindhere/
This problem is all about observations. If you correctly find the pattern,
it is a piece of cake.
It is given that Si = Si - 1 + "1" + reverse(invert(Si - 1)) for i > 1
Which means that till the mid length, the string Si will be the same as string Si-1.
  N = 1         S1 = "0"
  N = 2         S2 = "011"
  N = 3         S3 = "0111001"
  N = 4         S4 = "011100110110001"
To calculate length for a row we just need to find a pattern. e.g.
if N = 1, length = 1. If N = 2, length = 3. If N = 3, length = 7. If N = 4, length = 15.

So basically, for any row N, length = (2 ^ N) - 1

And mid is simply length/2;

Now, lets take N = 2 and N = 3 strings.

 N = 2         S2 = "011"
 N = 3         S3 = "0111001"
If we see, till length = 3, the strings are same. Which means,
if we are given N = 3 and k = 1 or 2 or 3 as input, we just need
to look at what is the bit at kth place for N = 2

If k <= mid then we simply find the kth bit of n-1th row
Another case is when k is mid+ 1. It is given in problem that in every
new row, we add an extra "1" after copying previous row.
Which means the bit at mid + 1 for any row is always 1.

If k = mid + 1 we don't need to do anything apart from simply returning '1'.
Finally, we have the last case where k > mid + 1.

e.g. for N = 3, if k = 5 we have to return 0. Now, lets compare the last three
bits of N = 3 with the bits of N = 2

We know these last three bits for S3 are generated as reverse(invert("011"))

This means, the 5th bit in S3 is just the 3rd bit in S2 but inverted.
Similarly, the 6th bit in S3 is just the 2nd bit in S2 but inverted.
And finally, the 7th bit in S3 is just 1st bit in S2 but inverted.

If k > mid + 1 then k for n-1 row is -> length - k + 1
e.g. for N = 3, if k = 5. then for N = 2,
k = 7 - 5 + 1 => 3
*/
public class KthBitInNthBinaryString {

  public static void main(String[] args) {
    int n = 4;
    int k = 11;
    String s = "11101";
    System.out.println(s);
    String t = invert(s);
    System.out.println(t);
    String v = reverse(t);
    System.out.println(v);
  }

  public static char findKthBit(int n, int k) {
    if (n == 1 || k == 1) {
      return '0';
    }

    int size = (int) Math.pow(2, n) - 1;
    int mid = size / 2;

    if (k <= mid) {
      return findKthBit(n - 1, k);
    } else if (k == mid + 1) {
      return '1';
    } else {
      k = size - k + 1;
      char ch = findKthBit(n - 1, k);
      return ch == '0' ? '1' : '0';
    }
  }

  public static String reverse(String s) {
    Deque<Character> stack = new ArrayDeque<>();
    for (char c : s.toCharArray()) {
      stack.push(c);
    }
    StringBuilder sb = new StringBuilder();
    while(!stack.isEmpty()) {
      sb.append(stack.pop());
    }
    System.out.println(stack);
//    Queue<Character> queue = new LinkedList<>(stack);
//    System.out.println(queue);
//    Deque<Character> stackOne = new ArrayDeque<>(queue);
//    System.out.println(stackOne);
//    while(!queue.isEmpty()) {
//      sb.append(queue.remove());
//    }
    return sb.toString();
  }
  public static String invert(String s) {
    StringBuilder sb = new StringBuilder();
    for (char c : s.toCharArray()) {
      sb.append( c == '0' ?  '1' : '0');
    }
    return sb.toString();
  }
}
