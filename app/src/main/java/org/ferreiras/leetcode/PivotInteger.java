package org.ferreiras.leetcode;
/*
Given a positive integer n, find the pivot integer x such that:

The sum of all elements between 1 and x inclusively equals the sum of all elements
between x and n inclusively.
Return the pivot integer x.
If no such integer exists, return -1.
It is guaranteed that there will be at most one pivot index for the given input.

Example 1:

Input: n = 8
Output: 6
Explanation:
6 is the pivot integer since: 1 + 2 + 3 + 4 + 5 + 6 = 6 + 7 + 8 = 21.
Example 2:

Input: n = 1
Output: 1
Explanation:
1 is the pivot integer since: 1 = 1.
Example 3:

Input: n = 4
Output: -1
Explanation:
It can be proved that no such integer exist.


Constraints:

1 <= n <= 1000
Intuition by
https://leetcode.com/olifarhaan/
Calculate the sum of integers.
1 to x = x(x+1)/2
x to n = (1 to n) - (1 to (x-1))
Equating both we get, x^2= n(n+1)/2
Find the square root of the sum=n(n+1)/2:
Take the square root of the sum calculated in step 1 and store it in variable a.
Check if the square root is an integer:
If the square root is an integer, it implies that the pivot point exists and that
the sum of integers from 1 to that pivot point is equal to the sum of integers
from the pivot point to n
n.
We can check if the difference between the square root and its ceiling value (rounded up) is zero.
If it is, it means the square root is an integer.
If the difference is zero, return the square root as the pivot integer.
If not, return -1, indicating that there's no valid pivot integer.
Return the result:
If the square root is an integer, return it as the pivot integer.
If not, return -1.
Complexity
Time complexity: O(1)
Space complexity: O(1)
 */
public class PivotInteger {
  public static void main(String[] args) {
    int n = 8;
    int r = pivotInteger(n);
    System.out.println(r);
  }
  public static int pivotInteger(int n) {
    int r = -1;
    int m = n * (n + 1) / 2;
    double p = Math.sqrt(m);

    if (p - Math.ceil(p) == 0)
      return (int) p;
    return r;
  }
}
