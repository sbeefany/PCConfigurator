package ru.pcconfigurator.MainLogic.Cases.WorkWithData;

import org.jetbrains.annotations.NotNull;
import ru.pcconfigurator.MainLogic.Entities.*;

import java.util.List;
import java.util.UUID;

public interface IAccessoriesRepository {

    List<Accessory> findAllAccessoriesByName(String name);

    List<Accessory> findAllAccessories();

    Accessory findAccessoryById(UUID id);
}
