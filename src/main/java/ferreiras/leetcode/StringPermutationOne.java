package ferreiras.leetcode;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/*
Given two strings s1 and s2, return true if s2 contains a permutation of s1, or false otherwise.
In other words, return true if one of s1's permutations is the substring of s2.

Example 1:

Input: s1 = "ab", s2 = "eidbaooo"
Output: true
Explanation: s2 contains one permutation of s1 ("ba").

Example 2:

Input: s1 = "ab", s2 = "eidboaoo"
Output: false


Constraints:

1 <= s1.length, s2.length <= 104
s1 and s2 consist of lowercase English letters.
 */
public class StringPermutationOne {

  public static void main(String[] args) {
    String s1 = "ab";
    String s2 = "eidbaoo";
    boolean response = checkInclusionOne(s1, s2);
    System.out.println(response);
  }

  public static boolean checkInclusion(String s1, String s2) {

    s1 = s1.toLowerCase();
    s2 = s2.toLowerCase();
    int[] frequencyOne = new int[26];
    for (char c : s1.toCharArray()) {
      frequencyOne[c - 'a']++;
    }

    int[] frequencyTwo = new int[26];
    for (char c : s2.toCharArray()) {
      frequencyTwo[c - 'a']++;
    }
    System.out.println(Arrays.toString(frequencyOne));
    Deque<Character> stack = new ArrayDeque<>();
    for (char c : s1.toCharArray()) {
      stack.push(c);
    }
    System.out.println(Arrays.toString(frequencyTwo));

    StringBuilder reverse = new StringBuilder();

    while (!stack.isEmpty()) {
      reverse.append(stack.pop());
    }

    int trim = s1.length();
    int len = s2.length();
    int left = 0;
    int right = trim;
    Deque<String> queue = new ArrayDeque<>();
    //String s2 = "eeaefgfhbawww";
    while (right < len) {
      queue.push(s2.substring(left, right));
      left += trim;
      right += trim;
    }

    return queue.contains(reverse.toString());
  }

  public static boolean checkInclusionOne(String s1, String s2) {
    int sizeOne = s1.length(), sizeTwo = s2.length();

    if (sizeOne > sizeTwo) return false;
    if (sizeOne == 0) return true;

    int[] frequencyOne = new int[26];
    int[] frequencyTwo = new int[26];

    for (int i = 0; i < sizeOne; i++) {
      frequencyOne[s1.charAt(i) - 'a']++;
      frequencyTwo[s2.charAt(i) - 'a']++;
    }
    System.out.println(Arrays.toString(frequencyOne));
    System.out.println(Arrays.toString(frequencyTwo));

    for (int i = sizeOne; i  < sizeTwo; i++) {
      if (Arrays.equals(frequencyOne, frequencyTwo)) {
        System.out.println("Equals");
//        return true;
        continue;
      }
      frequencyTwo[s2.charAt(i) - 'a']++;
      frequencyTwo[s2.charAt(i-sizeOne) - 'a']--;
    }

    System.out.println(Arrays.toString(frequencyTwo));

//    for (int i = 0; i < sizeOne; i++) {
//      frequencyOne[s1.charAt(i) - 'a']++;
//      frequencyTwo[s2.charAt(i) - 'a']++;
//    }
//    System.out.println("F1 -> " + Arrays.toString(frequencyOne));
//    System.out.println("F2 -> " + Arrays.toString(frequencyTwo));
//    int freq = 0;
//    for (int i = 0; i < 26; i++)
//      if (frequencyOne[i] == frequencyTwo[i])
//        freq++;
//
//    for (int i = 0; i < sizeTwo - sizeOne; i++) {
//      if (freq == 26)
//        return true;
//
//      int left = s2.charAt(i) - 'a';
//      int right = s2.charAt(i + sizeOne) - 'a';
//      frequencyTwo[right]++;
//      if (frequencyOne[right] == frequencyTwo[right])
//        freq++;
//      else if (frequencyOne[right] + 1 == frequencyTwo[right])
//        freq--;
//
//      frequencyTwo[left]--;
//      if (frequencyOne[left] == frequencyTwo[left])
//        freq++;
//      else if (frequencyOne[left] - 1 == frequencyTwo[left])
//        freq--;
//
//    }
//    return freq == 26;


    return Arrays.equals(frequencyOne, frequencyTwo);
  }
}
