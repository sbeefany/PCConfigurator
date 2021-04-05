package ru.pcconfigurator.MainLogic.Entities;

import ru.pcconfigurator.MainLogic.Entities.Dao.UserDTO;
import ru.pcconfigurator.MainLogic.Entities.Enums.Role;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

public class User {

    private final String email;
    private final String password;
    private final String name;
    private final String login;
    private final Role role;
    private final List<PcConfiguration> configurationList;
    private final Boolean isLogined;
    private final UUID userId;


    public User(String email, String password, String name, String login, Role role, List<PcConfiguration> configurationList) {
        this.email = email;
        this.password = password;
        this.name = name;
        this.login = login;
        this.role = role;
        this.configurationList = configurationList;
        userId = UUID.randomUUID();
        isLogined = false;
    }

    public User(String email, String password, String name, String login, Role role, List<PcConfiguration> configurationList, Boolean isLogined, UUID userId) {
        this.email = email;
        this.password = password;
        this.name = name;
        this.login = login;
        this.role = role;
        this.configurationList = configurationList;
        this.isLogined = isLogined;
        this.userId = userId;
    }

    public User addNewConfiguration(PcConfiguration configuration) {
        List<PcConfiguration> newList = new ArrayList<>(this.configurationList);
        boolean checkConfiguration = newList.stream().anyMatch(configuration1 -> {
            return configuration1.getId().equals(configuration.getId());
        });
        if (checkConfiguration) {
            return this;
        } else {
            newList.add(configuration);
            return new User(this.email, this.password, this.name, this.login, this.role, newList, this.isLogined, this.userId);
        }
    }

    public User deleteConfiguration(UUID configurationId) {
        List<PcConfiguration> newList = new LinkedList<>(this.configurationList);
        boolean checkConfiguration = newList.stream().anyMatch(configuration1 -> {
            return configuration1.getId().equals(configurationId);
        });
        if (checkConfiguration) {
            newList.remove(newList.stream().filter(pcConfiguration -> pcConfiguration.getId().equals(configurationId)).findFirst().orElse(null));
            return new User(this.email, this.password, this.name, this.login, this.role, newList, this.isLogined, this.userId);
        } else {
            return this;
        }
    }

    public Boolean checkEmail(String email) {
        return this.email.equals(email);
    }

    public Boolean checkPassword(String password) {
        return this.password.equals(password);
    }

    public Boolean checkId(UUID id) {
        return this.userId.equals(id);
    }

    public User changePassword(String newPassword) {
        return new User(this.email, newPassword, this.name, this.login, this.role, List.copyOf(this.configurationList), this.isLogined, this.userId);
    }

    public UUID getUserId() {
        return userId;
    }

    public User logIn() {
        return new User(this.email, this.password, this.name, this.login, this.role, List.copyOf(this.configurationList), true, this.userId);
    }

    public User logOut() {
        return new User(this.email, this.password, this.name, this.login, this.role, List.copyOf(this.configurationList), false, this.userId);
    }

    public Boolean getLogined() {
        return isLogined;
    }

    public Role getRole() {
        return role;
    }

    public String getLogin() {
        return login;
    }

    public Boolean hasThisConfiguration(UUID configurationId) {
        return configurationList.stream().anyMatch(pcConfiguration -> pcConfiguration.checkId(configurationId));
    }

    public UserDTO convertToDto() {
        UserDTO userDTO = new UserDTO();
        userDTO.setUserId(this.userId);
        userDTO.setEmail(this.email);
        userDTO.setLogin(this.login);
        userDTO.setLogined(this.isLogined);
        userDTO.setName(this.name);
        userDTO.setRole(this.role);
        userDTO.setPcConfigurationDaoList(this.configurationList.stream().map(PcConfiguration::convertToDao).collect(Collectors.toList()));
        return userDTO;
    }
}
