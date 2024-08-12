package org.ferreiras.leetCode;

import java.util.PriorityQueue;

/*
Design a class to find the kth largest element in a stream.
Note that it is the kth largest element in the sorted order, not the kth distinct element.

Implement KthLargest class:

KthLargest(int k, int[] nums) Initializes the object with the integer k and the stream of integers nums.
int add(int val) Appends the integer val to the stream and returns the element representing the kth
largest element in the stream.


Example 1:

Input
["KthLargest", "add", "add", "add", "add", "add"]
[[3, [4, 5, 8, 2]], [3], [5], [10], [9], [4]]
Output
[null, 4, 5, 5, 8, 8]

Explanation
KthLargest kthLargest = new KthLargest(3, [4, 5, 8, 2]);
kthLargest.add(3);   // return 4
kthLargest.add(5);   // return 5
kthLargest.add(10);  // return 5
kthLargest.add(9);   // return 8
kthLargest.add(4);   // return 8


Constraints:

1 <= k <= 104
0 <= nums.length <= 104
-104 <= nums[i] <= 104
-104 <= val <= 104
At most 104 calls will be made to add.
It is guaranteed that there will be at least k elements in the array when you search for the kth element.

Approach
Min-Heap (Priority Queue):

The key idea is to use a min-heap (priority queue) to maintain the k largest elements seen so far.
A min-heap is a binary tree where the root node is the smallest element.
This property allows us to efficiently get the smallest element of the heap in constant time.

Initialization:

During the initialization (KthLargest constructor), we iterate through the given list of numbers (nums).
Each number is added to the min-heap (pq), and if the heap size exceeds k, we remove the smallest element.
This ensures that the heap always contains exactly k elements, representing the k largest elements seen so far.
Adding New Elements:

When a new value is added using the add method, we insert this value into the min-heap.
Again, if the heap size exceeds k, we remove the smallest element to maintain the heap's size.
After adding the new value, the root of the heap (pq.top()) is the kth largest element, as the heap contains
the largest k elements, with the smallest of these being the kth largest overall.
Example Walkthrough
Let's walk through an example to better understand the approach:

Suppose k = 3, and the initial stream of numbers is [4, 5, 8, 2].
After constructing the KthLargest object, we will have the min-heap storing the 3 largest elements: [5, 8, 4]
 (min-heap represented as [4, 5, 8] because 4 is the smallest).
Now, if we add new elements:

Adding 3: The heap becomes [4, 5, 8] after adding 3 and popping the smallest element (3 is ignored since it's smaller than 4).
Adding 5: The heap becomes [5, 5, 8] after adding 5.
Adding 10: The heap becomes [5, 8, 10].
Adding 9: The heap becomes [8, 9, 10].
Adding 4: The heap remains [8, 9, 10].
At each step, the smallest element in the heap is the 3rd largest element in the stream.

Time Complexity
Constructor (KthLargest):

Building the initial heap from n elements takes (O(n log k)) time because each insertion into the heap takes (O(log k)) time and we do this n times.
Adding a New Element (add):

Each call to add takes (O(log k)) time since we may need to adjust the heap after inserting the new element.
This approach is efficient for scenarios where we have a large stream of numbers and need to frequently find the kth largest element.
 */
public class ArrayLargestElementInStream {
  private final int k;
  private final PriorityQueue<Integer> priorityQueue;
     public ArrayLargestElementInStream(int k, int[] nums) {
      this.k = k;
      priorityQueue = new PriorityQueue<>(k);

      for (int num : nums) {
        priorityQueue.offer(num);
        if (priorityQueue.size() > k) priorityQueue.poll();
      }
    }

    public int add(int val) {
      priorityQueue.offer(val);
      if (priorityQueue.size() > k) priorityQueue.poll();
      return priorityQueue.peek();
    }

  public static void main(String[] args) {

       int k = 3;
       int[] nums = {4, 5, 8, 2};
    ArrayLargestElementInStream arrayLargestElementInStream = new ArrayLargestElementInStream(k, nums);
    int response = arrayLargestElementInStream.add(3);
    System.out.println(response);

    /*
    ["KthLargest", "add", "add", "add", "add", "add"]
    {{3, {4, 5, 8, 2}}, {3}, {5}, {10}, {9}, {4}}
    Output
    {null, 4, 5, 5, 8, 8}
     */
  }
}
