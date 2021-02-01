package ru.pccconfigurator.MainLogic.Entities;

import org.jetbrains.annotations.NotNull;

import ru.pccconfigurator.MainLogic.Entities.Enums.VideoMemotyType;
import java.util.Objects;
import java.util.UUID;


public class Gpu extends Accessory {
    private final int coreFrequency;
    private final int memorySize;
    @NotNull
    private final VideoMemotyType videoMemotyType;
    private final int length;

    public Gpu(@NotNull String name, @NotNull String vendor, @NotNull UUID id,
               int price, int coreFrequency, int memorySize, @NotNull VideoMemotyType videoMemotyType, int length) {
        super(name, vendor, id, price);
        this.coreFrequency = coreFrequency;
        this.memorySize = memorySize;
        this.videoMemotyType = videoMemotyType;
        this.length = length;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Gpu)) return false;
        if (!super.equals(o)) return false;
        Gpu gpu = (Gpu) o;
        return coreFrequency == gpu.coreFrequency && memorySize == gpu.memorySize && length == gpu.length && videoMemotyType == gpu.videoMemotyType;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), coreFrequency, memorySize, videoMemotyType, length);
    }

    @Override
    public Boolean compabilityCheck(Accessory accessory) {
        return null;
    }

    public int getCoreFrequency() {
        return coreFrequency;
    }

    public int getMemorySize() {
        return memorySize;
    }

    public VideoMemotyType getVideoMemotyType() {
        return videoMemotyType;
    }

    public int getLength() {
        return length;
    }
}
