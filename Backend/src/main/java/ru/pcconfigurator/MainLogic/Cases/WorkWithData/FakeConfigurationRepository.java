package ru.pcconfigurator.MainLogic.Cases.WorkWithData;

import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.pcconfigurator.MainLogic.Entities.Accessory;
import ru.pcconfigurator.MainLogic.Entities.PcConfiguration;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Component
public class FakeConfigurationRepository implements IConfigurationRepository {

    private List<PcConfiguration> configurations = List.of(new PcConfiguration(new ArrayList<>()));

    @Override
    public void saveConfiguration(@NotNull PcConfiguration pcConfiguration) {
        ArrayList<PcConfiguration> pcConfigurations = new ArrayList<>(this.configurations);
        pcConfigurations.remove(pcConfigurations.stream().filter(
                pcConfiguration1 -> pcConfiguration1.checkId(pcConfiguration.getId())).findFirst().orElse(null));
        pcConfigurations.add(pcConfiguration);
        configurations = pcConfigurations;
    }

    @Override
    public PcConfiguration getPcConfiguration(@NotNull UUID id) throws NullPointerException {
        return configurations.stream().filter(pcConfiguration -> pcConfiguration.checkId(id)).findFirst().orElse(null);
    }

    @Override
    public List<PcConfiguration> getAllPcConfigurations() {
        return List.copyOf(configurations);
    }

    @Override
    public void deleteConfiguration(UUID configurationId) {

    }


}
