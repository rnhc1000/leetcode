package ferreiras.leetcode;
/*
Given two non-negative integers num1 and num2 represented as strings, return the product of
num1 and num2, also represented as a string.

Note:
You must not use any built-in BigInteger library or convert the inputs to integer directly.

Example 1:
Input: num1 = "2", num2 = "3"
Output: "6"

Example 2:
Input: num1 = "123", num2 = "456"
Output: "56088"

Constraints:
1 <= num1.length, num2.length <= 200
num1 and num2 consist of digits only.
Both num1 and num2 do not contain any leading zero, except the number 0 itself.
 */
public class MultiplyStrings {
  public static void main(String[] args) {
    String num1 = "2";
    String num2 = "3";
    String s = multiply(num1, num2);
    System.out.println(s);

  }
  public static String multiply(String num1, String num2) {
    char[] numOne = num1.toCharArray();
    char[] numTwo = num2.toCharArray();
    StringBuilder sb = new StringBuilder();
    sb.append(num1);
    int mul = 0;

    int r = Integer.parseInt(num1) * Integer.parseInt(num2);

    int lenOne = num1.length()-1;
    int lenTwo = num2.length()-1;
    int carry = 0;
    while ( lenOne >= 0 || lenTwo >= 0 || carry != 0 ) {
      int partialMul = lenOne>= 0 ? num1.charAt(lenOne) - '0' : 0;
      int partialMux = lenOne>= 0 ? num2.charAt(lenTwo) - '0' : 0;
      mul += (partialMux * partialMul + carry) % 10;
      carry = ( partialMux * partialMul + carry) / 10;
//      sb.append(mul);
      lenOne--;
      lenTwo--;
    }
    int c  = (num1.charAt(0) -'0') * (num2.charAt(0) -'0');
    System.out.println(mul);
    return String.valueOf(mul);
  }
}
