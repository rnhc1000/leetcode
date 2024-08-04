package org.ferreiras.leetCode;
/**
 * Unique Number Checker
 * Create a program that allows a user to enter a series of numbers
 * and checks if each number is unique or has been previously entered.
 * The program should display whether each number is unique or a duplicate.
 * Requirements:
 * Use a Set to store the unique numbers.
 * Prompt the user to enter a series of numbers, one at a time.
 * Check if each number is already present in the set.
 * Display whether each number is unique or a duplicate.
 */

import java.util.*;
import java.util.stream.Collectors;

@ClassPreamble (
        author = "Ricardo Ferreira",
        date = "2024-01-17",
        currentRevision = 1,
        lastModified = "2024-01-17",
        lastModifiedBy = "Ricardo Ferreira",
        reviewers = {},
        description = """
                Code to input data directly to a list,
                using Arrays.stream().input.nextLine()
                .split("\\s")
                .map(Integer::valueOf)
                .toList(),
                check for duplicates, using Set for unique data
                and a List<Integer> for the duplicates.
                """
)
public class InputDataListsSet {

  public static void main(String... args) {
    System.out.print("Input a list of numbers only with one space between them: ");
    Scanner input = new Scanner(System.in);
    List<Integer> numbers = Arrays.stream(input.nextLine()
            .split("\\s"))
            .map(Integer::valueOf)
            .toList();
    System.out.println(numbers);
    Set<Integer> unique = new HashSet<Integer>();
    List<Integer> duplicates = new ArrayList<Integer>();

    for (Integer x : numbers) {
      if (unique.contains(x)) {
        duplicates.add(x);
      } else {
        unique.add(x);
      }
    }
    System.out.println(duplicates);
    HashSet<Integer> sortedUnique = unique.stream()
            .sorted()
            .collect(Collectors.toCollection(LinkedHashSet::new));
    System.out.println(unique);
    System.out.println(sortedUnique);
  }
}
