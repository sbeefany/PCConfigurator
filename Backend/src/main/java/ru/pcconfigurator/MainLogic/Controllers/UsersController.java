package ru.pcconfigurator.MainLogic.Controllers;

import ru.pcconfigurator.MainLogic.Entities.Dao.LoginDTO;
import ru.pcconfigurator.MainLogic.Entities.Dao.SignUpUserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import ru.pcconfigurator.MainLogic.Cases.WorkWithData.IUserRepository;
import ru.pcconfigurator.MainLogic.Entities.Enums.Role;
import ru.pcconfigurator.MainLogic.Entities.User;

import java.util.Collections;
import java.util.UUID;

@RestController
@RequestMapping("/users")
public class UsersController {

    @Autowired
    private IUserRepository userRepository;

    @PostMapping("/signup")
    public void singUp(@RequestBody SignUpUserDTO newUser) {
        User user = new User(newUser.getEmail(), newUser.getPassword(), newUser.getName(), newUser.getLogin(), Role.User, Collections.emptyList());
        userRepository.signUp(user);
    }

    @PostMapping("/login")
    public UUID login(@RequestBody LoginDTO loginDTO) {
        User user = userRepository.findUserByLogin(loginDTO.getLogin());
        if (user == null) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "User with this login was not found");
        }
        if (user.checkPassword(loginDTO.getPassword())) {
            user = user.logIn();
            userRepository.saveUser(user);
            return user.getUserId();
        } else {
            throw new ResponseStatusException(
                    HttpStatus.FORBIDDEN, "Password is incorrect");
        }
    }

    @PostMapping("/logout")
    public void logout(@RequestParam("userId") UUID userId) {
        User user = userRepository.findUserById(userId);
        if (user != null) {
            user = user.logOut();
            userRepository.saveUser(user);
        } else {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "User with id login was not found");
        }

    }

}
