package br.dev.ferreiras.challenges.leetCode.dynamicProgramming;

/**
 * DP
 */
public class RobberHouse {
  public static void main(String[] args) {
    int[] houses = {2,7,9,3,1};
    int response = robberHouse(houses);
    System.out.println(response);
  }

  public static int robberHouse(int[] houses) {
    int left = 0, right = 0;
    for (int house : houses) {
      int current = house + left;
      int temp = Math.max(current, right);
      left = right;
      right = temp;
    }

    return right;
  }
}
