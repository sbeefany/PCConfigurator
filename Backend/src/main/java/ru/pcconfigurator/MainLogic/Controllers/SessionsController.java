package ru.pcconfigurator.MainLogic.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import ru.pcconfigurator.MainLogic.Cases.WorkWithData.IConfigurationRepository;
import ru.pcconfigurator.MainLogic.Cases.WorkWithData.ISessionRepository;
import ru.pcconfigurator.MainLogic.Cases.WorkWithData.IUserRepository;
import ru.pcconfigurator.MainLogic.Entities.ComparisonSession;
import ru.pcconfigurator.MainLogic.Entities.Dao.SessionDTO;
import ru.pcconfigurator.MainLogic.Entities.Enums.Role;
import ru.pcconfigurator.MainLogic.Entities.PcConfiguration;
import ru.pcconfigurator.MainLogic.Entities.User;

import java.util.Collections;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/sessions")
public class SessionsController {

    @Autowired
    private ISessionRepository sessionRepository;
    @Autowired
    private IConfigurationRepository configurationRepository;
    @Autowired
    private IUserRepository userRepository;

    @PostMapping("")
    public void createSession(@RequestParam("userId") String userId) {
        User user = userRepository.findUserById(UUID.fromString(userId));
        checkUserLogin(user);
        ComparisonSession session = new ComparisonSession(Collections.emptyList(), List.of(user));
        sessionRepository.saveSession(session);
    }

    @GetMapping("")
    public List<SessionDTO> getAllSessions(@RequestParam("userId") String userId) {
        User user = userRepository.findUserById(UUID.fromString(userId));
        checkUserLogin(user);
        if (user.getRole().equals(Role.Administrator))
            return sessionRepository.getAllSessions().stream().map(ComparisonSession::convertToSessionDto).collect(Collectors.toList());
        else
            return sessionRepository.getAllSessions().stream().filter(session -> session.isThereThisUser(UUID.fromString(userId))).map(ComparisonSession::convertToSessionDto).collect(Collectors.toList());

    }

    @PostMapping("/{sessionId}/users/{userId}")
    public void invitePerson(@PathVariable("sessionId") UUID sessionId, @PathVariable("userId") UUID newUserId, @RequestParam("userId") String userId) {
        User user = userRepository.findUserById(UUID.fromString(userId));
        checkUserLogin(user);
        ComparisonSession session = sessionRepository.findSession(sessionId);
        checkUserAndSession(session, user);
        User newUser = userRepository.findUserById(newUserId);
        if (newUser != null) {
            session = session.inviteUser(userRepository.findUserById(newUserId));
            sessionRepository.saveSession(session);
        } else {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "User with this id was not found");
        }
    }

    @DeleteMapping("/{sessionId}/users/{userId}")
    public void deletePerson(@PathVariable("sessionId") UUID sessionId, @PathVariable("userId") UUID oldUserId, @RequestParam("userId") String userId) {
        if (oldUserId.equals(UUID.fromString(userId)))
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST, "You try delete yourself");
        User user = userRepository.findUserById(UUID.fromString(userId));
        checkUserLogin(user);
        ComparisonSession session = sessionRepository.findSession(sessionId);
        checkUserAndSession(session, user);
        if (session.isThereThisUser(oldUserId)) {
            session = session.removeUser(oldUserId);
            sessionRepository.saveSession(session);
        } else {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "User with this id was not found");
        }
    }

    @GetMapping("/{sessionId}")
    public SessionDTO findSession(@PathVariable("sessionId") UUID sessionId, @RequestParam("userId") String userId) {
        User user = userRepository.findUserById(UUID.fromString(userId));
        checkUserLogin(user);
        ComparisonSession session = sessionRepository.findSession(sessionId);
        checkUserAndSession(session, user);
        return session.convertToSessionDto();
    }

    @DeleteMapping("/{sessionId}")
    public void deleteSession(@PathVariable("sessionId") UUID sessionId, @RequestParam("userId") String userId) {
        User user = userRepository.findUserById(UUID.fromString(userId));
        checkUserLogin(user);
        ComparisonSession session = sessionRepository.findSession(sessionId);
        checkUserAndSession(session, user);
        sessionRepository.deleteSession(sessionId);
    }

    @PostMapping("/{sessionId}/configurations/{configurationId}")
    public void addConfiguration(@PathVariable("sessionId") UUID sessionId, @PathVariable("configurationId") UUID configurationId, @RequestParam("userId") String userId) {
        User user = userRepository.findUserById(UUID.fromString(userId));
        checkUserLogin(user);
        ComparisonSession session = sessionRepository.findSession(sessionId);
        checkUserAndSession(session, user);
        checkUserAndConfiguration(user, configurationId);
        PcConfiguration configuration = configurationRepository.getPcConfiguration(configurationId);
        session = session.addPcConfiguration(configuration);
        sessionRepository.saveSession(session);

    }

    @DeleteMapping("/{sessionId}/configurations/{configurationId}")
    public void deleteConfiguration(@PathVariable("sessionId") UUID sessionId, @PathVariable("configurationId") UUID configurationId, @RequestParam("userId") String userId) {
        User user = userRepository.findUserById(UUID.fromString(userId));
        checkUserLogin(user);
        ComparisonSession session = sessionRepository.findSession(sessionId);
        checkUserAndSession(session, user);
        checkUserAndConfiguration(user, configurationId);
        session = session.deletePcConfiguration(configurationId);
        sessionRepository.saveSession(session);
    }

    private void checkUserAndSession(ComparisonSession session, User user) {
        if (session == null)
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Session with this id was not found");
        if (!session.isThereThisUser(user.getUserId())) {
            throw new ResponseStatusException(
                    HttpStatus.FORBIDDEN, "This user has not access to this session");
        }
    }

    private void checkUserLogin(User user) {
        if (user == null) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "User with this id was not found");
        }
        if (!user.getLogined()) {
            throw new ResponseStatusException(
                    HttpStatus.UNAUTHORIZED, "User is not logined");
        }
    }

    private void checkUserAndConfiguration(User user, UUID configurationId) {
        if (configurationRepository.getPcConfiguration(configurationId) == null) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Configuration with this id was not found");
        }
        if (!user.hasThisConfiguration(configurationId)) {
            throw new ResponseStatusException(
                    HttpStatus.FORBIDDEN, "This user has not got this configuration");
        }
    }

}
