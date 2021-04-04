package ru.pcconfigurator.MainLogic.Entities;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.UUID;

public class ComparisonSession {

    private final UUID sessionId;
    private final List<PcConfiguration> configurations;
    private final List<User> users;

    public ComparisonSession(List<PcConfiguration> configurations, List<User> users) {
        this.sessionId = UUID.randomUUID();
        this.configurations = configurations;
        this.users = users;
    }

    public ComparisonSession(UUID sessionId, List<PcConfiguration> configurations, List<User> users) {
        this.sessionId = sessionId;
        this.configurations = configurations;
        this.users = users;
    }

    public ComparisonSession addPcConfiguration(PcConfiguration configuration) {
        List<PcConfiguration> newList = new ArrayList<>(this.configurations);
        boolean checkConfiguration = newList.stream().anyMatch(configuration1 -> {
            return configuration1.getId().equals(configuration.getId());
        });
        if (checkConfiguration) {
            return this;
        } else {
            newList.add(configuration);
            return new ComparisonSession(this.sessionId, newList, this.users);
        }
    }

    public ComparisonSession deletePcConfiguration(UUID configurationId) {
        List<PcConfiguration> newList = new LinkedList<>(this.configurations);
        boolean checkConfiguration = newList.stream().anyMatch(configuration1 -> {
            return configuration1.getId().equals(configurationId);
        });
        if (checkConfiguration) {
            newList.remove(newList.stream().filter(pcConfiguration -> pcConfiguration.getId().equals(configurationId)).findFirst().orElse(null));
            return new ComparisonSession(this.sessionId, newList, this.users);
        } else {
            return this;
        }
    }

    public ComparisonSession inviteUser(User newUser) {
        List<User> newList = new LinkedList<>(this.users);
        User user = findUser(newUser.getUserId());
        if (user != null) {
            return this;
        } else {
            newList.add(newUser);
            return new ComparisonSession(this.sessionId, this.configurations, newList);
        }
    }

    public ComparisonSession removeUser(UUID userId) {
        List<User> newList = new ArrayList<>(this.users);
        User user = findUser(userId);
        if (user != null) {
            newList.remove(findUser(userId));
            return new ComparisonSession(this.sessionId, this.configurations, newList);
        } else {
            return this;
        }
    }

    public Boolean isThereThisUser(UUID userId) {
        return findUser(userId) != null;
    }

    public Boolean checkId(UUID sessionId) {
        return this.sessionId.equals(sessionId);
    }

    private User findUser(UUID userId) {
        return users.stream().filter(user -> user.checkId(userId)).findFirst().orElse(null);
    }

    public UUID getSessionId() {
        return sessionId;
    }
}
