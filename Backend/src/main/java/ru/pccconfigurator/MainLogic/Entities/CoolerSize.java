package ru.pccconfigurator.MainLogic.Entities;

import java.util.Objects;

public class CoolerSize {

    private final int height;
    private final int width;

    public CoolerSize(int height, int width) {
        this.height = height;
        this.width = width;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CoolerSize)) return false;
        CoolerSize that = (CoolerSize) o;
        return height == that.height && width == that.width;
    }

    @Override
    public int hashCode() {
        return Objects.hash(height, width);
    }
}
