package org.ferreiras.leetcode;
/*
 * @(#)HandlingHashMap.java
 * @author  Ricardo Ferreira
 * @version 1.0
 * @since   2024-01-01
 * Copyright (c) 2005-2024 Datagen1x.
 * Santo Agapito, 7, Imperatriz - MA, BR.
 * All rights reserved.
 * @param Given a list of Students and grades
 * @return Student with the largest average.
 *
 * Given an array of grades and respective students
 * return the student and best grade.
 */

import java.util.HashMap;
import java.util.Map;
@ClassPreamble(
        author = "Ricardo Ferreira",
        date = "10/01/2024",
        currentRevision = 7,
        lastModified = "10/01/2024",
        lastModifiedBy = "Ricardo Ferreira",
        reviewers = {}
)
public class BestAverage {
  public static void main(String... args) {
    String[][] averages = {
            {"John", "96"},
            {"Peter", "98"},
            {"Mark", "100"},
            {"John", "100"},
            {"Mark", "95"},
            {"Isabel", "100"},
            {"Isabel", "97"},
            {"Peter", "100"}
    };
    Map<String, Integer> response = bestAverage(averages);
    System.out.printf("Best Average: " + response);
  }

  public static Map<String, Integer> bestAverage(String[][] averages) {

    Map<String, Integer> map = new HashMap<>();
    int bestAverage = Integer.MIN_VALUE;

    for (String[] average : averages) {

      if (!map.containsKey(average[0])) {
        map.put(average[0], Integer.valueOf(average[1]));
      } else {
        map.put(average[0], map.getOrDefault((average[0]), 0) + Integer.parseInt(average[1]));
      }

    }
    String winner = "";
    Map<String, Integer> theBest = new HashMap<>();
    for (Map.Entry<String, Integer> entry : map.entrySet()) {

      if (bestAverage <= entry.getValue()) {
        bestAverage = entry.getValue();
        winner = entry.getKey();
      }

    }

    theBest.put(winner, bestAverage);

    return theBest;
  }
}
