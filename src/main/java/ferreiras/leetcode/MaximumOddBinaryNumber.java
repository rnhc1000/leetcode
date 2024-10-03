package ferreiras.leetcode;

/**
 * You are given a binary string s that contains at least one '1'.
 * You have to rearrange the bits in such a way that the resulting binary number
 * is the maximum odd binary number that can be created from this combination.
 * Return a string representing the maximum odd binary number that can be created
 * from the given combination.
 * Note that the resulting string can have leading zeros.
 * Example 1:
 * Input: s = "010"
 * Output: "001"
 * Explanation:
 * Because there is just one '1', it must be in the last position. So the answer is "001".
 * Example 2:
 * Input: s = "0101"
 * Output: "1001"
 * Explanation:
 * One of the '1's must be in the last position.
 * The maximum number that can be made with the remaining digits is "100". So the answer is "1001".
 */
public class MaximumOddBinaryNumber {
  public String maximumOddBinaryNumber(String s) {

    int countOne = 0, countZero = 0;
    for (int i = 0; i < s.length(); i++) {
      if (s.charAt(i) == '1') {
        countOne++;
      }
    }
    countZero = s.length() - countOne;
    StringBuilder sb = new StringBuilder();
    sb.append("1".repeat(Math.max(0, countOne - 1)));
    sb.append("0".repeat(Math.max(0, countZero)));
    sb.append("1");
    return sb.toString();

  }


  public static void main(String[] args) {
    int a = 10; // Binary: 0000 1010
    int b = 6;  // Binary: 0000 0110

    // Bitwise AND
    int bitwiseAnd = a & b;
    System.out.println("Bitwise AND: " + bitwiseAnd);

    // Bitwise OR
    int bitwiseOr = a | b;
    System.out.println("Bitwise OR: " + bitwiseOr);

    // Bitwise XOR
    int bitwiseXor = a ^ b;
    System.out.println("Bitwise XOR: " + bitwiseXor);

    // Bitwise complement
    int bitwiseComplement = ~a;
    System.out.println("Bitwise Complement of a: " + bitwiseComplement);

    // Left shift
    int leftShift = a << 2;
    System.out.println("Left Shift of a: " + leftShift);

    // Right shift
    int rightShift = a >> 1;
    System.out.println("Right Shift of a: " + rightShift);

    // Unsigned right shift
    int unsignedRightShift = a >>> 2;
    System.out.println("Unsigned Right Shift of a: " + unsignedRightShift);
  }
}
