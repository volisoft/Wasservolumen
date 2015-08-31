package com.myproject.ws.rest;

import com.myproject.services.WaterVolumeCalculator;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.ws.rs.ApplicationPath;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.MediaType;

@Stateless
@ApplicationPath("myproject")
@Path("/water/volume")
public class VolumeService extends Application {
   @Inject
   private WaterVolumeCalculator volumeCalculator;

   @POST
   @Produces(MediaType.TEXT_PLAIN) @Consumes(MediaType.APPLICATION_JSON)
   public int getClichedMessage(@NotNull @Valid VolumeRequestDto dto) {
      return volumeCalculator.calculateVolumeForRelief(dto.getRelief());
   }
}

