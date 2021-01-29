package ru.pccconfigurator.MainLogic.Entities;

import org.jetbrains.annotations.NotNull;

import java.ru.pccconfigurator.MainLogic.Entities.Enums.Socket;
import java.util.Objects;
import java.util.UUID;


public class Cpu extends Accessory {
    @NotNull
    private final Socket socket;
    private final int coresCount;
    private final int streamsCount;
    private final boolean hasGPU;
    private final int cashMemory;

    public Cpu(@NotNull String name, @NotNull String vendor, @NotNull UUID id, @NotNull Socket socket, int coresCount, int streamsCount, boolean hasGPU, int cashMemory) {
        super(name, vendor, id);
        this.socket = socket;
        this.coresCount = coresCount;
        this.streamsCount = streamsCount;
        this.hasGPU = hasGPU;
        this.cashMemory = cashMemory;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Cpu)) return false;
        Cpu cpu = (Cpu) o;
        return coresCount == cpu.coresCount &&
                streamsCount == cpu.streamsCount &&
                hasGPU == cpu.hasGPU &&
                cashMemory == cpu.cashMemory &&
                socket == cpu.socket;
    }

    @Override
    public int hashCode() {
        return Objects.hash(socket, coresCount, streamsCount, hasGPU, cashMemory);
    }
}
