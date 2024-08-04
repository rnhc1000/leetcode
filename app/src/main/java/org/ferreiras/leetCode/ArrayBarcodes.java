package org.ferreiras.leetCode;

import java.util.*;

/*
In a warehouse, there is a row of barcodes, where the ith barcode is barcodes[i].

Rearrange the barcodes so that no two adjacent barcodes are equal.
You may return any answer, and it is guaranteed an answer exists.

Example 1:

Input: barcodes = [1,1,1,2,2,2]
Output: [2,1,2,1,2,1]
Example 2:

Input: barcodes = [1,1,1,1,2,2,3,3]
Output: [1,3,1,3,1,2,1,2]


Constraints:

1 <= barcodes.length <= 10000
1 <= barcodes[i] <= 10000
 */
public class ArrayBarcodes {
  public static void main(String[] args) {
    int[] barcodes = {1, 1, 1, 1, 2, 2, 3, 3};
    int[] response = rearrangeBarcodes(barcodes);
    System.out.println(Arrays.toString(response));
  }

  public static int[] rearrangeBarcode(int[] barcodes) {

    if (barcodes.length < 3) return barcodes;
    Arrays.sort(barcodes);
    LinkedList<Integer> queue = new LinkedList<>();
    int[] response = new int[barcodes.length];
    List<Integer> list = new LinkedList<>();

    for (int i = 0; i < barcodes.length; i++) {
      queue.add(barcodes[i]);
    }
    int j = 0;
    System.out.println(queue);

    while (!queue.isEmpty()) {
      if (!Objects.equals(queue.peekFirst(), queue.peekLast())) {
        list.add(queue.removeFirst());
        list.add(queue.removeLast());
      }
      list.add(queue.remove());
    }
    return list.stream().mapToInt(x -> x).toArray();
  }

  static class BarCode {
    int barcode;
    int freq;

    BarCode(int barcode, int freq) {
      this.barcode = barcode;
      this.freq = freq;
    }

    @Override
    public String toString() {
      return "BarCode{" +
              "barcode=" + barcode +
              ", freq=" + freq +
              '}';
    }
  }
    public static int[] rearrangeBarcodes(int[] barcodes) {

      Map<Integer, Integer> map = new HashMap<>();
      for (int barcode : barcodes) {
        map.put(barcode, map.getOrDefault(barcode, 0) + 1);
      }

      System.out.println(map);

      PriorityQueue<BarCode> priorityQueue = new PriorityQueue<>(
              (a, b) -> b.freq - a.freq
      );

      for (int key : map.keySet()) {
        priorityQueue.offer(new BarCode(key, map.get(key)));
      }

      System.out.println(priorityQueue);
      BarCode prev = null;
      for (int i = 0; i < barcodes.length; i++) {
        BarCode barCode = priorityQueue.poll();
        assert barCode != null;
        barcodes[i] = barCode.barcode;
        barCode.freq--;

        if (prev != null) {
          priorityQueue.offer(prev);
        }
        if (barCode.freq > 0) {
          prev = barCode;
        } else prev = null;
      }

      return barcodes;
    }
  }

