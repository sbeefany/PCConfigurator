package ru.pcconfigurator.MainLogic.Cases.Facades;

import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.pcconfigurator.MainLogic.Cases.WorkWithData.IAccessoriesRepository;
import ru.pcconfigurator.MainLogic.Entities.Accessory;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Component
public class AccessoriesFacade implements IAccessoriesFacade{
    @Autowired
    private IAccessoriesRepository repository;


    @Override
    public Accessory findAccessory(@NotNull UUID uuid) {
        return repository.getAccessory(uuid);
    }

    @Override
    public List<Accessory> findAccessoriesByName(@NotNull String name) {
        return repository.getAllAccessories().stream()
                .filter(accessory -> accessory.getName().equals(name)).collect(Collectors.toList());
    }
}