package org.ferreiras.leetCode;
/*
Given a stream of characters return an array of frequency of each character occurrence.
The technique is based on the following statement: frequency[c - 'a']++;
Normalize the characters stream using Character.toLowerCode(ch)... frequency[ch - 'a'], otherwise
frequency[ch - 'A']

 */

import jdk.jfr.Description;

import java.util.Arrays;
import java.util.logging.Logger;

@Description ("Count occurrence of characters")
public class StringFrequencyOfCharacters {
  public static final Logger logger = Logger.getLogger(StringFrequencyOfCharacters.class.getName());

  public static void main(String[] args) {
    char[] charUpperCase = {
            'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H',
            'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P',
            'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X',
            'Y', 'Z',
            'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P'
    };

    char[] charLowerCase = {
            'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h',
            'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p',
            'q', 'r', 's', 't', 'u', 'v', 'w', 'x',
            'y', 'z'
    };
    int[] frequency = returnFrequencyOfCharacters(charUpperCase);
    for (int f : frequency) {
      System.out.printf("%d ", f);
    }
    System.out.println();

    /*
    1 1 1 1 1 1 1 1 2 2 2 2 2 2 2 2 1 1 1 1 1 1 1 1 1 1
     */

    String string = """ 
            the quick    brown   foxx dog jumps over     the lazy do
            ricardo  alves     ferreira silva
            """;
    int[] f = returnFrequencyOfCharacters(string);
    for (int fx : f) {
      System.out.printf("%d ", fx);
    }
    System.out.println();
  }

  public static int[] returnFrequencyOfCharacters(char[] ch) {
    logger.info("processing characters stream");
    long start = System.currentTimeMillis();
    int[] frequency = new int[26];
    for (char c : ch) {
      frequency[c - 'A']++;
    }
    long end = System.currentTimeMillis();
    System.out.println(end - start + " ms" + "\n");
    logger.info("end of processing characters stream");

    return frequency;
  }

  public static int[] returnFrequencyOfCharacters(String string) {
    int[] frequency = new int[26];
    String regex = "\\s+";
    string = string.toLowerCase();
    String[] word = string.split(regex);
    for (String w : word) {
      char[] ch = w.toCharArray();
      for (char c : ch) frequency[c - 'a']++;
    }
    System.out.println(Arrays.toString(word));
    System.out.println(string);

    return frequency;
  }
}
