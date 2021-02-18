package ru.pcconfigurator.MainLogic.Cases.WorkWithData;


import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.pcconfigurator.MainLogic.Entities.Accessory;

import java.util.List;
import java.util.UUID;

@Component
public class FakeAccessoriesRepository implements IAccessoriesRepository {


    private List<Accessory> accessories;

    @Override
    public Accessory getAccessory(@NotNull UUID id) {
        return accessories.stream().filter(accessory -> accessory.checkID(id)).findFirst().orElse(null);
    }

    @Override
    public List<Accessory> getAllAccessoriesByName(String name) {
        return null;
    }
}
