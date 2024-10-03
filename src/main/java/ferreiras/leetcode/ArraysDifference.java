package ferreiras.leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
/*
Source: Java Generics and Collections book, (pages: 188, 211, 222, 240).
List implementations:
                      get  add  contains next remove(0) iterator.remove
ArrayList             O(1) O(1) O(n)     O(1) O(n)      O(n)
LinkedList            O(n) O(1) O(n)     O(1) O(1)      O(1)
CopyOnWrite-ArrayList O(1) O(n) O(n)     O(1) O(n)      O(n)
Set implementations:

                      add      contains next     notes
HashSet               O(1)     O(1)     O(h/n)   h is the table capacity
LinkedHashSet         O(1)     O(1)     O(1)
CopyOnWriteArraySet   O(n)     O(n)     O(1)
EnumSet               O(1)     O(1)     O(1)
TreeSet               O(log n) O(log n) O(log n)
ConcurrentSkipListSet O(log n) O(log n) O(1)
Map implementations:

                      get      containsKey next     Notes
HashMap               O(1)     O(1)        O(h/n)   h is the table capacity
LinkedHashMap         O(1)     O(1)        O(1)
IdentityHashMap       O(1)     O(1)        O(h/n)   h is the table capacity
EnumMap               O(1)     O(1)        O(1)
TreeMap               O(log n) O(log n)    O(log n)
ConcurrentHashMap     O(1)     O(1)        O(h/n)   h is the table capacity
ConcurrentSkipListMap O(log n) O(log n)    O(1)
Queue implementations:

                      offer    peek poll     size
PriorityQueue         O(log n) O(1) O(log n) O(1)
ConcurrentLinkedQueue O(1)     O(1) O(1)     O(n)
ArrayBlockingQueue    O(1)     O(1) O(1)     O(1)
LinkedBlockingQueue   O(1)     O(1) O(1)     O(1)
PriorityBlockingQueue O(log n) O(1) O(log n) O(1)
DelayQueue            O(log n) O(1) O(log n) O(1)
LinkedList            O(1)     O(1) O(1)     O(1)
ArrayDeque            O(1)     O(1) O(1)     O(1)
LinkedBlockingDeque   O(1)     O(1) O(1)     O(1)
Boolean solution provided by
https://leetcode.com/mcihan7/
 */

@ClassPreamble(
        author = "Ricardo Ferreira",
        date = "10/01/2024",
        currentRevision = 7,
        lastModified = "10/01/2024",
        lastModifiedBy = "Ricardo Ferreira",
        reviewers = {}
)

public class ArraysDifference {
  public static void main(String[] args) {
    int[] nums1 = {1, 2, 3, 4};
    int[] nums2 = {1, 4, 5, 6};

    List<List<Integer>> response = findDifference(nums1, nums2);

    for (List<Integer> list : response) {
      System.out.println(list);
    }

    /*
    [2, 3]
    [5, 6]
     */
  }

  public static List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
    Set<Integer> setOne = new HashSet<>();
    Set<Integer> setTwo = new HashSet<>();

    List<Integer> diffSetOne = new ArrayList<>();
    List<Integer> diffSetTwo = new ArrayList<>();

    for (int num : nums1) setOne.add(num);

    for (int num : nums2) {

      setTwo.add(num);

      if(setOne.add(num)) {
        diffSetTwo.add(num);
      }

    }

    for (int num : nums1) {

      if(setTwo.add(num)) {
        diffSetOne.add(num);
      }

    }

    return List.of(diffSetOne, diffSetTwo);
  }
  public static List<List<Integer>> findDifferenceZero(int[] nums1, int[] nums2) {
    Set<Integer> setOne = new HashSet<>();
    Set<Integer> setTwo = new HashSet<>();
    List<Integer> toExclude = new ArrayList<>();

    for (int num : nums1) setOne.add(num);
    for (int num : nums2) setTwo.add(num);

    int sizeOne = nums1.length;
    int sizeTwo = nums2.length;

    for (int k : nums1) {

      for (int i : nums2) {
        if (k == i) {
          toExclude.add(k);
        }
      }

    }

    for (int exclude : toExclude) {
      setOne.remove(exclude);
      setTwo.remove(exclude);
    }

    List<Integer> listOne = new ArrayList<>(setOne);
    List<Integer> listTwo = new ArrayList<>(setTwo);

    return List.of(listOne, listTwo);
  }

  public static List<List<Integer>> findDifferences(int[] nums1, int[] nums2) {
    boolean[] n1 = new boolean[2001];
    boolean[] n2 = new boolean[2001];

    ArrayList<Integer> dif1 = new ArrayList<>();
    ArrayList<Integer> dif2 = new ArrayList<>();

    for (int num : nums1) {
      n1[num + 1000] = true;
    }

    for (int num : nums2) {
      n2[num + 1000] = true;

      if (!n1[num + 1000]) {
        n1[num + 1000] = true;  // to avoid duplications
        dif2.add(num);
      }
    }

    for (int num : nums1) {
      if (!n2[num + 1000]) {
        n2[num + 1000] = true;  // to avoid duplications
        dif1.add(num);
      }
    }

    return List.of(dif1, dif2);
  }

    public static List<List<Integer>> findDifferencesBoolean(int[] nums1, int[] nums2){
      Set<Integer> set1 = new HashSet<>();
      Set<Integer> set2 = new HashSet<>();

      ArrayList<Integer> diff1 = new ArrayList<>();
      ArrayList<Integer> diff2 = new ArrayList<>();

      for (int i : nums1) {

        set1.add(i);

      }
      for (int i : nums2) {

        set2.add(i);

        if (set1.add(i)) {
          diff2.add(i);
        }

      }
      for (int i : nums1) {

        if (set2.add(i)) {
          diff1.add(i);
        }

      }

      return List.of(diff1, diff2);
    }

    public static List<List<Integer>> anotherFindDifferences(int[] nums1, int[] nums2) {
      Set<Integer> set1 = new HashSet<>();
      Set<Integer> set2 = new HashSet<>();

      for (int num : nums1) {

        set1.add(num);

      }

      for (int num : nums2) {

        set2.add(num);

      }
      List<Integer> diff1 = new ArrayList<>(set1);
      diff1.removeAll(set2);

      List<Integer> diff2 = new ArrayList<>(set2);
      diff2.removeAll(set1);

      return List.of(diff1, diff2);
    }
  }



