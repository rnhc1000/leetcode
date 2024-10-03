package ferreiras.leetcode;

import java.util.Arrays;

/*
There are n seats and n students in a room. You are given an array seats of length n, where seats[i]
is the position of the ith seat. You are also given the array students of length n, where students[j]
is the position of the jth student.

You may perform the following move any number of times:

Increase or decrease the position of the ith student by 1 (i.e., moving the ith student from position
x to x + 1 or x - 1)
Return the minimum number of moves required to move each student to a seat such that no two students
are in the same seat.

Note that there may be multiple seats or students in the same position at the beginning.



Example 1:

Input: seats = [3,1,5], students = [2,7,4]
Output: 4
Explanation: The students are moved as follows:
- The first student is moved from from position 2 to position 1 using 1 move.
- The second student is moved from from position 7 to position 5 using 2 moves.
- The third student is moved from from position 4 to position 3 using 1 move.
In total, 1 + 2 + 1 = 4 moves were used.
Example 2:

Input: seats = [4,1,5,9], students = [1,3,2,6]
Output: 7
Explanation: The students are moved as follows:
- The first student is not moved.
- The second student is moved from from position 3 to position 4 using 1 move.
- The third student is moved from from position 2 to position 5 using 3 moves.
- The fourth student is moved from from position 6 to position 9 using 3 moves.
In total, 0 + 1 + 3 + 3 = 7 moves were used.
Example 3:

Input: seats = [2,2,6,6], students = [1,3,2,6]
Output: 4
Explanation: Note that there are two seats at position 2 and two seats at position 6.
The students are moved as follows:
- The first student is moved from from position 1 to position 2 using 1 move.
- The second student is moved from from position 3 to position 6 using 3 moves.
- The third student is not moved.
- The fourth student is not moved.
In total, 1 + 3 + 0 + 0 = 4 moves were used.


Constraints:

n == seats.length == students.length
1 <= n <= 100
1 <= seats[i], students[j] <= 100
Intuition by https://leetcode.com/lancertech6
The problem requires us to find the minimum number of moves to position each student in a
seat such that no two students occupy the same seat.
Since the cost of moving a student is the absolute difference between their current position
and the target seat position, the optimal way to achieve this is to pair the closest seats with
the closest students.

Approach
Sorting:

Sort both the seats and students arrays.
By sorting, we ensure that the smallest available seat is paired with the smallest positioned student,
the second smallest seat with the second smallest positioned student, and so on.
This minimizes the overall distance each student has to move.
Calculate Moves:

Iterate through the sorted arrays and compute the sum of absolute differences between the corresponding
elements in the seats and students arrays. This gives the total number of moves required to seat all students.
Complexity
Time Complexity: O(n log n)

Sorting the seats and students arrays takes ( O(n \log n) ) time each.
Calculating the total moves takes ( O(n) ) time.
Hence, the overall time complexity is dominated by the sorting step, i.e., ( O(n \log n) ).
Space Complexity: O(1)

No extra space is used other than a few variables to store intermediate results.

 */
public class ArrayMinimumMoves {
  public static void main(String[] args) {
    int[] seats = {4, 1, 5, 9}, students = {1, 3, 2, 6};
    int response = minMovesToSeat(seats, students);
    System.out.println(response);
  }

  public static int minMovesToSeat(int[] seats, int[] students) {
    Arrays.sort(seats);
    Arrays.sort(students);
    int size = seats.length;
    int moves = 0;
    for (int i = 0; i < size; i++) {
      moves += Math.abs(seats[i] - students[i]);
    }
    return moves;
  }
}

