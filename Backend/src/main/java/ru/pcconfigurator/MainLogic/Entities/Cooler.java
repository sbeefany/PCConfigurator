package ru.pcconfigurator.MainLogic.Entities;

import org.jetbrains.annotations.NotNull;

import ru.pcconfigurator.MainLogic.Entities.Dao.AccessoryDao;
import ru.pcconfigurator.MainLogic.Entities.Dao.AccessoryType;
import ru.pcconfigurator.MainLogic.Entities.Enums.Material;
import ru.pcconfigurator.MainLogic.Entities.Enums.Socket;

import java.util.Objects;
import java.util.UUID;


public class Cooler extends Accessory {

    @NotNull
    private final Socket socket;
    @NotNull
    private final Material material;

    private final int height;
    private final int noiceLvl;

    public Cooler(@NotNull String name, @NotNull String vendor, @NotNull UUID id, int price, @NotNull Socket socket, @NotNull Material material, int height, int noiceLvl) {
        super(name, vendor, id, price);
        this.socket = socket;
        this.material = material;
        this.height = height;
        this.noiceLvl = noiceLvl;
    }

    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Cooler)) return false;
        if (!super.equals(o)) return false;
        Cooler cooler = (Cooler) o;
        return height == cooler.height && noiceLvl == cooler.noiceLvl && socket == cooler.socket && material == cooler.material;
    }

    public int hashCode() {
        return Objects.hash(super.hashCode(), socket, material, height, noiceLvl);
    }

    @Override
    public Boolean compatibilityCheck(@NotNull Accessory accessory) {
        if (accessory instanceof ComputerCase) {
            return this.height <= ((ComputerCase) accessory).getMaxSize().getMaxCooleerHeight();
        }
        if (accessory instanceof MotherBoard) {
            return this.socket.equals(((MotherBoard) accessory).getSocket());
        }
        return true;
    }

    @Override
    public AccessoryDao convertToAccessoryDao() {
        AccessoryDao accessoryDao = createAccessoryDao();
        accessoryDao.setAccessoryType(AccessoryType.Cooler);
        return accessoryDao;
    }

    public Socket getSocket() {
        return socket;
    }

    public Material getMaterial() {
        return material;
    }

    public int getHeight() {
        return height;
    }

    public int getNoiceLvl() {
        return noiceLvl;
    }
}
