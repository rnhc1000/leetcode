package ferreiras.leetcode;

/**
 * Given two strings s and t of lengths m and n respectively, return the minimum window
 * substring  of s such that every character in t (including duplicates) is included in
 * the window. If there is no such substring, return the empty string "".
 * The testcases will be generated such that the answer is unique.
 * Example 1:
 * Input: s = "ADOBECODEBANC", t = "ABC"
 * Output: "BANC"
 * Explanation: The minimum window substring "BANC" includes 'A', 'B', and 'C' from string t.
 * Example 2:
 * Input: s = "a", t = "a"
 * Output: "a"
 * Explanation: The entire string s is the minimum window.
 * Example 3:
 * Input: s = "a", t = "aa"
 * Output: ""
 * Explanation: Both 'a's from t must be included in the window.
 * Since the largest window of s only has one 'a', return empty string.
 * Intuition provided by https://leetcode.com/Shivansu_7/
 * Window Creation with Two Pointers:
 * Use two pointers, one for the left end of the window and another for the right end,
 * to create a window of letters in string s.
 * This window should aim to contain all the characters present in string t.
 * Expanding the Window:
 * Start by expanding the right pointer until all the characters from string t are
 * included in the window.
 * Shrinking the Window:
 * Once all characters from t are covered, start moving the left pointer to minimize
 * the size of the window while still ensuring all characters from t are present.
 * This ensures the smallest possible window containing all characters from t is achieved.
 * Continued Adjustment of Pointers:
 * Continue the process of expanding the right pointer and shrinking the left pointer
 * until reaching the end of string s.
 * This ensures thorough coverage and minimizes the size of the window containing
 * all characters from t.
 * Approach
 * Initialization:
 * Initialize an empty string ans to store the minimum window substring.
 * Initialize two HashMaps: mapT to store the frequency of characters in string t,
 * and mapS to store the frequency of characters in the current window of string s.
 * Initialize mct to track the number of characters matched so far and dmct to represent
 * the desired match count, which is the length of string t.
 * Iterating through the string:
 * Use two pointers, i and j, to represent the window boundaries.
 * Start both pointers at -1.
 * i will be moved forward to expand the window, and j will be moved forward to shrink
 * the window.
 * Expanding the window (while loop):
 * Increment i until either the end of string s is reached or all characters from string
 * t are found (mct reaches dmct).
 * Update mapS with the frequency of characters encountered. If a character is found
 * which is present in t, increment mct.
 * Shrinking the window (nested while loop):
 * After expanding the window, increment j until the minimum window containing all
 * characters from t is found (mct equals dmct).
 * Update the ans if the current window is smaller than the previous minimum.
 * Update mapS accordingly and decrement mct if a character is no longer in the window.
 * Check for completion:
 * Break the loop if neither flag1 (expanding) nor flag2 (shrinking) flags are set.
 * This indicates that both pointer movements did not happen, implying that the windows cannot be expanded or shrunk further.
 * Return the minimum window substring found:
 * Return the ans after the while loop exits, which contains the minimum window substring.
 * Complexity
 * Time complexity: O(n)O(n)O(n) n is length of string s
 * Space complexity: O(n)O(n)O(n) n is length of string s
 */

import java.util.Map;
import java.util.HashMap;
public class MinimumWindowSubString {

  public static void main(String[] args) {
    String s = "ADOBECCODEBANC";
    String t = "ABC";
    String r = minWindow(s,t);
    System.out.println(r);

  }
  public static String minWindowx(String s, String t) {
    int start, end, minLength, index, count = 0;
    Map<Character,Integer> frequencyOfStringT = new HashMap<>();
    for (int i = 0; i <t.length(); i++) {
      int counter = frequencyOfStringT.getOrDefault(t.charAt(i),0);
      frequencyOfStringT.put(t.charAt(i), counter+1);
    }
    char[] cs = s.toCharArray();
    for (char c : cs) {
      if (frequencyOfStringT.containsKey(c)) {
        frequencyOfStringT.put(c, frequencyOfStringT.getOrDefault(c, 1) + 1);
      }
    }
    System.out.println(frequencyOfStringT);
    return t;
  }
    public static String minWindow(String s, String t) {
      if(s.equals(t)){
        return s;
      }
      HashMap<Character, Integer> frequencyOfT = new HashMap<>(); //frequecny of t
      HashMap<Character, Integer> frequency = new HashMap<>();

      for(char ch : t.toCharArray()) {
        int count = frequencyOfT.getOrDefault((ch),0)+1;
        frequencyOfT.put(ch, count);
      }

      int match = 0;
      int sizeOfT = t.length();
      int i = -1;
      int j = -1;
      String response = "";
      while(true) {
        boolean expandingWindow = false;
        boolean shrinkingWindow = false;
        while(i < s.length()-1 && match < sizeOfT) {
          i++;
          char ch = s.charAt(i);
          int count = frequency.getOrDefault(ch,0) + 1;
          frequency.put(ch, count);
          int countFrequency = frequency.getOrDefault(ch,0);
          int countFrequencyOfT = frequencyOfT.getOrDefault(ch,0);
          if(countFrequency <= countFrequencyOfT){
            match++;
          }
          expandingWindow=true;
        }
        while(j < i && match == sizeOfT) {
          j++;
          String guess = s.substring(j, i+1);
          if(response.isEmpty() || guess.length() < response.length()) {
            response = guess;
          }
          char ch = s.charAt(j);
          if(frequency.get(ch)==1) {
            frequency.remove(ch);
          }
          else {
            frequency.put(ch, frequency.get(ch)-1);
          }

          if(frequency.getOrDefault(ch, 0) < frequencyOfT.getOrDefault(ch, 0)) {
            match--;
          }
          shrinkingWindow=true;
        }
        if(!expandingWindow && !shrinkingWindow) {
          break;
        }
      }
      return response;
    }
  }
