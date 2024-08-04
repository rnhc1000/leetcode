package org.ferreiras.leetCode;

import java.util.*;

/*
 * An integer has sequential digits if and only if each digit in the number
 * is one more than the previous digit.
 * Return a sorted list of all the integers in the range [low, high] inclusive
 * that have sequential digits.
 * Example 1:
 * Input: low = 100, high = 300
 * Output: [123,234]
 * Example 2:
 * Input: low = 1000, high = 13000
 * Output: [1234,2345,3456,4567,5678,6789,12345]
 * Constraints:
 * 10 <= low <= high <= 10^9
 */
public class SequenceIntegers {

  public static void main(String[] args) {
    int low = 1000;
    int high = 100000;
    sequentialDigits(low, high);
  }

  public static void sequentialDigitx(int low, int high) {
    List<Integer> list = new ArrayList<>();
    for (int i = low; i < high; i++) {
      list.add(i);
    }
    Map<Integer, Integer> map = new HashMap<>();
    map.put(10, 11);
    map.put(100, 111);
    map.put(1000, 1111);
    map.put(10000, 11111);
    map.put(100000, 111111);
    map.put(1000000, 1111111);

    Map<Integer, Integer> hmap = new HashMap<>();
    hmap.put(10, 12);
    hmap.put(100, 123);
    hmap.put(1000, 1234);
    hmap.put(10000, 12345);
    hmap.put(100000, 123456);
    hmap.put(1000000, 1234567);
    hmap.put(10000000, 12345678);
    hmap.put(100000000, 123456789);

    SortedSet<Integer> l = new TreeSet<>();
    int basis = 0;


    int seed = 0;
    int n = (high - low) / low;
    int i = 1;
    while (n > 0) {
      for (Integer num : list) {
        if (map.containsKey(num)) {
          seed = map.get(num);
        }
        if (map.containsKey(low)) {
          basis = hmap.get(low);
        }
        if (num == basis || num == basis + (seed * i)) {
          if (num % 10 != 0) {
            l.add(num);
          }
        }
      }
      n--;
      i++;
    }
//    List<Integer> toSort = new ArrayList<>();
//    for (Integer x : l) {
//      Integer integer = x;
//      toSort.add(integer);
//    }
//    toSort.sort(null);
//    Set<Integer> s = new TreeSet<>();
//    for (Integer integer : toSort) {
//      s.add(integer);
//    }
    System.out.println(l);

    List<Integer> lxs = new ArrayList<>(l);

    System.out.println(lxs);
//    String first = String.valueOf(low);
//    String second = String.valueOf(high);
//
//    for (int i = 0; i < first.length(); i++) {
//      for (int k = 1; k < first.length() - 1; k++) {
//        String s = first.substring(i, i + k);
//        System.out.print(" " + s);
//      }
//    }
  }

  public static List<Integer> sequentialDigits(int low, int high) {
    SortedSet<Integer> response = new TreeSet<>();
    for (int digit = 1; digit <= 9; ++digit) {
      int num = digit;
      int nextDigit = digit + 1;
      while (num <= high && nextDigit <= 9) {
        num = num * 10 + nextDigit;
        if (low <= num && num <= high) {
          response.add(num);
        }
        ++nextDigit;
      }
    }
    System.out.println(response);
    return new ArrayList<>(response);
  }
}

