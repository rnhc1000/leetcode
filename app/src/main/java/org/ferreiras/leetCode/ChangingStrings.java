package org.ferreiras.leetCode;

/**
 * Given two strings word1 and word2, return the minimum number of operations
 * required to convert word1 to word2.
 * You have the following three operations permitted on a word:
 * Insert a character
 * Delete a character
 * Replace a character
 * Example 1:
 * Input: word1 = "horse", word2 = "ros"
 * Output: 3
 * Explanation:
 * horse -> rorse (replace 'h' with 'r')
 * rorse -> rose (remove 'r')
 * rose -> ros (remove 'e')
 * Example 2:
 * <p>
 * Input: word1 = "intention", word2 = "execution"
 * Output: 5
 * Explanation:
 * intention -> inention (remove 't')
 * inention -> enention (replace 'i' with 'e')
 * enention -> exention (replace 'n' with 'x')
 * exention -> exection (replace 'n' with 'c')
 * exection -> execution (insert 'u')
 */
public class ChangingStrings {

  public static void main(String[] args) {
    String one = "horse";
    String two = "ros";
    int response = minDistances(one, two);
    System.out.println(response);
  }

  public static int minDistance(String word1, String word2) {
    int sizeOne = word1.length();
    int sizeTwo = word2.length();
    int[][] dp = new int[sizeOne + 1][sizeTwo + 1];

    for (int i = 0; i <= sizeOne; i++) {
      dp[i][0] = i;
    }

    for (int j = 0; j <=sizeTwo; j++) {
      dp[0][j] = j;
    }

    for (int i = 1; i <= sizeOne; i++) {
      for (int j = 1; j <= sizeTwo; j++) {
        if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
          dp[i][j] = dp[i - 1][j - 1];
        } else {
          dp[i][j] = Math.min(dp[i - 1][j - 1], Math.min(dp[i - 1][j], dp[i][j - 1])) + 1;
        }
      }
    }
    return dp[sizeOne][sizeTwo];
  }
  public static int minDistances(String word1, String word2) {
    int m = word1.length();
    int n = word2.length();
    if(m==0)
      return n;
    if(n==0)
      return m;
    int[][] md = new int[m+1][n+1];

    for(int i=0;i<=m;i++){
      for(int j=0;j<=n;j++){
        if(i==0)
          md[i][j]=j;
        else if(j==0)
          md[i][j] = i;
        else if(word1.charAt(i-1)==word2.charAt(j-1))
          md[i][j] = md[i-1][j-1];
        else
          md[i][j] = 1 + Math.min(md[i-1][j-1], Math.min(md[i-1][j], md[i][j-1]));
      }
    }
    return md[m][n];
  }
}


