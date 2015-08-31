package com.myproject.services;

import com.myproject.utils.ArrayUtil;

import javax.ejb.Stateless;

@Stateless
public class WaterVolumeCalculator {
   private static final int MIN_GAP_LENGTH = 3;

   /**
    * Calculates water volume for given relief
    * Time complexity: best/worst/avg O(n) (makes two traversals in linear time)
    * Space complexity: best/worst/avg O(n) (requires additional array for storing maximum
    * height of a wall from right hand side)
    *
    * @param relief topography of the surface
    * @return volume of the water remained in cavities
    */
   public int calculateVolumeForRelief(int[] relief) {
      int volume = 0;
      if (relief.length < MIN_GAP_LENGTH) return volume;

      int[] rmaxHeight = ArrayUtil.cumulativeSumRight(relief, 0);

      int waterLevel = relief[0];
      for (int i = 0; i < relief.length; i++) {
         waterLevel = updateWaterLevel(relief[i], rmaxHeight[i], waterLevel);
         int diff = waterLevel - relief[i];
         volume += diff > 0 ? diff : 0;
      }

      return volume;
   }

   private int updateWaterLevel(int wallHeight, int maxRightHeight, int currentWaterLevel) {
      if (currentWaterLevel > maxRightHeight)  return maxRightHeight;
      if (currentWaterLevel < wallHeight) return wallHeight;
      return currentWaterLevel;
   }
}
