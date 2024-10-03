package ferreiras.leetcode;
/*
You are given an m x n integer grid accounts where accounts[i][j] is the totalPerCustomer of money
the ith customer has in the jth bank. Return the wealth that the richest customer has.
A customer's wealth is the totalPerCustomer of money they have in all their bank accounts.
The richest customer is the customer that has the maximum wealth.
Input: accounts = [[1,2,3],[3,2,1]]
Output: 6
Input: accounts = [[1,5],[7,3],[3,5]]
Output: 10
 */
public class MaximumWealth {

  public static void main(String[] args) {
    int[][] accounts = {
            {2,8,7},
            {7,1,3},
            {1,9,5}
    };
    int wealthiest = maximumWealth(accounts);
    System.out.println("Wealthiest is Customer: " + wealthiest);
  }
  public static int maximumWealth(int[][] accounts) {

    int totalPerCustomer = 0;
    int maxWealth = Integer.MIN_VALUE;
    for (int[] account : accounts) {
      for (int wealth : account) {
        totalPerCustomer += wealth;
      }
      if(totalPerCustomer > maxWealth) {
        maxWealth = totalPerCustomer;
      }
      totalPerCustomer = 0;
    }
    return maxWealth;
  }
}
