package ru.pcconfigurator.MainLogic.Cases.WorkWithData;


import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.pcconfigurator.MainLogic.Entities.Accessory;
import ru.pcconfigurator.MainLogic.Entities.Enums.VideoMemotyType;
import ru.pcconfigurator.MainLogic.Entities.Gpu;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Component
public class FakeAccessoriesRepository implements IAccessoriesRepository {


    private List<Accessory> accessories = List.of(new Gpu("TESTGPU","nvidia",UUID.fromString("3422b448-2460-4fd2-9183-8000de6f8343"),12312,12,12, VideoMemotyType.GDDR4,123,750));

    @Override
    public Accessory getAccessory(@NotNull UUID id) {
        return accessories.stream().filter(accessory -> accessory.checkID(id)).findFirst().orElse(null);
    }

    @Override
    public List<Accessory> getAllAccessoriesByName(String name) {
        return accessories.stream().filter(accessory -> accessory.checkName(name)).collect(Collectors.toList());
    }

    @Override
    public List<Accessory> getAllAccessories() {
        return List.copyOf(accessories);
    }
}
