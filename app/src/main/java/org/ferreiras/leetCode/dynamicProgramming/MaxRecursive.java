package br.dev.ferreiras.challenges.leetCode.dynamicProgramming;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class MaxRecursive {
  public static void main(String[] args) {
    int[] numbers = {4, 3, 6, 7, 0, 9, 2};
    int n = numbers.length - 1;
    int max = findMax(numbers, n);
    System.out.println(max);

    String s = "racecar";
    boolean b = isPalindrome(s, 0, 6);
    System.out.println(b);
    int[] sequence = {1, 2, 3, 4, 6, 7, 8, 9};
    boolean c = sequence(sequence, 7);
    System.out.println(c);

    int m = 1234567;

    System.out.println(sumOfDigits(m));

    int f = 10;
    System.out.println(fib(10));

    //int r = binomialCoefficient(m, f);

    //System.out.println(r);
    map();


  }

  /**
   * @param numbers
   * @param i
   * @return
   */
  public static int findMax(int[] numbers, int i) {
    if (i == 0) return numbers[0];

    return Math.max(numbers[i], findMax(numbers, i - 1));
  }

  public static boolean isPalindrome(String s, int i, int j) {
    if (i >= j) return true;

    return s.charAt(i) == s.charAt(j) && isPalindrome(s, i + 1, j - 1);
  }

  /**
   * @param numbers
   * @param n
   * @return
   */
  public static boolean sequence(int[] numbers, int n) {
    if (n == 0) {
      return true;
    }

    return numbers[n] - numbers[n - 1] == 1 && sequence(numbers, n - 1);
  }

  public static int sumOfDigits(int n) {
    if (n == 0) {
      return n;
    }

    return (n % 10 + sumOfDigits(n / 10));
  }

  public static void combination(int[] numbers, HashSet<Integer> set, int k, int start) {
    if (set.size() == k) {
      System.out.println(set);
    }

    if (start == numbers.length) {
      return;
    }
    for (int i = start; i < numbers.length; i++) {
      set.add(numbers[i]);
      combination(numbers, set, i + 1, k);
      set.remove(numbers[i]);
    }
  }

  /**
   * Top-down approach
   *
   * @param n
   * @param cache
   * @return
   */
  public static int fibonacci(int n, int[] cache) {
    if (n == 0) return 0;
    if (n == 1) return 1;
    if (cache[n] != 0) return cache[n];
    int result = fibonacci(n - 1, cache) + fibonacci(n - 2, cache);
    cache[n] = result;
    return result;
  }

  /**
   * Bottom-up approach
   *
   * @param n
   * @return
   */
  public static int fib(int n) {
    int[] dp = new int[n + 1];
    dp[0] = 0;
    dp[1] = 1;

    for (int i = 2; i <= n; i++) {
      dp[i] = dp[i - 2] + dp[i - 1];
    }

    return dp[n];
  }

  public static int binomialCoefficient(int m, int n) {
    if (m == n || n == 0) {
      return 1;
    }
    return binomialCoefficient(m - 1, n - 1) + binomialCoefficient(m - 1, n);
  }

  public static void map() {
    Map<Integer, String> m = new HashMap<>();
    m.put(5, "Five");
    m.put(8, "Eight");
    m.put(6, "Six");
    m.put(4, "Four");
    m.put(2, "Two");

// Retrieving
    System.out.println(m.get(6));

// Lambda forEach
    m.forEach((key, value) -> {
      String msg = key + ": " + value;

      if (key == 2) System.out.println("key 2 -> " + value);
      System.out.println(msg);
    });
  }
}
