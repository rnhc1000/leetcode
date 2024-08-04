package org.ferreiras.leetCode;

/**
 *
 547. Number of Provinces
  There are n cities. Some of them are connected, while some are not.
 If city a is connected directly with city b, and city b is connected
 directly with city c, then city a is connected indirectly with city c.

 A province is a group of directly or indirectly connected cities and
 no other cities outside of the group.

 You are given an n x n matrix isConnected where isConnected[i][j] = 1
 if the ith city and the jth city are directly connected, and
 isConnected[i][j] = 0 otherwise.
 Return the total number of provinces.
 */
public class NumberOfProvincesGraph {
  public int findCircleNum(int[][] isConnected) {
    int size = isConnected.length;
    int visited[] = new int[size];
    int provinces = 0;

    for (int i = 0; i < size; i++) {
      if (visited[i] == 0) {
        provinces++;
        dfs(isConnected, visited, i);
      }
    }
    return provinces;
  }

  static void dfs(int[][] connected, int[] visited, int i) {
    int size = connected.length;
    for (int j = 0; j < size; j++) {
      if (connected[i][j] == 1 && visited[j] == 0) {
        visited[j] = 1;
        dfs(connected, visited, j);
      }
    }
  }
}
