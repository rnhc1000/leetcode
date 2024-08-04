package org.ferreiras.leetCode;

public class StaticChallenge {
  static{
    initialize();
  }
  private static int sum;

  public static int add(int num) {
    sum+=num;
    return sum;
  }
  public static void initialize() {
    sum = 10;
  }

  public static void main(String[] args) {
    StaticChallenge.add(5);
    System.out.println(StaticChallenge.add(4));
  }
}
