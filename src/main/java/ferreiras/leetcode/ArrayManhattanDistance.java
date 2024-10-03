package ferreiras.leetcode;

/*
You are playing a simplified PAC-MAN game on an infinite 2-D grid. You start at the point [0, 0],
and you are given a destination point target = [xtarget, ytarget] that you are trying to get to.
There are several ghosts on the map with their starting positions given as a 2D array ghosts,
where ghosts[i] = [xi, yi] represents the starting position of the ith ghost.
All inputs are integral coordinates.

Each turn, you and all the ghosts may independently choose to either move 1 unit in any of the
four cardinal directions: north, east, south, or west, or stay still. All actions happen simultaneously.

You escape if and only if you can reach the target before any ghost reaches you.
If you reach any square (including the target) at the same time as a ghost, it does not count as an escape.

Return true if it is possible to escape regardless of how the ghosts move, otherwise return false.



Example 1:

Input: ghosts = [[1,0],[0,3]], target = [0,1]
Output: true
Explanation: You can reach the destination (0, 1) after 1 turn, while the ghosts located at (1, 0) and (0, 3) cannot catch up with you.
Example 2:

Input: ghosts = [[1,0]], target = [2,0]
Output: false
Explanation: You need to reach the destination (2, 0), but the ghost at (1, 0) lies between you and the destination.
Example 3:

Input: ghosts = [[2,0]], target = [1,0]
Output: false
Explanation: The ghost can reach the target at the same time as you.


Constraints:

1 <= ghosts.length <= 100
ghosts[i].length == 2
-104 <= xi, yi <= 104
There can be multiple ghosts in the same location.
target.length == 2
-104 <= xtarget, ytarget <= 104

AY73

Approach
For who doesn't manhattan distance

Manhattan distance, represented by abs(x1-x2) + abs(y1-y2), measures the sum of absolute differences
in x and y coordinates between two points in a two-dimensional plane.

For reaching safely, the manhattan distance of the given point should be less than all the ghosts to
target, or else they can reach to the final target before us.

Now what if the distance of all ghosts to target is greater than ours?
Because there is a restriction on ghosts and we can travel only one unit at a time,
wherever they move, we can find some other way, and we can also reach our final
destination without colliding with any of them.

Complexity
Time complexity:O(n)
Space complexity:O(1)
 */
public class ArrayManhattanDistance {

  public static void main(String[] args) {
    int[][] ghosts = {{1, 0}, {0, 3}};
    int[] target = {0, 1};
    boolean response = escapeGhosts(ghosts, target);
    System.out.println(response);
  }

  public static boolean escapeGhosts(int[][] ghosts, int[] target) {
    int value = Math.abs(target[0]) + Math.abs(target[1]);
    for (int[] ghost : ghosts) {
      if (value >= (Math.abs(target[0] - ghost[0]) + Math.abs(target[1] - ghost[1]))) {
        return false;
      }
    }

    return true;
  }
}
