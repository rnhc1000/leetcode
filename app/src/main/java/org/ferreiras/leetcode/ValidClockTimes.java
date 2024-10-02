package org.ferreiras.leetcode;

/**
 * You are given a string of length 5 called time, representing the current time on a
 * digital clock in the format "hh:mm".
 * The earliest possible time is "00:00" and the latest possible time is "23:59".
 * In the string time, the digits represented by the ? symbol are unknown, and must
 * be replaced with a digit from 0 to 9.
 * Return an integer answer, the number of valid clock times that can be created by replacing
 * every ? with a digit from 0 to 9.
 * Example 1:
 * Input: time = "?5:00"
 * Output: 2
 * Explanation: We can replace the ? with either a 0 or 1, producing "05:00" or "15:00".
 * Note that we cannot replace it with a 2, since the time "25:00" is invalid.
 * In total, we have two choices.
 * Example 2:
 * Input: time = "0?:0?"
 * Output: 100
 * Explanation: Each ? can be replaced by any digit from 0 to 9, so we have 100 total choices.
 * Example 3:
 * Input: time = "??:??"
 * Output: 1440
 * Explanation: There are 24 possible choices for the hours, and 60 possible choices for the minutes.
 * In total, we have 24 * 60 = 1440 choices.
 * char(c) - '0' => equal to the caracter, e.g, char(5)  - '0' = 5;
 */
public class ValidClockTimes {
  public static void main(String[] args) {
    String string = "?5:00";
    int response = ValidClockTimes.countTime(string);
    System.out.println(response);
  }

  public static int countTime(String time) {

    if (time.equals("??:??")) return 1440;
    int response = 1;
    if (time.charAt(0) == '?' && time.charAt(1) == '?') {
      response *= 24;
    } else if (time.charAt(0) == '?') {
      response *= (time.charAt(1) - '0' >= 4) ? 2 : 3;
    } else if (time.charAt(1) == '?') {
      response *= (time.charAt(0) - '0' >= 2) ? 4 : 10;
    }
    if (time.charAt(3) == '?') {
      response *= 6;
    }
    if (time.charAt(4) == '?') {
      response *= 10;
    }
    return response;
  }
}

