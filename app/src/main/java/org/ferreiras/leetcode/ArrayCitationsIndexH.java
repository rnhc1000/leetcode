package org.ferreiras.leetcode;
/*
Given an array of integers citations where citations[i] is the number of citations a researcher
received for their ith paper, return the researcher's h-index.

According to the definition of h-index on Wikipedia:
The h-index is defined as the maximum value of h such that the given researcher has published at
least h papers that have each been cited at least h times.



Example 1:

Input: citations = [3,0,6,1,5]
Output: 3
Explanation:
[3,0,6,1,5] means the researcher has 5 papers in total and each of them had received 3, 0, 6, 1, 5
citations respectively.
Since the researcher has 3 papers with at least 3 citations each and the remaining two with no more
than 3 citations each, their h-index is 3.
Example 2:

Input: citations = [1,3,1]
Output: 1


Constraints:

n == citations.length
1 <= n <= 5000
0 <= citations[i] <= 1000
 */
public class ArrayCitationsIndexH {

  public static void main(String[] args) {
    int[] citations = { 3,0,6,1,5 };

    int response = hIndex(citations);
    System.out.println(response);
  }
  public static int hIndex(int[] citations) {
    int size = citations.length;
    int[] relevance = new int[size + 1];

    for ( int citation: citations) {
      if ( citation >= size) {
        relevance[size]++;
      } else {
        relevance[citation]++;
      }
    }

    int count = 0;
    for (int i = size; i >= 0; i--) {

      count += relevance[i];

      if (count >= i) {
        return i;
      }
    }

    return 0;
  }
}
