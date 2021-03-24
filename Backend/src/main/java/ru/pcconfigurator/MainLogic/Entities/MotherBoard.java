package ru.pcconfigurator.MainLogic.Entities;

import org.jetbrains.annotations.NotNull;

import ru.pcconfigurator.MainLogic.Entities.Dao.AccessoryDao;
import ru.pcconfigurator.MainLogic.Entities.Dao.AccessoryType;
import ru.pcconfigurator.MainLogic.Entities.Enums.*;

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

    private final int ramCount;
    private final boolean hasSlotForM2;

    public MotherBoard(@NotNull String name, @NotNull String vendor, @NotNull UUID id, int price, @NotNull Socket socket,
                       @NotNull ChipSet chipSet, @NotNull FormFactor formFactor, @NotNull TypeRam typeRam,
                       int ramCount, boolean hasSlotForM2) {
        super(name, vendor, id, price);
        this.socket = socket;
        this.chipSet = chipSet;
        this.formFactor = formFactor;
        this.typeRam = typeRam;
        this.ramCount = ramCount;
        this.hasSlotForM2 = hasSlotForM2;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof MotherBoard)) return false;
        if (!super.equals(o)) return false;
        MotherBoard that = (MotherBoard) o;
        return ramCount == that.ramCount && hasSlotForM2 == that.hasSlotForM2 && socket == that.socket && chipSet == that.chipSet && formFactor == that.formFactor && typeRam == that.typeRam;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), socket, chipSet, formFactor, typeRam, ramCount, hasSlotForM2);
    }

    @Override
    public Boolean compatibilityCheck(@NotNull Accessory accessory) {
        if(accessory instanceof Cpu){
            return this.socket.equals(((Cpu) accessory).getSocket());
        }
        if(accessory instanceof Cooler){
            return this.socket.equals(((Cooler) accessory).getSocket());
        }
        if(accessory instanceof ComputerCase){
            return ((ComputerCase) accessory).getFormFactor().stream().anyMatch(this.formFactor::equals);
        }
        if(accessory instanceof Ram){
            return this.typeRam.equals(((Ram) accessory).getTypeRam());
        }
        if(accessory instanceof Disk){
            if(((Disk) accessory).getDiskType().equals(DiskType.M2))
                return hasSlotForM2;
        }
        return true;
    }

    @Override
    public AccessoryDao convertToAccessoryDao() {
        AccessoryDao accessoryDao = createAccessoryDao();
        accessoryDao.setAccessoryType(AccessoryType.MotherBoard);
        return accessoryDao;
    }

    public @NotNull Socket getSocket() {
        return socket;
    }

    public @NotNull ChipSet getChipSet() {
        return chipSet;
    }

    public @NotNull FormFactor getFormFactor() {
        return formFactor;
    }

    public @NotNull TypeRam getTypeRam() {
        return typeRam;
    }

    public int getRamCount() {
        return ramCount;
    }

    public boolean hasSlotForM2() {
        return hasSlotForM2;
    }
}
