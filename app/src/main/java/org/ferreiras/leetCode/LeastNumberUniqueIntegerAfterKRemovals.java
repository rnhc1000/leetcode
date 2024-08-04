package org.ferreiras.leetCode;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

public class LeastNumberUniqueIntegerAfterKRemovals {
  public static void main(String[] args) {
    int[] numbers = {2, 4, 1, 8, 3, 5, 1, 3};
    int k = 3;
    int response = findLeastNumOfUniqueInts(numbers, k);
    System.out.println(response);
  }

  public static int findLeastNumOfUniqueInts(int[] arr, int k) {

    Map<Integer, Integer> map = new LinkedHashMap<>();
    for (int a : arr) {
      map.put(a, map.getOrDefault((a), 0) + 1);
    }
    System.out.println(map);

    Queue<Integer> queue = new PriorityQueue<>(map.values());
    System.out.println(queue);
    while (k > 0 && !queue.isEmpty()) {
      int frequency = queue.poll();
      if (k >= frequency) {
        k -= frequency;
      } else {
        queue.add(frequency - k);
        k = 0;
      }
    }
    return queue.size();
  }
}
