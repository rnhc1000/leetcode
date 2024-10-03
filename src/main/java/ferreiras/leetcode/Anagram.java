package ferreiras.leetcode;
/*
 * @author rferreira
 * @code @t
 * An anagram is a word or phrase formed by rearranging the letters
 * of a different word or phrase, typically using all the original
 * letters exactly once.(https://en.wikipedia.org/wiki/Anagram)
 * secure" is an anagram of "rescue
 * Two different strings as input and return
 * a boolean if one is anagram of the other
 * 1. eliminate spaces, convert to lower,
 * 2. associate to an array and sort.
 * 3. if one is equals to the other sorted
 * 4. we have an anagram, otherwise not
 * 5. first check if the strings' length
 * 6. are different return false;
 */

import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;
import java.util.logging.Logger;
import java.util.stream.Collectors;

import static ferreiras.leetcode.ConcurrencyUtils.*;

@ClassPreamble (
        author = "Ricardo Ferreira",
        date = "25/08/2023",
        currentRevision = 7,
        lastModified = "02/08/2024",
        lastModifiedBy = "Ricardo Ferreira",
        reviewers = {}
)
public class Anagram {

  private final static Logger logger = Logger.getLogger(Anagram.class.getName());
  public static void main(String[] args) throws InterruptedException {

    String s1 = " the quick brown fox dog jumps over the lazy dog ";
    String s2 = "  quick the brown jumps over the dog lazy dog fox";

    boolean response = isAnagram(s1, s2);
//    boolean response = validAnagram(s1, s2);

    response = isAnagram(s1, s2);


    if (response) {
      System.out.println("S1 and S2 are anagrams!");
    } else {
      System.out.println("The two strings are not anagram of each other!");
    }

  }
  public static boolean isAnagram(String s1, String s2) {
    startTimer();

    logger.info("Starting Anagram....- V1");

    String regex = "\\s+";
    s1 = s1.replaceAll(regex, "").toLowerCase();
    s2 = s2.replaceAll(regex, "").toLowerCase();
    int lenStringOne = s1.length(), lenStringTwo = s2.length();
    logger.info(String.format("Length of each string provided as is: %d, %d", lenStringOne, lenStringTwo));

    if (lenStringOne != lenStringTwo) {
      logger.info("Its not feasible to have an anagram with the strings provided. Try again!");
      timeTaken();
      return false;
    }

    char[] s1Auxiliar = s1.toCharArray(), s2Auxiliar = s2.toCharArray();

    Arrays.sort(s1.toCharArray());
    Arrays.sort(s2.toCharArray());
    logger.info("Both strings are sorted..." + s1);

//    s1 = String.valueOf(s1Auxiliar);
//    s2 = String.valueOf(s2Auxiliar);
    logger.info("Stopping watch...");

    timeTaken();
    stopWatchReset();
    return  (s1.equals(s2));
  }

  public static boolean validAnagram(String s1, String s2) throws InterruptedException {
    logger.info("Starting Anagram.... - V2");
    startTimer();
    String regex = "\\s+";
    s1 = s1.replaceAll(regex, "").toLowerCase();
    s2 = s2.replaceAll(regex, "").toLowerCase();
    int lenStringOne = s1.length(), lenStringTwo = s2.length();
    logger.info(String.format("Length of each string provided as is: %d, %d", lenStringOne, lenStringTwo));
    if (lenStringOne != lenStringTwo) {
      logger.info("Its not feasible to have an anagram with the strings provided. Try again!");
      timeTaken();
      return false;
    }

    logger.info("Both strings are normalized..." + s1);
    char[] stringOne = s1.toCharArray();
    char[] stringTwo = s2.toCharArray();

    StringBuilder sbOne = new StringBuilder(), sbTwo = new StringBuilder();

    Thread thread = new Thread( () -> {
      Arrays.sort(stringOne);
      Arrays.sort(stringTwo);
      logger.info("Both strings are sorted...");
      for (char c : stringOne) {
        sbOne.append(c);
      }
      for (char c : stringTwo) {
        sbTwo.append(c);
      }
    });

    thread.start();
    thread.join();

    logger.info("Stopping watch...");

    timeTaken();
    stopWatchReset();
    return sbOne.toString().contentEquals(sbTwo.toString());
  }
/*
Collectors.groupingBy() provides functionality similar to the GROUP BY clause in SQL.
We can use this to group objects by any attribute and store results in a Map.
Collectors.groupingBy() – this is the method of Collectors class to group objects by some property
and store results in a Map instance
Function.identity() – it is a functional interface in Java; the identity method returns a
Function that always returns its input arguments
Collectors.counting() – this Collectors class method counts the number of elements passed
in the stream as a parameter
 */
  public static boolean existsAnagram(String s, String t) {
    Map<Integer, Long> mapS = s.chars().boxed()
                               .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
    Map<Integer, Long> mapT = t.chars().boxed()
                               .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

    return mapS.equals(mapT);
  }

}

