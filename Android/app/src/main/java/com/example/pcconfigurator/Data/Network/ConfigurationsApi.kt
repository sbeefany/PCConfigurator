package com.example.pcconfigurator.Data.Network

import Accessory
import com.example.pcconfigurator.Data.Models.Configuration
import retrofit2.http.*
import java.util.*

interface ConfigurationsApi {

    @POST("/pcconfigurations/{configurationId}/accessories")
    fun addAccessory(@Path("configurationId") configurationId:UUID, @Body accessoryId:UUID)

    @DELETE("/pcconfigurations/{configurationId}/accessories/{accessoryId}")
    fun deleteAccessory(@Path("accessoryId") accessoryId: UUID,@Path("configurationId") configurationId: UUID)

    @PUT("/pcconfigurations/{configurationId}/accessories/{accessoryId}")
    fun updateAccessory(@Path("configurationId") configurationId: UUID,@Path("accessoryId") accessoryId: UUID, @Body newAccessoryId: UUID)

    @GET("/pcconfigurations/{configurationId}")
    fun findConfigurationById(@Path("configurationId") configurationId: UUID) : Configuration

    @POST("/pcconfigurations")
    fun createConfiguration(@Body accessoriesDTO: List<Accessory>): UUID

    @GET("/pcconfigurations")
    fun findAllConfigurations():List<Configuration>

}