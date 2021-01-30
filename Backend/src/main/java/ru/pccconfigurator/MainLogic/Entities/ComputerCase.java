package ru.pccconfigurator.MainLogic.Entities;

import org.jetbrains.annotations.NotNull;
import ru.pccconfigurator.MainLogic.Entities.Enums.FormFactor;
import ru.pccconfigurator.MainLogic.Entities.Enums.FormFactorPowerSupply;
import ru.pccconfigurator.MainLogic.Entities.Enums.TypeSizeComputerCase;

import java.util.List;
import java.util.Objects;
import java.util.UUID;

public class ComputerCase extends Accessory{
    @NotNull
    private final List<FormFactor> formFactor;
    @NotNull
    private final TypeSizeComputerCase typeSizeComputerCase;

    private final int coolersCount;
    @NotNull
    private final List<CoolerSize> sizes;
    @NotNull
    private final List<Connector> connectors;
    @NotNull
    private final FormFactorPowerSupply formFactorPowerSupply;
    private final int length;
    private final int widht;
    private final int height;

    public ComputerCase(@NotNull String name, @NotNull String vendor, @NotNull UUID id, int price,
                        @NotNull List<FormFactor> formFactor, @NotNull TypeSizeComputerCase typeSizeComputerCase,
                        int coolersCount, @NotNull List<CoolerSize> sizes,
                        @NotNull List<Connector> connectors,
                        @NotNull FormFactorPowerSupply formFactorPowerSupply, int length, int widht, int height) {
        super(name, vendor, id, price);
        this.formFactor = formFactor;
        this.typeSizeComputerCase = typeSizeComputerCase;
        this.coolersCount = coolersCount;
        this.sizes = sizes;
        this.connectors = connectors;
        this.formFactorPowerSupply = formFactorPowerSupply;
        this.length = length;
        this.widht = widht;
        this.height = height;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ComputerCase)) return false;
        if (!super.equals(o)) return false;
        ComputerCase that = (ComputerCase) o;
        return coolersCount == that.coolersCount && length == that.length && widht == that.widht
                && height == that.height && formFactor.equals(that.formFactor)
                && typeSizeComputerCase == that.typeSizeComputerCase && sizes.equals(that.sizes)
                && connectors.equals(that.connectors) && formFactorPowerSupply == that.formFactorPowerSupply;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), formFactor, typeSizeComputerCase, coolersCount,
                sizes, connectors, formFactorPowerSupply, length, widht, height);
    }
}
