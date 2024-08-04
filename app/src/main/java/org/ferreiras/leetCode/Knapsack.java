package org.ferreiras.leetCode;

import java.util.Arrays;

import static java.util.Arrays.*;

/*
Neste código, weights e values representam os pesos e valores dos itens, respectivamente, e capacity é
a capacidade máxima da mochila. A função knapsack retorna o valor máximo que pode ser colocado na mochila
dada a capacidade e os itens disponíveis. A tabela dp é preenchida iterativamente para armazenar as soluções
dos subproblemas, e o valor máximo é retornado no final.
Um exemplo clássico de problema resolvido com programação dinâmica é o problema da mochila (knapsack problem),
onde é necessário determinar quais itens selecionar para maximizar o valor total, sem exceder o peso máximo
que a mochila pode suportar.
 */
public class Knapsack {

  // Função para resolver o problema da mochila
  public static int knapsack(int[] weights, int[] values, int capacity) {
    int n = weights.length;
    int[][] dp = new int[n + 1][capacity + 1];
    for (int[] d : dp) {
      Arrays.fill(d, 0);
    }

    // Preenche a tabela dp
    for (int i = 1; i <= n; i++) {
      for (int j = 1; j <= capacity; j++) {
        if (weights[i - 1] > j) {
          // Se o peso do item for maior que a capacidade da mochila atual, não é possível incluir o item
          dp[i][j] = dp[i - 1][j];
        } else {
          System.out.printf("%d ", dp[i-1][j-weights[i-1]]);
          int currentBalance = values[i-1] + dp[i-1][j-weights[i-1]];
          // Verifica se vale a pena incluir o item atual na mochila
          dp[i][j] = Math.max(dp[i - 1][j], currentBalance);
        }
      }
    }
    // Retorna o valor máximo que pode ser colocado na mochila
    return dp[n][capacity];
  }

  public static void main(String[] args) {
    int[] weights = {2, 3, 4, 5}, values = {3, 4, 5, 6};
    int capacity = 8;
    int maxValue = knapsack(weights, values, capacity);
    System.out.print("\nMax value in the knapsack: " + maxValue);
  }
}

