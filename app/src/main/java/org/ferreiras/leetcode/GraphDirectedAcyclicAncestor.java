package org.ferreiras.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/*
You are given a positive integer n representing the number of nodes of a Directed Acyclic Graph (DAG).
The nodes are numbered from 0 to n - 1 (inclusive).

You are also given a 2D integer array edges, where edges[i] = [fromi, toi] denotes that there is a unidirectional
edge from fromi to toi in the graph.

Return a list answer, where answer[i] is the list of ancestors of the ith node, sorted in ascending order.

A node u is an ancestor of another node v if u can reach v via a set of edges.



Example 1:
Input: n = 8, edgeList = [[0,3],[0,4],[1,3],[2,4],[2,7],[3,5],[3,6],[3,7],[4,6]]
Output: [[],[],[],[0,1],[0,2],[0,1,3],[0,1,2,3,4],[0,1,2,3]]
Explanation:
The above diagram represents the input graph.
- Nodes 0, 1, and 2 do not have any ancestors.
- Node 3 has two ancestors 0 and 1.
- Node 4 has two ancestors 0 and 2.
- Node 5 has three ancestors 0, 1, and 3.
- Node 6 has five ancestors 0, 1, 2, 3, and 4.
- Node 7 has four ancestors 0, 1, 2, and 3.

Example 2:
Input: n = 5, edgeList = [[0,1],[0,2],[0,3],[0,4],[1,2],[1,3],[1,4],[2,3],[2,4],[3,4]]
Output: [[],[0],[0,1],[0,1,2],[0,1,2,3]]
Explanation:
The above diagram represents the input graph.
- Node 0 does not have any ancestor.
- Node 1 has one ancestor 0.
- Node 2 has two ancestors 0 and 1.
- Node 3 has three ancestors 0, 1, and 2.
- Node 4 has four ancestors 0, 1, 2, and 3.


Constraints:

1 <= n <= 1000
0 <= edges.length <= min(2000, n * (n - 1) / 2)
edges[i].length == 2
0 <= fromi, toi <= n - 1
fromi != toi
There are no duplicate edges.
The graph is directed and acyclic.

Intuition by https://leetcode.com/suyalneeraj09
The intuition behind the approach is to use a DFS to traverse the graph and find the ancestors of each node.
By starting the DFS from each node and adding the current node to the response list of its children, we ensure
that all the ancestors of a node are recorded in the response list of that node.
The children list is used to keep track of the direct children of each node, which helps in efficiently
traversing the graph during the DFS.

Approach
The approach used in the code is a depth-first search (DFS) to find the ancestors of each node in the graph
represented by the given edges.

Initialize two lists:
response to store the ancestors of each node, and children(dc) to store the direct children of each node.
Iterate through the edges list and add each child node to the children(dc) list of its parent node.
Iterate through the nodes from 0 to n-1 and perform a DFS starting from each node.
In the DFS function, for each child node of the current node, check if the current node is not already present
in the response list of the child node. If not, add the current node to the response list of the child node and
recursively call the DFS function with the child node as the new current node.
Return the response list as the final result.
Complexity
Time complexity:O(V + E)
Space complexity:O(V + E)
 */
public class GraphDirectedAcyclicAncestor {

  public static void main(String[] args) {

    int n = 5;
    int[][] edgeList = {
            {0, 1}, {0, 2}, {0, 3}, {0, 4}, {1, 2}, {1, 3}, {1, 4}, {2, 3}, {2, 4}, {3, 4}
    };

    List<List<Integer>> ancestors = getAncestors(n, edgeList);
    for (List<Integer> ancestor : ancestors) {
      System.out.println(ancestor);
    }

  }

  public List<List<Integer>> getAncestor(int n, int[][] edges) {
    List<List<Integer>> res = new ArrayList<>();
    for (int i = 0; i < n; i++) {
      res.add(new ArrayList<>());
    }

    ArrayList[] graph = new ArrayList[n];
    for (int i = 0; i < n; i++) {
      graph[i] = new ArrayList<>();
    }
    for (int[] edge : edges) {
      graph[edge[0]].add(edge[1]);
    }
    for (int i = 0; i < n; i++) {
      dfs(graph, i, i, res, new boolean[n]);
    }
    return res;
  }

  public void dfs(ArrayList<Integer>[] graph, int parent, int curr, List<List<Integer>> res, boolean[] visit) {
    visit[curr] = true;
    for (int i = 0; i < graph[curr].size(); i++) {
      int dest = graph[curr].get(i);
      if (!visit[dest]) {
        res.get(dest).add(parent);
        dfs(graph, parent, dest, res, visit);
      }
    }
  }

  public static List<List<Integer>> getAncestors(int n, int[][] edges) {
    List<List<Integer>> response = new LinkedList<>();
    List<List<Integer>> children = new LinkedList<>();

    for (int i = 0; i < n; i++) {
      response.add(new ArrayList<>());
      children.add(new ArrayList<>());
    }

    for (int[] edge : edges) {
      children.get(edge[0]).add(edge[1]);
    }

    for (int i = 0; i < n; i++) {
      dfs(i, i, response, children);
    }

    return response;
  }

  public static void dfs(int k, int current, List<List<Integer>> response, List<List<Integer>> children) {

    for (int child : children.get(current)) {
      if (response.get(child).isEmpty() || (response.get(child).get(response.get(child).size() - 1) != k)) {
        response.get(child).add(k);
        dfs(k, child, response, children);
      }

    }
  }

}
