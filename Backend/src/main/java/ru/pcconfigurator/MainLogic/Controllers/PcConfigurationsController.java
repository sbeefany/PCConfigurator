package ru.pcconfigurator.MainLogic.Controllers;

import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import ru.pcconfigurator.MainLogic.Cases.WorkWithData.IAccessoriesRepository;
import ru.pcconfigurator.MainLogic.Cases.WorkWithData.IConfigurationRepository;
import ru.pcconfigurator.MainLogic.Entities.Accessory;
import ru.pcconfigurator.MainLogic.Entities.PcConfiguration;

import java.util.UUID;
@RestController
@RequestMapping("/pcconfigurations")
public class PcConfigurationsController {

    @Autowired
    private IAccessoriesRepository accessoriesRepository;
    @Autowired
    private IConfigurationRepository configurationRepository;


    @PostMapping("/{configurationId}/accessories")
    public void addAccessory(@PathVariable("configurationId") @NotNull UUID configurationId,
                             @NotNull @RequestBody Accessory accessory) {
        PcConfiguration configuration = findPcConfigurationById(configurationId);
        configuration.addAccessory(accessory);
        configurationRepository.saveConfiguration(configuration);
    }

    @DeleteMapping("/{configurationId}/accessories/{accessoryId}")
    public void deleteAccessory(@PathVariable("accessoryId") @NotNull UUID accessoryId,@PathVariable("configurationId") @NotNull UUID configurationId) {
        PcConfiguration configuration = findPcConfigurationById(configurationId);
        configuration.deleteAccessory(accessoriesRepository.getAccessory(accessoryId));
        configurationRepository.saveConfiguration(configuration);
    }

    @PutMapping("/{configurationId}/accessories/{accessoryId}")
    public void updateAccessory(@PathVariable("accessoryId")@NotNull UUID oldAccessory,@PathVariable("configurationId") @NotNull UUID configurationId,
                                @RequestBody @NotNull Accessory newAccessory) {
        PcConfiguration configuration = findPcConfigurationById(configurationId);
        configuration.deleteAccessory(accessoriesRepository.getAccessory(oldAccessory));
        configuration.addAccessory(newAccessory);
        configurationRepository.saveConfiguration(configuration);
    }
    @GetMapping("/{configurationId}")
    public PcConfiguration findPcConfigurationById(@PathVariable("configurationId") @NotNull UUID configurationId){
        return configurationRepository.getPcConfiguration(configurationId);
    }

    @PostMapping("")
    public void createPcConfiguration(@RequestBody @NotNull PcConfiguration pcConfiguration){
        configurationRepository.saveConfiguration(pcConfiguration);
    }
}
