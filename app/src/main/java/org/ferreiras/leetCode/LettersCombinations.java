package org.ferreiras.leetCode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Letter Combinations of a Phone Number
 * Given a string containing digits from 2-9 inclusive, return all possible letter
 * combinations that the number could represent. Return the answer in any order.
 * A mapping of digits to letters (just like on the telephone buttons) is given below.
 * Note that 1 does not map to any letters.
 * Intuition:
 * The problem requires finding all possible letter combinations that can be formed by a
 * given sequence of digits. For example, if the input is "23", then the output should
 * contain all possible combinations of the letters 'a', 'b', and 'c' for digit 2,
 * and 'd', 'e', and 'f' for digit 3.
 * This can be solved using a backtracking approach where we start with the first digit
 * and find all the possible letters that can be formed using that digit, and then move on
 * to the next digit and find all the possible letters that can be formed using that digit,
 * and so on until we have formed a combination of all digits.
 * Nice explanation of the solution by
 * <a href="https://leetcode.com/devanshupatel/">...</a>
 * Approach:
 * Define a function letterCombinations which takes a string of digits as input and returns
 * a vector of all possible letter combinations.
 * Check if the input string is empty, if it is, return an empty vector as there are no possible
 * letter combinations.
 * Define a mapping vector which contains the letters corresponding to each digit. For example,
 * the mapping vector for the input "23" would be
 * {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"}.
 * Define an empty string combination with the same size as the input digits string.
 * Call the backtrack function with the initial index as 0 and pass the result vector, mapping vector,
 * combination string, and digits string as arguments.
 * In the backtrack function, check if the current index is equal to the size of the digits string.
 * If it is, that means we have formed a complete combination of letters, so we add the current
 * combination string to the result vector and return.
 * Otherwise, get the possible letters corresponding to the current digit using the mapping vector.
 * Iterate through all the possible letters and set the current index of the combination string to
 * that letter.
 * Call the backtrack function recursively with the incremented index.
 * After the recursive call returns, reset the current index of the combination string to its previous
 * value so that we can try the next letter.
 * Complexity:
 * Time Complexity:
 * The time complexity of the algorithm is O(3^N × 4^M), where N is the number of digits in the input
 * string that correspond to 3 letters ('2', '3', '4', '5', '6', '8'), and M is the number of digits
 * in the input string that correspond to 4 letters ('7', '9').
 * The reason for this is that each digit can correspond to 3 or 4 letters, and we need to generate all
 * possible combinations of these letters. The maximum length of the result vector can be
 * 3^N × 4^M, as each letter can be used at most once in a combination.
 * Space Complexity:
 * The space complexity of the algorithm is O(N), where N is the number of digits in the input string.
 * This is because we use a combination string of size N to store the current combination of letters
 * being formed, and a result vector to store all the possible combinations.
 * The mapping vector is of constant size and does not contribute to the space complexity.
 */
public class LettersCombinations {
  public static void main(String[] args) {
    String s = "23";
    List<String> list = letterCombinations(s);
    System.out.println(list);
  }

  public static List<String> letterCombinations(String digits) {
    Map<Character, String> phone = new HashMap<>();
    phone.put('2', "abc");
    phone.put('3', "def");
    phone.put('4', "ghi");
    phone.put('5', "jkl");
    phone.put('6', "mno");
    phone.put('7', "pqrs");
    phone.put('8', "tuv");
    phone.put('9', "wxyz");

    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < digits.length(); i++) {
      if (phone.containsKey(digits.charAt(i))) {
        sb.append(phone.get(digits.charAt(i)));
      } else {
        switch (digits.charAt(i)) {
          case '1', '0' -> sb.append('-');
        }
      }
    }

    String n = sb.toString();
    List<String> list = new ArrayList<>();
    char[] c = n.toCharArray();

    for (int j=0; j<c.length; j++) {
      for (int k=1; k<c.length; k++) {
        StringBuilder ns = new StringBuilder();
        ns.append(c[j]).append(c[k]);
        String s = ns.toString();
        list.add(s);
      }
    }
    return list;
  }

  public static List<String> letterCombination(String digits) {
  List<String> res=new ArrayList<>();
       if(digits.isEmpty()) return res;
  Map<Character,String> hm=new HashMap<>();
        hm.put('2',"abc");
        hm.put('3',"def");
        hm.put('4',"ghi");
        hm.put('5',"jkl");
        hm.put('6',"mno");
        hm.put('7',"pqrs");
        hm.put('8',"tuv");
        hm.put('9',"wxyz");

  backTrack(digits,0,hm,new StringBuilder(),res);
        return res;
}
  private static void backTrack(String digits, int i,Map<Character,String> hm,StringBuilder sb,List<String>res){
    if(i==digits.length()){
      res.add(sb.toString());
      return;
    }

    String curr=hm.get(digits.charAt(i));
    for(int k=0;k<curr.length();k++){
      sb.append(curr.charAt(k));
      backTrack(digits, i+1, hm,  sb, res);
      sb.deleteCharAt(sb.length() -1);
    }
  }

  public List<String> letterCombinationsOne(String digits) {
    List<String> combos = new ArrayList<>();
    if (digits == null || digits.isEmpty()) {
      return combos;
    }
    String[] phonePad = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
    StringBuilder combinations = new StringBuilder();
    backtrack(combos, phonePad, combinations, digits, 0);
    return combos;
  }

  private void backtrack(List<String> combos, String[] map, StringBuilder combinations, String digits, int index) {
    if (index == digits.length()) {
      combos.add(combinations.toString());
    } else {
      String characters = map[digits.charAt(index) - '0'];
      for (char character : characters.toCharArray()) {
        combinations.append(character);
        backtrack(combos, map, combinations, digits, index + 1);
        combinations.deleteCharAt(combinations.length() - 1);
      }
    }
  }
}
