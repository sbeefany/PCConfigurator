package java.ru.pccconfigurator.MainLogic.Entities;

import java.util.zip.DataFormatException;

public interface IComputer {
    Computer createComputer(Cooler cooler, Cpu cpu, Disk disk, Gpu gpu, MotherBoard motherBoard, Ram ram) throws DataFormatException;

    Computer addCooler(Cooler cooler) throws DataFormatException;

    Computer addCpu(Cpu cpu) throws DataFormatException;

    Computer addDisk(Disk disk) throws DataFormatException;

    Computer addGpu(Gpu gpu) throws DataFormatException;

    Computer addMotherBoaed(MotherBoard motherBoard) throws DataFormatException;

    Computer addRam(Ram ram) throws DataFormatException;

    Computer generateComputer();

    String getInfoAboutAccessories();

    Boolean isFullPack();


}
