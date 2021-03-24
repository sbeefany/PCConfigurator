package ru.pcconfigurator.MainLogic.Entities;

import org.jetbrains.annotations.NotNull;

import ru.pcconfigurator.MainLogic.Entities.Dao.AccessoryDao;
import ru.pcconfigurator.MainLogic.Entities.Dao.AccessoryType;
import ru.pcconfigurator.MainLogic.Entities.Enums.DiskType;

import java.util.Objects;
import java.util.UUID;


public class Disk extends Accessory {
    private final int diskSizeGB;
    @NotNull
    private final DiskType diskType;

    public Disk(@NotNull String name, @NotNull String vendor, @NotNull UUID id, int price, int diskSizeGB, @NotNull DiskType diskType) {
        super(name, vendor, id, price);
        this.diskSizeGB = diskSizeGB;
        this.diskType = diskType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Disk)) return false;
        if (!super.equals(o)) return false;
        Disk disk = (Disk) o;
        return diskSizeGB == disk.diskSizeGB && diskType == disk.diskType;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), diskSizeGB, diskType);
    }

    @Override
    public Boolean compatibilityCheck(@NotNull Accessory accessory) {
        if(this.diskType.equals(DiskType.M2) && accessory instanceof MotherBoard){
            return ((MotherBoard) accessory).hasSlotForM2();
        }
        return true;
    }

    @Override
    public AccessoryDao convertToAccessoryDao() {
        AccessoryDao accessoryDao = createAccessoryDao();
        accessoryDao.setAccessoryType(AccessoryType.Disk);
        return accessoryDao;
    }

    public int getDiskSizeGB() {
        return diskSizeGB;
    }

    public @NotNull DiskType getDiskType() {
        return diskType;
    }
}
