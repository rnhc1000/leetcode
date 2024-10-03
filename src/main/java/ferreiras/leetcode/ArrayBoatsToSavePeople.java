package ferreiras.leetcode;

import java.util.Arrays;

/*
You are given an array people where people[i] is the weight of the ith person, and an infinite
number of boats where each boat can carry a maximum weight of limit.
Each boat carries at most two people at the same time, provided the sum of the weight of those
people is at most limit.
Return the minimum number of boats to carry every given person.
Example 1:

Input: people = [1,2], limit = 3
Output: 1
Explanation:
1 boat (1, 2)
Example 2:

Input: people = [3,2,2,1], limit = 3
Output: 3
Explanation: 3 boats (1, 2), (2) and (3)
Example 3:
Input: people = [3,5,3,4], limit = 5
Output: 4
Explanation:
4 boats (3), (3), (4), (5)

Constraints:

1 <= people.length <= 5 * 104
1 <= people[i] <= limit <= 3 * 104

Intuition by https://leetcode.com/sujalgupta09
The intuition behind the solution lies in optimizing the number of boats needed to rescue
all the people, given the weight limit per boat.

Sorting: Sorting the array of people's weights allows us to pair the heaviest and lightest
individuals efficiently. It ensures that if two people are to be placed in a boat, they are
the closest in weight to each other, minimizing the chances of exceeding the weight limit.
Two-pointer approach: Using two pointers allows us to consider pairs of people from both
ends of the sorted array. By starting with the lightest and heaviest individuals, we can
determine if they can be placed together in a boat without exceeding the weight limit.
Iterative checking: While iterating through the array with two pointers, we check if the
sum of weights of the current pair of people is within the weight limit of the boat.
If it is, we move the lighter person's pointer to the right, indicating they are accounted for.
Regardless, we move the heavier person's pointer to the left, as they are already paired or
alone in a boat.
Counting boats: Incrementing the count at each iteration signifies that a boat is being used.
The count will eventually represent the minimum number of boats needed to rescue all people.
In summary, the intuition is to pair people optimally, starting with the lightest and heaviest
individuals, and incrementally move towards the middle of the sorted array, minimizing the number
of boats required to rescue everyone.

Approach
The approach used in the numRescueBoats function is to sort the array of people's weights in
ascending order. Then, it uses a two-pointer technique where one pointer (i) starts from the
beginning of the array and the other pointer (j) starts from the end of the array.

The function then iterates over the array while the two pointers (i and j) don't cross each other.
At each iteration, it checks if the sum of the weights of the person at pointer i and the person
at pointer j is less than or equal to the limit. If it is, it means both of these people can fit
into one boat, so it increments i to move to the next person. Regardless of whether a pair of people
fits into a boat or not, it decrements j to consider the next person from the heavier end.

Finally, it increments the count variable at each iteration, indicating the number of boats needed.

This approach ensures that the heaviest person is paired with the lightest person who can fit into
the same boat, thus minimizing the number of boats required to rescue all the people.

Complexity
Time complexity:
O(n log n).

Space complexity:
O(1)
 */
public class ArrayBoatsToSavePeople {
  public static void main(String[] args) {
    int[] people = {3, 5, 3, 4};
    int limit = 5;
    int response = numRescueBoats(people, limit);
    System.out.println(response);
  }

  public static int numRescueBoats(int[] people, int limit) {
    Arrays.sort(people);
    int right = people.length - 1, left = 0, currentWeight = 0, boats = 0;

    while (left <= right) {
      currentWeight = people[right] + people[left];
      if (currentWeight <= limit) {
        left++;
      }
      right--;
      boats++;
    }

    return boats;
  }
}
