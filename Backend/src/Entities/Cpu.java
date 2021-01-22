package Entities;

import java.util.Objects;

public class Cpu extends Accessories {

    private Socket socket;
    private int coresCount;
    private int streamsCount;
    private boolean hasGPU;
    private int cashMemory;

    public Socket getSocket() {
        return socket;
    }

    public int getCoresCount() {
        return coresCount;
    }

    public int getStreamsCount() {
        return streamsCount;
    }

    public boolean isHasGPU() {
        return hasGPU;
    }

    public int getCashMemory() {
        return cashMemory;
    }

    public Cpu(Socket socket, int coresCount, int streamsCount, boolean hasGPU, int cashMemory) {
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
