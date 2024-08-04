package org.ferreiras.leetCode;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * In a town, there are n people labeled from 1 to n. There is a rumor that one of these
 * people is secretly the town judge.
 * <p>
 * If the town judge exists, then:
 * <p>
 * The town judge trusts nobody.
 * Everybody (except for the town judge) trusts the town judge.
 * There is exactly one person that satisfies properties 1 and 2.
 * You are given an array trust where trust[i] = [ai, bi] representing that the person labeled
 * ai trusts the person labeled bi. If a trust relationship does not exist in trust array,
 * then such a trust relationship does not exist.
 * Return the label of the town judge if the town judge exists and can be identified, or return -1 otherwise.
 * Example 1:
 * Input: n = 2, trust = [[1,2]]
 * Output: 2
 * Example 2:
 * Input: n = 3, trust = [[1,3],[2,3]]
 * Output: 3
 * Example 3:
 * Input: n = 3, trust = [[1,3],[2,3],[3,1]]
 * Output: -1
 * Intuition by
 * <a href="https://leetcode.com/niits/">...</a>
 * Approach
 * We have two conditions.
 * 1. The town judge trusts nobody.
 * 2. Everybody (except for the town judge) trusts the town judge.
 * From condition 2, town judge has n - 1 trust, so it's good idea to count number of trust for each person.
 * Input: n = 3, trust = [[1,3],[2,3],[3,1]]
 * Let's see one by one. We use array to keep number of trust for each person. Since the description says "peoplelabeled from 1 to n", so we use index from 1 to 3. That's why we need n + 1 for the array. Let's say trusted for the array.
 * trusted = [0,0,0,0]
 * In each element, trusted person is index 1, so add +1 to corresponding index number.
 * We have 3, 3 and 1. In the end trusted should be
 * trusted = [0,1,0,2]
 * As I told you, town judge has n - 1 trust. In this case, 2. We have 2 at index 3.
 * That's why we should return 3 in this case?
 * That is wrong.
 * Why? That's because person 3 trusts person 1 which doesn't meet condtion 1,
 * "The town judge trusts nobody".
 * How can we avoid this problem?
 * There are several ways to avoid this but I think the simplest strategy is to add -1
 * to corresponding number from index 0 in each element.
 * <p>
 * Let's update trusted from beginning.
 * <p>
 * Input: n = 3, trust = [[1,3],[2,3],[3,1]]
 * trusted = [0,0,0,0]
 * First of all, we found 1 and 3, so add -1 to index 1 in trusted and add +1 to index 3
 * in trusted
 * <p>
 * trusted = [0,-1,0,1]
 * Next, we found 2 and 3, so add -1 to index 2 in trusted and add +1 to index 3 in trusted
 * <p>
 * trusted = [0,-1,-1,2]
 * Next, we found 3 and 1, so add -1 to index 3 in trusted and add +1 to index 1 in trusted
 * trusted = [0,0,-1,1]
 * Then check if somebody has n - 1 trust. Nobody has n - 1, so
 * return -1
 * Points
 * Adding -1 enables us to return a right answer in the situation where somebody gets n - 1 trust but that guy trusts other person.
 * Because even if we add -1 to trusted, number of trust for the town judge is not changed (= n - 1). If changed, that means that guy trusts somebody which means it breaks condition 1.
 * Approach
 * We have two conditions.
 * 1. The town judge trusts nobody.
 * 2. Everybody (except for the town judge) trusts the town judge.
 * From condition 2, town judge has n - 1 trust, so it's good idea to count number of
 * trust for each person.
 * Input: n = 3, trust = [[1,3],[2,3],[3,1]]
 * Let's see one by one. We use array to keep number of trust for each person.
 * Since the description says "peoplelabeled from 1 to n", so we use index from 1 to 3.
 * That's why we need n + 1 for the array. Let's say trusted for the array.
 * trusted = [0,0,0,0]
 * In each element, trusted person is index 1, so add +1 to corresponding index number.
 * We have 3, 3 and 1. In the end trusted should be
 * trusted = [0,1,0,2]
 * As I told you, town judge has n - 1 trust. In this case, 2. We have 2 at index 3.
 * That's why we should return 3 in this case?
 * That is wrong.
 * Why? That's because person 3 trusts person 1 which doesn't meet condtion 1,
 * "The town judge trusts nobody".
 * How can we avoid this problem?
 * There are several ways to avoid this but I think the simplest strategy is to
 * add -1 to corresponding number from index 0 in each element.
 * Let's update trusted from beginning.
 * Input: n = 3, trust = [[1,3],[2,3],[3,1]]
 * trusted = [0,0,0,0]
 * First of all, we found 1 and 3, so add -1 to index 1 in trusted and add +1
 * to index 3 in trusted
 * trusted = [0,-1,0,1]
 * Next, we found 2 and 3, so add -1 to index 2 in trusted and add +1 to index 3 in trusted
 * trusted = [0,-1,-1,2]
 * Next, we found 3 and 1, so add -1 to index 3 in trusted and add +1 to index 1 in trusted
 * trusted = [0,0,-1,1]
 * Then check if somebody has n - 1 trust. Nobody has n - 1, so
 * return -1
 * Points
 * Adding -1 enables us to return a right answer in the situation where somebody gets n - 1
 * trust but that guy trusts other person.
 * Because even if we add -1 to trusted, number of trust for the town judge is not changed (= n - 1).
 * If changed, that means that guy trusts somebody which means it breaks condition 1.
 */
public class FindJudge {
  public static void main(String[] args) {
    int[][] trust = {
            {1, 3},
            {2, 3},
            {3, 1}
    };
    int n = 3;
    System.out.println(findJudge(n, trust));
  }

  public static int findJudge(int n, int[][] trust) {

    Map<Integer,Integer> map = new HashMap<>();
      int[] trusted = new int[n + 1];

      for (int[] pair : trust) {
        trusted[pair[0]] -= 1;
        trusted[pair[1]] += 1;
      }

      for (int i = 1; i <= n; i++) {
        if (trusted[i] == n - 1) {
          return i;
        }
      }

      return -1;
    }
}
