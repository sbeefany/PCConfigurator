package ru.pcconfigurator.MainLogic.Cases.WorkWithData;


import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.pcconfigurator.MainLogic.Entities.*;
import ru.pcconfigurator.MainLogic.Entities.Enums.Socket;
import ru.pcconfigurator.MainLogic.Entities.Enums.VideoMemotyType;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Component
public class FakeAccessoriesRepository implements IAccessoriesRepository {


    private List<Accessory> accessories = List.of(new Gpu("TESTGPU","nvidia",UUID.fromString("3422b448-2460-4fd2-9183-8000de6f8343"),12312,12,12, VideoMemotyType.GDDR4,123,750),
            new Cpu("TEstCpu","Intel",UUID.fromString("b0135826-3608-4067-a8eb-2e7ea678b4e0"),121212, Socket.LGA1700,12,12,false,2));

    @Override
    public List<Accessory> findAllAccessoriesByName(String name) {
        return accessories.stream().filter(accessory -> accessory.checkName(name)).collect(Collectors.toList());
    }

    @Override
    public List<Accessory> findAllAccessories() {
        return List.copyOf(accessories);
    }

    @Override
    public Accessory findAccessoryById(UUID id) {
        return accessories.stream().filter(accessory -> accessory.checkID(id)).findFirst().orElse(null);
    }


}
