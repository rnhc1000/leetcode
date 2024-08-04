package org.ferreiras.leetCode;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * You are given an integer n. There are n rooms numbered from 0 to n - 1.
 * You are given a 2D integer array meetings where meetings[i] = [starti, endi]
 * means that a meeting will be held during the half-closed time interval [starti, endi).
 * All the values of starti are unique.
 * Meetings are allocated to rooms in the following manner:
 * Each meeting will take place in the unused room with the lowest number.
 * If there are no available rooms, the meeting will be delayed until a room becomes free.
 * The delayed meeting should have the same duration as the original meeting.
 * When a room becomes unused, meetings that have an earlier original start time should be
 * given the room.
 * Return the number of the room that held the most meetings. If there are multiple rooms,
 * return the room with the lowest number.
 * A half-closed interval [a, b) is the interval between a and b including a and not including b.
 * Example 1:
 * Input: n = 2, meetings = [[0,10],[1,5],[2,7],[3,4]]
 * Output: 0
 * Explanation:
 * - At time 0, both rooms are not being used. The first meeting starts in room 0.
 * - At time 1, only room 1 is not being used. The second meeting starts in room 1.
 * - At time 2, both rooms are being used. The third meeting is delayed.
 * - At time 3, both rooms are being used. The fourth meeting is delayed.
 * - At time 5, the meeting in room 1 finishes.
 * The third meeting starts in room 1 for the time period [5,10).
 * - At time 10, the meetings in both rooms finish. The fourth meeting starts in room 0 for the time period [10,11).
 * Both rooms 0 and 1 held 2 meetings, so we return 0.
 * Example 2:
 * Input: n = 3, meetings = [[1,20],[2,10],[3,5],[4,9],[6,8]]
 * Output: 1
 * Explanation:
 * - At time 1, all three rooms are not being used. The first meeting starts in room 0.
 * - At time 2, rooms 1 and 2 are not being used. The second meeting starts in room 1.
 * - At time 3, only room 2 is not being used. The third meeting starts in room 2.
 * - At time 4, all three rooms are being used. The fourth meeting is delayed.
 * - At time 5, the meeting in room 2 finishes. The fourth meeting starts in room 2 for
 * the time period [5,10).
 * - At time 6, all three rooms are being used. The fifth meeting is delayed.
 * - At time 10, the meetings in rooms 1 and 2 finish. The fifth meeting starts in room 1 for
 * the time period [10,12).
 * Room 0 held 1 meeting while rooms 1 and 2 each held 2 meetings, so we return 1.
 * Constraints:
 * 1 <= n <= 100
 * 1 <= meetings.length <= 105
 * meetings[i].length == 2
 * 0 <= starti < endi <= 5 * 105
 * All the values of starti are unique.
 * Intuition inspired by:
 * <a href="https://leetcode.com/Mazhar_MIK/">...</a>
 */
public class MeetingRoom3 {
  public static void main(String[] args) {
    int[][] meetings = {
            {1, 20},
            {2, 10},
            {3, 5},
            {4, 9},
            {6, 8}
    };
    int n = 2;
    int r = mostBooked(n, meetings);
    System.out.println(r);
  }

  public static int mostBooked(int n, int[][] meetings) {
    // sort by starting time of meetings
    Arrays.sort(meetings, (x, y) -> Integer.compare(x[0], y[0]));

    // Each room is used 0 times in the beginning
    int[] roomsUsedCount = new int[n];

    // To store {earliest room empty time, room No.}
    PriorityQueue<long[]> usedRooms = new PriorityQueue<>((x, y) -> Long.compare(x[0], y[0]));

    // To store rooms that are used
    PriorityQueue<Integer> unusedRooms = new PriorityQueue<>();
    for (int room = 0; room < n; room++) {
      unusedRooms.add(room); // All rooms are unused in the beginning
    }

    for (int[] meet : meetings) {
      int start = meet[0];
      int end = meet[1];

      // First see, by this time, which rooms can be empty now
      // And move them to unusedRooms
      while (!usedRooms.isEmpty() && usedRooms.peek()[0] <= start) {
        int room = (int) usedRooms.poll()[1];
        unusedRooms.add(room);
      }

      if (!unusedRooms.isEmpty()) {
        int room = unusedRooms.poll();
        usedRooms.add(new long[]{end, room});
        roomsUsedCount[room]++;
      } else { // We don't have any room available now. Pick the earliest end room
        int room = (int) usedRooms.peek()[1];
        long endTime = usedRooms.poll()[0];
        usedRooms.add(new long[]{endTime + (end - start), room});
        roomsUsedCount[room]++;
      }
    }

    int resultRoom = -1;
    int maxUse = 0;
    for (int room = 0; room < n; room++) {
      if (roomsUsedCount[room] > maxUse) {
        maxUse = roomsUsedCount[room];
        resultRoom = room;
      }
    }

    return resultRoom;

  }

  public int mostBookedOne(int n, int[][] meetings) {
    Arrays.sort(meetings, (x, y) -> Integer.compare(x[0], y[0]));
    int[] roomsUsedCount = new int[n];
    PriorityQueue<long[]> usedRooms = new PriorityQueue<>((x, y) -> Long.compare(x[0], y[0]));
    PriorityQueue<Integer> unusedRooms = new PriorityQueue<>();
    for (int room = 0; room < n; room++) {
      unusedRooms.add(room);
    }
    for (int[] meeting : meetings) {
      int start = meeting[0];
      int end = meeting[1];
      while (!usedRooms.isEmpty() && usedRooms.peek()[0] <= start) {
        int room = (int) usedRooms.poll()[1];
        unusedRooms.add(room);
      }

      if (!unusedRooms.isEmpty()) {
        int room = unusedRooms.poll();
        usedRooms.add(new long[]{end, room});
        roomsUsedCount[room]++;
      } else {
        int room = (int) usedRooms.peek()[1];
        long endTime = usedRooms.poll()[0];
        usedRooms.add(new long[]{endTime + (end - start), room});
        roomsUsedCount[room]++;
      }
    }

    int resultRoom = -1;
    int maxUse = 0;
    for (int room = 0; room < n; room++) {
      if (roomsUsedCount[room] > maxUse) {
        maxUse = roomsUsedCount[room];
        resultRoom = room;
      }
    }
    return resultRoom;
  }

  public int mostBookedTwo(int n, int[][] meetings) {

    Arrays.sort(meetings, (x, y) -> Integer.compare(x[0], y[0]));
    int[] roomsUsedCount = new int[n];
    long[] roomsAvailable = new long[n];
    for (int[] meeting : meetings) {
      int start = meeting[0];
      int end = meeting[1];
      boolean available = false;
      long freeRoomTime = Long.MAX_VALUE;
      int earlyEndRoom = 0;
      for (int room = 0; room < n; room++) {
        if (roomsAvailable[room] <= start) {
          available = true;
          roomsAvailable[room] = end;
          roomsUsedCount[room]++;
          break;
        }
        if (roomsAvailable[room] < freeRoomTime) {
          earlyEndRoom = room;
          freeRoomTime = roomsAvailable[room];
        }
      }
      if (!available) {
        roomsAvailable[earlyEndRoom] += (end - start);
        roomsUsedCount[earlyEndRoom]++;
      }
    }
    int resultRoom = Integer.MIN_VALUE;
    int maxUse = 0;
    for (int room = 0; room < n; room++) {
      if (roomsUsedCount[room] > maxUse) {
        maxUse = roomsUsedCount[room];
        resultRoom = room;
      }
    }
    return resultRoom;
  }
}
