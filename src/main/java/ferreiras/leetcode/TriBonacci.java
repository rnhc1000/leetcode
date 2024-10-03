package ferreiras.leetcode;

/**
 * The Tribonacci sequence Tn is defined as follows:
 * T0 = 0, T1 = 1, T2 = 1, and Tn+3 = Tn + Tn+1 + Tn+2 for n >= 0.
 * Given n, return the value of Tn.
 * Example 1:
 * Input: n = 4
 * Output: 4
 * Explanation:
 * T_3 = 0 + 1 + 1 = 2
 * T_4 = 1 + 1 + 2 = 4
 * Example 2:
 * Input: n = 25
 * Output: 1389537
 * Constraints:
 * 0 <= n <= 37
 * The answer is guaranteed to fit within a 32-bit integer, ie. answer <= 2^31 - 1.
 */
@ClassPreamble (
        author = "Ricardo Ferreira",
        date = "2024-01-17",
        currentRevision = 1,
        lastModified = "2024-01-17",
        lastModifiedBy = "Ricardo Ferreira",
        reviewers = {},
        description = """
                Code to find return the
                Tn value of a Tribonacci
                sequence.
                """
)
public class TriBonacci {

  public static void main(String[] args) {
    int n = 25;
    int r = tribonacci(n);
    System.out.println(r);
  }

  public static int tribonacci(int n) {
    int[] sequence = new int[n+1];
    int sum = 0;
    for (int i = 0; i <= n; i++) {
      if (i == 0) {
        sequence[i] = 0;
        continue;
      } else if (i < 3) {
        sequence[i] = 1;
        continue;
      }
      sequence[i] = sequence[i - 1] + sequence[i - 2] + sequence[i - 3];
    }
    for (int s : sequence) {
      sum += s;
    }
    return sequence[n];
  }
}
