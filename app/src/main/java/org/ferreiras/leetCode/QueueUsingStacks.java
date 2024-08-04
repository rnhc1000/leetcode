package org.ferreiras.leetCode;

import java.util.Stack;

/**
 * Implement a first in first out (FIFO) queue using only two stacks.
 * The implemented queue should support all the functions of a normal
 * queue (push, peek, pop, and empty).
 * Implement the MyQueue class:
 * void push(int x) Pushes element x to the back of the queue.
 * int pop() Removes the element from the front of the queue and returns it.
 * int peek() Returns the element at the front of the queue.
 * boolean empty() Returns true if the queue is empty, false otherwise.
 * Notes:
 * You must use only standard operations of a stack, which means only push to top,
 * peek/pop from top, size, and is empty operations are valid.
 * Depending on your language, the stack may not be supported natively.
 * You may simulate a stack using a list or deque (double-ended queue) as long as
 * you use only a stack's standard operations.
 * Example 1:
 * Input
 * ["MyQueue", "push", "push", "peek", "pop", "empty"]
 * [[], [1], [2], [], [], []]
 * Output
 * [null, null, null, 1, 1, false]
 */

public class QueueUsingStacks {
  static class MyQueue {

    private Stack<Integer> stackOne;
    private Stack<Integer> stackTwo;

    public MyQueue() {
      stackOne = new Stack<>();
      stackTwo = new Stack<>();
    }

    public void push(int x) {
      while (!stackOne.isEmpty()) {
        stackTwo.push(stackOne.pop());
      }
      stackOne.push(x);
      while (!stackTwo.isEmpty()) {
        stackOne.push(stackTwo.pop());
      }
    }

    public int pop() {
      if (stackOne.isEmpty()) return 0;
      return stackOne.pop();
    }

    public int peek() {
      return stackOne.peek();
    }

    public boolean empty() {
      return stackOne.isEmpty();
    }
  }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */
