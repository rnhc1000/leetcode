package ferreiras.leetcode;
/**
 * Function<T, T> function = x -> return x * x
 */

import java.util.*;
import java.util.function.Function;

public class LambdaFunctions {

  static Random random = new Random();
  static int seed = 0;

  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    System.out.print("Input quantity of numbers: ");
    int number  = input.nextInt();
    input.nextLine();
//    List<Integer> guess = magicNumbers(number);
    int[] guess = magicNumbers(number);
    System.out.println("Guess suggested is: " + Arrays.toString(guess));
    input.close();
  }

  public static Function<Integer, Integer> squareLambda = x -> x * x;
  public static Function<Integer, Integer> randomLambda = numbersMagic -> {
    numbersMagic = random.nextInt(1, seed);
    return numbersMagic;
  };

  public static int[] magicNumbers(int magicNumbers) {
    switch (magicNumbers) {
      case 6 -> seed = 60;
      case 15 -> seed = 80;
      case 18 -> seed = 25;
      default -> seed = 59;
    }
    List<Integer> list = new ArrayList<>();
    int[] guess = new int[magicNumbers];
    for (int i = 0; i < magicNumbers;i++) {
      guess[i] = randomLambda.apply(0);
    }
    Arrays.sort(guess);
    for (int i : guess) {
      if (!list.contains(i)) {
        list.add(i);
      }
    }
    while (list.size() != magicNumbers) {
      int temp = randomLambda.apply(0);
      if (!list.contains(temp)) {
        list.add(temp);
      }
    }
    return list.stream().mapToInt(x -> x).toArray();
  }
}
