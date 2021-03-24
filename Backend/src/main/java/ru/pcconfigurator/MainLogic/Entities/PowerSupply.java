package ru.pcconfigurator.MainLogic.Entities;

import org.jetbrains.annotations.NotNull;
import ru.pcconfigurator.MainLogic.Entities.Dao.AccessoryDao;
import ru.pcconfigurator.MainLogic.Entities.Dao.AccessoryType;
import ru.pcconfigurator.MainLogic.Entities.Enums.FormFactorPowerSupply;

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

    @Override
    public Boolean compatibilityCheck(@NotNull Accessory accessory) {
        if(accessory instanceof ComputerCase){
            return ((ComputerCase) accessory).getFormFactorPowerSupply().equals(this.formFactorPowerSupply);
        }
        if(accessory instanceof Gpu) {
            return this.powerCount>=((Gpu) accessory).getNeededPower();
        }
        return true;
    }

    @Override
    public AccessoryDao convertToAccessoryDao() {
        AccessoryDao accessoryDao = createAccessoryDao();
        accessoryDao.setAccessoryType(AccessoryType.PowerSupply);
        return accessoryDao;
    }

    public FormFactorPowerSupply getFormFactorPowerSupply() {
        return formFactorPowerSupply;
    }

    public int getPowerCount() {
        return powerCount;
    }
}
