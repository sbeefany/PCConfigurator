package Entities;

import java.util.Objects;

public class Ram extends Accessories{
    private TypeRam typeRam;
    private int valueRam;
    private int frequency;

    public Ram(TypeRam typeRam, int valueRam, int frequency) {
        this.typeRam = typeRam;
        this.valueRam = valueRam;
        this.frequency = frequency;
    }

    public TypeRam getTypeRam() {
        return typeRam;
    }

    public int getValueRam() {
        return valueRam;
    }

    public int getFrequency() {
        return frequency;
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
