package org.ferreiras.leetcode;

import java.util.*;

/**
 * Given two arrays of strings list1 and list2, find the common strings with the least index sum.
 * A common string is a string that appeared in both list1 and list2.
 * A common string with the least index sum is a common string such that if it appeared at
 * list1[i] and list2[j] then i + j should be the minimum value among all the other common strings.
 * Return all the common strings with the least index sum. Return the answer in any order.
 * Example 1:
 * Input: list1 = ["Shogun","Tapioca Express","Burger King","KFC"],
 * list2 = ["Piatti","The Grill at Torrey Pines","Hungry Hunter Steakhouse","Shogun"]
 * Output: ["Shogun"]
 * Explanation: The only common string is "Shogun".
 * Example 2:
 * Input: list1 = ["Shogun","Tapioca Express","Burger King","KFC"],
 * list2 = ["KFC","Shogun","Burger King"]
 * Output: ["Shogun"]
 * Explanation:
 * The common string with the least index sum is "Shogun" with index sum = (0 + 1) = 1.
 * Example 3:
 * Input: list1 = ["happy","sad","good"], list2 = ["sad","happy","good"]
 * Output: ["sad","happy"]
 * Explanation: There are three common strings:
 * "happy" with index sum = (0 + 1) = 1.
 * "sad" with index sum = (1 + 0) = 1.
 * "good" with index sum = (2 + 2) = 4.
 * The strings with the least index sum are "sad" and "happy".
 */
public class MinimumIndexSumTwoLists {

  public static void main(String[] args) {
    String[] list1 = {"Shogun","Tapioca Express","Burger King","KFC"};
    String[] list2 = {"Piatti","The Grill at Torrey Pines","Hungry Hunter Steakhouse","Shogun"};
    String[] response = findRestaurants(list1,list2);
    for (String r : response) {
      System.out.print(" " + r);
    }

    List<Integer>list = Arrays.asList(1,2,3,4,5,6,7,8);

    Integer[] i = list.toArray(new Integer[0]);
//    System.out.println(Arrays.toString(i));
      int n = 5;

      String[] bits = new String[n];
      Queue<String> queue = new LinkedList<>();
      queue.add("1");
      StringBuilder sb = new StringBuilder();
      int temp = 0;
      while (temp < n) {

        String current = queue.poll();
        sb.append(current);
        bits[temp] = sb.toString();
        sb.delete(0,sb.length());
        queue.add(current + "0");
        queue.add(current + "1");
        temp++;
      }
      int size = bits.length;
    System.out.println(size);
      for (String bit  : bits )
        if(bit.charAt(0) == 1 && bit.charAt(1) == 1) {
          size-=size;
        }
    System.out.println(Arrays.toString(bits));
    System.out.println(size);
    }

  public static String[] findRestaurant(String[] list1, String[] list2) {
    int sizeOne = list1.length;
    int sizeTwo = list2.length;
    List<String> response = new ArrayList<>();
    Map<String, Integer> map = new LinkedHashMap<>();

    int large = Math.max(sizeOne, sizeTwo);
    int small = Math.min(sizeOne, sizeTwo);

   if (sizeOne > sizeTwo) {
     for (int i = 0; i < sizeTwo; i++) {
       for (int j=0; j < sizeOne; j++) {
         if (list1[j].equals(list2[i])) {
           response.add(list1[j]);
           map.put(list1[j], j);
         }
       }
     }
   } else if (sizeOne < sizeTwo) {
     for (int i = 0; i < sizeOne; i++) {
       for(int j = 0; j < sizeTwo; j++) {
         if (list1[j].equals(list2[i])) {
           response.add(list1[j]);
           map.put(list1[j], map.getOrDefault((list1[j]), 0) + 1);
         }
       }
     }
   } else {
     for (int i = 0; i < sizeOne; i++) {
       for(int j = 0; j < sizeTwo; j++) {
         if (list1[j].equals(list2[i])) {
           response.add(list1[j]);
           map.put(list1[j], j);
         }
       }
     }

   }
    System.out.println(map);
   return  response.toArray(new String[0]);
//   int count = 0;
//   for (String s : response) {
//     r[count] = s;
//     count++;
//   }
  }
  public static String[] findRestaurants(String[] list1, String[] list2) {
    int sizeOne = list1.length;
    int sizeTwo = list2.length;
    List<String> response = new ArrayList<>();
    List<Integer> index = new ArrayList<>();
    Map<String, Integer> map = new LinkedHashMap<>();

    int large = Math.max(sizeOne, sizeTwo);
    int small = Math.min(sizeOne, sizeTwo);

    for (int i = 0; i < sizeOne; i++) {
      map.put(list1[i], i);
    }
    int minimum = Integer.MAX_VALUE;
    for (int j = 0 ; j < sizeTwo; j++) {
      if (map.containsKey(list2[j]) ) {
        int indexes = (map.get(list2[j])+j);
        if(indexes < minimum) {
          minimum = indexes;
          response.clear();
          response.add(list2[j]);
        } else if (indexes == minimum) {
          response.add(list2[j]);
        }
      }
    }

    return  response.toArray(new String[0]);
//   int count = 0;
//   for (String s : response) {
//     r[count] = s;
//     count++;
//   }
  }
}
