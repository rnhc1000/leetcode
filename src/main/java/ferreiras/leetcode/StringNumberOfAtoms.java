package ferreiras.leetcode;

import java.util.*;

/*
Given a string formula representing a chemical formula, return the count of each atom.

The atomic element always starts with an uppercase character, then zero or more lowercase letters, representing the name.

One or more digits representing that element's count may follow if the count is greater than 1.
If the count is 1, no digits will follow.

For example, "H2O" and "H2O2" are possible, but "H1O2" is impossible.
Two formulas are concatenated together to produce another formula.

For example, "H2O2He3Mg4" is also a formula.
A formula placed in parentheses, and a count (optionally added) is also a formula.

For example, "(H2O2)" and "(H2O2)3" are formulas.
Return the count of all elements as a string in the following form: the first name (in sorted order),
followed by its count (if that count is more than 1), followed by the second name (in sorted order),
followed by its count (if that count is more than 1), and so on.

The test cases are generated so that all the values in the output fit in a 32-bit integer.

Example 1:

Input: formula = "H2O"
Output: "H2O"
Explanation:
The count of elements are {'H': 2, 'O': 1}.
Example 2:

Input: formula = "Mg(OH)2"
Output: "H2MgO2"
Explanation:
The count of elements are {'H': 2, 'Mg': 1, 'O': 2}.
Example 3:

Input: formula = "K4(ON(SO3)2)2"
Output: "K4N2O14S4"
Explanation:
The count of elements are {'K': 4, 'N': 2, 'O': 14, 'S': 4}.

Constraints:

1 <= formula.length <= 1000
formula consists of English letters, digits, '(', and ')'.
formula is always valid.
 */
public class StringNumberOfAtoms {
  public static void main(String... args) {
    String formula = "K4(ON(SO3)2)2";
    String response = countOfAtoms(formula);
    System.out.println(response);
  }
  public static String countOfAtoms(String formula) {

    Map<String, Integer> mapCounter = new HashMap<>();
    Deque<Map<String, Integer>> stackOfParentheses = new ArrayDeque<>();
    int currentIndex = 0,  size = formula.length();

    while (currentIndex < size) {
      char currentChar = formula.charAt(currentIndex);

      if (currentChar == '(') {
        currentIndex++;
        stackOfParentheses.push(new HashMap<>());
        continue;
      }

      if (currentChar == ')') {
        StringBuilder sb = new StringBuilder();
        currentIndex++;

        while (currentIndex < size && Character.isDigit(formula.charAt(currentIndex))) {
          sb.append(formula.charAt(currentIndex));
          currentIndex++;
        }

        int multiplier = sb.isEmpty() ? 1 : Integer.parseInt(sb.toString());
        Map<String, Integer> last_counter = stackOfParentheses.pop();
        Map<String, Integer> target = stackOfParentheses.isEmpty() ? mapCounter : stackOfParentheses.peek();

        for (Map.Entry<String, Integer> entry : last_counter.entrySet()) {
          target.put(entry.getKey(), target.getOrDefault(entry.getKey(), 0) + entry.getValue() * multiplier);
        }
        continue;
      }

      StringBuilder currentElement = new StringBuilder();
      StringBuilder currentSbCounter = new StringBuilder();
      Map<String, Integer> target = stackOfParentheses.isEmpty() ? mapCounter : stackOfParentheses.peek();

      while (currentIndex < size && formula.charAt(currentIndex) != '(' && formula.charAt(currentIndex) != ')') {
        if (Character.isAlphabetic(formula.charAt(currentIndex))) {
          if (Character.isUpperCase(formula.charAt(currentIndex)) && !currentElement.isEmpty()) {
            target.put(currentElement.toString(), target.getOrDefault(currentElement.toString(), 0) + (currentSbCounter.isEmpty() ? 1 : Integer.parseInt(currentSbCounter.toString())));
            currentElement = new StringBuilder();
            currentSbCounter = new StringBuilder();
          }
          currentElement.append(formula.charAt(currentIndex));
        } else {
          currentSbCounter.append(formula.charAt(currentIndex));
        }
        currentIndex++;
      }

      target.put(currentElement.toString(), target.getOrDefault(currentElement.toString(), 0) + (currentSbCounter.isEmpty() ? 1 : Integer.parseInt(currentSbCounter.toString())));
    }

    List<String> elements = new LinkedList<>();
    for (Map.Entry<String, Integer> entry : mapCounter.entrySet()) {
      elements.add(entry.getKey() + (entry.getValue() == 1 ? "" : entry.getValue()));
    }
    elements.sort(Comparator.comparing(s -> s));
//    Collections.sort(elements);

    StringBuilder result = new StringBuilder();
    for (String element : elements) {
      result.append(element);
    }

    return result.toString();
  }
}
