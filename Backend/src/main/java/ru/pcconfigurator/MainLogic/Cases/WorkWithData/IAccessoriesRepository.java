package ru.pcconfigurator.MainLogic.Cases.WorkWithData;

import org.jetbrains.annotations.NotNull;
import ru.pcconfigurator.MainLogic.Entities.Accessory;

import java.util.List;
import java.util.UUID;

public interface IAccessoriesRepository {

    Accessory getAccessory(@NotNull UUID id) throws NullPointerException;

    List<Accessory> getAllAccessoriesByName(String name);
}
