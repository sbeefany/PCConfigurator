package ru.pccconfigurator.MainLogic.Entities;

import org.jetbrains.annotations.NotNull;

import java.util.Objects;
import java.util.UUID;

public class Accessory {
    @NotNull
    private final String name;
    @NotNull
    private final String vendor;
    @NotNull
    private final UUID id;

    public Accessory(@NotNull String name, @NotNull String vendor, @NotNull UUID id) {
        this.name = name;
        this.vendor = vendor;
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Accessory)) return false;
        Accessory that = (Accessory) o;
        return Objects.equals(name, that.name) && Objects.equals(vendor, that.vendor);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, vendor);
    }

    public Boolean checkID(UUID id){
        return this.id.equals(id);
    }
}