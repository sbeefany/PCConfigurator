package ru.pccconfigurator.MainLogic.Cases.WorkWithData;

import ru.pccconfigurator.MainLogic.Entities.Accessory;
import java.util.List;
import java.util.UUID;

public interface RepositoryAccessories {
    void saveAccessory(Accessory accessory);

    Accessory getAccessory(UUID id);

    List<Accessory> getAccessoriesByName(String name);
}
