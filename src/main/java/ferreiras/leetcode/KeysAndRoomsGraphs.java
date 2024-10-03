package ferreiras.leetcode;

import java.util.*;

/**
 * There are n rooms labeled from 0 to n - 1 and all the rooms are locked except for room 0.
 * Your goal is to visit all the rooms. However, you cannot enter a locked room without
 * having its key.
 * When you visit a room, you may find a set of distinct keys in it. Each key has a number
 * on it, denoting which room it unlocks, and you can take all of them with you to unlock
 * the other rooms.
 * Given an array rooms where rooms[i] is the set of keys that you can obtain if you
 * visited room i, return true if you can visit all the rooms, or false otherwise.
 * Example 1:
 * Input: rooms = [[1],[2],[3],[]]
 * Output: true
 * Explanation:
 * We visit room 0 and pick up key 1.
 * We then visit room 1 and pick up key 2.
 * We then visit room 2 and pick up key 3.
 * We then visit room 3.
 * Since we were able to visit every room, we return true.
 * Example 2:
 * <p>
 * Input: rooms = [[1,3],[3,0,1],[2],[0]]
 * Output: false
 * Explanation:
 * We can not enter room number 2 since the only key that unlocks it is in that room.
 */
public class KeysAndRoomsGraphs {
  public static void main(String[] args) {
    List<List<Integer>> rooms = List.of(
            List.of(1, 3),
            List.of(3, 0, 1,2),
            List.of(2),
            List.of(3)
    );

    boolean response = canVisitRooms(rooms);
    System.out.println(response);

  }

  public static boolean canVisitAllRooms(List<List<Integer>> rooms) {
    Map<Integer, List<Integer>> map = new HashMap<>();
    int room = 0;
    for (List<Integer> list : rooms) {
      map.put(room, list);
      room++;
    }

    System.out.println(map);
    for (Map.Entry<Integer, List<Integer>> entry : map.entrySet()) {


    }
    return false;
  }

  public static boolean canVisitRooms(List<List<Integer>> rooms) {

    Set<Integer> set = new HashSet<>();
    Queue<Integer> queue = new LinkedList<>();
    int n = rooms.size();
    set.add(0);
    for (int i = 0; i < rooms.get(0).size(); i++) {
      set.add(rooms.get(0).get(i));
      queue.offer(rooms.get(0).get(i));
    }

    while (!queue.isEmpty()) {
      int i = queue.remove();
      for (int j = 0; j < rooms.get(i).size(); j++) {
        if (set.add(rooms.get(i).get(j)))
          queue.offer(rooms.get(i).get(j));
      }
      if (set.size() == n) return true;
    }

    return false;
  }
}
