package ru.pcconfigurator.MainLogic.Cases.WorkWithData;

import org.springframework.stereotype.Component;
import ru.pcconfigurator.MainLogic.Entities.ComparisonSession;
import ru.pcconfigurator.MainLogic.Entities.Enums.Role;
import ru.pcconfigurator.MainLogic.Entities.PcConfiguration;
import ru.pcconfigurator.MainLogic.Entities.User;

import java.util.*;
@Component
public class FakeSessionRepository implements ISessionRepository {

    private List<ComparisonSession> sessions = List.of(new ComparisonSession(Collections.emptyList(),
            List.of(new User("1", "1", "1", "1", Role.User, Collections.emptyList(), Boolean.TRUE, UUID.fromString("146c41eb-a114-4bdc-96be-0d606e40f380")))));
    @Override
    public void saveSession(ComparisonSession session) {
        ArrayList<ComparisonSession> sessions1 = new ArrayList<>(this.sessions);
        deleteSession(session.getSessionId());
        sessions1.add(session);
        sessions = sessions1;
    }

    @Override
    public ComparisonSession findSession(UUID sessionId) {
        return this.sessions.stream().filter(
                session -> session.checkId(sessionId)).findFirst().orElse(null);
    }

    @Override
    public void deleteSession(UUID sessionId) {
        LinkedList<ComparisonSession> sessions = new LinkedList<>(this.sessions);
        sessions.remove(this.sessions.stream().filter(
                session -> session.checkId(sessionId)).findFirst().orElse(null));
        this.sessions = sessions;
    }

    @Override
    public List<ComparisonSession> getAllSessions() {
        return List.copyOf(sessions);
    }
}
