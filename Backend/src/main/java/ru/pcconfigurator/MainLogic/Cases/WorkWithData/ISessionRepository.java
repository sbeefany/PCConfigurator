package ru.pcconfigurator.MainLogic.Cases.WorkWithData;

import ru.pcconfigurator.MainLogic.Entities.ComparisonSession;

import java.util.List;
import java.util.UUID;

public interface ISessionRepository {

    void saveSession(ComparisonSession session);

    ComparisonSession findSession(UUID sessionId);

    void deleteSession(UUID sessionId);

    List<ComparisonSession> getAllSessions();


}
