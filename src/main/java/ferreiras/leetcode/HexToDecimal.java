package ferreiras.leetcode;

import java.util.LinkedHashMap;
import java.util.Map;

/*
Given an integer num, return a string representing its hexadecimal representation. For negative integers, two’s complement method is used.

All the letters in the answer string should be lowercase characters, and there should not be any leading zeros in the answer except for the zero itself.

Note: You are not allowed to use any built-in library method to directly solve this problem.



Example 1:

Input: num = 26
Output: "1a"
Example 2:

Input: num = -1
Output: "ffffffff"


Constraints:

-231 <= num <= 231 - 1

For Java there is no unsigned int data type.
So in case of java, convert number to long and make the 32 higher bits as all zeroes.
Idea remains the same as above.
num =  (long)Math.pow(2, 32) + num ;
 */
public class HexToDecimal {
  public static void main(String[] args) {
    int num = -1;
    String hex = toHex(num);
    System.out.println(hex);
  }

  public static String toHex(int num) {

    int base = 16;
    long remainder = 0;
    int modulus = 0;
    Map<Long, String> map = new LinkedHashMap<>();
    map.put(0L, "0");
    map.put(1L, "1");
    map.put(2L, "2");
    map.put(3L, "3");
    map.put(4L, "4");
    map.put(5L, "5");
    map.put(6L, "6");
    map.put(7L, "7");
    map.put(8L, "8");
    map.put(9L, "9");
    map.put(10L, "a");
    map.put(11L, "b");
    map.put(12L, "c");
    map.put(13L, "d");
    map.put(14L, "e");
    map.put(15L, "f");

    StringBuilder sb = new StringBuilder();
    if (num > 0) {

      while (num != 0) {
        remainder = num % 16;
        sb.insert(0, map.get(remainder));
        num = num / 16;

      }
    } else {
        // store num in a u_int, size of u_it is greater,
        // it will be positive since msb is 0
        long n = num;
        n =  (long)Math.pow(2, 32) + num ;
        // use the same remainder technique.
        while (n != 0) {
          remainder = n % 16;
          sb.insert(0, map.get(remainder));

          n /= 16;
        }
      }
    System.out.println(sb.toString());

    return sb.toString();

  }
}
