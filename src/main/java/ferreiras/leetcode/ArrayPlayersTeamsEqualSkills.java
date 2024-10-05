package ferreiras.leetcode;

import java.util.Arrays;

/*
You are given a positive integer array skill of even length n where skill[i] denotes the
skill of the ith player. Divide the players into n / 2 teams of size 2 such that the total
skill of each team is equal.

The chemistry of a team is equal to the product of the skills of the players on that team.

Return the sum of the chemistry of all the teams, or return -1 if there is no way to divide
the players into teams such that the total skill of each team is equal.

Example 1:

Input: skill = [3,2,5,1,3,4]
Output: 22
Explanation:
Divide the players into the following teams: (1, 5), (2, 4), (3, 3), where each team has a total skill of 6.
The sum of the chemistry of all the teams is: 1 * 5 + 2 * 4 + 3 * 3 = 5 + 8 + 9 = 22.
Example 2:

Input: skill = [3,4]
Output: 12
Explanation:
The two players form a team with a total skill of 7.
The chemistry of the team is 3 * 4 = 12.
Example 3:

Input: skill = [1,1,2,3]
Output: -1
Explanation:
There is no way to divide the players into teams such that the total skill of each team is equal.

Constraints:

2 <= skill.length <= 105
skill.length is even.
1 <= skill[i] <= 1000
 */
public class ArrayPlayersTeamsEqualSkills {

  public static void main(String[] args) {
    int[] skills = {3, 2, 5, 1, 3, 4};
    long response = dividePlayers(skills);
    System.out.println(response);
  }

  public static long dividePlayers(int[] skill) {

    Arrays.sort(skill);
    int size = skill.length;
    long maximumSum, totalSkills = 0L;
    maximumSum = (long) skill[0] + (long) skill[size - 1];

    for (int i = 0; i < size / 2; i++) {

      if (skill[i] + skill[size - i - 1] != maximumSum) {
        return -1;
      }

      totalSkills += (long) skill[i] * (long)skill[size - i - 1];
    }
    return totalSkills;

  }

  public static long dividePlayers(long[] skill) {
    Arrays.sort(skill);
    long teamSkill = skill[0] + skill[skill.length - 1];
    long chem = skill[0] * skill[skill.length - 1];

    for (int i = 1; i < skill.length / 2; i++) {
      if (skill[i] + skill[skill.length - 1 - i] != teamSkill) return -1;
      chem += skill[i] * skill[skill.length - 1 - i];
    }
    return chem;
  }
}
