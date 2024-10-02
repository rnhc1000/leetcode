package org.ferreiras.leetcode;

import java.util.ArrayList;
import java.util.List;

public class CountRepetitions {
  class Record {
    int count;
    int nextIndex;

    public Record(int count, int nextIndex) {
      this.count = count;
      this.nextIndex = nextIndex;
    }
  }


    public int getMaxRepetitions(String s1, int n1, String s2, int n2) {

      List<Record> records = new ArrayList();

      this.load(s1, s2, records);

      int index = 0, match = 0;

      while (n1 > 0) {
        match += records.get(index).count;
        index = records.get(index).nextIndex;
        n1--;
      }

      return match / n2;

    }

    public void load(String s1, String s2, List<Record> records) {

      for (int i = 0; i < s2.length(); i++) {
        int nextIndex = i;
        int count = 0;

        for (int j = 0; j < s1.length(); j++) {

          if (s2.charAt(nextIndex) == s1.charAt(j)) nextIndex++;

          if (nextIndex == s2.length()) {
            count++;
            nextIndex = 0;
          }

        }
        records.add(new Record(count, nextIndex));
      }
    }
  }
