package ru.pccconfigurator.MainLogic.Entities;

import java.util.List;
import java.util.Objects;


public class PcConfiguration {

    private final List<Accessory> accessories;

    public PcConfiguration(List<Accessory> accessories) {
        this.accessories = accessories;
    }

    public Boolean addAccessory(Accessory accessory){
        if (checkNewAccessory(accessory))
            return accessories.add(accessory);
        else
            throw  new IllegalArgumentException();
    }

    public Boolean deleteAccesory(Accessory accessory){
        return accessories.remove(accessory);
    }

    public PcConfiguration generateComputer() {
        return null;
    }

    public String getInfoAboutAccessories() {
        return this.toString();//Переделать
    }

    public Boolean isFullPack() {
        return null;
    }

    private Boolean checkNewAccessory(Accessory accessory){

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PcConfiguration)) return false;
        PcConfiguration that = (PcConfiguration) o;
        return accessories.equals(that.accessories);
    }

    @Override
    public int hashCode() {
        return Objects.hash(accessories);
    }
}
