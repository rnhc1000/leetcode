package org.ferreiras.leetcode;

public class GuessNumber {
  public static void main(String[] args) {
    int n = 4;
    System.out.println(guessNumber(n));
  }

  public static int guessNumber(int n) {
    if (n == 1) return 1;
    if(guess(n)== 0) return n;
    int first = 1 ;
    int last = n;
    int mid = 0;
    int r = Integer.MIN_VALUE;
    while (r != 0) {
      mid = first+(last-first)/2;
      r = guess(mid);
      if (r == 0) break;
      if (r == -1) {
        last = mid;
      } else if (r == 1) {
        first = mid;
      }
    }
    return mid;
  }

  public static int guess(int n) {

    return Integer.compare(1, n);
  }
}
