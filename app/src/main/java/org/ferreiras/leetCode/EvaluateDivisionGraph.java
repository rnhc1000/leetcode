package org.ferreiras.leetCode;

import java.util.*;

/**
 * You are given an array of variable pairs equations and an array of real
 * numbers values, where equations[i] = [Ai, Bi] and values[i] represent the
 * equation Ai / Bi = values[i]. Each Ai or Bi is a string that represents a
 * single variable.
 * You are also given some queries, where queries[j] = [Cj, Dj] represents the
 * jth query where you must find the answer for Cj / Dj = ?.
 * Return the answers to all queries. If a single answer cannot be determined,
 * return -1.0.
 * Note: The input is always valid. You may assume that evaluating the queries
 * will not result in division by zero and that there is no contradiction.
 * Note: The variables that do not occur in the list of equations are undefined,
 * so the answer cannot be determined for them.
 * Example 1:
 * Input: equations = [["a","b"],["b","c"]], values = [2.0,3.0],
 * queries = [["a","c"],["b","a"],["a","e"],["a","a"],["x","x"]]
 * Output: [6.00000,0.50000,-1.00000,1.00000,-1.00000]
 * Explanation:
 * Given: a / b = 2.0, b / c = 3.0
 * queries are: a / c = ?, b / a = ?, a / e = ?, a / a = ?, x / x = ?
 * return: [6.0, 0.5, -1.0, 1.0, -1.0 ]
 * note: x is undefined => -1.0
 * Example 2:
 * Input: equations = [["a","b"],["b","c"],["bc","cd"]],
 * values = [1.5,2.5,5.0],
 * queries = [["a","c"],["c","b"],["bc","cd"],["cd","bc"]]
 * Output: [3.75000,0.40000,5.00000,0.20000]
 * Example 3:
 * Input: equations = [["a","b"]], values = [0.5],
 * queries = [["a","b"],["b","a"],["a","c"],["x","y"]]
 * Output: [0.50000,2.00000,-1.00000,-1.00000]
 */
public class EvaluateDivisionGraph {
  public static void main(String[] args) {
    List<List<String>> equations = List.of(
            List.of("a","b"),
            List.of("b","c"),
            List.of("bc","cd")
    );

    List<List<String>> queries = List.of(
            List.of("a","c"),
            List.of("c","b"),
            List.of("bc","cd"),
            List.of("cd","bc")
    );

    double[] values = {1.5,2.5,5.0};

    double[] response = calcEquation(equations,values, queries);

    for (double d: response) {
      System.out.print(d + " ");
    }

  }
  public static double[] calcEquation(List<List<String>> equations, double[] values,
                                      List<List<String>> queries) {

    int sizeQueries = queries.size();
    int sizeEquations = equations.size();
    double[] response = new double[queries.size()];
    Map<String, Map<String, Double>> adjacentList = new HashMap<>();
    for (int i = 0; i < sizeEquations; ++i) {
      final String A = equations.get(i).get(0);
      final String B = equations.get(i).get(1);
      adjacentList.putIfAbsent(A, new HashMap<>());
      adjacentList.putIfAbsent(B, new HashMap<>());
      adjacentList.get(A).put(B, values[i]);
      adjacentList.get(B).put(A, 1.0 / values[i]);
    }
    for (int i = 0; i < sizeQueries; ++i) {
      final String A = queries.get(i).get(0);
      final String C = queries.get(i).get(1);
      if (!adjacentList.containsKey(A) || !adjacentList.containsKey(C))
        response[i] = -1.0;
      else
        response[i] = divide(adjacentList, A, C, new HashSet<>());
    }

    return response;
  }
  private static double divide(Map<String, Map<String, Double>> adjacentList,
                               final String A,
                               final String C,
                               Set<String> seen) {
    if (A.equals(C))
      return 1.0;
    seen.add(A);
    for (final String B : adjacentList.get(A).keySet()) {
      if (seen.contains(B))
        continue;
      final double result = divide(adjacentList, B, C, seen);
      if (result > 0)
        return adjacentList.get(A).get(B) * result;
    }
    return -1.0;
  }
}
