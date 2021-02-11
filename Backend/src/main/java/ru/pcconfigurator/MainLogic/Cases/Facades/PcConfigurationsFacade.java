package ru.pcconfigurator.MainLogic.Cases.Facades;

import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.pcconfigurator.MainLogic.Cases.WorkWithData.IAccessoriesRepository;
import ru.pcconfigurator.MainLogic.Cases.WorkWithData.IConfigurationRepository;
import ru.pcconfigurator.MainLogic.Entities.PcConfiguration;

import java.util.UUID;
@Component
public class PcConfigurationsFacade implements IConfigurationFacade{
    @Autowired
    private IAccessoriesRepository accessoriesRepository;
    @Autowired
    private IConfigurationRepository configurationRepository;


    @Override
    public void addAccessory(@NotNull UUID accessoryId, @NotNull UUID configurationId) {
        PcConfiguration configuration = configurationRepository.getPcConfiguration(configurationId);
        configuration.addAccessory(accessoriesRepository.getAccessory(accessoryId));
        configurationRepository.saveConfiguration(configuration);
    }

    @Override
    public void deleteAccessory(@NotNull UUID accessoryId, @NotNull UUID configurationId) {
        PcConfiguration configuration = configurationRepository.getPcConfiguration(configurationId);
        configuration.deleteAccessory(accessoriesRepository.getAccessory(accessoryId));
        configurationRepository.saveConfiguration(configuration);
    }

    @Override
    public void updateAccessory(@NotNull UUID oldAccessory, @NotNull UUID newAccessory, @NotNull UUID configurationId) {
        PcConfiguration configuration = configurationRepository.getPcConfiguration(configurationId);
        configuration.deleteAccessory(accessoriesRepository.getAccessory(oldAccessory));
        configuration.addAccessory(accessoriesRepository.getAccessory(newAccessory));
        configurationRepository.saveConfiguration(configuration);
    }

}
