package org.ferreiras.leetCode;

import java.util.Arrays;
import java.util.List;

public class ListToArrayOfStrings {
  public static void main(String[] args) {
    List<String> list = List.of("Ricardo", "Alves", "Ferreira", "Silva");
    String [] response = listToArray(list);
    System.out.println(Arrays.toString(response));
  }
                        
  public static String[] listToArray(List<String> list) {
    return list.toArray(new String[0]);
  }
}
