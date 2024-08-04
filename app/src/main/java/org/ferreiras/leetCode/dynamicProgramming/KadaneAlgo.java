package br.dev.ferreiras.challenges.leetCode.dynamicProgramming;

/**
 * Given an array Arr[] of N integers. Find the contiguous sub-array(containing
 * at least one number) which has the maximum sum and return its sum.
 * Algoritmo de Kadane
 * A ideia do algoritmo de Kadane é realizarmos uma solução gulosa.
 * Vamos iterar do 1 até o N, quando estivermos em i, sempre manteremos 2 valores:
 * a resposta máxima até aqui e o valor do intervalo de soma máximo terminando
 * em i, guardaremos eles em maxSum e currentSum, respectivamente.
 */
public class KadaneAlgo {
  public static void main(String[] args) {
    int[] numbers = {-2,0,1,2,-4,5,6};
    int k = 7;
    long response = maxSubarraySum(numbers, k);
    System.out.println(response);
  }
  public static long maxSubarraySum(int[] arr, int n){
    long currentSum = 0;
    long maxSum = Long.MIN_VALUE;
    for (int i = 0; i < n; i++) {
      if (currentSum < 0) currentSum = 0;
      currentSum += arr[i];
      maxSum = Math.max(maxSum, currentSum);
    }
    return maxSum;
  }
}
