package org.ferreiras.leetCode;
/*
You are given two strings s and t consisting of only lowercase English letters.

Return the minimum number of characters that need to be appended to the end of s so that t
becomes a subsequence of s.

A subsequence is a string that can be derived from another string by deleting some or no
characters without changing the order of the remaining characters.

Example 1:

Input: s = "coaching", t = "coding"
Output: 4
Explanation: Append the characters "ding" to the end of s so that s = "coachingding".
Now, t is a subsequence of s ("coachingding").
It can be shown that appending any 3 characters to the end of s will never make t a subsequence.
Example 2:

Input: s = "abcde", t = "a"
Output: 0
Explanation: t is already a subsequence of s ("abcde").
Example 3:

Input: s = "z", t = "abcde"
Output: 5
Explanation: Append the characters "abcde" to the end of s so that s = "zabcde".
Now, t is a subsequence of s ("zabcde").
It can be shown that appending any 4 characters to the end of s will never make t a subsequence.


Constraints:

1 <= s.length, t.length <= 105
s and t consist only of lowercase English letters.

Intuition
To make t a subsequence of s, we need to find the longest prefix of t that is already a
subsequence of s. The remaining characters of t that are not part of this longest prefix
will need to be appended to the end of s.

Approach
Two Pointers Technique:
Use two pointers, one (i) for s and one (j) for t.
Traverse through s and t simultaneously. If characters s[i] and t[j] match, move both pointers forward.
If they don’t match, move only the pointer i for s.
The goal is to find how many characters from t we can match in s sequentially.
Remaining Characters:
After the traversal, if the pointer j is equal to the length of t, it means all characters in t are
matched in s, and no characters need to be appended.
Otherwise, the number of characters that need to be appended is the length of t minus the position of j.
Complexity Analysis
Time Complexity: O(n + m), where n is the length of s and m is the length of t. This is because we are
traversing both strings once.
Space Complexity: O(1), as we are using a constant amount of space for the pointers and no additional
data structures.
 */
@ClassPreamble(
        author = "Ricardo Ferreira",
        date = "2024/06/03",
        currentRevision = 1,
        lastModified = "2024/06/03",
        lastModifiedBy = "Ricardo Ferreira",
        reviewers = {}
)
public class StringSubsequence {

  public static void main(String[] args) {
    String s = "coaching", t = "coding";

    int count = appendCharacters(s,t);
    System.out.println(count);
  }
  public static int appendCharacters(String s, String t) {
    int count = 0;


    int sizeOfS = s.length();
    int sizeOfT = t.length();


    int indexOfS = 0, indexOfT = 0;

    while (indexOfS < sizeOfS && indexOfT < sizeOfT) {
      if (s.charAt(indexOfS) == t.charAt(indexOfT)) {
        indexOfT++;
      }
        indexOfS++;
    }
    System.out.println(indexOfS + " " + indexOfT);
    return sizeOfT - indexOfT;
  }
}
