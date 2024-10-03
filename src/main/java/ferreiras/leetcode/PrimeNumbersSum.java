package ferreiras.leetcode;

import java.util.*;

public class PrimeNumbersSum {
  public static void main(String[] args) {
    int k = 25;
    List<List<Integer>> primes = primePairNumbers(k);
    System.out.println(primes);

  }
  public static List<Integer> primeNumbers(int number) {
    boolean[] prime = new boolean[number + 1];
    Arrays.fill(prime, true);
    for (int p = 2; p * p <= number; p++) {
      if(prime[p]) {
        for (int i = p * 2; i <= number ; i+=p) {
          prime[i] = false;
        }
      }
    }
    System.out.println(Arrays.toString(prime));

    List<Integer> primes = new LinkedList<>();

    for (int i = 2; i <= number; i++) {

      if (prime[i]) {
        primes.add(i);
      }

    }

    return primes;
  }
  public static List<List<Integer>> primePairNumbers(int number) {

    long start = System.currentTimeMillis();

    boolean[] prime = new boolean[number + 1];
    Arrays.fill(prime, true);
    for (int p = 2; p * p <= number; p++) {

      if(prime[p]) {

        for (int i = p * 2; i <= number ; i+=p) {
          prime[i] = false;
        }

      }
    }
    System.out.println(Arrays.toString(prime));

    List<Integer> primes = new LinkedList<>();

    for (int i = 2; i <= number; i++) {

      if (prime[i]) {
        primes.add(i);
      }

    }

    List<List<Integer>> response = new ArrayList<>();
    Map<Integer, Integer> map = new LinkedHashMap<>();
    System.out.println(primes);
    for (Integer p : primes) {
      List<Integer> pairs = new ArrayList<>();
      int complement = number - p;
      if (map.containsKey(complement)) {
        pairs.add(complement);
        pairs.add(p);
        System.out.println(pairs);
        response.add(pairs);
      } else {
        map.put(p, map.getOrDefault(p, 0) + 1);
      }
    }
    System.out.println(map);
    long end = System.currentTimeMillis();
    System.out.println(end - start + " ms");
    return response;
  }
}
