package ru.pcconfigurator.MainLogic.Cases.WorkWithData;

import org.jetbrains.annotations.NotNull;
import ru.pcconfigurator.MainLogic.Entities.PcConfiguration;

import java.util.UUID;

public interface IConfigurationRepository {

    void saveConfiguration(@NotNull PcConfiguration pcConfiguration);

    PcConfiguration getPcConfiguration(@NotNull UUID id) throws NullPointerException;

}
