package ru.pcconfigurator.MainLogic.Entities.Dao;

import org.jetbrains.annotations.NotNull;
import ru.pcconfigurator.MainLogic.Entities.Accessory;

import java.util.List;
import java.util.UUID;

public class PcConfigurationDao {

    private List<AccessoryDao> accessories;

    private  UUID id;

    public List<AccessoryDao> getAccessories() {
        return accessories;
    }

    public void setAccessories(List<AccessoryDao> accessories) {
        this.accessories = accessories;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }
}
