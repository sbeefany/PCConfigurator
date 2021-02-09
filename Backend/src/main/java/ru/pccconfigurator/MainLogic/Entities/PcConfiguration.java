package ru.pccconfigurator.MainLogic.Entities;

import java.util.List;
import java.util.Objects;


public class PcConfiguration {

    private final List<Accessory> accessories;

    public PcConfiguration(List<Accessory> accessories) {
        this.accessories = accessories;
    }

    public Boolean addAccessory(Accessory accessory){
        if (checkNewAccessory(accessory))
            return accessories.add(accessory);
        else
            return false;
    }

    public Boolean deleteAccessory(Accessory accessory){
        return accessories.remove(accessory);
    }

    public PcConfiguration generateComputer() {
        return null;
    }

    public String getInfoAboutAccessories() {
        return this.toString();//Переделать
    }

    public Boolean isFullPack() {
        return null;
    }

    private Boolean checkNewAccessory(Accessory accessory) {
        boolean checkAccessory;
        boolean checkCount;
        if(accessory instanceof ComputerCaseCooler || accessory instanceof Ram){
            if(accessory instanceof ComputerCaseCooler){
               ComputerCase computerCase = (ComputerCase) accessories.stream().filter(accessory1 -> accessory1.getClass().equals(ComputerCase.class)).findFirst().orElse(null);
               if(computerCase!=null){
                   checkAccessory = accessories.stream().allMatch(accessory1 -> accessory1.compatibilityCheck(accessory));
                   checkCount = accessories.stream().filter(accessory1 -> accessory1.getClass().equals(accessory.getClass())).count()<
                           computerCase.getSizes().stream().filter(coolerSize -> coolerSize.equals(((ComputerCaseCooler) accessory).getCoolerSize())).count();
               }else{
                   return false;
               }
            }else{
                MotherBoard motherBoard = (MotherBoard) accessories.stream().filter(accessory1 -> accessory1.getClass().equals(MotherBoard.class)).findFirst().orElse(null);
                if(motherBoard!=null){
                    checkAccessory = accessories.stream().allMatch(accessory1 -> accessory1.compatibilityCheck(accessory));
                    checkCount = accessories.stream().filter(accessory1 -> accessory1.getClass().equals(accessory.getClass())).count()<motherBoard.getRamCount();

                }else{
                    return false;
                }

            }

        }else{
            checkAccessory = accessories.stream().allMatch(accessory1 -> accessory1.compatibilityCheck(accessory));
            checkCount = accessories.stream().noneMatch(accessory1 -> accessory1.getClass().equals(accessory.getClass()));
        }

        return checkCount&&checkAccessory;



    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PcConfiguration)) return false;
        PcConfiguration that = (PcConfiguration) o;
        return accessories.equals(that.accessories);
    }

    @Override
    public int hashCode() {
        return Objects.hash(accessories);
    }
}
