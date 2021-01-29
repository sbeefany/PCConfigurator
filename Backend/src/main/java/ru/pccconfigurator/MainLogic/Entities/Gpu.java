package ru.pccconfigurator.MainLogic.Entities;

import org.jetbrains.annotations.NotNull;

import java.ru.pccconfigurator.MainLogic.Entities.Enums.VideoMemotyType;
import java.util.Objects;
import java.util.UUID;


public class Gpu extends Accessory {
    private final int coreFrequency;
    private final int memorySize;
    @NotNull
    private final VideoMemotyType videoMemotyType;
    private final int size;

    public Gpu(@NotNull String name, @NotNull String vendor, @NotNull UUID id, int coreFrequency, int memorySize, @NotNull VideoMemotyType videoMemotyType, int size) {
        super(name, vendor, id);
        this.coreFrequency = coreFrequency;
        this.memorySize = memorySize;
        this.videoMemotyType = videoMemotyType;
        this.size = size;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Gpu gpu = (Gpu) o;
        return coreFrequency == gpu.coreFrequency && memorySize == gpu.memorySize && size == gpu.size && videoMemotyType == gpu.videoMemotyType;
    }

    @Override
    public int hashCode() {
        return Objects.hash(coreFrequency, memorySize, videoMemotyType, size);
    }
}
