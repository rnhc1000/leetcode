package org.ferreiras.leetCode;

import java.util.Arrays;
import java.util.List;

public class ListToArrayOfIntegers {
  public static void main(String[] args) {
    List<Integer> list = List.of(1,2,3,4,5,6,7,8,9);
    int[] response = listToArray(list);
    System.out.println(Arrays.toString(response));
  }

  public static int[] listToArray(List<Integer> list) {

//    return list.stream().mapToInt(k -> k).toArray();
    return list.stream().mapToInt(Integer::intValue).toArray();
  }
}
