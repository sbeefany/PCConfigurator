package ru.pcconfigurator.MainLogic.Cases.Facades;

import org.jetbrains.annotations.NotNull;
import ru.pcconfigurator.MainLogic.Entities.Accessory;

import java.util.List;
import java.util.UUID;

public interface IAccessoriesFacade {

    Accessory findAccessory(@NotNull UUID uuid);

    List<Accessory> findAccessoriesByName(@NotNull String name);
}
