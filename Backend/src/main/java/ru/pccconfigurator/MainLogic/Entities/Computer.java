package java.ru.pccconfigurator.MainLogic.Entities;

import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.Objects;
import java.util.zip.DataFormatException;

public class Computer implements IComputer {
    @Nullable
    private final Cooler cooler;
    @Nullable
    private final Cpu cpu;
    @Nullable
    private final Disk disk;
    @Nullable
    private final Gpu gpu;
    @Nullable
    private final MotherBoard motherBoard;
    @Nullable
    private final Ram ram;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Computer)) return false;
        Computer computer = (Computer) o;
        return Objects.equals(cooler, computer.cooler) && Objects.equals(cpu, computer.cpu) && Objects.equals(disk, computer.disk) && Objects.equals(gpu, computer.gpu) && Objects.equals(motherBoard, computer.motherBoard) && Objects.equals(ram, computer.ram);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cooler, cpu, disk, gpu, motherBoard, ram);
    }

    private Computer(@Nullable Cooler cooler, @Nullable Cpu cpu, @Nullable Disk disk, @Nullable Gpu gpu, @Nullable MotherBoard motherBoard, @Nullable Ram ram) {
        this.cooler = cooler;
        this.cpu = cpu;
        this.disk = disk;
        this.gpu = gpu;
        this.motherBoard = motherBoard;
        this.ram = ram;
    }

    @Override
    public Computer createComputer(Cooler cooler, Cpu cpu, Disk disk, Gpu gpu, MotherBoard motherBoard, Ram ram) throws DataFormatException {
        return null;
    }

    @Override
    public Computer addCooler(Cooler cooler) throws DataFormatException {
        return null;
    }

    @Override
    public Computer addCpu(Cpu cpu) throws DataFormatException {
        return null;
    }

    @Override
    public Computer addDisk(Disk disk) throws DataFormatException {
        return null;
    }

    @Override
    public Computer addGpu(Gpu gpu) throws DataFormatException {
        return null;
    }

    @Override
    public Computer addMotherBoaed(MotherBoard motherBoard) throws DataFormatException {
        return null;
    }

    @Override
    public Computer addRam(Ram ram) throws DataFormatException {
        return null;
    }

    @Override
    public Computer generateComputer() {
        return null;
    }

    @Override
    public String getInfoAboutAccessories() {
        return null;
    }

    @Override
    public Boolean isFullPack() {
        return null;
    }


}
