package org.ferreiras.leetcode;
/*
 Find the Maximum Sum of Node Values
Hard

106

17

Add to List

Share
There exists an undirected tree with n nodes numbered 0 to n - 1.
You are given a 0-indexed 2D integer array edges of length n - 1, where edges[i] = [ui, vi]
indicates that there is an edge between nodes ui and vi in the tree.
You are also given a positive integer k, and a 0-indexed array of non-negative integers nums of
length n, where nums[i] represents the value of the node numbered i.

Alice wants the sum of values of tree nodes to be maximum, for which Alice can perform the following
operation any number of times (including zero) on the tree:

Choose any edge [u, v] connecting the nodes u and v, and update their values as follows:
nums[u] = nums[u] XOR k
nums[v] = nums[v] XOR k
Return the maximum possible sum of the values Alice can achieve by performing the operation any
number of times.

Example 1:


Input: nums = [1,2,1], k = 3, edges = [[0,1],[0,2]]
Output: 6
Explanation:
Alice can achieve the maximum sum of 6 using a single operation:
- Choose the edge [0,2]. nums[0] and nums[2] become: 1 XOR 3 = 2, and the array nums becomes: [1,2,1] -> [2,2,2].
The total sum of values is 2 + 2 + 2 = 6.
It can be shown that 6 is the maximum achievable sum of values.

Example 2:

Input: nums = [2,3], k = 7, edges = [[0,1]]
Output: 9
Explanation: Alice can achieve the maximum sum of 9 using a single operation:
- Choose the edge [0,1]. nums[0] becomes: 2 XOR 7 = 5 and nums[1] become: 3 XOR 7 = 4, and the array nums becomes: [2,3] -> [5,4].
The total sum of values is 5 + 4 = 9.
It can be shown that 9 is the maximum achievable sum of values.

Example 3:

Input: nums = [7,7,7,7,7,7], k = 3, edges = [[0,1],[0,2],[0,3],[0,4],[0,5]]
Output: 42
Explanation: The maximum achievable sum is 42 which can be achieved by Alice performing no operations.


Constraints:

2 <= n == nums.length <= 2 * 104
1 <= k <= 109
0 <= nums[i] <= 109
edges.length == n - 1
edges[i].length == 2
0 <= edges[i][0], edges[i][1] <= n - 1
The input is generated such that edges represent a valid tree.

Intuition https://leetcode.com/bhanu_bhakta
The intuition behind this approach is that XOR operations on elements in the list can either
increase or decrease their values. The goal is to maximize the overall sum after these operations.
By tracking the minimum positive change and the maximum negative change, the solution ensures
that if the count of beneficial operations (positive changes) is odd, we can adjust the sum to
ensure it remains maximized.

Approach
Initialization:

totalSum keeps track of the total sum of elements after potential XOR operations.
count tracks the number of elements that were increased by the XOR operation.
positiveMin is initialized to infinity and will store the minimum positive net change
from the XOR operation.
negativeMax is initialized to negative infinity and will store the maximum negative net change
from the XOR operation.
Iterating Through Elements:

For each element in nums, compute the result of XOR-ing the element with k
(i.e., nodeValAfterOperation = nodeValue ^ k).
Calculate the netChange which is the difference between the XOR-ed value and the original value
(netChange = nodeValAfterOperation - nodeValue).
Updating totalSum:

Add the original value of the element to totalSum.
If the netChange is positive (i.e., the XOR operation results in a higher value),
update positiveMin if this change is the smallest positive change encountered and
add this net change to totalSum.
If the netChange is negative, update negativeMax if this change is the largest negative
change encountered.

Counting Operations:

Increment the count for each positive net change since we are tracking how many elements were
beneficially changed by the XOR operation.

Balancing the Count of Changes:

If the count (number of beneficial changes) is even, return totalSum directly since an even
count of positive changes ensures the sum is maximized.

If the count is odd, we face a dilemma since adding or subtracting an odd number of beneficial
changes can be suboptimal. Hence, we need to decide whether to:

Remove the smallest positive change to make the count even (maximizing totalSum - positiveMin).
Add the largest negative change (potentially minimizing the loss) to balance out the sum
(maximizing totalSum + negativeMax).

Complexity
Time complexity:
O(N)

Space complexity:
O(1)
 */
public class TreeSumOfNodes {
}
