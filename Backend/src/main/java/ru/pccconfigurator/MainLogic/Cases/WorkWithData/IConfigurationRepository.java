package ru.pccconfigurator.MainLogic.Cases.WorkWithData;

import ru.pccconfigurator.MainLogic.Entities.Accessory;
import ru.pccconfigurator.MainLogic.Entities.PcConfiguration;

import java.util.UUID;

public interface IConfigurationRepository {

    void saveConfiguration(PcConfiguration pcConfiguration);

    PcConfiguration getPcConfiguration(UUID id);

}
