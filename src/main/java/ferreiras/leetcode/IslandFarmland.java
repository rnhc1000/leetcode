package ferreiras.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
You are given a 0-indexed m x n binary matrix land where a 0 represents a hectare of forested land
and a 1 represents a hectare of farmland.

To keep the land organized, there are designated rectangular areas of hectares that consist entirely
of farmland. These rectangular areas are called groups. No two groups are adjacent, meaning farmland
in one group is not four-directionally adjacent to another farmland in a different group.

land can be represented by a coordinate system where the top left corner of land is (0, 0) and the
bottom right corner of land is (m-1, n-1). Find the coordinates of the top left and bottom right
corner of each group of farmland. A group of farmland with a top left corner at (r1, c1) and a
bottom right corner at (r2, c2) is represented by the 4-length array [r1, c1, r2, c2].

Return a 2D array containing the 4-length arrays described above for each group of farmland in land.
If there are no groups of farmland, return an empty array.
You may return the answer in any order.

Example 1:

Input: land = [[1,0,0],[0,1,1],[0,1,1]]
Output: [[0,0,0,0],[1,1,2,2]]
Explanation:
The first group has a top left corner at land[0][0] and a bottom right corner at land[0][0].
The second group has a top left corner at land[1][1] and a bottom right corner at land[2][2].
Example 2:


Input: land = [[1,1],[1,1]]
Output: [[0,0,1,1]]
Explanation:
The first group has a top left corner at land[0][0] and a bottom right corner at land[1][1].

Example 3:
Input: land = [[0]]
Output: []
Explanation:
There are no groups of farmland.


Constraints:

m == land.length
n == land[i].length
1 <= m, n <= 300
land consists of only 0's and 1's.
Groups of farmland are rectangular in shape.
 */
public class IslandFarmland {
  static int land_k, land_j;

  public static void dfs(int[][] land, int i, int j) {

    if (i == land.length || j == land[0].length || land[i][j] == 0) {

      return;

    }
    land[i][j] = 0;

    land_k = Math.max(i, land_k);

    land_j = Math.max(j, land_j);

    dfs(land, i + 1, j);
    dfs(land, i, j + 1);

  }

  public static int[][] findFarmland(int[][] land) {

    List<List<Integer>> lists = new ArrayList<>();

    for (int i = 0; i < land.length; i++) {

      for (int j = 0; j < land[0].length; j++) {

        if (land[i][j] == 1) {
          land_k = i;
          land_j = j;
          dfs(land, i, j);
          List<Integer> list = new ArrayList<>();
          list.add(i);
          list.add(j);
          list.add(land_k);
          list.add(land_j);
          lists.add(list);
        }

      }
    }

    int size = lists.size();

    int[][] response = new int[size][4];

    int index = 0;

    for (List<Integer> list : lists) {
      response[index][0] = list.get(0);
      response[index][1] = list.get(1);
      response[index][2] = list.get(2);
      response[index][3] = list.get(3);
      index++;
    }

    return response;
  }

  public static void main(String[] args) {
    int[][] land = {
            {1, 0, 0},
            {0, 1, 1},
            {0, 1, 1}
    };
    int[][] response = findFarmland(land);

    for (int[] l : response) {
      System.out.println(Arrays.toString(l));
    }
  }
}
