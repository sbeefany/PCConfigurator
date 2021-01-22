package Entities;

import java.util.Objects;

public class MotherBoard extends Accessories {

    private Socket socket;
    private ChipSet chipSet;
    private FormFactor formFactor;
    private TypeRam typeRam;

    public MotherBoard(Socket socket, ChipSet chipSet, FormFactor formFactor, TypeRam typeRam) {
        this.socket = socket;
        this.chipSet = chipSet;
        this.formFactor = formFactor;
        this.typeRam = typeRam;
    }

    public Socket getSocket() {
        return socket;
    }

    public ChipSet getChipSet() {
        return chipSet;
    }

    public FormFactor getFormFactor() {
        return formFactor;
    }

    public TypeRam getTypeRam() {
        return typeRam;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof MotherBoard)) return false;
        MotherBoard that = (MotherBoard) o;
        return socket == that.socket &&
                chipSet == that.chipSet &&
                formFactor == that.formFactor &&
                typeRam == that.typeRam;
    }

    @Override
    public int hashCode() {
        return Objects.hash(socket, chipSet, formFactor, typeRam);
    }
}
