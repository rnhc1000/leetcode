package ferreiras.leetcode;
/*
An attendance record for a student can be represented as a string where each character signifies
whether the student was absent, late, or present on that day.
The record only contains the following three characters:

'A': Absent.
'L': Late.
'P': Present.
Any student is eligible for an attendance award if they meet both of the following criteria:

The student was absent ('A') for strictly fewer than 2 days total.
The student was never late ('L') for 3 or more consecutive days.
Given an integer n, return the number of possible attendance records of length n that make a student eligible for an attendance award. The answer may be very large, so return it modulo 109 + 7.


Example 1:

Input: n = 2
Output: 8
Explanation: There are 8 records with length 2 that are eligible for an award:
"PP", "AP", "PA", "LP", "PL", "AL", "LA", "LL"
Only "AA" is not eligible because there are 2 absences (there need to be fewer than 2).
Example 2:

Input: n = 1
Output: 3
Example 3:

Input: n = 10101
Output: 183236316


Constraints:

1 <= n <= 105

Intuition and Approach https://leetcode.com/va-run-6626
The problem is about finding the number of valid attendance records of length n
that satisfy the conditions:

The student was absent ('A') for strictly fewer than 2 days total.
The student was never late ('L') for 3 or more consecutive days.
We can approach this problem using dynamic programming (DP) with memoization.
The key idea is to recursively generate valid sequences and use memoization to
store the results of sub-problems to avoid redundant calculations.

Dynamic Programming State
We define a 3D DP table memo where:

memo[i][j][k] represents the number of valid sequences of length i with j 'A's and
up to k consecutive 'L's.
Transition
For each state (n, cntA, concL), we can:

Append 'P' (Present): This does not change the count of 'A's and resets the count of consecutive 'L's to 0.
Append 'A' (Absent): This increases the count of 'A's by 1 and resets the count of consecutive 'L's to 0.
This is only possible if cntA is currently 0 (as we can't have more than 1 'A').
Append 'L' (Late): This does not change the count of 'A's but increases the count of consecutive 'L's by 1.
This is only possible if concL is less than 2 (as we can't have 3 consecutive 'L's).
Base Case
When n (remaining length) is 0, there is exactly one valid sequence: the empty sequence.
Thus, helper(0, cntA, concL) = 1.

Memoization
We use a memoization table to store results of subproblems:

memo[i][j][k] stores the number of valid sequences of length i with j 'A's and up to k
consecutive 'L's.

 */
public class ArrayAttendanceRecord {
  public static final int MOD = 1000000007;
  public static Integer[][][] dp;

  public static int checkRecord(int n) {
    dp = new Integer[n + 1][2][3]; // Memoization table
    return helper(n, 0, 0); // Start with length n, 0 'A's, and 0 consecutive 'L's
  }

  public static int helper(int n, int countAbsent, int countLate) {
    if (n == 0) { // Base case
      return 1;
    }
    if (dp[n][countAbsent][countLate] != null) { // Memoization check
      return dp[n][countAbsent][countLate];
    }

    int result = 0;
    // Append 'P' (Present)
    result = (result + helper(n - 1, countAbsent, 0)) % MOD;
    // Append 'A' (Absent)
    if (countAbsent == 0) {
      result = (result + helper(n - 1, countAbsent + 1, 0)) % MOD;
    }
    // Append 'L' (Late)
    if (countLate < 2) {
      result = (result + helper(n - 1, countAbsent, countLate + 1)) % MOD;
    }

    dp[n][countAbsent][countLate] = result; // Store the result in the dp table
    return result;
  }
}
