package org.ferreiras.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
You have a long flowerbed in which some of the plots are planted, and some are not.
However, flowers cannot be planted in adjacent plots.
Given an integer array flowerbed containing 0's and 1's, where 0 means empty and 1 means not empty,
and an integer n, return true if n new flowers can be planted in the flowerbed without violating
the no-adjacent-flowers rule and false otherwise.
Example 1:
Input: flowerbed = [1,0,0,0,1], n = 1
Output: true
Example 2:
Input: flowerbed = [1,0,0,0,1], n = 2
Output: false
 */
public class CanPlaceFlowers {
  public static void main(String[] args) {
    int[] flowerbed = {1,0,1,0,1,0,0};
    int flowers = 1;
//    boolean response = canPlaceFlowers(flowerbed, flowers);
//    System.out.println(response);
//    listSubArrays();
    boolean response = canFlowersBePlaced(flowerbed,flowers);
    System.out.println(response);
  }
  public static void listSubArrays() {
    int[] array = new int[] {1, 2, 3,4, 5};
    List<List<Integer>> subArrays = new ArrayList<>();
    List<Integer> list = Arrays.stream(array).boxed().toList();
    System.out.println(list);
//    List<Integer> list = new ArrayList<>();
    for (int i = 0; i < array.length; i++) {
      for (int j = i; j < array.length; j++){
        subArrays.add(list.subList(i, j+1));
      }
    }
    System.out.println((long) subArrays.size());
    for (List<Integer> arrays : subArrays) {
      System.out.println(arrays);
    }
  }

  public static boolean canFlowersBePlaced(int[] flowerbed, int flowers) {
    boolean okToPlant = false;
    if(flowers == 0 ){
      return true ;
    }
    int sizeOfFlowerBed = flowerbed.length;
    int limitToCompareSizeOfFlowerBed = sizeOfFlowerBed-1;
    int slotToPlant = 0 ;
    int index = 0 ;
    while(index < flowerbed.length ){
      if((flowerbed[index] == 0) && ((index == 0) || (flowerbed[index - 1] == 0)) &&
              ((index == (limitToCompareSizeOfFlowerBed)) || (flowerbed[index + 1] == 0))){
        flowerbed[index] = 1 ;
        slotToPlant++ ;
      }
      if(slotToPlant == flowers){
        okToPlant=true;
        return okToPlant;

      }
      index++;
    }
    return okToPlant ;
  }

  public static boolean canPlaceFlowers(int[] flowerbed, int flowers) {
    int numberOfBeds = flowerbed.length;
    boolean response = false;
    if (numberOfBeds == 2) {
      response = ((flowerbed[0] == flowerbed[1]) && flowers == 1);
      return response;
    }
    int countZeros = 0;
    int nextZero = 1;
    for (int i = 0; i < numberOfBeds; i++) {
      if (flowerbed[i] == 1) {
        continue;
      } else if (flowerbed[nextZero + i + 1] == 0)
        countZeros++;
    }
    if (countZeros == flowers) {
      response = true;
    }


    return response;
  }
}

