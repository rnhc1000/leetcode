package org.ferreiras.leetCode;
/**
 *
 * @param n
 * @return
 * And operation between multiple of 2 and next lower number will
 * always give 0 and otherwise it will never be 0.
 * example 1: 8 & 7
 * 1000(8) & 0111(7) => 0000(0)
 * example 1: = 10 & 9
 * 1010(10) & 1001(9) => 1000(8)
 */
import java.util.Scanner;

public class Power {

  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    System.out.print("Digite o numero a ser verificado: ");
    int number = input.nextInt();
    boolean r  = isPowerOfThree(number);
    System.out.println(r);
    input.close();
  }
  public static boolean isPowerOfTwo(int n) {
//    double log = Math.log(n)/Math.log(2);
//    System.out.println(log);
//    int l = (int)log;
//    return Math.pow(2,l) == n;
    return (n > 0) && ((n & (n - 1)) == 0);
  }

  public static boolean isPowerOfFour(int n) {
    if(n == 0) return false;
    if(n == 1) return true;
    double log = Math.log(n) / Math.log(4);
    return log == (int)log;
  }

  public static boolean isPowerOfThree(int n) {
    if (n == 0) return false;
    if (n ==1) return true;
    while ( n % 3 == 0) {
      n = n / 3;
    }
    return n == 1;
  }
}

