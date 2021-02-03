package ru.pccconfigurator.MainLogic.Entities;

import org.jetbrains.annotations.NotNull;

import java.util.Objects;
import java.util.UUID;

public class ComputeCaseCooler extends Accessory{

    @NotNull
    private final CoolerSize coolerSize;
    private final int speed;
    private final int noice;

    public ComputeCaseCooler(@NotNull String name, @NotNull String vendor, @NotNull UUID id, int price, @NotNull CoolerSize coolerSize, int speed, int noice) {
        super(name, vendor, id, price);
        this.coolerSize = coolerSize;
        this.speed = speed;
        this.noice = noice;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ComputeCaseCooler)) return false;
        if (!super.equals(o)) return false;
        ComputeCaseCooler that = (ComputeCaseCooler) o;
        return speed == that.speed && noice == that.noice && coolerSize.equals(that.coolerSize);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), coolerSize, speed, noice);
    }

    @Override
    public Boolean compabilityCheck(Accessory accessory) {
        if(accessory instanceof ComputerCase){
            return ((ComputerCase) accessory).getSizes().stream()
                    .anyMatch(coolerSize1 -> coolerSize1.equals(coolerSize));
        }
        return true;
    }

    public @NotNull CoolerSize getCoolerSize() {
        return new CoolerSize(coolerSize.getHeight(),coolerSize.getWidth());
    }

    public int getSpeed() {
        return speed;
    }

    public int getNoice() {
        return noice;
    }
}
