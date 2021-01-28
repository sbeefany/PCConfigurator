package java.ru.pccconfigurator.MainLogic.Cases.WorkWithData;

import java.ru.pccconfigurator.MainLogic.Entities.Accessory;
import java.util.List;
import java.util.UUID;

public class AccessoriesRepository implements RepositoryAccessories{

    @Override
    public void saveAccessory(Accessory accessory) {

    }

    @Override
    public Accessory getAccessory(UUID id) {
        return null;
    }

    @Override
    public List<Accessory> getAccessoriesByName(String name) {
        return null;
    }
}
