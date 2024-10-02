package org.ferreiras.leetcode;
/*
Given two integers representing the numerator and denominator of a fraction,
return the fraction in string format.

If the fractional part is repeating, enclose the repeating part in parentheses.

If multiple answers are possible, return any of them.

It is guaranteed that the length of the answer string is less than 104 for all the given inputs.

Example 1:

Input: numerator = 1, denominator = 2
Output: "0.5"
Example 2:

Input: numerator = 2, denominator = 1
Output: "2"

Example 3:
Input: numerator = 4, denominator = 333
Output: "0.(012)"


Constraints:

-231 <= numerator, denominator <= 231 - 1
denominator != 0
 */
public class FractionToRecurringDecimal {
  public static void main(String[] args) {
    int n = 3;
    int m = 4;
    String response = fractionToDecimal(n, m);
    System.out.println(response);
  }
  public static String fractionToDecimal(int numerator, int denominator) {

    if (denominator == 1) {
      return Integer.toString(numerator);
    }
    if (numerator % denominator == 0) {
      return Integer.toString(numerator/denominator);
    }

    double division = (double) numerator / denominator ;


    System.out.println(division);
    String s = Double.toString(division);
    System.out.println(s.length());
    StringBuilder sb = new StringBuilder();
    sb.append(s.charAt(0)).append('.').append('(');
    for (int i = 2; i < 5; i++) {

      if(s.charAt(i+1) == s.charAt(i)) {
        sb.append(s.charAt(i));

      }
      System.out.println(s.charAt(i));
    }
    sb.append(')');
    System.out.println(sb.toString());
    return Double.toString(division);
  }
}
