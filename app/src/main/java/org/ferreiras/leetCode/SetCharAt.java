package org.ferreiras.leetCode;
/*
Example 1:

Input: deadends = ["0201","0101","0102","1212","2002"], target = "0202"
Output: 6
Explanation:
A sequence of valid moves would be
"0000" -> "1000" -> "1100" -> "1200" -> "1201" -> "1202" -> "0202".
Note that a sequence like "0000" -> "0001" -> "0002" -> "0102" -> "0202" would be invalid,
because the wheels of the lock become stuck after the display becomes the dead end "0102".

Example 2:
Input: deadends = ["8888"], target = "0009"
Output: 1
Explanation: We can turn the last wheel in reverse to move from "0000" -> "0009".

Example 3:
Input: deadends = ["8887","8889","8878","8898","8788","8988","7888","9888"], target = "8888"
Output: -1
Explanation: We cannot reach the target without getting stuck.


Constraints:

1 <= deadends.length <= 500
deadends[i].length == 4
target.length == 4
target will not be in the list deadends.
target and deadends[i] consist of digits only.
 */
import java.util.*;

public class SetCharAt {
  public static void main(String[] args) {
    String[] secrets = { "0201","0101","0102","1212","2002" };
    String target = "0202";
    int response = handleChar(secrets, target);
    System.out.println(response);
  }
  public static int handleChar(String[] locks, String target) {
    int moves = 0;
    Set<String> visited = new HashSet<>(Arrays.asList(locks));
    Queue<String> queue = new ArrayDeque<>(List.of("0000"));

    while (!queue.isEmpty()) {
      ++moves;
      for (int size = queue.size(); size > 0; size--) {
        StringBuilder sb = new StringBuilder(queue.remove());
        for (int i = 0; i < 4; i++) {
          final char cache = sb.charAt(i);
          sb.setCharAt(i, sb.charAt(i) == '0' ? '1' : (char) (sb.charAt(i) + 1));
          String secret = sb.toString();
          if (secret.equals(target)) {
            return moves;
          }
          if (!visited.contains(secret)) {
            queue.offer(secret);
            visited.add(secret);
          }
          sb.setCharAt(i, cache);
          // Decrease the i-th digit by 1.
          sb.setCharAt(i, sb.charAt(i) == '0' ? '9' : (char) (sb.charAt(i) - 1));
          secret = sb.toString();
          if (secret.equals(target))
            return moves;
          if (!visited.contains(secret)) {
            queue.offer(secret);
            visited.add(secret);
          }
          sb.setCharAt(i, cache);
        }
      }
    }
    return -1;
  }
}
