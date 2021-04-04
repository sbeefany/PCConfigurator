package ru.pcconfigurator.MainLogic.Cases.WorkWithData;

import ru.pcconfigurator.MainLogic.Entities.User;

import java.util.UUID;

public interface IUserRepository {

    public User findUserById(UUID userId);

    public User findUserByLogin(String login);

    public void signUp(User user);

    public void saveUser(User user);
}
