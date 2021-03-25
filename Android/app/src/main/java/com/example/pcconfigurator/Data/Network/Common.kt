package com.example.pcconfigurator.Data.Network

object Common {

    private val BASE_URL = "https://www.simplifiedcoding.net/demos/"
    val retrofitApi: ConfigurationsApi
        get() = ConfigurationsRestApi.getClient(BASE_URL).create(ConfigurationsApi::class.java)
}