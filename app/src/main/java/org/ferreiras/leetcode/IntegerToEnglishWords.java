package org.ferreiras.leetcode;

import java.util.HashMap;
import java.util.Map;

/*
Convert a non-negative integer num to its English words representation.

Example 1:

Input: num = 123
Output: "One Hundred Twenty Three"
Example 2:

Input: num = 12345
Output: "Twelve Thousand Three Hundred Forty Five"
Example 3:

Input: num = 1234567
Output: "One Million Two Hundred Thirty Four Thousand Five Hundred Sixty Seven"


Constraints:

0 <= num <= 231 - 1

Intuition
The goal is to convert an integer into its English words representation. The solution breaks down the number into manageable parts (thousands, millions, billions) and converts each part into words using predefined mappings for single digits, teens, and tens. By systematically processing each segment, we can build the full English representation of the number.

Approach
Base Case: If the number is 0, return "Zero".
Segmenting the Number:
The number is divided into groups of three digits (thousands, millions, billions) using integer
division and modulus operations.
Mapping Numbers to Words: For each group:
Use a helper function to convert numbers less than 1000 into words.
Append the corresponding scale (Thousand, Million, Billion) to the result.
Concatenation: Build the final string by concatenating the words for each group, ensuring proper spacing.
Trimming: Remove any trailing spaces from the final result.

 */
public class IntegerToEnglishWords {

  public static void main(String[] args) {
    int num = 12345;
    String response = numberToWords(num);
    System.out.println(response);

  }

  public static String numberToWords(int num) {

    if (num == 0) return "Zero";

    String[] millions = {"Thousand", "Million", "Billion"};
    StringBuilder result = new StringBuilder(helper(num % 1000));
    num /= 1000;
    if (num > 0 && num % 1000 > 0) {
      result.append("Thousand ");
    }

    num /= 1000;
    if (num > 0 && num % 1000 > 0) {
      result.append(helper(num % 1000)).append(" Million ");
    }

    num/= 1000;
    if (num > 0) {
      result.append(helper(num % 1000)).append(" Billion ");
    }
    return result.toString().trim();
  }

  public static String helper(int num) {

    Map<Integer, String> units = getIntegerStringMapUnits();
    Map<Integer, String> tens = getIntegerStringMapTens();

    StringBuilder sb = new StringBuilder();


    if (num > 99) {
      sb.append(units.get(num / 100)).append(" Hundred ");
    }
    num %= 100;

    if (num < 20 && num > 9) {
      sb.append(units.get(num % 10)).append(" ");
    } else {
      if (num > 19 && num < 99) {
        sb.append(tens.get(num / 10)).append(" ");
      }

      num = num % 10;
      if (num > 0) {
        sb.append(units.get(num)).append(" ");
      }

    }

    return sb.toString();
  }

  private static Map<Integer, String> getIntegerStringMapUnits() {
    Map<Integer, String> map = new HashMap<>();
    map.put(0, "Zero");
    map.put(1, "One");
    map.put(2, "Two");
    map.put(3, "Three");
    map.put(4, "Four");
    map.put(5, "Five");
    map.put(6, "Six");
    map.put(7, "Seven");
    map.put(8, "Eight");
    map.put(9, "Nine");
    map.put(10, "Ten");
    map.put(11, "Eleven");
    map.put(12, "Twelve");
    map.put(13, "Thirteen");
    map.put(14, "Fourteen");
    map.put(15, "Fifteen");
    map.put(16, "Sixteen");
    map.put(17, "Seventeen");
    map.put(18, "Eighteen");
    map.put(19, "Nineteen");

    return map;
  }

  private static Map<Integer, String> getIntegerStringMapTens() {
    Map<Integer, String> map = new HashMap<>();
    map.put(2, "Twenty");
    map.put(3, "Thirty");
    map.put(4, "Forty");
    map.put(5, "Fifty");
    map.put(6, "Sixty");
    map.put(7, "Seventy");
    map.put(8, "Eighty");
    map.put(9, "Ninety");

    return map;
  }
}
