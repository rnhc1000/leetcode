package org.ferreiras.leetcode;

import java.util.LinkedList;
import java.util.Queue;

public class RecentCounter {
  private Queue<Integer> requests;
  public RecentCounter() {
    this.requests = new LinkedList<>();
  }
  public int ping(int t) {
    requests.add(t);
    try {
      while (requests.peek() < t - 3000) {
        requests.poll();
      }
    } catch (NullPointerException ex) {
      System.out.println(ex.getMessage());
    }
  return requests.size();
  }

  public static void main(String[] args) {
    RecentCounter recentCounter = new RecentCounter();
  }
}
