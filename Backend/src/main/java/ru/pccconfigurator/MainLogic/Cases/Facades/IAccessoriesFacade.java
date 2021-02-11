package ru.pccconfigurator.MainLogic.Cases.Facades;

import ru.pccconfigurator.MainLogic.Entities.Accessory;

import java.lang.module.Configuration;
import java.util.List;
import java.util.UUID;

public interface IAccessoriesFacade {

    Accessory getAccessory(UUID uuid);

    Configuration getConfiguration(UUID uuid);

    List<Accessory> getAccessories(String name);
}
