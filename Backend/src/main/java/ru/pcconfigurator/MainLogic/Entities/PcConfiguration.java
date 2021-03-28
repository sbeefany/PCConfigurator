package ru.pcconfigurator.MainLogic.Entities;

import org.jetbrains.annotations.NotNull;
import ru.pcconfigurator.MainLogic.Cases.WorkWithData.IAccessoriesRepository;
import ru.pcconfigurator.MainLogic.Entities.Dao.PcConfigurationDao;

import java.util.*;
import java.util.stream.Collectors;


public class PcConfiguration {
    @NotNull
    private final List<Accessory> accessories;
    @NotNull
    private final UUID id;

    public PcConfiguration(@NotNull List<Accessory> accessories) {
        this.accessories = accessories;
        id = UUID.randomUUID();
    }
    public PcConfiguration(@NotNull List<Accessory> accessories,@NotNull UUID id) {
        this.accessories = accessories;
        this.id = id;
    }


    public PcConfiguration addAccessory(Accessory accessory) {
        if (checkNewAccessory(accessory)) {
            List<Accessory> newAccessories = new ArrayList<>(accessories);
            newAccessories.add(accessory);
            return new PcConfiguration(newAccessories,this.id);
        } else
            return this;
    }

    public PcConfiguration deleteAccessory(UUID accessoryId) {
        Accessory accessory = accessories.stream().filter(accessory1 -> accessory1.checkID(accessoryId)).findFirst().orElse(null);
        if (accessory != null) {
            List<Accessory> newAccessories = new LinkedList<>(accessories);
            newAccessories.remove(accessory);
            return new PcConfiguration(newAccessories,this.id);
        } else {
            return this;
        }
    }

    public PcConfiguration generateComputer() {
        return null;
    }

    public String getInfoAboutAccessories() {
        return this.toString();//Переделать
    }

    public Boolean isFullPack() {
        return accessories.stream().anyMatch(accessory -> accessory.getClass().equals(MotherBoard.class)) &&
                accessories.stream().anyMatch(accessory -> accessory.getClass().equals(Cpu.class)) &&
                accessories.stream().anyMatch(accessory -> accessory.getClass().equals(Ram.class)) &&
                accessories.stream().anyMatch(accessory -> accessory.getClass().equals(Cooler.class)) &&
                accessories.stream().anyMatch(accessory -> accessory.getClass().equals(ComputerCase.class)) &&
                accessories.stream().anyMatch(accessory -> accessory.getClass().equals(PowerSupply.class)) &&
                accessories.stream().anyMatch(accessory -> accessory.getClass().equals(Gpu.class)) &&
                accessories.stream().anyMatch(accessory -> accessory.getClass().equals(ComputerCaseCooler.class)) &&
                accessories.stream().anyMatch(accessory -> accessory.getClass().equals(Disk.class));
    }


    private Boolean checkNewAccessory(Accessory accessory) {
        boolean checkAccessory;
        boolean checkCount;
        if (accessory instanceof ComputerCaseCooler || accessory instanceof Ram) {
            if (accessory instanceof ComputerCaseCooler) {
                ComputerCase computerCase = (ComputerCase) accessories.stream().filter(accessory1 -> accessory1.getClass().equals(ComputerCase.class)).findFirst().orElse(null);
                if (computerCase != null) {
                    checkAccessory = accessories.stream().allMatch(accessory1 -> accessory1.compatibilityCheck(accessory));
                    checkCount = accessories.stream().filter(accessory1 -> accessory1.getClass().equals(accessory.getClass())).count() <
                            computerCase.getSizes().stream().filter(coolerSize -> coolerSize.equals(((ComputerCaseCooler) accessory).getCoolerSize())).count();
                } else {
                    return false;
                }
            } else {
                MotherBoard motherBoard = (MotherBoard) accessories.stream().filter(accessory1 -> accessory1.getClass().equals(MotherBoard.class)).findFirst().orElse(null);
                if (motherBoard != null) {
                    checkAccessory = accessories.stream().allMatch(accessory1 -> accessory1.compatibilityCheck(accessory));
                    checkCount = accessories.stream().filter(accessory1 -> accessory1.getClass().equals(accessory.getClass())).count() < motherBoard.getRamCount();

                } else {
                    return false;
                }

            }

        } else {
            checkAccessory = accessories.stream().allMatch(accessory1 -> accessory1.compatibilityCheck(accessory));
            checkCount = accessories.stream().noneMatch(accessory1 -> accessory1.getClass().equals(accessory.getClass()));
        }

        return checkCount && checkAccessory;


    }

    public Boolean checkId(UUID id) {
        return this.id.equals(id);
    }

    public PcConfigurationDao convertToDao() {
        PcConfigurationDao pcConfigurationDao = new PcConfigurationDao();
        pcConfigurationDao.setId(this.id);
        pcConfigurationDao.setAccessories(accessories.stream().map(Accessory::convertToAccessoryDao).collect(Collectors.toList()));
        return pcConfigurationDao;
    }

    public Boolean hasThisAccessory(@NotNull UUID id){
        return accessories.stream().anyMatch(accessory -> accessory.checkID(id));
    }

    public @NotNull List<Accessory> getAccessories() {
        return accessories;
    }

    public @NotNull UUID getId() {
        return id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PcConfiguration)) return false;
        PcConfiguration that = (PcConfiguration) o;
        return accessories.equals(that.accessories) && id.equals(that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(accessories, id);
    }
}
