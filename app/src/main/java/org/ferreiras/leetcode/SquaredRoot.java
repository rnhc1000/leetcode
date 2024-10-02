package org.ferreiras.leetcode;

public class SquaredRoot {
  public static void main(String[] args) {
    int num = 16;
    int r = squaredRoot(num);
    System.out.println(r);
  }
  public static int squaredRoot(int num) {
    int left = 1, right = num, middle = 0;
    while (left <= right) {

      middle = (right-left) / 2;

      if (middle * middle == num) {
        return middle;
      }
      if (middle * middle > num) {
        left++;
      } else {
        right--;
      }
    }

    return -1;
  }
  public boolean isPerfectSquare(int num) {
    if (num == 1) return true;
    long left = 1, right = num;
    long middle = 0;

    while (left <= right) {

      middle = ( right+ left ) / 2;

      if ( middle * middle == num) return true;
      if ( middle * middle <  num) left = middle + 1;
      right = middle - 1;
    }

    return false;
  }
}
