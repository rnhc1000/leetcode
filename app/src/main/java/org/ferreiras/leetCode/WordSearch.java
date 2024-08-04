package org.ferreiras.leetCode;
/*
Given an m x n grid of characters board and a string word, return true if word exists in the grid.

The word can be constructed from letters of sequentially adjacent cells,
where adjacent cells are horizontally or vertically neighboring.
The same letter cell may not be used more than once.



Example 1:

Input:
board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCCED"
Output:
true

Example 2:
Input:
board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "SEE"
Output:
true

Example 3:
Input:
board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCB"
Output: false

Constraints:

m == board.length
n = board[i].length
1 <= m, n <= 6
1 <= word.length <= 15
board and word consists of only lowercase and uppercase English letters.
 */
public class WordSearch {

  public static void main(String[] args) {
    char[][] c = {
            {'A','B','C','E'},
            {'S','F','C','S'},
            {'A','D','E','E'}
    };
    String word = "ABCCED";
    boolean flag = exist(c, word);
    System.out.println(flag);
  }
  public static boolean exist(char[][] board, String word) {
    char[] ch = word.toCharArray();
    int n = board.length, m = board[0].length, c = ch.length;
    boolean[][] dp = new boolean[n][m];
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        if (board[i][j] == ch[0]) {
          if (helper(i, j, 0, ch, board, dp, n, m, c))
            return true;
        }
      }
    }

    return false;
  }

  private static boolean helper(int i, int j, int pos, char[] s, char[][] board, boolean[][] dp, int n, int m, int l) {
    if (i >= n || i < 0 || j >= m || j < 0 || dp[i][j] || pos >= l || board[i][j] != s[pos])
      return false;
    if (pos == l - 1)
      return true;
    dp[i][j] = true;
    if (helper(i - 1, j, pos + 1, s, board, dp, n, m, l)
            || helper(i, j + 1, pos + 1, s, board, dp, n, m, l)
            || helper(i + 1, j, pos + 1, s, board, dp, n, m, l)
            || helper(i, j - 1, pos + 1, s, board, dp, n, m, l))
      return true;
    dp[i][j] = false;

    return false;
  }
}
