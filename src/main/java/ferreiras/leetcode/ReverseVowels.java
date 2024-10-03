package ferreiras.leetcode;
/*
Given a string s, reverse only all the vowels in the string and return it.
The vowels are 'a', 'e', 'i', 'o', and 'u', and they can appear in both lower
and upper cases, more than once.
Example 1:
Input: s = "hello"
Output: "holle"
Example 2:

Input: s = "leetcode"
Output: "leotcede"
 */

import java.util.HashSet;
import java.util.Set;

public class ReverseVowels {

  public static void main(String[] args) {
    String s = "leetcode";
    String response = reverseVowels(s);
    System.out.println(response);

  }

  public static char[] swapPosition(char[] character, int left, int right) {
    char temp = character[left];
    character[left] = character[right];
    character[right] = temp;
    return character;
  }

  public static String reverseVowels(String s) {
    char[] c = s.toCharArray();
    int left = 0;
    int right = s.length() - 1;
    Set<Character> set = new HashSet<>();
    set.add('a');
    set.add('e');
    set.add('i');
    set.add('o');
    set.add('u');
    set.add('A');
    set.add('E');
    set.add('I');
    set.add('O');
    set.add('U');
    while (left < right) {
      if (set.contains(c[left])) {
        if (set.contains(c[right])) {
          swapPosition(c, left, right);
          left++;
        }
        right--;
      } else {
        left++;
      }
    }
    return String.valueOf(c);
  }
}
