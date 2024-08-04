package org.ferreiras.leetCode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/*
You are given a 2D array of integers envelopes where envelopes[i] = [wi, hi] represents the
width and the height of an envelope.

One envelope can fit into another if and only if both the width and height of one envelope are
greater than the other envelope's width and height.

Return the maximum number of envelops you can Russian doll (i.e., put one inside the other).

Note: You cannot rotate an envelope.

Example 1:

Input: envelopes = [ [5,4],[6,4],[6,7],[2,3] ]
Output: 3

Explanation:
The maximum number of envelops you can Russian doll is 3 ([2,3] => [5,4] => [6,7]).

Example 2:

Input: envelopes = [ [1,1],[1,1],[1,1] ]
Output: 1


Constraints:

1 <= envelopes.length <= 105
envelopes[i].length == 2
1 <= wi, hi <= 105
 */
public class ArrayRussianDolls {

  public static void main(String[] args) {
    int[][] envelopes = {
            {5, 4},
            {6, 4},
            {6, 7},
            {2, 3}
    };

    int [] lis = { 1,3,4,6,7,8,9};


    int response = maxEnvelopes(envelopes);
    System.out.println(response);
    int size = longestIncreasingSubsequence(lis);
    System.out.println(size);
  }
  public static int maxEnvelopes(int[][] envelopes) {

    List<Integer> width = new LinkedList<>();
    List<Integer> height = new LinkedList<>();
    for (int[] envelope : envelopes) {

        width.add(envelope[0]);
        height.add(envelope[1]);
    }
    System.out.println(width);
    System.out.println(height);
    //result.toArray(new int[0][]
    return -1;
  }

  public static int longestIncreasingSubsequence(int[] numbers) {

    Integer[] ini = new Integer[numbers.length];

    if (numbers.length == 0) return 0;
    List<Integer> list =  Arrays.asList(ini);

    for (int i = 0; i < numbers.length; i++) {
      for (int j = 0; j < i; j++) {


        if (numbers[j] < numbers[i]) {
          list.add(Math.max(list.get(i), list.get(j)+1));
        }

      }
    }

    System.out.println(list);
    return list.size();

  }
}
