package org.ferreiras.leetcode;

/**
 * You are given two positive integer arrays spells and potions, of length n and m respectively,
 * where spells[i] represents the strength of the ith spell and potions[j] represents the strength
 * of the jth potion.
 * You are also given an integer success. A spell and potion pair is considered successful if the
 * product of their strengths is at least success.
 * Return an integer array pairs of length n where pairs[i] is the number of potions that will form a
 * successful pair with the ith spell.
 * Example 1:
 * Input: spells = [5,1,3], potions = [1,2,3,4,5], success = 7
 * Output: [4,0,3]
 * Explanation:
 * - 0th spell: 5 * [1,2,3,4,5] = [5,10,15,20,25]. 4 pairs are successful.
 * - 1st spell: 1 * [1,2,3,4,5] = [1,2,3,4,5]. 0 pairs are successful.
 * - 2nd spell: 3 * [1,2,3,4,5] = [3,6,9,12,15]. 3 pairs are successful.
 * Thus, [4,0,3] is returned.
 * Example 2:
 * Input: spells = [3,1,2], potions = [8,5,8], success = 16
 * Output: [2,0,2]
 * Explanation:
 * - 0th spell: 3 * [8,5,8] = [24,15,24]. 2 pairs are successful.
 * - 1st spell: 1 * [8,5,8] = [8,5,8]. 0 pairs are successful.
 * - 2nd spell: 2 * [8,5,8] = [16,10,16]. 2 pairs are successful.
 * Thus, [2,0,2] is returned.
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SpellsPotions {
  public static void main(String[] args) {
    int[] spells = {3, 1, 2};
    int[] potions = {8, 5, 8};
    int success = 16;
    int[] response = successfulPairs(spells, potions, success);
    for (int i : response) {
      System.out.print(i + " - ");
    }
  }

  public static int[] successfulPairs(int[] spells, int[] potions, long success) {
    Arrays.sort(potions);
    List<List<Integer>> lists = new ArrayList<>();
    for (int s : spells) {
      List<Integer> list = new ArrayList<Integer>();
      for (int t : potions) {
        list.add(s * t);
      }
      lists.add(list);
    }
    int count = 0;
    List<Integer> response = new ArrayList();
    for (List<Integer> l : lists) {
      for (int n : l) {
        if (n >= success) {
          count++;
        }
      }
      response.add(count);
      count = 0;
    }
    int[] product = new int[response.size()];
    for (int i = 0; i < response.size(); i++) {
      product[i] = response.get(i);
    }
    return product;
  }

  public static int[] mostSuccessfulPairs(int[] spells, int[] potions, long success) {
    int n = spells.length;
    int m = potions.length;
    int[] pairs = new int[n];
    Arrays.sort(potions);
    for (int i = 0; i < n; i++) {
      int spell = spells[i];
      int left = 0;
      int right = m - 1;
      while (left <= right) {
        int mid = left + (right - left) / 2;
        long product = (long) spell * potions[mid];
        if (product >= success) {
          right = mid - 1;
        } else {
          left = mid + 1;
        }
      }
      pairs[i] = m - left;
    }
    return pairs;
  }
}

/**
 * programa {
 *     funcao inicio() {
 *
 *         inteiro unidade, dezena, centena, u_milhar, d_milhar, numero
 *
 *         leia(numero)
 *
 *         unidade = ((numero/1)%10)*1
 *         dezena = ((numero/10)%10)*10
 *         centena = ((numero/100)%10)*100
 *         u_milhar = ((numero/1000)%10)*1000
 *         d_milhar = ((numero/10000)%10)*1000
 *
 *         escreva(numero + " Decomposto e:\\n")
 *         escreva(d_milhar+"+")
 *         escreva(u_milhar+"+")
 *         escreva(centena+"+")
 *         escreva(dezena+"+")
 *         escreva(unidade+"")
 *     }
 * }
 */
