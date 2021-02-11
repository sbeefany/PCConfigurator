package ru.pccconfigurator.MainLogic.Cases.Facades;

import java.util.UUID;

public interface IConfigurationFacade {

    void addAccessory(UUID accessoryId,UUID configurationId);

    void deleteAccessory(UUID accessoryId,UUID configurationId);

    void updateAccessory(UUID oldAccessory, UUID newAccessory,UUID configurationId);

}
