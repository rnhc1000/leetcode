package org.ferreiras.leetcode;

/*
 * We are given an array asteroids of integers representing asteroids in a row.
 * For each asteroid, the absolute value represents its size, and the sign represents
 * its direction (positive meaning right, negative meaning left).
 * Each asteroid moves at the same speed.
 * Find out the state of the asteroids after all collisions.
 * If two asteroids meet, the smaller one will explode.
 * If both are the same size, both will explode.
 * Two asteroids moving in the same direction will never meet.
 * Example 1:
 * Input: asteroids = [5,10,-5]
 * Output: [5,10]
 * Explanation: The 10 and -5 collide resulting in 10. The 5 and 10 never collide.
 * Example 2:
 * Input: asteroids = [8,-8]
 * Output: []
 * Explanation: The 8 and -8 collide exploding each other.
 * Example 3:
 * Input: asteroids = [10,2,-5]
 * Output: [10]
 * Explanation: The 2 and -5 collide resulting in -5. The 10 and -5 collide resulting in 10.
 */

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

@ClassPreamble (
        author = "Ricardo Ferreira",
        date = "10/01/2024",
        currentRevision = 7,
        lastModified = "10/01/2024",
        lastModifiedBy = "Ricardo Ferreira",
        reviewers = {}
)

public class AsteroidsCollision {
  public static void main(String[] args) {
    int[] asteroids = {5, 10, -5};
    List<Integer> response = asteroidsCollision(asteroids);
    System.out.println(response);
  }

  public static List<Integer> asteroidsCollision(int[] asteroids) {
    Deque<Integer> stack = new ArrayDeque<>();
    int count = 0, size = asteroids.length;
    for (int i = 0; i < size - 1; i++) {
      if (asteroids[i] > 0) {
        stack.push(asteroids[i]);
        count++;
      } else if (asteroids[i] == asteroids[i + 1]) {
        stack.pop();
      } else {
        stack.pop();
      }
    }

    return new ArrayList<>(stack);
  }
}



