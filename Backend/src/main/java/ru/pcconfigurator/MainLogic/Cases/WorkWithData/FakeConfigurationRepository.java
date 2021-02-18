package ru.pcconfigurator.MainLogic.Cases.WorkWithData;

import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.pcconfigurator.MainLogic.Entities.PcConfiguration;

import java.util.List;
import java.util.UUID;
@Component
public class FakeConfigurationRepository implements IConfigurationRepository {

    private List<PcConfiguration> configurations;

    @Override
    public void saveConfiguration(@NotNull PcConfiguration pcConfiguration) {
        configurations.add(pcConfiguration);
    }

    @Override
    public PcConfiguration getPcConfiguration(@NotNull UUID id) throws NullPointerException {
        return null;
    }


}
