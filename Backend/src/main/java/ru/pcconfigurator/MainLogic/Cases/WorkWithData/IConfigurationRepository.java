package ru.pcconfigurator.MainLogic.Cases.WorkWithData;

import org.jetbrains.annotations.NotNull;
import ru.pcconfigurator.MainLogic.Entities.PcConfiguration;

import java.util.List;
import java.util.UUID;

public interface IConfigurationRepository {

    void saveConfiguration(@NotNull PcConfiguration pcConfiguration);

    PcConfiguration getPcConfiguration(@NotNull UUID id) throws NullPointerException;

    List<PcConfiguration> getAllPcConfigurations();

    void deleteConfiguration(UUID configurationId);

}
