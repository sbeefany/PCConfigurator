package ru.pccconfigurator.MainLogic.Entities;

import org.jetbrains.annotations.NotNull;

import java.util.Objects;
import java.util.UUID;

public abstract class Accessory {
    @NotNull
    private final String name;
    @NotNull
    private final String vendor;
    @NotNull
    private final UUID id;
    private final int price;

    public Accessory(@NotNull String name, @NotNull String vendor, @NotNull UUID id, int price) {
        this.name = name;
        this.vendor = vendor;
        this.id = id;
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Accessory)) return false;
        Accessory accessory = (Accessory) o;
        return price == accessory.price && name.equals(accessory.name) && vendor.equals(accessory.vendor) && id.equals(accessory.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, vendor, id, price);
    }

    public Boolean checkID(UUID id){
        return this.id.equals(id);
    }

    public abstract Boolean compabilityCheck(@NotNull Accessory accessory) throws RuntimeException;

    public String getName() {
        return name;
    }

    public String getVendor() {
        return vendor;
    }

    public UUID getId() {
        return id;
    }

    public int getPrice() {
        return price;
    }
}