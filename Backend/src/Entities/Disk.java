package Entities;

import java.util.Objects;

public class Disk extends Accessories{
    private float size;
    private int diskSizeGB;
    private DiskType diskType;

    public Disk(float size, int diskSizeGB, DiskType diskType) {
        this.size = size;
        this.diskSizeGB = diskSizeGB;
        this.diskType = diskType;
    }

    public float getSize() {
        return size;
    }

    public int getDiskSizeGB() {
        return diskSizeGB;
    }

    public DiskType getDiskType() {
        return diskType;
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
