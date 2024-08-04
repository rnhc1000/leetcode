package org.ferreiras.leetCode;
/**
 * Intuition
 * Question is very badly explained, so let me explain in simple words.
 * <p>
 * Lets Consider [100,80,70,75,85]
 * Question asks us to find the span of that stock's price for the current day.
 * So starting from the 0 th index, we consider 100 as the current day price. So we need to find the previous highest price so their no previous data so it will be 1.
 * On the 1st index (80) the previous highest price is 100, so span will be 1 and return 1.
 * On the 2nd index (70) the previous highest price is 80, so span will be 1 and return 1.
 * On the 3rd index (75) the previous highest price is 80, so span will be 2 and return 2.
 * On the 4th index (85) the previous highest price is 75, so span will be 4 and return 4.
 * The output will look like [1,1,1,2,4]
 * Input:
 * ["StockSpanner","next","next","next","next","next"]
 * [ [ ],[100],[80],[70],[75],[85]]
 * <p>
 * Output:
 * [null,1,1,1,2,4]
 * <p>
 * Approach
 * The StockSpanner class has a stack of pairs of integers, where the first
 * integer represents the stock price, and the second integer represents the
 * span of that price.
 * The constructor of the class does not take any arguments and does not do
 * anything.
 * The next() method of the class takes an integer argument price, which represents
 * the price of the stock for the current day, and returns an integer representing
 * the span of that price.
 * Initially, the span is set to 1.
 * If the stack is not empty and the top of the stack has a price less than or equal
 * to the current price, then the span is increased by the span of the top of the stack,
 * and the top of the stack is popped.
 * The pair of the current price and its span is pushed onto the stack.
 * Finally, the span of the current price is returned.
 * Complexity:
 * The time complexity of the next function is O(N), where N is the number of calls to
 * next. This is because in the worst case, all the elements in the stack will be popped
 * out before the current price is pushed onto the stack.
 * The space complexity of the algorithm is O(N), as we are storing all the prices and
 * their corresponding span values in the stack.
 */

import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;

@ClassPreamble (
        author = "Ricardo Ferreira",
        date = "2024-01-17",
        currentRevision = 1,
        lastModified = "2024-01-17",
        lastModifiedBy = "Ricardo Ferreira",
        reviewers = {},
        description = """
                Code to find out max span
                over a sliding window,
                using Queue.
                """
)
public class OnLineStockSpan {
  static class StockSpanner {
    Queue<int[]> q;

    public StockSpanner() {
      q = new PriorityQueue<>();
    }

    public int next(int price) {
      int span = 1;
      while (!q.isEmpty() && q.peek()[0] <= price) {
        span += q.remove()[1];
      }
      q.offer(new int[]{price, span});
      return span;
    }
  }

  static class StockSpanners {
    Stack<int[]> st;

    public StockSpanners() {
      st = new Stack<>();
    }

    public int next(int price) {
      int span = 1;
      while (!st.isEmpty() && st.peek()[0] <= price) {
        span += st.pop()[1];
      }
      st.push(new int[]{price, span});
      return span;
    }
  }
}

