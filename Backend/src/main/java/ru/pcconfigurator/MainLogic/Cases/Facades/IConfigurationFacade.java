package ru.pcconfigurator.MainLogic.Cases.Facades;

import org.jetbrains.annotations.NotNull;

import java.util.UUID;

public interface IConfigurationFacade {

    void addAccessory(@NotNull UUID accessoryId, @NotNull UUID configurationId);

    void deleteAccessory(@NotNull UUID accessoryId,@NotNull UUID configurationId);

    void updateAccessory(@NotNull UUID oldAccessory, @NotNull UUID newAccessory,@NotNull UUID configurationId);

}
