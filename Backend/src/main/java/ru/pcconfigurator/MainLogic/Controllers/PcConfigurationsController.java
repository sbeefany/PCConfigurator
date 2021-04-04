package ru.pcconfigurator.MainLogic.Controllers;

import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import ru.pcconfigurator.MainLogic.Cases.WorkWithData.IAccessoriesRepository;
import ru.pcconfigurator.MainLogic.Cases.WorkWithData.IConfigurationRepository;
import ru.pcconfigurator.MainLogic.Cases.WorkWithData.IUserRepository;
import ru.pcconfigurator.MainLogic.Entities.Accessory;
import ru.pcconfigurator.MainLogic.Entities.Dao.AccessoryDao;
import ru.pcconfigurator.MainLogic.Entities.Dao.PcConfigurationDao;
import ru.pcconfigurator.MainLogic.Entities.Enums.Role;
import ru.pcconfigurator.MainLogic.Entities.PcConfiguration;
import ru.pcconfigurator.MainLogic.Entities.User;

import java.util.List;
import java.util.Objects;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@RestController
@RequestMapping("/pcconfigurations")
public class PcConfigurationsController {

    @Autowired
    private IAccessoriesRepository accessoriesRepository;
    @Autowired
    private IConfigurationRepository configurationRepository;
    @Autowired
    private IUserRepository userRepository;


    @PostMapping("/{configurationId}/accessories")
    public void addAccessory(@PathVariable("configurationId") @NotNull UUID configurationId,
                             @NotNull @RequestBody UUID accessoryId, @RequestParam("userId") String userId) {
        User user = userRepository.findUserById(UUID.fromString(userId));
        checkUserLogin(user);
        checkUserAndConfiguration(user, configurationId);
        PcConfiguration configuration = configurationRepository.getPcConfiguration(configurationId);
        Accessory accessory = accessoriesRepository.findAccessoryById(accessoryId);
        if (configuration != null && accessory != null) {
            configuration = configuration.addAccessory(accessory);
            configurationRepository.saveConfiguration(configuration);
        } else {
            if (configuration == null)
                throw new ResponseStatusException(
                        HttpStatus.NOT_FOUND, "There is not configuration with this id");
            else
                throw new ResponseStatusException(
                        HttpStatus.BAD_REQUEST, "There is not accessory with this id");
        }

    }

    @DeleteMapping("/{configurationId}/accessories/{accessoryId}")
    public void deleteAccessory(@PathVariable("accessoryId") @NotNull UUID accessoryId,
                                @PathVariable("configurationId") @NotNull UUID configurationId, @RequestParam("userId") String userId) {
        User user = userRepository.findUserById(UUID.fromString(userId));
        checkUserLogin(user);
        checkUserAndConfiguration(user, configurationId);
        PcConfiguration configuration = configurationRepository.getPcConfiguration(configurationId);
        if (configuration != null && configuration.hasThisAccessory(accessoryId)) {
            configuration = configuration.deleteAccessory(accessoryId);
            configurationRepository.saveConfiguration(configuration);
        } else {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "There is not configuration with this id or there is not accessory with this Id in this configuration");
        }

    }

    @PutMapping("/{configurationId}/accessories/{accessoryId}")
    public void updateAccessory(@PathVariable("accessoryId") @NotNull UUID oldAccessory, @PathVariable("configurationId") @NotNull UUID configurationId,
                                @RequestBody @NotNull UUID accessoryId, @RequestParam("userId") String userId) {
        User user = userRepository.findUserById(UUID.fromString(userId));
        checkUserLogin(user);
        checkUserAndConfiguration(user, configurationId);
        PcConfiguration configuration = configurationRepository.getPcConfiguration(configurationId);
        Accessory accessory = accessoriesRepository.findAccessoryById(accessoryId);
        if (configuration != null && configuration.hasThisAccessory(oldAccessory) && accessory != null) {
            configuration = configuration.deleteAccessory(oldAccessory);
            configuration = configuration.addAccessory(accessory);
            configurationRepository.saveConfiguration(configuration);
        } else {
            if (accessory == null)
                throw new ResponseStatusException(
                        HttpStatus.BAD_REQUEST, "There is not accessory with this id");
            else
                throw new ResponseStatusException(
                        HttpStatus.NOT_FOUND, "There is not configuration with this id or there is not accessory with this Id in this configuration");
        }


    }

    @GetMapping("/{configurationId}")
    public PcConfigurationDao findPcConfigurationById(@PathVariable("configurationId") @NotNull UUID configurationId, @RequestParam("userId") String userId) {
        User user = userRepository.findUserById(UUID.fromString(userId));
        checkUserLogin(user);
        checkUserAndConfiguration(user, configurationId);
        PcConfiguration pcConfiguration = configurationRepository.getPcConfiguration(configurationId);
        if (pcConfiguration != null)
            return pcConfiguration.convertToDao();
        else
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "There is not configuration with this id");
    }

    @PostMapping("")
    public void createPcConfiguration(@RequestBody @NotNull List<AccessoryDao> accessoryDaos, @RequestParam("userId") String userId) {
        User user = userRepository.findUserById(UUID.fromString(userId));
        checkUserLogin(user);
        List<Accessory> accessories = accessoryDaos.stream()
                .map(accessoryDao -> accessoriesRepository.findAccessoryById(accessoryDao.getId())).collect(Collectors.toList());

        if (accessories.stream().noneMatch(Objects::isNull)) {
            PcConfiguration pcConfiguration = new PcConfiguration(
                    accessories);
            configurationRepository.saveConfiguration(pcConfiguration);
            user = user.addNewConfiguration(pcConfiguration);
            userRepository.saveUser(user);
        } else {
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST, "There is not accessory with this id");
        }

    }

    @GetMapping("")
    public List<PcConfigurationDao> findAllPcConfigurations(@RequestParam("userId") String userId) {
        User user = userRepository.findUserById(UUID.fromString(userId));
        checkUserLogin(user);
        if (user.getRole().equals(Role.Administrator))
            return configurationRepository.getAllPcConfigurations().stream().map(PcConfiguration::convertToDao).collect(Collectors.toList());
        else {
            return configurationRepository.getAllPcConfigurations().stream().filter(pcConfiguration -> user.hasThisConfiguration(pcConfiguration.getId()))
                    .map(PcConfiguration::convertToDao).collect(Collectors.toList());
        }
    }

    private void checkUserAndConfiguration(User user, UUID configurationId) {
        if (!user.hasThisConfiguration(configurationId)) {
            throw new ResponseStatusException(
                    HttpStatus.FORBIDDEN, "This user has not got this configuration");
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

}

