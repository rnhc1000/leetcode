package ferreiras.leetcode;
/*
There is a party where n friends numbered from 0 to n - 1 are attending. There is an infinite number of chairs in this party that are numbered from 0 to infinity. When a friend arrives at the party, they sit on the unoccupied chair with the smallest number.

For example, if chairs 0, 1, and 5 are occupied when a friend comes, they will sit on chair number 2.
When a friend leaves the party, their chair becomes unoccupied at the moment they leave. If another friend arrives at that same moment, they can sit in that chair.

You are given a 0-indexed 2D integer array times where times[i] = [arrivali, leavingi], indicating the arrival and leaving times of the ith friend respectively, and an integer targetFriend. All arrival times are distinct.

Return the chair number that the friend numbered targetFriend will sit on.



Example 1:

Input: times = [[1,4],[2,3],[4,6]], targetFriend = 1
Output: 1
Explanation:
- Friend 0 arrives at time 1 and sits on chair 0.
- Friend 1 arrives at time 2 and sits on chair 1.
- Friend 1 leaves at time 3 and chair 1 becomes empty.
- Friend 0 leaves at time 4 and chair 0 becomes empty.
- Friend 2 arrives at time 4 and sits on chair 0.
Since friend 1 sat on chair 1, we return 1.
Example 2:

Input: times = [[3,10],[1,5],[2,6]], targetFriend = 0
Output: 2
Explanation:
- Friend 1 arrives at time 1 and sits on chair 0.
- Friend 2 arrives at time 2 and sits on chair 1.
- Friend 0 arrives at time 3 and sits on chair 2.
- Friend 1 leaves at time 5 and chair 0 becomes empty.
- Friend 2 leaves at time 6 and chair 1 becomes empty.
- Friend 0 leaves at time 10 and chair 2 becomes empty.
Since friend 0 sat on chair 2, we return 2.


Constraints:

n == times.length
2 <= n <= 104
times[i].length == 2
1 <= arrivali < leavingi <= 105
0 <= targetFriend <= n - 1
Each arrivali time is distinct.
now i am creating one priorityQueue to park available chairs.
and one priorityQueue to store the assigned chairs with friends in form of Item class object.
Note:- Assigned priorityQueue is based on endTime as minHeap
you might have question, why priorityQueue for available chairs?
because we have to assign minimum index chair, so min-heap is needed.
I created an array of Item objects named arrival, and added the index of friend, like any i-th
value would be as friend index, here i am keeping chair Index = -1 by default in Item class.
now I am sorting the arrival array based on start time.
now we would traverse through arrival array, lets say we have picked an Item item = arrival[i];
so in this item we have to remove all those values from the Assigned priorityQueue that has below
condition true
while(item.startTime>=assigned.peek().endTime)
why??
because any item having endTime smaller than the startTime would leave the chair so, we would get
free chairs, and will add those chair to available chair PriorityQueue.
once we are coming out of while loop , we would pick a chair from available priorityQueue.
update the chair picked from available to Item object and store the object to assigned.
now check here if the current Item has same friend value as targetFriend index value...===>
if yes ==> return item.chair.
 */

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

public class ArrayUnoccupiedChair {

  public int smallestChair(int[][] times, int targetFriend) {
    Queue<Integer> available = new PriorityQueue<>();
    Queue<Guest> assigned = new PriorityQueue<>((a, b) -> a.endTime - b.endTime);
    Guest[] arrival = new Guest[times.length];

    for (int i = 0; i < times.length; i++) {
      arrival[i] = new Guest(i, times[i][0], times[i][1]);
      available.add(i);
    }

    Arrays.sort(arrival, (a, b) -> a.startTime - b.startTime);

    for (Guest guest : arrival) {
      while (!assigned.isEmpty() && assigned.peek().endTime <= guest.startTime) {
        available.add(assigned.poll().chair);
      }
      guest.setChair(available.remove());
      assigned.add(guest);

      if (guest.friend == targetFriend) {
        return guest.chair;
      }
    }

    return -1;
  }
}

class Guest {
  int friend;
  int chair = -1;
  int startTime;
  int endTime;

  public Guest(int friend, int startTime, int endTime) {
    this.friend = friend;
    this.startTime = startTime;
    this.endTime = endTime;
  }

  public void setChair(int chair) {
    this.chair = chair;
  }
}

