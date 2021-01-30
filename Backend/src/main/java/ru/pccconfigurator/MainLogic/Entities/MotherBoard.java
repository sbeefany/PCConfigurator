package ru.pccconfigurator.MainLogic.Entities;

import org.jetbrains.annotations.NotNull;

import ru.pccconfigurator.MainLogic.Entities.Enums.ChipSet;
import ru.pccconfigurator.MainLogic.Entities.Enums.FormFactor;
import ru.pccconfigurator.MainLogic.Entities.Enums.Socket;
import ru.pccconfigurator.MainLogic.Entities.Enums.TypeRam;
import java.util.Objects;
import java.util.UUID;


public class MotherBoard extends Accessory {
    @NotNull
    private final Socket socket;
    @NotNull
    private final ChipSet chipSet;
    @NotNull
    private final FormFactor formFactor;
    @NotNull
    private final TypeRam typeRam;

    public MotherBoard(@NotNull String name, @NotNull String vendor, @NotNull UUID id, int price, @NotNull Socket socket,
                       @NotNull ChipSet chipSet, @NotNull FormFactor formFactor, @NotNull TypeRam typeRam) {
        super(name, vendor, id, price);
        this.socket = socket;
        this.chipSet = chipSet;
        this.formFactor = formFactor;
        this.typeRam = typeRam;
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
