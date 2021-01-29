package ru.pccconfigurator.MainLogic.Entities;

import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.Objects;
import java.util.zip.DataFormatException;

public class Configuration {

    private final List<Accessory> accessories;

    public Configuration(List<Accessory> accessories) {
        this.accessories = accessories;
    }


    public Configuration generateComputer() {
        return null;
    }

    public String getInfoAboutAccessories() {
        return null;
    }

    public Boolean isFullPack() {
        return null;
    }


}
