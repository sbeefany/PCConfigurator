package ru.pcconfigurator.MainLogic.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import ru.pcconfigurator.MainLogic.Cases.WorkWithData.IUserRepository;
import ru.pcconfigurator.MainLogic.Entities.User;

import java.util.UUID;

@RestController
@RequestMapping("/users")
public class UsersController {

    @Autowired
    private IUserRepository userRepository;

    @PostMapping("/signup")
    public void singUp(@RequestBody SignUpUserDTO user){

    }

    @PostMapping("/login")
    public void login(@RequestBody String login ,@RequestBody String password){
        User user = userRepository.findUserByLogin(login);
        if(user==null){
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "User with this login was not found");
        }
        if(user.checkPassword(password)){
            user.logIn();
        }else{

        }
    }

    @PostMapping("/logout")
    public void logout(@RequestParam("userId") UUID userId){

    }

}
