package ru.pccconfigurator.MainLogic.Entities;

import java.util.Objects;

public class MaxSize {

    private final int maxCooleerHeight;
    private final int maxGpuLength;

    public MaxSize(int maxCooleerHeight, int maxGpuLength) {
        this.maxCooleerHeight = maxCooleerHeight;
        this.maxGpuLength = maxGpuLength;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof MaxSize)) return false;
        MaxSize maxLength = (MaxSize) o;
        return maxCooleerHeight == maxLength.maxCooleerHeight && maxGpuLength == maxLength.maxGpuLength;
    }

    @Override
    public int hashCode() {
        return Objects.hash(maxCooleerHeight, maxGpuLength);
    }

    public int getMaxCooleerHeight() {
        return maxCooleerHeight;
    }

    public int getMaxGpuLength() {
        return maxGpuLength;
    }
}
