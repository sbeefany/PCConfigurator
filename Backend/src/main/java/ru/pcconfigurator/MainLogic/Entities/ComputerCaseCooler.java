package ru.pcconfigurator.MainLogic.Entities;

import org.jetbrains.annotations.NotNull;
import ru.pcconfigurator.MainLogic.Entities.Dao.AccessoryDao;
import ru.pcconfigurator.MainLogic.Entities.Dao.AccessoryType;

import java.util.Objects;
import java.util.UUID;

public class ComputerCaseCooler extends Accessory{

    @NotNull
    private final CoolerSize coolerSize;
    private final int speed;
    private final int noice;

    public ComputerCaseCooler(@NotNull String name, @NotNull String vendor, @NotNull UUID id, int price, @NotNull CoolerSize coolerSize, int speed, int noice) {
        super(name, vendor, id, price);
        this.coolerSize = coolerSize;
        this.speed = speed;
        this.noice = noice;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ComputerCaseCooler)) return false;
        if (!super.equals(o)) return false;
        ComputerCaseCooler that = (ComputerCaseCooler) o;
        return speed == that.speed && noice == that.noice && coolerSize.equals(that.coolerSize);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), coolerSize, speed, noice);
    }

    @Override
    public Boolean compatibilityCheck(@NotNull Accessory accessory) {
        if(accessory instanceof ComputerCase){
            return ((ComputerCase) accessory).getSizes().stream()
                    .anyMatch(coolerSize1 -> coolerSize1.equals(coolerSize));
        }
        return true;
    }

    public @NotNull CoolerSize getCoolerSize() {
        return new CoolerSize(coolerSize.getHeight(),coolerSize.getWidth());
    }

    @Override
    public AccessoryDao convertToAccessoryDao() {
        AccessoryDao accessoryDao = createAccessoryDao();
        accessoryDao.setAccessoryType(AccessoryType.ComputerCaseCooler);
        return accessoryDao;
    }

    public int getSpeed() {
        return speed;
    }

    public int getNoice() {
        return noice;
    }
}
