package org.ferreiras.leetcode;
/**
 * There are n kids with candies. You are given an integer array candies, where each candies[i]
 * represents the number of candies the ith kid has, and an integer extraCandies, denoting the
 * number of extra candies that you have.
 * Return a boolean array result of length n, where result[i] is true if, after giving the ith kid
 * all the extraCandies, they will have the greatest number of candies among all the kids,
 * or false otherwise.
 * Note that multiple kids can have the greatest number of candies.
 * Example 1:
 * Input: candies = [2,3,5,1,3], extraCandies = 3
 * Output: [true,true,true,false,true]
 * Input: candies = [4,2,1,1,2], extraCandies = 1
 * Output: [true,false,false,false,false]
 */

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class KidsGreatestCandies {
  public static void main(String[] args) {
    int[] candies = {2,3,5,1,3};
    int extraCandies = 3;
    System.out.println(kidsWithCandies(candies, extraCandies));
    System.out.println(squareLambda.apply(5));
  }

  public static int square(int x) {
    return x*x;
  }

  static Function<Integer,Integer> squareLambda = x -> {
    return x * x;
  };

  public static List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
    List<Boolean> happyKids = new ArrayList<>();
    int sizeOfCandies = candies.length;
    int j=0;
    for (int candy : candies) {
      candies[j] = candy+extraCandies;
      j++;
    }
    int maxCandies = candies[0];
    for (int candy : candies) {
      maxCandies = Math.max(maxCandies, candy);
    }
    for (int candy : candies) {
      if (candy >= (maxCandies - extraCandies)) {
        happyKids.add(true);
      } else {
        happyKids.add(false);
      }
    }
    return happyKids;
  }
}
