package org.ferreiras.leetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/*
There are a total of numCourses courses you have to take, labeled from 0 to numCourses - 1.
You are given an array prerequisites where prerequisites[i] = [ai, bi] indicates that you
must take course ai first if you want to take course bi.

For example, the pair [0, 1] indicates that you have to take course 0 before you can take course 1.
Prerequisites can also be indirect. If course a is a prerequisite of course b, and course b is a
prerequisite of course c, then course a is a prerequisite of course c.

You are also given an array queries where queries[j] = [uj, vj].
For the jth query, you should answer whether course uj is a prerequisite of course vj or not.

Return a boolean array answer, where answer[j] is the answer to the jth query.


Example 1:

Input: numCourses = 2, prerequisites = [[1,0]], queries = [[0,1],[1,0]]
Output: [false,true]
Explanation:
The pair [1, 0] indicates that you have to take course 1 before you can take course 0.
Course 0 is not a prerequisite of course 1, but the opposite is true.

Example 2:

Input: numCourses = 2, prerequisites = [], queries = [[1,0],[0,1]]
Output: [false,false]
Explanation:
There are no prerequisites, and each course is independent.
Example 3:


Input: numCourses = 3, prerequisites = [[1,2],[1,0],[2,0]], queries = [[1,0],[1,2]]
Output: [true,true]


Constraints:

2 <= numCourses <= 100
0 <= prerequisites.length <= (numCourses * (numCourses - 1) / 2)
prerequisites[i].length == 2
0 <= ai, bi <= n - 1
ai != bi
All the pairs [ai, bi] are unique.
The prerequisites graph has no cycles.
1 <= queries.length <= 104
0 <= ui, vi <= n - 1
ui != vi

Idea

This problem is to check if 2 vertices are connected in directed graph.
Floyd-Warshall O(n^3) is an algorithm that will output the minimum distance of any vertices.
We can modify it to output if any vertices is connected or not.

Complexity:

Time: O(n^3)
Space: O(n^2)
More Floyd-warshall problems:

1334. Find the City With the Smallest Number of Neighbors at a Threshold Distance
 */
public class ArrayCourses {

  public static void main(String[] args) {
    int numCourses = 3;
    int[][]prerequisites = {{1,2}, {1,0}, {2,0}}, queries = {{1,0},{1,2}};

    List<Boolean> response = checkIfPrerequisite(numCourses, prerequisites, queries);
    System.out.println(response);

  }
  public static List<Boolean> checkIfPrerequisite(int numCourses, int[][] prerequisites, int[][] queries) {

    List<Boolean> response = new LinkedList<>();
    if(prerequisites.length == 0) {
      return Arrays.asList(false,false);
    }

    boolean[][] connected = new boolean[numCourses][numCourses];

    for (int[] prerequisite : prerequisites) {

      connected[prerequisite[0]][prerequisite[1]] = true;

    }

    for (boolean[] con : connected) {
      System.out.print("[ ");
      for (boolean b : con) {
        System.out.printf("%b ", b);
      }
      System.out.print("]\n");
    }

    System.out.println(" -------------- ");

    for (int k = 0; k < numCourses; k++)
      for (int i = 0; i < numCourses; i++)
        for (int j = 0; j < numCourses; j++)
          connected[i][j] = connected[i][j] || connected[i][k] && connected[k][j];

    for (int[] query : queries) {
      response.add(connected[query[0]][query[1]]);
    }

    for (boolean[] con : connected) {
      for (boolean b : con) {
        System.out.printf("%b, ", b);
      }
    }
    return response;

  }
}
