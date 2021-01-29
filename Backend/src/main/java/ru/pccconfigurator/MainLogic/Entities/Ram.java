package ru.pccconfigurator.MainLogic.Entities;

import org.jetbrains.annotations.NotNull;

import java.ru.pccconfigurator.MainLogic.Entities.Enums.TypeRam;
import java.util.Objects;
import java.util.UUID;


public class Ram extends Accessory {
    @NotNull
    private final TypeRam typeRam;
    private final int valueRam;
    private final int frequency;

    public Ram(@NotNull String name, @NotNull String vendor, @NotNull UUID id,
               @NotNull TypeRam typeRam, int valueRam, int frequency) {
        super(name, vendor, id);
        this.typeRam = typeRam;
        this.valueRam = valueRam;
        this.frequency = frequency;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Ram)) return false;
        Ram ram = (Ram) o;
        return valueRam == ram.valueRam &&
                frequency == ram.frequency &&
                typeRam == ram.typeRam;
    }

    @Override
    public int hashCode() {
        return Objects.hash(typeRam, valueRam, frequency);
    }
}
