package com.example.pcconfigurator.Data.Models

import java.util.*

data class ComparisonSession(
    val uuid: UUID,
    var configurations: List<Configuration>,
    var users: List<UUID>,
) {

    fun addConfiguration(configuration: Configuration, userId: UUID) {
        if (configurations.size < 2 && configurations.find { it.checkUserId(userId) } != null) {
            val newList = mutableListOf<Configuration>()
            newList.addAll(configurations)
            newList.add(configuration)
            configurations = newList
        }
    }

    fun inviteUser( userId: UUID) {
        if (users.size < 2 && users.find { it==userId } != null) {
            val newList = mutableListOf<UUID>()
            newList.addAll(users)
            newList.add(userId)
            users = newList
        }
    }

    fun checkConfigurationByUserId(userId: UUID): Boolean {
        return configurations.find { it.checkUserId(userId) } != null
    }
}