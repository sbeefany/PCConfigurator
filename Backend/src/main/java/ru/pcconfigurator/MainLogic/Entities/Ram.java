package ru.pcconfigurator.MainLogic.Entities;

import org.jetbrains.annotations.NotNull;

import ru.pcconfigurator.MainLogic.Entities.Dao.AccessoryDao;
import ru.pcconfigurator.MainLogic.Entities.Dao.AccessoryType;
import ru.pcconfigurator.MainLogic.Entities.Enums.TypeRam;
import java.util.Objects;
import java.util.UUID;


public class Ram extends Accessory {
    @NotNull
    private final TypeRam typeRam;
    private final int valueRam;
    private final int frequency;

    public Ram(@NotNull String name, @NotNull String vendor, @NotNull UUID id,
               int price, @NotNull TypeRam typeRam, int valueRam, int frequency) {
        super(name, vendor, id, price);
        this.typeRam = typeRam;
        this.valueRam = valueRam;
        this.frequency = frequency;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Ram)) return false;
        Ram ram = (Ram) o;
        return valueRam == ram.valueRam &&
                frequency == ram.frequency &&
                typeRam == ram.typeRam;
    }

    @Override
    public int hashCode() {
        return Objects.hash(typeRam, valueRam, frequency);
    }

    @Override
    public Boolean compatibilityCheck(@NotNull Accessory accessory) {
        if(accessory instanceof MotherBoard){
            return this.typeRam.equals(((MotherBoard) accessory).getTypeRam());
        }
        return true;
    }

    @Override
    public AccessoryDao convertToAccessoryDao() {
        AccessoryDao accessoryDao = createAccessoryDao();
        accessoryDao.setAccessoryType(AccessoryType.Ram);
        return accessoryDao;
    }

    public TypeRam getTypeRam() {
        return typeRam;
    }

    public int getValueRam() {
        return valueRam;
    }

    public int getFrequency() {
        return frequency;
    }
}
