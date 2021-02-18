package ru.pcconfigurator.MainLogic.Controllers;

import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import ru.pcconfigurator.MainLogic.Cases.WorkWithData.IAccessoriesRepository;
import ru.pcconfigurator.MainLogic.Cases.WorkWithData.IConfigurationRepository;
import ru.pcconfigurator.MainLogic.Entities.PcConfiguration;

import java.util.UUID;
@Controller
@RequestMapping("/pcconfigurations")
public class PcConfigurationsController {

    @Autowired
    private IAccessoriesRepository accessoriesRepository;
    @Autowired
    private IConfigurationRepository configurationRepository;


    @PostMapping("/:configurationId/accessories")
    public void addAccessory(@NotNull UUID accessoryId, @NotNull UUID configurationId) {
        PcConfiguration configuration = findPcConfigurationById(configurationId);
        configuration.addAccessory(accessoriesRepository.getAccessory(accessoryId));
        configurationRepository.saveConfiguration(configuration);
    }

    @DeleteMapping("/:configurationId/accessories/:accessoryId")
    public void deleteAccessory(@NotNull UUID accessoryId, @NotNull UUID configurationId) {
        PcConfiguration configuration = findPcConfigurationById(configurationId);
        configuration.deleteAccessory(accessoriesRepository.getAccessory(accessoryId));
        configurationRepository.saveConfiguration(configuration);
    }

    @PutMapping("/:configurationId/accessories/:accessoryId")
    public void updateAccessory(@NotNull UUID oldAccessory, @NotNull UUID newAccessory, @NotNull UUID configurationId) {
        PcConfiguration configuration = findPcConfigurationById(configurationId);
        configuration.deleteAccessory(accessoriesRepository.getAccessory(oldAccessory));
        configuration.addAccessory(accessoriesRepository.getAccessory(newAccessory));
        configurationRepository.saveConfiguration(configuration);
    }
    @GetMapping("/:configurationId")
    public PcConfiguration findPcConfigurationById(@NotNull UUID configurationId){
        return configurationRepository.getPcConfiguration(configurationId);
    }

    @PostMapping("/pcconfigurations")
    public void createPcConfiguration(@NotNull PcConfiguration pcConfiguration){
        configurationRepository.saveConfiguration(pcConfiguration);
    }
}
