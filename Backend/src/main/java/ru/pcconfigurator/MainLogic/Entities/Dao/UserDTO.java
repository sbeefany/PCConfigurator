package ru.pcconfigurator.MainLogic.Entities.Dao;

import ru.pcconfigurator.MainLogic.Entities.Enums.Role;

import java.util.List;
import java.util.UUID;

public class UserDTO {

    private UUID userId;
    private String login;
    private String email;
    private List<PcConfigurationDao> pcConfigurationDaoList;
    private Role role;
    private String name;
    private Boolean isLogined;

    public UUID getUserId() {
        return userId;
    }

    public void setUserId(UUID userId) {
        this.userId = userId;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<PcConfigurationDao> getPcConfigurationDaoList() {
        return pcConfigurationDaoList;
    }

    public void setPcConfigurationDaoList(List<PcConfigurationDao> pcConfigurationDaoList) {
        this.pcConfigurationDaoList = pcConfigurationDaoList;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean getLogined() {
        return isLogined;
    }

    public void setLogined(Boolean logined) {
        isLogined = logined;
    }
}
