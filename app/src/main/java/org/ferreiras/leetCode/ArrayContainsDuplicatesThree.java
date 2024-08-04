package org.ferreiras.leetCode;

import java.util.Random;
import java.util.TreeSet;

/*
You are given an integer array nums and two integers indexDiff and valueDiff.

Find a pair of indices (i, j) such that:

i != j,
abs(i - j) <= indexDiff.
abs(nums[i] - nums[j]) <= valueDiff, and
Return true if such pair exists or false otherwise.



Example 1:

Input: nums = [1,2,3,1], indexDiff = 3, valueDiff = 0
Output: true
Explanation: We can choose (i, j) = (0, 3).
We satisfy the three conditions:
i != j --> 0 != 3
abs(i - j) <= indexDiff --> abs(0 - 3) <= 3
abs(nums[i] - nums[j]) <= valueDiff --> abs(1 - 1) <= 0

Consider the edge cases. What are the edge cases? What happens when the array is empty, singleton etc.
And what about when k is 0? Consider edge cases that you know are unlikely to be included in a general
solution, and take care of those cases right away.
Then, you understand that for any element x in nums, you're actually looking for its partner.
This partner element is at most k hops away from x, and doesn't differ from x by more than t.
So, if you happen to have k elements in your hand, and look at a (k + 1)th element, you ask "does this
(k + 1)th guy find a partner in the k I'm already holding on to?"
If not, well guess what? The oldest element in the k ones you have can no more find its partner so you
can get rid of it and let (k + 1)th guy get in.
For an example, let's consider the first one given i.e. nums = [1,2,3,1] | k = 3 | t = 0.
Now, you're holding on to the first k elements i.e. [1,2,3]. Your supposed loop considers the next element
i.e. [..., 1]. Now if this 1 has a partner in [1,2,3], great, we're done. But if not, then there's no problem
in throwing the first [1...], because well, all the elements you see now are going to be more than k hops away
from him. So you end up with [2,3,1].
That was the basic processing idea.
Finally, you understand that upon processing each element x, if the largest number smaller than x or the
smallest number greater than x, in the k elements you already have, produce something bounded by t, you have
an answer.
Now it's your turn to research what data structure can hold onto elements such that it can yeild a
ceiling/floor relative to some number efficiently (clearly it will have to keep its elements in a sorted
manner...)
(P.S. think a bit about why ceiling/floor and not just max/min)
 */
public class ArrayContainsDuplicatesThree {
  public static void main(String[] args) {
    int[] nums = {1, 2, 3, 1};
    int indexDiff = 3, valueDiff = 0;
    boolean result = containsNearbyDuplicate(nums, indexDiff, valueDiff);
    System.out.printf("\n %s", result);

  }

  public static boolean containsNearbyAlmostDuplicate(int[] nums, int indexDiff, int valueDiff) {
//    Arrays.sort(nums);
    Random random = new Random();
    int i = random.nextInt(nums.length);
    int j = random.nextInt(nums.length - 1);
    while (i == j) {
      j = random.nextInt(i);
    }

    System.out.printf("%d, %d", i, j);
    return Math.abs(i - j) <= indexDiff && Math.abs(nums[i] - nums[j]) <= valueDiff;
  }

  public static boolean containsNearbyDuplicate(int[] nums, int indexDiff, int valueDiff) {
    int len = nums.length;

    // return false when given parameters makes two distinct indices impossible
    if (len <= 1 || indexDiff <= 0) {
      return false;
    }

    /**
     * Important, question definition:
     *   Absolute diff between nums[i] and nums[j] <= t
     *   Absolute diff between indices i and j <=indexDiff
     **/

    TreeSet<Long> set = new TreeSet<>();
    for (int i = 0; i < nums.length; i++) {
      Long number = new Long(nums[i]);
      Long ceil = set.ceiling(number);
      Long floor = set.floor(number);

      if (ceil != null && ceil - number <= valueDiff) {
        return true;
      }

      if (floor != null && number - floor <= valueDiff) {
        return true;
      }

      set.add(number);
      if (set.size() > indexDiff) {
        Long oldest = new Long(nums[i - indexDiff]);
        set.remove(oldest);
      }
    }

    return false;
  }
}
