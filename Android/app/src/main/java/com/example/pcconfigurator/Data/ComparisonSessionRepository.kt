package com.example.pcconfigurator.Data

import com.example.pcconfigurator.Data.Models.ComparisonSession
import java.util.*

object ComparisonSessionRepository {

    var comparisonSessions:List<ComparisonSession> = listOf(ComparisonSession(UUID.fromString("fbea6d48-9ac8-441a-8bb5-ea6cba6eed76"),
        listOf(),
        listOf(UUID.fromString("be0b6c37-f50d-4511-9e3b-31cff4de6b11"))))

    fun saveComparisonSession(comparisonSession: ComparisonSession){
        val newList = mutableListOf<ComparisonSession>()
        newList.addAll(comparisonSessions)
        newList.add(comparisonSession)
        comparisonSessions=newList
    }

    fun getComparisonSessionById(uuid: UUID) = comparisonSessions.find { it.uuid == uuid }

    fun getComparisonSessionByUserId(userID:UUID) = comparisonSessions.find { it.checkConfigurationByUserId(userID) }
}