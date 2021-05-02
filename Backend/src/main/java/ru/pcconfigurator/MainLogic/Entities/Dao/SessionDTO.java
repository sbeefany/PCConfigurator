package ru.pcconfigurator.MainLogic.Entities.Dao;

import java.util.List;
import java.util.UUID;

public class SessionDTO {

    private UUID sessionId;
    private List<PcConfigurationDao> pcConfigurationDaoList;
    private List<UserDTO> users;

    public UUID getSessionId() {
        return sessionId;
    }

    public void setSessionId(UUID sessionId) {
        this.sessionId = sessionId;
    }

    public List<PcConfigurationDao> getPcConfigurationDaoList() {
        return pcConfigurationDaoList;
    }

    public void setPcConfigurationDaoList(List<PcConfigurationDao> pcConfigurationDaoList) {
        this.pcConfigurationDaoList = pcConfigurationDaoList;
    }

    public List<UserDTO> getUsers() {
        return users;
    }

    public void setUsers(List<UserDTO> users) {
        this.users = users;
    }
}
