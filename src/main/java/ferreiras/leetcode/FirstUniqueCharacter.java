package ferreiras.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Given a string s, find the first non-repeating character in it and return its index.
 * If it does not exist, return -1.
 * Example 1:
 * Input: s = "leetcode"
 * Output: 0
 * Example 2:
 * Input: s = "loveleetcode"
 * Output: 2
 * Example 3:
 * Input: s = "aabb"
 * Output: -1
 */

import java.util.Arrays;
public class FirstUniqueCharacter {

  public static void main(String[] args) {
    String s = "loveleetcode";
    int response = firstUniqueChar(s);
    System.out.println("Index of 1st non-repeating character: "+response);
  }
  public static int firstUniqueChar(String s) {
    char[] cx = s.toCharArray();
    Map<Character, Integer> map = new HashMap<>();
//    for (char c : cx) {
//      if(!map.containsKey(c)) {
//        map.put(c, 1);
//      } else {
//        map.put(c, map.getOrDefault((c), 0) + 1);
//      }
//    }
    for (char c : cx) {
      map.put(c, map.getOrDefault((c),0) +1);
    }
    List<Character> list = new ArrayList<>();
    for (Map.Entry<Character,Integer> entry : map.entrySet()) {
      if(entry.getValue() == 1) {
        list.add(entry.getKey());
      }
    }
    System.out.print(Arrays.toString(cx));
    System.out.println(map);
    System.out.println(" " + list + "\n");
    for (int i = 0; i< s.length(); i++) {
      if (list.contains(s.charAt(i))) {
         return i;
      }
    }
    return -1;
  }
}
