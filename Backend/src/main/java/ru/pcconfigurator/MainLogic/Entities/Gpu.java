package ru.pcconfigurator.MainLogic.Entities;

import org.jetbrains.annotations.NotNull;

import ru.pcconfigurator.MainLogic.Entities.Dao.AccessoryDao;
import ru.pcconfigurator.MainLogic.Entities.Dao.AccessoryType;
import ru.pcconfigurator.MainLogic.Entities.Enums.VideoMemotyType;
import java.util.Objects;
import java.util.UUID;


public class Gpu extends Accessory {
    private final int coreFrequency;
    private final int memorySize;
    @NotNull
    private final VideoMemotyType videoMemotyType;
    private final int length;
    private final float neededPower;

    public Gpu(@NotNull String name, @NotNull String vendor, @NotNull UUID id, int price,
               int coreFrequency, int memorySize, @NotNull VideoMemotyType videoMemotyType, int length, float neededPower) {
        super(name, vendor, id, price);
        this.coreFrequency = coreFrequency;
        this.memorySize = memorySize;
        this.videoMemotyType = videoMemotyType;
        this.length = length;
        this.neededPower = neededPower;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Gpu)) return false;
        if (!super.equals(o)) return false;
        Gpu gpu = (Gpu) o;
        return coreFrequency == gpu.coreFrequency && memorySize == gpu.memorySize && length == gpu.length && Float.compare(gpu.neededPower, neededPower) == 0 && videoMemotyType == gpu.videoMemotyType;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), coreFrequency, memorySize, videoMemotyType, length, neededPower);
    }

    @Override
    public Boolean compatibilityCheck(@NotNull Accessory accessory) {
        if(accessory instanceof PowerSupply){
            return neededPower<= ((PowerSupply) accessory).getPowerCount();
        }
        if(accessory instanceof ComputerCase){
            return length<=((ComputerCase) accessory).getMaxSize().getMaxGpuLength();
        }
        return true;
    }

    @Override
    public AccessoryDao convertToAccessoryDao() {
        AccessoryDao accessoryDao = createAccessoryDao();
        accessoryDao.setAccessoryType(AccessoryType.Gpu);
        return accessoryDao;
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

    public float getNeededPower() {
        return neededPower;
    }
}
