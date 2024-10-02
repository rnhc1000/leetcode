package org.ferreiras.leetcode;

import java.util.ArrayList;
import java.util.List;

/*
You are given an array of strings equations that represent relationships between
variables where each string equations[i] is of length 4 and takes one of two different
forms: "xi==yi" or "xi!=yi".Here, xi and yi are lowercase letters (not necessarily different)
that represent one-letter variable names.

Return true if it is possible to assign integers to variable names so as to satisfy all the
given equations, or false otherwise.

Example 1:

Input: equations = ["a==b","b!=a"]
Output: false
Explanation:
If we assign say, a = 1 and b = 1, then the first equation is satisfied, but not the second.
There is no way to assign the variables to satisfy both equations.

Example 2:
Input: equations = ["b==a","a==b"]
Output: true
Explanation:
We could assign a = 1 and b = 1 to satisfy both equations.


Constraints:

1 <= equations.length <= 500
equations[i].length == 4
equations[i][0] is a lowercase letter.
equations[i][1] is either '=' or '!'.
equations[i][2] is '='.
equations[i][3] is a lowercase letter.
 */
public class EqualityEquations {
  int[] parent = new int[26];
  public int find(int x) {
    // with path compression
    if (parent[x] == x) return x;
    return parent[x] = find(parent[x]);
    // without path compression
    // return parent[x] == x ? x : find(parent[x]);
  }
  public static void main(String[] args) {
    String[] equations = {"a==b","b!=c","c==a"};
    boolean t = equationsPossible(equations);
    System.out.println(t);
  }

  public static boolean equationsPossible(String[] equations) {
    List<List<Character>> list = new ArrayList<>();
    for (String string : equations) {
      List<Character> ll = new ArrayList<>();
      char[] ch = string.toCharArray();
      for (char c : ch) {
        ll.add(c);
      }
      list.add(ll);
    }
    boolean flag = true;
    for (List<Character> c : list) {
      System.out.println(c);

      if (c.get(1) == '!') {
        flag = false;
      }
    }

    return flag;
  }
  public boolean equationPossible(String[] equations) {
    // at the beginning, put each character index in its own group
    // so we will have 26 groups with one character each
    // i.e. 'a' in group 0, 'b' in group 1, ..., 'z' in group 25
    for (int i = 0; i < 26; i++) parent[i] = i;
    for (String e : equations) {
      // if two character is equal,
      if (e.charAt(1) == '=') {
        // e.g. a = b
        // then we group them together
        // how? we use `find` function to find out the parent group of the target character index
        // then update parent. a & b would be in group 1 (i.e. a merged into the group where b belongs to)
        // or you can also do `parent[find(e.charAt(3)- 'a')] = find(e.charAt(0) - 'a');` (i.e. b merged into the group where a belongs to)
        parent[find(e.charAt(0)- 'a')] = find(e.charAt(3) - 'a');
      }
    }
    // handle != case
    for (String e : equations) {
      // if two characters are not equal
      // then which means their parent must not be equal
      if (e.charAt(1) == '!' && find(e.charAt(0) - 'a') == find(e.charAt(3) - 'a')) {
        return false;
      }
    }
    return true;
  }
}
