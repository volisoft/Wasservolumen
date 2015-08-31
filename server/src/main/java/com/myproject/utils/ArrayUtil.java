package com.myproject.utils;

public class ArrayUtil {
   /**
    * Scans beginning from the right side and returns cumulative sum of intermediate elements
    * @param arr input array
    * @param seed initial value
    * @return array containing cumulative sums of elements of given array
    */
   public static int[] cumulativeSumRight(int[] arr, int seed) {
      int[] result = new int[arr.length];
      for (int i = arr.length - 1; i >= 0; i--) {
         seed = Math.max(arr[i], seed);
         result[i] = seed;
      }
      return result;
   }
}
