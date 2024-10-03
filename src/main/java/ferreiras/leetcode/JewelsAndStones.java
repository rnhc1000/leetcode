package ferreiras.leetcode;

import java.util.List;
import java.util.Set;

/*
You're given strings jewels representing the types of stones that are jewels,
and stones representing the stones you have.
Each character in stones is a type of stone you have.
You want to know how many of the stones you have are also jewels.

Letters are case sensitive, so "a" is considered a different type of stone from "A".

Example 1:

Input: jewels = "aA", stones = "aAAbbbb"
Output: 3

Example 2:

Input: jewels = "z", stones = "ZZ"
Output: 0

Constraints:

1 <= jewels.length, stones.length <= 50
jewels and stones consist of only English letters.
All the characters of jewels are unique.
 */
public class JewelsAndStones {
  public static void main(String[] args) {
    String jewels = "aA", stones = "aAAbbbb";
    int count = JewelsAndStones.numJewelsInStone(jewels, stones);
    System.out.println(count);
    Set<Integer> x = (Set<Integer>) List.of(1,2,3,4,5,6);
    Integer[] y = x.toArray(new Integer[0]);
  }
  public static int numJewelsInStones(String jewels, String stones) {
    int count = 0;
    for (int i = 0 ; i < stones.length(); i++) {
      for (int j = 0; j < jewels.length(); j++) {
        if (jewels.charAt(j) == stones.charAt(i))  {
          count++;
        }
      }
    }

    return count;
  }

  public static int numJewelsInStone(String jewels, String stones) {
    int count = 0;
    for (char c : stones.toCharArray()) {
      if (jewels.indexOf(c) != -1) count++;
    }

    return count;
  }
}
