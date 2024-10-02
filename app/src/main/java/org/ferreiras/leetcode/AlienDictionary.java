package org.ferreiras.leetcode;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;

/*
In an alien language, surprisingly, they also use English lowercase letters,
but possibly in a different order.
The order of the alphabet is some permutation of lowercase letters.

Given a sequence of words written in the alien language, and the order of the alphabet,
return true if and only if the given words are sorted lexicographically in this alien language.

Example 1:

Input: words = ["hello","leetcode"], order = "hlabcdefgijkmnopqrstuvwxyz"
Output: true
Explanation:
As 'h' comes before 'l' in this language, then the sequence is sorted.

Example 2:

Input: words = ["word","world","row"], order = "worldabcefghijkmnpqstuvxyz"
Output: false
Explanation:
As 'd' comes after 'l' in this language, then words[0] > words[1], hence the sequence is unsorted.

Example 3:

Input: words = ["apple","app"], order = "abcdefghijklmnopqrstuvwxyz"
Output: false
Explanation:
The first three characters "app" match, and the second string is shorter (in size.)
According to lexicographical rules "apple" > "app", because 'l' > '∅', where '∅' is
defined as the blank character which is less than any other character (More info).


Constraints:

1 <= words.length <= 100
1 <= words[i].length <= 20
order.length == 26
All characters in words[i] and order are English lowercase letters.
 */
@org.ferreiras.leetcode.ClassPreamble (
        author = "Ricardo Ferreira",
        date = "22/11/2023",
        currentRevision = 1,
        lastModified = "02/05/2024",
        lastModifiedBy = "Ricardo Ferreira",
        reviewers = {}
)
public class AlienDictionary {
  public static void main(String[] args) {
    String [] words = {"hello","leetcode"};
    String order = "hlabcdefgijkmnopqrstuvwxyz";
    /*
    [7, 11, 0, 1, 2, 3, 4, 5, 6, 8, 9, 10, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25]
     */
    boolean response = isAlienSorted(words,order);

  }
  public static boolean isAlienSorted(String[] words, String order) {

    int[] position = new int[26];
    int pos = 0;
    char[] ch = order.toCharArray();
    for (char c : ch) {
      position[pos++] = c - 'a';
    }
    pos=0;
    Map<Integer, Character> map = new LinkedHashMap<>();
    for (int p : position) {
      map.put(p, ch[pos++]);
    }

    System.out.println(Arrays.toString(position));
    System.out.println(map);

    return true;
  }
}
