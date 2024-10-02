package org.ferreiras.leetcode;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * You have been given an array of strings, where each string may contain
 * only lowercase English letters.
 * You need to write a method groupAnagrams(String[] strings) that groups
 * the anagrams in the array together using a hash table (HashMap).
 * The method should return a list of lists, where each inner array contains
 * a group of anagrams.
 * For example, if the input array is ["eat", "tea", "tan", "ate", "nat", "bat"],
 * the method should return [["eat","tea","ate"],["tan","nat"],["bat"]] because
 * the first three strings are anagrams of each other, the next two strings are
 * anagrams of each other, and the last string has no anagrams in the input array.
 * You need to implement the groupAnagrams(String[] strings) method and return a
 * list of lists, where each inner list contains a group of anagrams according to
 * the above requirements.
 * Return type: List<List<String>>
 * String[] s = {"eat", "ate", "tan", "tea", "nat", "bat"}
 * String[] s = {"listen", "silent", "triangle", "integral", "garden", "ranged"}
 * {eilnst=[listen, silent], aegilnrt=[triangle, integral], adegnr=[garden, ranged]}
 * [listen, silent]
 * [triangle, integral]
 * [garden, ranged]
 */



public class GroupAnagrams {
  public static void main(String[] args) {
    String[] s = {
            "listen",
            "silent",
            "triangle",
            "integral",
            "garden",
            "ranged"
    };
    List<List<String>> l = groupAnagrams(s);

    for (List<String> lx : l) {
      System.out.println(lx);
    }
  }

  public static List<List<String>> groupingAnagrams(String[] strings) {
    int size = strings.length;
    List<List<String>> response = new ArrayList<>();
    Map<String, Integer> dictionary = new HashMap<>();
    for (String string : strings) {
      dictionary.put(string, 1);
    }
    int d = 1;
    String s = "";
    int jump = 0;
    for (String string : strings) {

      List<String> list = new ArrayList<>();
      for (int i = 0; i < string.length(); i++) {
        s = string.substring(d) + string.substring(0, d);
        if (dictionary.containsKey(s)) {
          list.add(s);
          dictionary.remove(s);
        }
        string = s;
      }
      response.add(list);
    }
    System.out.println(dictionary);
    return response;
  }
  public static List<List<String>> groupAnagrams(String[] strings) {

    Map<String, List<String>> dictionary = new HashMap<>();
    for (String string : strings) {
      char[] c = string.toCharArray();
      Arrays.sort(c);
      String canonical = new String(c);
      if(dictionary.containsKey(canonical)) {
        dictionary.get(canonical).add(string);
      } else {
        List<String> group = new ArrayList<>();
        group.add(string);
        dictionary.put(canonical, group);
      }
    }
    System.out.println(dictionary);
    return new ArrayList<>(dictionary.values());
  }
}
