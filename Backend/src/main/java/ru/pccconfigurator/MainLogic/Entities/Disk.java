package ru.pccconfigurator.MainLogic.Entities;

import org.jetbrains.annotations.NotNull;

import ru.pccconfigurator.MainLogic.Entities.Enums.DiskType;

import java.util.Objects;
import java.util.UUID;


public class Disk extends Accessory {
    private final float size;
    private final int diskSizeGB;
    @NotNull
    private final DiskType diskType;

    public Disk(@NotNull String name, @NotNull String vendor, @NotNull UUID id, int price, float size, int diskSizeGB, @NotNull DiskType diskType) {
        super(name, vendor, id, price);
        this.size = size;
        this.diskSizeGB = diskSizeGB;
        this.diskType = diskType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Disk)) return false;
        Disk disk = (Disk) o;
        return Float.compare(disk.size, size) == 0 &&
                diskSizeGB == disk.diskSizeGB &&
                diskType == disk.diskType;
    }

    @Override
    public int hashCode() {
        return Objects.hash(size, diskSizeGB, diskType);
    }
}
