package ferreiras.leetcode;

/*
Write a function that reverses a string. The input string is given as an array of characters s.

You must do this by modifying the input array in-place with O(1) extra memory.



Example 1:

Input: s = ["h","e","l","l","o"]
Output: ["o","l","l","e","h"]
Example 2:

Input: s = ["H","a","n","n","a","h"]
Output: ["h","a","n","n","a","H"]


Constraints:

1 <= s.length <= 105
s[i] is a printable ascii character.
 */
public class StringReverse {

  public static void main(String[] args) {
    char[] ch = {'H', 'a', 'n', 'n', 'a', 'h'};
    revertedString(ch);
  }

  public static void reverseString(char[] s) {

    int rightPointer = s.length - 1, leftPointer = 0;

    while (leftPointer < rightPointer) {
      char temp = s[rightPointer];
      s[rightPointer] = s[leftPointer];
      s[leftPointer] = temp;
      leftPointer++;
      rightPointer--;
    }
    for (char c : s) {
      System.out.printf("%c ", c);
    }
  }

  public static <T> Pair<T, T> swap(T varOne, T varTwo) {

    T temp = varOne;
    varOne = varTwo;
    varTwo = temp;

    return new Pair<>(varOne, varTwo);

  }

  static record Pair<S, T>(S varOne, T varTwo) {
  }

  ;

  public static void revertedString(char[] s) {

    int rightPointer = s.length - 1, leftPointer = 0;

    while (leftPointer < rightPointer) {
      char temp = s[rightPointer];
      Pair<Character, Character> pair = swap(s[rightPointer], s[leftPointer]);
      s[rightPointer] = pair.varOne;
      s[leftPointer] = pair.varTwo;
      leftPointer++;
      rightPointer--;
    }
    for (char c : s) {
      System.out.printf("%c ", c);
    }
  }
}
  