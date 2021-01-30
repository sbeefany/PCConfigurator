package ru.pccconfigurator.MainLogic.Entities;

import org.jetbrains.annotations.NotNull;
import ru.pccconfigurator.MainLogic.Entities.Enums.FormFactorPowerSupply;

import java.util.Objects;
import java.util.UUID;

public class PowerSupply extends Accessory{
    @NotNull
    private final FormFactorPowerSupply formFactorPowerSupply;
    private final int powerCount;

    public PowerSupply(@NotNull String name, @NotNull String vendor, @NotNull UUID id, int price, @NotNull FormFactorPowerSupply formFactorPowerSupply, int powerCount) {
        super(name, vendor, id, price);
        this.formFactorPowerSupply = formFactorPowerSupply;
        this.powerCount = powerCount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PowerSupply)) return false;
        if (!super.equals(o)) return false;
        PowerSupply that = (PowerSupply) o;
        return powerCount == that.powerCount && formFactorPowerSupply == that.formFactorPowerSupply;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), formFactorPowerSupply, powerCount);
    }
}
