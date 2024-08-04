package org.ferreiras.leetCode;
/*
 * In a town, there are n people labeled from 1 to n.
 * There is a rumor that one of these people is secretly the town judge.
 * If the town judge exists, then:
 * The town judge trusts nobody.
 * Everybody (except for the town judge) trusts the town judge.
 * There is exactly one person that satisfies properties 1 and 2.
 * You are given an array trust where trust = [[a,i], [b,i]] representing
 * that the person labeled [a][i] trusts the person labeled [b][i].
 * If a trust relationship does not exist in trust array, then such a trust relationship does not exist.
 * Return the label of the town judge if the town judge exists and can be identified, or
 * return -1 otherwise.
 * @param {number} n
 * @param {number[][]} trust
 * @return {number}
 * trust = [[1, 3], [1, 4], [2, 3], [2, 4], [4, 3], [5, 3], [6, 3]];
 */

import java.util.HashMap;
import java.util.Map;

public class TrustJudge {

  public static void main(String[] args) {
//    int[][] trust = {{1, 3}, {1, 4}, {2, 3}, {2, 4}, {4, 3}, {5, 3}, {6, 3}};
//    int n = 6;
//    int[][] trust = {{1, 3}, {1, 4}, {2, 3}};
//    int n = 3;
//    int[][] trust = {{1, 3}, {2, 1}, {4, 3}, {3, 2}};
//    int n = 4;
//    int[][] trust = {{1, 2}, {2, 3}};
//    int n = 2;
    int[][] trust = {{1, 2}};
    int n = 2;
    int judge = judgeTrusted(n, trust);
    if (judge == -1) {
      System.out.println("There is no judge in town!");
    } else {
      System.out.println("The judge is citizen #: " + judge);
    }
  }

  public static int judgeTrusted(int n, int[][] trust) {
    if (n == 1)
      return 1;
    if (trust.length == 0)
      return -1;
    int citizens = n + 1;
    int judge = -1, possibleJudge = -1;
    int[] trustedCount = new int[n + 1];
    Map<Integer, Integer> map = new HashMap<>();

    for (int[] x : trust) {
      map.put(x[0], x[1]);
      // trustedCount for each citizen
      trustedCount[x[1]]++;
    }
        /*
        condition 1 - to be trusted by everyone
        */
    for (int i = 0; i < citizens; i++) {
      if (trustedCount[i] == n - 1) {
        possibleJudge = i;
      }
    }

        /*
        check if the possibleJudge meets the condition #2:
        Do not trust anyone
        */

    for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
      if (!map.containsKey(possibleJudge)) {
        judge = possibleJudge;
        break;
      }
    }
    return judge;
  }
}
