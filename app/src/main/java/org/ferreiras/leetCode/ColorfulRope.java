package org.ferreiras.leetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * Minimum Time to Make Rope Colorful
 * Alice has n balloons arranged on a rope. You are given a 0-indexed string colors
 * where colors[i] is the color of the ith balloon.
 *
 * Alice wants the rope to be colorful.
 * She does not want two consecutive balloons to be of the same color, so she asks Bob
 * for help. Bob can remove some balloons from the rope to make it colorful.
 * You are given a 0-indexed integer array neededTime where neededTime[i] is the time
 * (in seconds) that Bob needs to remove the ith balloon from the rope.
 *
 * Return the minimum time Bob needs to make the rope colorful
 * Input: colors = "abaac", neededTime = [1,2,3,4,5]
 * Output: 3
 * Input: colors = "abc", neededTime = [1,2,3]
 * Output: 0
 */


public class ColorfulRope {
  public static void main(String[] args) {
    String colors = "aaabbbabbbb";
    int [] neededTime = {3,5,10,7,5,3,5,5,4,8,1};
/*    System.out.println("Time to remove balloon: "+ neededTimeColor(colors,neededTime));
    System.out.println("2nd attempt: " + minCost(colors,neededTime));*/
    System.out.println("2nd attempt: " + maxCost(colors,neededTime));

  }
  public static int neededTimeColor(String colors, int[] neededTime) {
    int left=0, right = 1;
    int maxIndex=colors.length()-1;
    List<Integer> timeToRemove = new ArrayList<>();
    for (; left < maxIndex; left++) {
      if (colors.charAt(left) == colors.charAt(right)) {
        timeToRemove.add(Math.min(neededTime[left], neededTime[right]));
      }
      right++;
    }
    return timeToRemove.stream().reduce(0, Integer::sum);
  }

  public static int minCost(String colors, int[] neededTime) {
    char[] balloon = colors.toCharArray();
    int minTime = 0,j=0;
    for(int i=1;i<balloon.length;i++){
      if(balloon[j]==balloon[i]){
        if(neededTime[i]<neededTime[j]){
          minTime+=neededTime[i];
        }else{
          minTime+=neededTime[j];
          j=i;
        }
      }else{
        j=i;
      }
    }
    return minTime;
  }
  public static int maxCost(String colors, int[] neededTime) {
    int ptrOne=0;
    int maxIndex = colors.length();
    List<Integer> timeToRemove = new ArrayList<>();
    for (int ptrTwo=1; ptrTwo < maxIndex; ptrTwo++) {
      if (colors.charAt(ptrOne) == (colors.charAt(ptrTwo))) {
        if(neededTime[ptrTwo] < neededTime[ptrOne]) {
          timeToRemove.add(neededTime[ptrTwo]);
        } else {
          timeToRemove.add(neededTime[ptrOne]);
          ptrOne = ptrTwo;
        }
      } else {
        ptrOne = ptrTwo;
      }
    }
    return timeToRemove.stream().mapToInt(Integer::intValue).sum();
  }
}
