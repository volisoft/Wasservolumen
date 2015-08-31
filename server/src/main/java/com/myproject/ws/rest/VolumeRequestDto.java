package com.myproject.ws.rest;

import javax.validation.constraints.NotNull;

public class VolumeRequestDto {
   @NotNull
   private int[] relief;

   public int[] getRelief() {
      return relief;
   }

   public void setRelief(int[] relief) {
      this.relief = relief;
   }
}
