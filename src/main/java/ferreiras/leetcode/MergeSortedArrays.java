package ferreiras.leetcode;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class MergeSortedArrays {

  public static void main(String[] args) {

    Random random = new Random();
    int size = random.nextInt(1,20);
    int[] arrayOne = new int[size];
    size = random.nextInt(1,10);
    int[] arrayTwo = new int[size];

    for (int i=0; i<arrayOne.length; i++){
      arrayOne[i] = random.nextInt(0,99);
    }
    for (int i=0; i<arrayTwo.length; i++){
      arrayTwo[i] = random.nextInt(0,99);
    }
    int[] response = mergeSortedArrays(arrayOne,arrayTwo);
    System.out.println("Method One: ");
    for (int i : response) {
      System.out.print(" " + i);
    }
    System.out.print("\n--------------------------------------------\n");
    List<Integer> list = sortedMergedArrays(arrayOne,arrayTwo);
    System.out.println("Method Two: ");

    for (int i : list) {
      System.out.print(" " + i);
    }
  }
  public static int[] mergeSortedArrays(int[] arrayOne, int[]arrayTwo){
    int sizeOfArrayOne = arrayOne.length;
    int sizeOfArrayTwo = arrayTwo.length;
    int sizeOfMerged = sizeOfArrayOne + sizeOfArrayTwo;
    int[] merged = new int[sizeOfMerged];
    int countZeros=0;
    for (int i = 0; i<arrayOne.length; i++) {
      if(arrayOne[i] == 0) {
        i++;
        countZeros++;
        continue;
      }
      merged[i] = arrayOne[i];
    }
    int indexToContinueMerge = sizeOfArrayOne-1-countZeros;
    for(int i = 0; i<arrayTwo.length; i++) {
      if(arrayTwo[i] == 0) {
        i++;
        countZeros++;
        continue;
      }
      merged[indexToContinueMerge] = arrayTwo[i];
      indexToContinueMerge++;
    }

    Arrays.sort(merged);
    int[] sorted = new int[sizeOfMerged-countZeros-1];
    int j=0;
    for (int i=0; i<sizeOfMerged; i++) {
      if (merged[i] != 0) {
        sorted[j] =  merged[i];
        j++;
      }
    }
    return sorted;
  }

  public static List<Integer> sortedMergedArrays(int[] arrayOne, int[]arrayTwo) {
    int sizeOfArrayOne = arrayOne.length;
    int sizeOfArrayTwo = arrayTwo.length;
    List<Integer> listOfArraysMerged = new ArrayList<>();
    for (int i : arrayOne) {
      if(i != 0) listOfArraysMerged.add(i);
    }
    for (int i : arrayTwo) {
      if(i != 0) listOfArraysMerged.add(i);
    }
/*    System.out.print(" " + arraysOne.toString(arrayOne));
    System.out.println();
    System.out.print(" " + arraysOne.toString(arrayTwo));
    System.out.println(listOfArraysMerged);*/
    List<Integer> listWithoutDuplicates = new ArrayList<>();
    for(int i : listOfArraysMerged) {
      if (!listWithoutDuplicates.contains(i)) {
        listWithoutDuplicates.add(i);
      }
    }
    return listWithoutDuplicates.stream().sorted().toList();
  }
}
