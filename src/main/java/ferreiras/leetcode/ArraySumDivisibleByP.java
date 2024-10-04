package ferreiras.leetcode;

import java.util.HashMap;
import java.util.logging.Logger;

/*
Given an array of positive integers nums, remove the smallest subarray (possibly empty)
such that the sum of the remaining elements is divisible by p.
It is not allowed to remove the whole array.

Return the length of the smallest subarray that you need to remove, or -1 if it's impossible.

A subarray is defined as a contiguous block of elements in the array.

Example 1:
Input: nums = [3,1,4,2], p = 6
Output: 1
Explanation:
The sum of the elements in nums is 10, which is not divisible by 6.
We can remove the subarray [4], and the sum of the remaining elements is 6, which is divisible by 6.

Example 2:
Input: nums = [6,3,5,2], p = 9
Output: 2
Explanation:
We cannot remove a single element to get a sum divisible by 9.
The best way is to remove the subarray [5,2], leaving us with [6,3] with sum 9.

Example 3:
Input: nums = [1,2,3], p = 3
Output: 0
Explanation:
Here the sum is 6. which is already divisible by 3. Thus, we do not need to remove anything.


Constraints:

1 <= nums.length <= 105
1 <= nums[i] <= 109
1 <= p <= 109
 */
public class ArraySumDivisibleByP {

//  public static final Logger logger = LoggerFactory.getLogger(String.valueOf(ArraySumDivisibleByP.class));
public static final Logger logger = Logger.getLogger(String.valueOf(ArraySumDivisibleByP.class));

  public static void main(String[] args) {
    int[] nums = {1000000000, 1000000000, 1000000000};
    int p = 3;
    int response = minSubarray(nums, p);
    logger.info(String.valueOf(response));
  }

  public static int minSubarray(int[] nums, int p) {

//    long sum = Arrays.stream(nums).mapToLong(x -> x).sum();
    /*
    great question, we can do that but bro, think if the numbers in the array are huge like
    [100000000000, 10000000000, 100000000000] and if you go for sum first => then this will
    lead to overflow as Integer can not park that huge value after sum...
    so lets make use of Modulous.
     */
    int sum = 0;
    for (int num : nums) {
      sum = (sum + num) % p;
      System.out.println(sum);

    }

    logger.info(String.valueOf(sum));
    int mod = sum % p;
    if (mod == 0) return 0;

    int response = nums.length;
    HashMap<Integer, Integer> map = new HashMap<>();
    map.put(0, -1);
    int currentModulus = 0;
    for (int i = 0; i < nums.length; i++) {

      currentModulus = (currentModulus + nums[i]) % p;
      int targetModulus = (currentModulus - mod + p) % p;

      if (map.containsKey(targetModulus))
        response = Math.min(response, i - map.get(targetModulus));
      map.put(currentModulus, i);
    }

    return response == nums.length ? -1 : response;
  }

}
