package ferreiras.leetcode;

import java.util.*;

/*
 * You are given an m x n binary matrix mat of 1's (representing soldiers)
 * and 0's (representing civilians). The soldiers are positioned in front of the civilians.
 * That is, all the 1's will appear to the left of all the 0's in each row.
 * A row i is weaker than a row j if one of the following is true:
 * The number of soldiers in row i is less than the number of soldiers in row j.
 * Both rows have the same number of soldiers and i < j.
 * Return the indices of the k weakest rows in the matrix ordered from weakest to strongest.
 * Example 1:
 * Input: mat =
 * [[1,1,0,0,0],
 * [1,1,1,1,0],
 * [1,0,0,0,0],
 * [1,1,0,0,0],
 * [1,1,1,1,1]],
 * k = 3
 * Output: [2,0,3]
 * Explanation:
 * The number of soldiers in each row is:
 * - Row 0: 2
 * - Row 1: 4
 * - Row 2: 1
 * - Row 3: 2
 * - Row 4: 5
 * The rows ordered from weakest to strongest are [2,0,3,1,4].
 * Example 2:
 * Input: mat =
 * [[1,0,0,0],
 * [1,1,1,1],
 * [1,0,0,0],
 * [1,0,0,0]],
 * k = 2
 * Output: [0,2]
 * Explanation:
 * The number of soldiers in each row is:
 * - Row 0: 1
 * - Row 1: 4
 * - Row 2: 1
 * - Row 3: 1
 * The rows ordered from weakest to strongest are [0,2,3,1].
 * Constraints:
 * m == mat length
 * n == mat[i].length
 * 2 <= n, m <= 100
 * 1 <= k <= m
 * matrix[i][j] is either 0 or 1.
 */
public class WeakestRowInMatrix {
  public static void main(String[] args) {
    int[][] input = {
            {1, 0},
            {0, 0},
            {1, 0}
//            {1, 1, 0, 0, 0},
//            {1, 1, 1, 1, 0},
//            {1, 0, 0, 0, 0},
//            {1, 1, 0, 0, 0},
//            {1, 1, 1, 1, 1}
    };
    int k = 2;
    int[] response = kWeakestRows(input, k);
    System.out.println(Arrays.toString(response));
  }

  public static int[] kWeakestRows(int[][] mat, int k) {
    Map<Integer, Integer> map = new LinkedHashMap<>();
    int size = mat.length;
    for (int j = 0; j < mat.length; j++) {
      for (int i = 0; i < mat[j].length; i++) {
        if (mat[j][i] == 1) {
          map.put(j, map.getOrDefault((j), 0) + 1);
        }
      }
    }
    System.out.println(map);
    List<Integer> list = new ArrayList<>(map.keySet());
    list.sort(Comparator.comparingInt(map::get));
    int[] weakest = new int[k];
    for (int i = 0; i < k; i++) {
      weakest[i] = list.get(i);
    }
    return weakest;
  }

  public static int[] weakestRows(int[][] mat, int k) {
    Map<Integer, Integer> map = new LinkedHashMap<>();
    int size = mat.length;
    int countSoldiers = 0;
    for (int i = 0; i < size; i++) {
      for (int j = 0; j < mat[i].length; j++) {
        if (mat[i][j] == 1) countSoldiers += 1;
      }
      map.put(i, countSoldiers);
      countSoldiers = 0;
    }
    List<Integer> list = new ArrayList<>(map.keySet());
    list.sort((a, b) -> map.get(a) - map.get(b));
    int[] weakest = new int[k];
    for (int i = 0; i < k; i++) {
      weakest[i] = list.get(i);
    }
    return weakest;
  }

  public static int[] kWeakestRow(int[][] mat, int k) {
    Map<Integer, Integer> map = new LinkedHashMap<>();
    int size = mat.length;
    int soldiers = 0, civilians = 0;
    int countSoldiers;

    for (int j = 0; j < mat.length; j++) {
      for (int i = 0; i < mat[j].length; i++) {
        if (mat[i][j] == 1) {
          map.put(j, map.getOrDefault((j), 0) + 1);
        }
      }
    }
    List<Integer> list = new ArrayList<>(map.keySet());
    System.out.println("Keyset: " + list);
    Collections.sort(list, (a, b) -> map.get(a) - map.get(b));
    System.out.println(list);

//    Map.Entry<Integer, Integer> min = null;
//    for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
//      if (min == null || min.getValue() > entry.getValue()) {
//        min = entry;
//      }
//    }


//    System.out.println("Menor valor: "+ min.getKey());
    int[] values = new int[size];
    final int[] count = {0};
    map.forEach((key, value) -> {
      values[count[0]] = value;
      count[0]++;
    });

    int[] resp = new int[k];
    int j = 0;
    for (int i = 0; i < k; i++) {
      resp[i] = list.get(i);
      j++;
    }
    return resp;
  }
//          for (int i = 0; i < mat.length; i++) {
//    int count = 0;
//    for (int j = 0; j < mat[0].length; j++) {
//      if (mat[i][j] == 1) count++;
//    }
//    map.put(i, count);
//  }
}
