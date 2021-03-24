package ru.pcconfigurator.MainLogic.Controllers;

import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import ru.pcconfigurator.MainLogic.Cases.WorkWithData.IAccessoriesRepository;
import ru.pcconfigurator.MainLogic.Cases.WorkWithData.IConfigurationRepository;
import ru.pcconfigurator.MainLogic.Entities.Accessory;
import ru.pcconfigurator.MainLogic.Entities.Dao.AccessoryDao;
import ru.pcconfigurator.MainLogic.Entities.Dao.PcConfigurationDao;
import ru.pcconfigurator.MainLogic.Entities.PcConfiguration;

import java.util.List;
import java.util.Objects;
import java.util.UUID;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@RestController
@RequestMapping("/pcconfigurations")
public class PcConfigurationsController {

    @Autowired
    private IAccessoriesRepository accessoriesRepository;
    @Autowired
    private IConfigurationRepository configurationRepository;


    @PostMapping("/{configurationId}/accessories")
    public void addAccessory(@PathVariable("configurationId") @NotNull UUID configurationId,
                             @NotNull @RequestBody UUID accessoryId) {
        PcConfiguration configuration = configurationRepository.getPcConfiguration(configurationId);
        Accessory accessory = accessoriesRepository.findAccessoryById(accessoryId);
        if (configuration != null && accessory != null) {
            configuration = configuration.addAccessory(accessory);
            configurationRepository.saveConfiguration(configuration);
        }else{
            if(configuration==null)
                throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "There is not configuration with this id");
            else
                throw new ResponseStatusException(
                        HttpStatus.BAD_REQUEST, "There is not accessory with this id");
        }

    }

    @DeleteMapping("/{configurationId}/accessories/{accessoryId}")
    public void deleteAccessory(@PathVariable("accessoryId") @NotNull UUID accessoryId,
                                @PathVariable("configurationId") @NotNull UUID configurationId) {
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
                                @RequestBody @NotNull UUID accessoryId) {
        PcConfiguration configuration = configurationRepository.getPcConfiguration(configurationId);
        Accessory accessory = accessoriesRepository.findAccessoryById(accessoryId);
        if (configuration != null && configuration.hasThisAccessory(oldAccessory) && accessory!=null) {
            configuration = configuration.deleteAccessory(oldAccessory);
            configuration = configuration.addAccessory(accessory);
            configurationRepository.saveConfiguration(configuration);
        } else {
            if(accessory == null)
                throw new ResponseStatusException(
                        HttpStatus.BAD_REQUEST, "There is not accessory with this id");
            else
                throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "There is not configuration with this id or there is not accessory with this Id in this configuration");
        }


    }

    @GetMapping("/{configurationId}")
    public PcConfigurationDao findPcConfigurationById(@PathVariable("configurationId") @NotNull UUID configurationId) {
        PcConfiguration pcConfiguration = configurationRepository.getPcConfiguration(configurationId);
        if (pcConfiguration != null)
            return pcConfiguration.convertToDao();
        else
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "There is not configuration with this id");
    }

    @PostMapping("")
    public void createPcConfiguration(@RequestBody @NotNull List<AccessoryDao> accessoryDaos) {
        Stream<Accessory> accessoryStream = accessoryDaos.stream()
                .map(accessoryDao -> accessoriesRepository.findAccessoryById(accessoryDao.getId()));
        if (accessoryStream.noneMatch(Objects::isNull)) {
            configurationRepository.saveConfiguration(new PcConfiguration(
                    accessoryStream.collect(Collectors.toList())));
        } else {
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST, "There is not accessory with this id");
        }

    }

    @GetMapping("")
    public List<PcConfigurationDao> findAllPcConfigurations() {
        return configurationRepository.getAllPcConfigurations().stream().map(PcConfiguration::convertToDao).collect(Collectors.toList());
    }
}
