package org.ferreiras.leetcode;

interface MountainArrays {
  public int get(int index);
  public int length();

}
public class MountainArray implements MountainArrays{

  public int findInMountainArray(int target, MountainArrays mountainArr) {

    int left = 0, middle = 0;
    int right = mountainArr.length() - 1;

    while (left <= right) {

      middle = (left + right) / 2;

      if (mountainArr.get(middle) < mountainArr.get(middle + 1)) {
        left = middle + 1;
      } else {
        right = middle - 1;
      }
    }

    if (mountainArr.get(left) == target)
      return left;

    int ascending = binarySearch((MountainArray) mountainArr, target, 0, left - 1, true);
    int descending = binarySearch((MountainArray) mountainArr, target, left + 1, mountainArr.length() - 1, false);

    int min = Math.min(ascending, descending);
    int max = Math.max(ascending, descending);

    if (min != -1)
      return min;
    if (max != -1)
      return max;
    return -1;
  }

  public int binarySearch(MountainArray mArr, int tar, int left, int right, boolean direction) {

    int response = -1;

    while (left <= right) {

      int mid = (left + right) / 2;
      if (mArr.get(mid) == tar) {
        response = mid;
        break;
      } else if (mArr.get(mid) < tar) {
        if (direction)
          left = mid + 1;
        else
          right = mid - 1;
      } else {
        if (direction)
          right = mid - 1;
        else
          left = mid + 1;
      }
    }

    return response;
  }

  @Override
  public int get(int index) {
    return 0;
  }

  @Override
  public int length() {
    return 0;
  }
}

