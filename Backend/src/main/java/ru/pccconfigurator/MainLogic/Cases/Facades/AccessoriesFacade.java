package ru.pccconfigurator.MainLogic.Cases.Facades;

import ru.pccconfigurator.MainLogic.Cases.WorkWithData.IAccessoriesRepository;
import ru.pccconfigurator.MainLogic.Cases.WorkWithData.IConfigurationRepository;
import ru.pccconfigurator.MainLogic.Entities.Accessory;

import java.lang.module.Configuration;
import java.util.List;
import java.util.UUID;

public class AccessoriesFacade implements IConfigurationFacade{

    IAccessoriesRepository accessoriesRepository;
    IConfigurationRepository configurationRepository;


    @Override
    public void addAccessory(UUID accessoryId, UUID configurationId) {
        configurationRepository.getPcConfiguration(configurationId).addAccessory(accessoriesRepository.getAccessory(accessoryId));
    }

    @Override
    public void deleteAccessory(UUID accessoryId, UUID configurationId) {
        configurationRepository.getPcConfiguration(configurationId).deleteAccessory(accessoriesRepository.getAccessory(accessoryId));
    }

    @Override
    public void updateAccessory(UUID oldAccessory, UUID newAccessory, UUID configurationId) {
        configurationRepository.getPcConfiguration(configurationId).deleteAccessory(accessoriesRepository.getAccessory(oldAccessory));
        configurationRepository.getPcConfiguration(configurationId).addAccessory(accessoriesRepository.getAccessory(newAccessory));
    }
}
