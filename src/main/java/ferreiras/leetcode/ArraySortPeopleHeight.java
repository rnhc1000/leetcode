package ferreiras.leetcode;

import java.util.*;

/*
You are given an array of strings names, and an array heights that consists of distinct
positive integers. Both arrays are of length n.

For each index i, names[i] and heights[i] denote the name and height of the ith person.

Return names sorted in descending order by the people's heights.



Example 1:

Input: names = ["Mary","John","Emma"], heights = [180,165,170]
Output: ["Mary","Emma","John"]
Explanation: Mary is the tallest, followed by Emma and John.
Example 2:

Input: names = ["Alice","Bob","Bob"], heights = [155,185,150]
Output: ["Bob","Alice","Bob"]
Explanation: The first Bob is the tallest, followed by Alice and the second Bob.


Constraints:

n == names.length == heights.length
1 <= n <= 103
1 <= names[i].length <= 20
1 <= heights[i] <= 105
names[i] consists of lower and upper case English letters.
All the values of heights are distinct.
 */
public class ArraySortPeopleHeight {

  public static void main(String[] args) {
    String[] names = {"Alice","Bob","Bob"};
    int[] heights = {155,185,150};

    String[] sorted = sortPeople(names, heights);
    System.out.println(Arrays.toString(sorted));
  }

  public static String[] sortPeople(String[] names, int[] heights) {


    Map<Integer, String> map = new TreeMap<>(Comparator.reverseOrder());

    for (int i=0; i < heights.length; i++) {

      map.put(heights[i], names[i] );
    }

    System.out.println(map);

//    List<String> sortedKey = new ArrayList<>(map.values());

    int[] height = new ArrayList<>(map.keySet()).stream().mapToInt(x -> x).toArray();

    return new ArrayList<>(map.values()).toArray(new String[0]);
  }
}
