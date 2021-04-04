package ru.pcconfigurator.MainLogic.Cases.WorkWithData;

import org.springframework.stereotype.Component;
import ru.pcconfigurator.MainLogic.Entities.Enums.Role;
import ru.pcconfigurator.MainLogic.Entities.User;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.UUID;

@Component
public class FakeUserRepository implements IUserRepository {

    private List<User> users = List.of(new User("1", "1", "1", "1", Role.User, Collections.emptyList(), Boolean.TRUE, UUID.fromString("146c41eb-a114-4bdc-96be-0d606e40f380")));

    @Override
    public User findUserById(UUID userId) {
        return users.stream().filter(user -> user.getUserId().equals(userId)).findFirst().orElse(null);
    }

    @Override
    public User findUserByLogin(String login) {
        return users.stream().filter(user -> user.getLogin().equals(login)).findFirst().orElse(null);
    }

    @Override
    public void signUp(User user) {
        ArrayList<User> usersList = new ArrayList<>(users);
        usersList.add(user);
        users = usersList;
    }

    @Override
    public void saveUser(User user) {
        ArrayList<User> usersList = new ArrayList<>(users);
        usersList.remove(users.stream().filter(user1 -> user1.getUserId().equals(user.getUserId())).findFirst().orElse(null));
        usersList.add(user);
        users = usersList;
    }

}
