package ferreiras.leetcode;

/**
 * You are a professional robber planning to rob houses along a street.
 * Each house has a certain amount of money stashed, the only constraint stopping
 * you from robbing each of them is that adjacent houses have security systems
 * connected and it will automatically contact the police if two adjacent houses
 * were broken into on the same night.
 * Given an integer array nums representing the amount of money of each house,
 * return the maximum amount of money you can rob tonight without alerting the police.
 * Example 1:
 * Input: nums = [1,2,3,1]
 * Output: 4
 * Explanation: Rob house 1 (money = 1) and then rob house 3 (money = 3).
 * Total amount you can rob = 1 + 3 = 4.
 * Example 2:
 * <p>
 * Input: nums = [2,7,9,3,1]
 * Output: 12
 * Explanation: Rob house 1 (money = 2), rob house 3 (money = 9) and rob house 5 (money = 1).
 * Total amount you can rob = 2 + 9 + 1 = 12.
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= nums.length <= 100
 * 0 <= nums[i] <= 400
 */
public class HouseRobber {

  public static void main(String[] args) {
    int[] nums = {2,7,9,3,1};
    int total = rob(nums);
    System.out.println(total);
  }

  public static int rob(int[] nums) {
    int len = nums.length;
    int sum = 0;
    int [] aux = new int[len];
    if (len == 0) {
      return 0;
    }
    if (len == 1) {
      return nums[0];
    }
    aux[0] = nums[0];
    aux[1] = Math.max(nums[0],nums[1]);

      for (int i = 2; i < len; i++) {
        int a = aux[i-1];
        int b = aux[i-2];
        int c = b + nums[i];
        aux[i] = Math.max(a,c);
      }
    return aux[len-1];
  }

  public int robber(int[] nums) {
    int len = nums.length;
    int sum = 0;
    switch (len) {
      case 1:
        sum = nums[0];
        break;
      case 2:
        sum = (nums[0] > nums[1]) ? nums[0] : nums[1];
        break;
      default:
        break;

    }
    if (sum > 0) {
      return sum;
    } else {
      for (int i = 0; i < len; i += 2) {
        sum += nums[i];
      }
    }
    return sum;
  }
}
