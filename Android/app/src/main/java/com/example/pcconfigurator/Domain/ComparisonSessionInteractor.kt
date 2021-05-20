package com.example.pcconfigurator.Domain

import com.example.pcconfigurator.Data.ComparisonSessionRepository
import com.example.pcconfigurator.Data.ConfigurationsRepository
import com.example.pcconfigurator.Data.Models.ComparisonSession
import com.example.pcconfigurator.Data.Models.Configuration
import java.lang.NullPointerException
import java.util.*

object ComparisonSessionInteractor {

    fun createComparisonSession(authorId: UUID): ComparisonSession {
        val comparisonSession = ComparisonSession(UUID.randomUUID(),
            listOf(), listOf(authorId))
        ComparisonSessionRepository.saveComparisonSession(comparisonSession)
        return comparisonSession
    }

    fun inviteUser(comparisonSessionId: UUID, newUserId: UUID): ComparisonSession {
        val comparisonSession =
            ComparisonSessionRepository.getComparisonSessionById(comparisonSessionId)
        if (comparisonSession != null) {
            comparisonSession.inviteUser(newUserId)
            return comparisonSession
        }
        throw NullPointerException("ComparisonSession with this Id had not been found")
    }

    fun addConfiguration(
        comparisonSessionId: UUID,
        configurationId: UUID,
        userId: UUID,
    ): ComparisonSession {
        val comparisonSession =
            ComparisonSessionRepository.getComparisonSessionById(comparisonSessionId)
        if (comparisonSession != null) {
            comparisonSession.addConfiguration(ConfigurationsRepository.getConfiguration(
                configurationId), userId)
            return comparisonSession
        }
        throw NullPointerException("ComparisonSession with this Id had not been found")
    }

    fun findComparisonSession(uuid: UUID) =
        ComparisonSessionRepository.getComparisonSessionByUserId(uuid)
}