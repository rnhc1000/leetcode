package org.ferreiras.leetcode;
/*
 * There are n cities numbered from 0 to n - 1 and n - 1 roads such that there is
 * only one way to travel between two different cities (this network form a tree).
 * Last year, The ministry of transport decided to orient the roads in one direction
 * because they are too narrow.
 * Roads are represented by connections where connections[i] = [ai, bi] represents a
 * road from city ai to city bi.
 * This year, there will be a big event in the capital (city 0), and many people want
 * to travel to this city.
 * Your task consists of reorienting some roads such that each city can visit the city 0.
 * Return the minimum number of edges changed.
 * It's guaranteed that each city can reach city 0 after reorder.
 * Input:
 * n = 6, connections = [[0,1],[1,3],[2,3],[4,0],[4,5]]
 * Output:
 * 3
 * Explanation: Change the direction of edges show in red such that each node can
 * reach the node 0 (capital).
 * Input: n = 5, connections = [[1,0],[1,2],[3,2],[3,4]]
 * Output: 2
 * Explanation: Change the direction of edges show in red such that each node can
 * reach the node 0 (capital).
 * Example 3:
 * Input: n = 3, connections = [[1,0],[2,0]]
 * Output: 0
 */

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class ReorderRoutes {
  public static void main(String[] args) {
    int n = 6;
    int[][] connections = {
            {0,1},
            {1,3},
            {2,3},
            {4,0},
            {4,5}
    };
    int response = minReorder(n, connections);
    System.out.println(response);
  }
  public static int  dfs(List<List<Integer>> al, boolean[] visited, int from) {
    int change = 0;
    visited[from] = true;
    for (var to : al.get(from))
      if (!visited[Math.abs(to)])
        change += dfs(al, visited, Math.abs(to)) + (to > 0 ? 1 : 0);
    return change;
  }

  public static int minReorder(int n, int[][] connections) {
    List<List<Integer>> adjList = new ArrayList<>();
    for (int i = 0; i < n; i++) {
      adjList.add(new ArrayList<>());
    }

    for (int i = 0; i < connections.length; i++) {
      adjList.get(connections[i][0]).add(connections[i][1]);
      adjList.get(connections[i][1]).add(-connections[i][0]);
    }

    int counter = 0;
    int[] visited = new int[n];
    Queue<Integer> queue = new LinkedList<>();
    queue.add(0);
    visited[0] = 1;
    while (!queue.isEmpty()) {
      int node = queue.poll();
      for (int city : adjList.get(Math.abs(node))) {
        if (visited[Math.abs(city)] == 0) {
          visited[Math.abs(city)] = 1;
          queue.add(city);
          if (city > 0)
            counter++;
        }
      }
    }

    return counter;
  }
}
