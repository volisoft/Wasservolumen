package com.myproject.services;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class WaterVolumeServiceTest {
   WaterVolumeCalculator volumeService = new WaterVolumeCalculator();

   @Test
   public void emptyRelief_volume_zero() {
      int volume = volumeService.calculateVolumeForRelief(new int[]{});
      assertThat(volume, is(0));

   }

   @Test
   public void insufficientlyShortRelief_volume_zero() {
      int volume = volumeService.calculateVolumeForRelief(new int[]{1, 2});
      assertThat(volume, is(0));

   }

   @Test
   public void declinedRelief_volume_zero() {
      int volume = volumeService.calculateVolumeForRelief(new int[]{1, 2, 3});
      assertThat(volume, is(0));

   }

   @Test
   public void inclinedRelief_volume_zero() {
      int volume = volumeService.calculateVolumeForRelief(new int[]{3, 2, 1});
      assertThat(volume, is(0));
   }

   @Test
   public void oscillatingInclinedRelief_volume_two() {
      int volume = volumeService.calculateVolumeForRelief(new int[]{1, 0, 1, 3, 2, 1, 2});
      assertThat(volume, is(2));
   }

   @Test
   public void oscillatingDeclinedRelief_volume_two() {
      int volume = volumeService.calculateVolumeForRelief(new int[]{2, 1, 2, 3, 1, 0, 1});
      assertThat(volume, is(2));
   }

   @Test
   public void negativeRelief_volume_zero() {
      int volume = volumeService.calculateVolumeForRelief(new int[]{1, -1, 1});
      assertThat(volume, is(2));

   }
}