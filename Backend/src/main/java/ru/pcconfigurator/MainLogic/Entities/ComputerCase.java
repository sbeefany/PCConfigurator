package ru.pcconfigurator.MainLogic.Entities;

import org.jetbrains.annotations.NotNull;
import ru.pcconfigurator.MainLogic.Entities.Dao.AccessoryDao;
import ru.pcconfigurator.MainLogic.Entities.Dao.AccessoryType;
import ru.pcconfigurator.MainLogic.Entities.Enums.FormFactor;
import ru.pcconfigurator.MainLogic.Entities.Enums.FormFactorPowerSupply;
import ru.pcconfigurator.MainLogic.Entities.Enums.TypeSizeComputerCase;

import java.util.List;
import java.util.Objects;
import java.util.UUID;

public class ComputerCase extends Accessory{
    @NotNull
    private final List<FormFactor> formFactor;
    @NotNull
    private final TypeSizeComputerCase typeSizeComputerCase;

    private final int coolersCount;
    @NotNull
    private final List<CoolerSize> sizes;
    @NotNull
    private final List<Connector> connectors;
    @NotNull
    private final FormFactorPowerSupply formFactorPowerSupply;
    private final int length;
    private final int width;
    private final int height;

    @NotNull
    private final MaxSize maxSize;

    public ComputerCase(@NotNull String name, @NotNull String vendor, @NotNull UUID id, int price,
                        @NotNull List<FormFactor> formFactor, @NotNull TypeSizeComputerCase typeSizeComputerCase,
                        int coolersCount, @NotNull List<CoolerSize> sizes, @NotNull List<Connector> connectors,
                        @NotNull FormFactorPowerSupply formFactorPowerSupply, int length, int widht, int height, @NotNull MaxSize maxSize) {
        super(name, vendor, id, price);
        this.formFactor = formFactor;
        this.typeSizeComputerCase = typeSizeComputerCase;
        this.coolersCount = coolersCount;
        this.sizes = sizes;
        this.connectors = connectors;
        this.formFactorPowerSupply = formFactorPowerSupply;
        this.length = length;
        this.width = widht;
        this.height = height;
        this.maxSize = maxSize;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ComputerCase)) return false;
        if (!super.equals(o)) return false;
        ComputerCase that = (ComputerCase) o;
        return coolersCount == that.coolersCount && length == that.length && width == that.width && height == that.height && formFactor.equals(that.formFactor) && typeSizeComputerCase == that.typeSizeComputerCase && sizes.equals(that.sizes) && connectors.equals(that.connectors) && formFactorPowerSupply == that.formFactorPowerSupply && maxSize.equals(that.maxSize);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), formFactor, typeSizeComputerCase, coolersCount, sizes, connectors, formFactorPowerSupply, length, width, height, maxSize);
    }

    @Override
    public AccessoryDao convertToAccessoryDao() {
        AccessoryDao accessoryDao = createAccessoryDao();
        accessoryDao.setAccessoryType(AccessoryType.ComputerCase);
        return accessoryDao;
    }

    @Override
    public Boolean compatibilityCheck(@NotNull Accessory accessory) {
        if(accessory instanceof ComputerCaseCooler){
            return this.sizes.stream().anyMatch(size->size.equals(((ComputerCaseCooler) accessory).getCoolerSize()));
        }
        if(accessory instanceof Cooler){
            return this.maxSize.getMaxCooleerHeight()>=((Cooler) accessory).getHeight();
        }
        if(accessory instanceof Gpu){
            return this.maxSize.getMaxGpuLength()>=((Gpu) accessory).getLength();
        }
        if(accessory instanceof MotherBoard){
            return this.formFactor.stream().anyMatch(formFactor1 -> formFactor1.equals(((MotherBoard) accessory).getFormFactor()));
        }
        if(accessory instanceof PowerSupply){
            return this.formFactorPowerSupply.equals(((PowerSupply) accessory).getFormFactorPowerSupply());
        }
        return true;

    }

    public List<FormFactor> getFormFactor() {
        return formFactor;
    }

    public TypeSizeComputerCase getTypeSizeComputerCase() {
        return typeSizeComputerCase;
    }

    public int getCoolersCount() {
        return coolersCount;
    }

    public List<CoolerSize> getSizes() {
        return sizes;
    }

    public List<Connector> getConnectors() {
        return connectors;
    }

    public FormFactorPowerSupply getFormFactorPowerSupply() {
        return formFactorPowerSupply;
    }

    public int getLength() {
        return length;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public MaxSize getMaxSize() {
        return maxSize;
    }
}
