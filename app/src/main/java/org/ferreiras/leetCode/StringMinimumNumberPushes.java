package org.ferreiras.leetCode;

import java.util.*;

/*
You are given a string word containing lowercase English letters.

Telephone keypads have keys mapped with distinct collections of lowercase English letters,
which can be used to form words by pushing them.
For example, the key 2 is mapped with ["a","b","c"], we need to push the key one time to type "a",
two times to type "b", and three times to type "c" .

It is allowed to remap the keys numbered 2 to 9 to distinct collections of letters.
The keys can be remapped to any amount of letters, but each letter must be mapped to exactly one key.
You need to find the minimum number of times the keys will be pushed to type the string word.

Return the minimum number of pushes needed to type word after remapping the keys.

An example mapping of letters to keys on a telephone keypad is given below.
Note that 1, *, #, and 0 do not map to any letters.

Example 1:


Input: word = "abcde"
Output: 5
Explanation: The remapped keypad given in the image provides the minimum cost.
"a" -> one push on key 2
"b" -> one push on key 3
"c" -> one push on key 4
"d" -> one push on key 5
"e" -> one push on key 6
Total cost is 1 + 1 + 1 + 1 + 1 = 5.
It can be shown that no other mapping can provide a lower cost.
Example 2:


Input: word = "xyzxyzxyzxyz"
Output: 12
Explanation: The remapped keypad given in the image provides the minimum cost.
"x" -> one push on key 2
"y" -> one push on key 3
"z" -> one push on key 4
Total cost is 1 * 4 + 1 * 4 + 1 * 4 = 12
It can be shown that no other mapping can provide a lower cost.
Note that the key 9 is not mapped to any letter: it is not necessary to map letters to every key, but to map all the letters.
Example 3:


Input: word = "aabbccddeeffgghhiiiiii"
Output: 24
Explanation: The remapped keypad given in the image provides the minimum cost.
"a" -> one push on key 2
"b" -> one push on key 3
"c" -> one push on key 4
"d" -> one push on key 5
"e" -> one push on key 6
"f" -> one push on key 7
"g" -> one push on key 8
"h" -> two pushes on key 9
"i" -> one push on key 9
Total cost is 1 * 2 + 1 * 2 + 1 * 2 + 1 * 2 + 1 * 2 + 1 * 2 + 1 * 2 + 2 * 2 + 6 * 1 = 24.
It can be shown that no other mapping can provide a lower cost.


Constraints:

1 <= word.length <= 105
word consists of lowercase English letters.
Intuition
The intuition behind this solution is to prioritize the characters with the highest frequency first,
as they will require the most pushes. By processing the characters in descending order of frequency,
we can minimize the total number of pushes required.

Approach
Count the frequency of each character in the input string using a hash map .
Create a max heap (priority queue) based on the character frequencies.
Iterate through the characters in the max heap, calculating the minimum pushes required for each
character based on its priority.
Return the total number of pushes calculated.
Time and Space Complexity
Time Complexity: O(n log k), where n is the length of the input string and k is the number of
unique characters. The time complexity is dominated by the priority queue operations, which take
O(log k) time for each character.
Space Complexity:
O(k), where k is the number of unique characters. The space is used to store the character
frequencies in the hash map and the priority queue.

 */
public class StringMinimumNumberPushes {

  public static void main(String[] args) {
    String s = "aabbccddffeegghhiiiiii";
    int response = minimumPushes(s);
    System.out.println(response);
  }
  public static int minimumPushes(String word) {

    int minimumPushes = 0, size = word.length();
    Map<Character,Integer> map = new LinkedHashMap<>();

    for (int i = 0; i < size; i++) {
      char ch = word.charAt(i);
      map.put(ch, map.getOrDefault(ch,0) + 1);
    }
    Queue<Map.Entry<Character,Integer>> maxHeap = new PriorityQueue<>(
            (key, value) -> value.getValue().compareTo(key.getValue())
    );

    maxHeap.addAll(map.entrySet());
    System.out.println(maxHeap);

    int sizeMap = map.size();

    for (int i = 1; i <= sizeMap; i++) {

      Map.Entry<Character,Integer> entry = maxHeap.poll();

      if (i <= 8)
        minimumPushes += entry.getValue();
      else if (i > 8  && i <= 16)
        minimumPushes += entry.getValue() * 2;
      else if (i > 16 && i <= 24 )
        minimumPushes += entry.getValue() * 3;
      else
        minimumPushes += entry.getValue() * 4;

    }
    System.out.println(map);
    return minimumPushes;
  }
}
