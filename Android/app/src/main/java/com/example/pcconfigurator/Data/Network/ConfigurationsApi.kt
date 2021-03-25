package com.example.pcconfigurator.Data.Network

import com.example.pcconfigurator.Data.Network.NetworkDTO.AccessoryDTO
import com.example.pcconfigurator.Data.Network.NetworkDTO.ConfigurationDTO
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
    fun findConfigurationById(@Path("configurationId") configurationId: UUID) : ConfigurationDTO

    @POST("/pcconfigurations")
    fun createConfiguration(@Body accessoriesDTO: List<AccessoryDTO>): UUID

    @GET("/pcconfigurations")
    fun findAllConfigurations():List<ConfigurationDTO>

}