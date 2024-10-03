package ferreiras.leetcode;

import java.util.*;

/*
Graph Data Structure is a collection of nodes connected by edges.
It’s used to represent relationships between different entities.
Graph algorithms are methods used to manipulate and analyze graphs, solving various
problems like finding the shortest path or detecting cycles.

There is a bi-directional graph with n vertices, where each vertex is labeled from 0 to n - 1
(inclusive). The edges in the graph are represented as a 2D integer array edges, where each
edges[i] = [ui, vi] denotes a bi-directional edge between vertex ui and vertex vi.
Every vertex pair is connected by at most one edge, and no vertex has an edge to itself.

You want to determine if there is a valid path that exists from vertex source to vertex destination.

Given edges and the integers n, source, and destination, return true if there is a valid path from
source to destination, or false otherwise.

Example 1:

Input: n = 3, edges = [[0,1],[1,2],[2,0]], source = 0, destination = 2
Output: true
Explanation:
There are two paths from vertex 0 to vertex 2:
- 0 → 1 → 2
- 0 → 2

Example 2:
Input: n = 6, edges = [[0,1],[0,2],[3,5],[5,4],[4,3]], source = 0, destination = 5
Output: false
Explanation:
There is no path from vertex 0 to vertex 5.

Constraints:

1 <= n <= 2 * 105
0 <= edges.length <= 2 * 105
edges[i].length == 2
0 <= ui, vi <= n - 1
ui != vi
0 <= source, destination <= n - 1
There are no duplicate edges.
There are no self edges.
Depth-First Search (DFS)🤓:
Graph Representation:

Construct an adjacency list representation of the graph using the given edges.
This representation allows efficient traversal of nodes and their neighbors.
Depth-First Search (DFS) Function:

Implement a recursive DFS function (dfs) to traverse the graph starting from the source node.
Use a visited set to keep track of nodes that have been visited during the traversal to avoid
revisiting and potential infinite loops (cycles).
Base case:
If the current node being visited is the destination, return True as a path has been found.

Recursive case:
For each neighbor of the current node, if it has not been visited yet, recursively call dfs
on that neighbor.
If any recursive call returns True, propagate True back up through the call stack indicating
that a path to the destination has been found.
If the DFS traversal completes without finding a path to the destination, return False.
 */
public class GraphPathExists {

  public static void main(String[] args) {
    int[][] edges = {
            {0, 1},
            {1, 2},
            {2, 0}
    };
    int n = 3;
    int source = 0, destination = 2;
    boolean response = validPath(n,edges, source, destination);
  }
  public static boolean validPath(int n, int[][] edges, int source, int destination) {
    Map<Integer, List<Integer>> map = new LinkedHashMap<>();
    for (int[] edge : edges) {
      int u = edge[0];
      int v = edge[1];
      map.computeIfAbsent(u, k -> new ArrayList<>()).add(v);
      map.computeIfAbsent(v, k -> new ArrayList<>()).add(u);
    }

    Set<Integer> visited = new HashSet<>();
    return dfs(source, destination, map, visited);
  }

  public static  boolean dfs(int node, int destination, Map<Integer, List<Integer>> map, Set<Integer> visited) {

    if (node == destination) {
      return true;
    }

    visited.add(node);
    for (int neighbor : map.getOrDefault(node, new ArrayList<>())) {

      if (!visited.contains(neighbor)) {
        if (dfs(neighbor, destination, map, visited)) {
          return true;
        }
      }

    }

    return false;
  }

  public boolean validPaths(int n, int[][] edges, int source, int destination) {
    Map<Integer, List<Integer>> graph = new HashMap<>();
    for (int[] edge : edges) {
      int u = edge[0];
      int v = edge[1];
      graph.computeIfAbsent(u, k -> new ArrayList<>()).add(v);
      graph.computeIfAbsent(v, k -> new ArrayList<>()).add(u);
    }

    int[] distances = new int[n];
    Arrays.fill(distances, Integer.MAX_VALUE);
    distances[source] = 0;

    PriorityQueue<int[]> priorityQueue = new PriorityQueue<>((a, b) -> a[0] - b[0]);
    priorityQueue.offer(new int[] {0, source});

    while (!priorityQueue.isEmpty()) {
      int[] current = priorityQueue.poll();
      int currentDistance = current[0];
      int currentNode = current[1];

      if (currentNode == destination) {
        return true;
      }

      if (currentDistance > distances[currentNode]) {
        continue;
      }

      for (int neighbor : graph.getOrDefault(currentNode, new ArrayList<>())) {
        int distance = currentDistance + 1; // Assuming unweighted graph
        if (distance < distances[neighbor]) {
          distances[neighbor] = distance;
          priorityQueue.offer(new int[] {distance, neighbor});
        }
      }
    }

    return false;
  }
}

