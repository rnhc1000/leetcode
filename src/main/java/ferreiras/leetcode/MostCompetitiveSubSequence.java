package ferreiras.leetcode;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Arrays;
/*
Given an integer array numbers and a positive integer target, return the most competitive
subsequence of numbers of size target.
An array's subsequence is a resulting sequence obtained by erasing some (possibly zero)
elements from the array.
We define that a subsequence a is more competitive than a subsequence b (of the same length)
if in the first position where a and b differ, subsequence a has a number less than the
corresponding number in b.
For example, [1,3,4] is more competitive than [1,3,5] because the first position they differ
is at the final number, and 4 is less than 5.

The java.util.ArrayDeque.peekLast() method in Java is used to retrieve or fetch the last
element of the deque. The element retrieved does not get deleted or removed from the Queue
instead the method just returns it. If no element is present in the deque or it is empty,
then Null is returned.
 */
public class MostCompetitiveSubSequence {

  public static void main(String[] args) {
    int[] numbers = {2,4,3,3,5,4,9,6};
    int k = 2;
    int [] response = mostCompetitiveSequence(numbers,k);
    System.out.println(Arrays.toString(response));

  }
  public static int[] mostCompetitiveSequence(int[] numbers, int target) {
      if (target == numbers.length) {
        return numbers;
      }
      int numbersToBeRemoved = numbers.length - target;
      Deque<Integer> deck = new LinkedList<>();
      for (int number : numbers) {
        while ( (!deck.isEmpty() ) && ( (deck.peekLast() > number) ) && (numbersToBeRemoved > 0) ) {
          numbersToBeRemoved--;
          deck.removeLast();
        }
        deck.offer(number);
      }

      while (numbersToBeRemoved > 0) {
        numbersToBeRemoved--;
        deck.removeLast();
      }

      int[] res = new int[deck.size()];
      int i = 0;
      while (!deck.isEmpty()) {
        res[i++] = deck.remove();
      }
      return res;
    }

  }

