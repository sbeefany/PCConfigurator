package ru.pccconfigurator.MainLogic.Entities;

import org.jetbrains.annotations.NotNull;
import ru.pccconfigurator.MainLogic.Entities.Enums.ConnectorType;

import java.util.Objects;

public class Connector {
    @NotNull
    private final String info;
    @NotNull
    private final ConnectorType connectorType;

    public Connector(@NotNull String info, @NotNull ConnectorType connectorType) {
        this.info = info;
        this.connectorType = connectorType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Connector)) return false;
        Connector connector = (Connector) o;
        return info.equals(connector.info) && connectorType == connector.connectorType;
    }

    @Override
    public int hashCode() {
        return Objects.hash(info, connectorType);
    }
}
