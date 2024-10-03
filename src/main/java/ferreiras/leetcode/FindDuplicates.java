package ferreiras.leetcode;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Floyd's Tortoise and Hare algorithm, also known as Floyd's Cycle Detection algorithm,
 * is an algorithm used to detect loops (cycles) in data structures like linked lists or arrays.
 * It has been proven to reliably detect cycles under specific circumstances and can be applied
 * to finding duplicate elements.
 * This algorithm employs two pointers, referred to as the "tortoise" and the "hare,"
 * to traverse the list.
 * Tortoise: A pointer that advances one step at a time through the list.
 * Hare: A pointer that advances two steps at a time through the list.
 * Using these pointers, you progress until the hare catches up with the tortoise or a cycle is detected.
 * Here's an overview of the algorithm:
 * Phase 1 (Cycle Detection):
 * Move the tortoise and hare, advancing the hare twice as fast as the tortoise, until the hare catches
 * up with the tortoise or a cycle is detected. If a cycle is detected, reset the tortoise and move the
 * hare back to its position before the reset.
 * Phase 2 (Cycle Start Detection):
 * Move the tortoise and hare one step at a time until they match again. The position where they match
 * again is the starting point of the cycle, corresponding to the duplicate element.
 * Let's explain why this works for the problem at hand:
 * Properties of Floyd's Tortoise and Hare Algorithm:
 * The algorithm ensures that the tortoise and hare will match again at some position in the list.
 * Exploiting this property, if a cycle exists, the tortoise and hare will certainly match at some
 * position within the cycle.
 * Relation between Duplicate Element and Cycle:
 * In the presence of a duplicate element, the duplicate corresponds to the starting point of the cycle.
 * Starting from the first element as the tortoise, and moving through the duplicates until reaching a
 * duplicate (cycle start), the hare will join, and the tortoise and hare will match again inside the cycle.
 * Therefore, the Floyd's Tortoise and Hare Algorithm provides an efficient and reliable way to find
 * duplicate elements.
 * We can apply the same algorithm to Linked List cycle Ⅱ.
 */
public class FindDuplicates {
  public static void main(String[] args) {
    int[] numbers = { 1,2,3,5,6,7,8,2};
    int response = findDuplicate(numbers);
    System.out.println(response);
  }
  public static int findDuplicate(int[] nums) {
    /**
     * Floyd's Tortoise and Hare algorithm
     */
    int slowPointer = nums[0];
    int fastPointer = nums[0];

    do {
      slowPointer = nums[slowPointer];
      fastPointer = nums[nums[fastPointer]];
    } while (slowPointer != fastPointer);

    slowPointer = nums[0];
    while (slowPointer != fastPointer) {
      slowPointer = nums[slowPointer];
      fastPointer = nums[fastPointer];
    }
    return slowPointer;
  }

  public int findDuplicates(int[] nums) {

    Map<Integer, Integer> map = new LinkedHashMap<>();
    for (int num : nums) {
      map.put(num, map.getOrDefault((num), 0) + 1);
    }
    for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
      if (entry.getValue() > 1) {
        return entry.getKey();
      }
    }
    return -1;
  }
}
