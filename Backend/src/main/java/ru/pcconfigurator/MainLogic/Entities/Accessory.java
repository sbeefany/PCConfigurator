package ru.pcconfigurator.MainLogic.Entities;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.jetbrains.annotations.NotNull;
import ru.pcconfigurator.MainLogic.Entities.Dao.AccessoryDao;

import java.util.Objects;
import java.util.UUID;

public abstract class Accessory {
    @NotNull
    private final String name;
    @NotNull
    private final String vendor;
    @NotNull
    private final UUID id;
    private final int price;

    public Accessory(@NotNull @JsonProperty("name") String name, @NotNull @JsonProperty("vendor")  String vendor, @NotNull @JsonProperty("id") UUID id, @JsonProperty("price") int price) {
        this.name = name;
        this.vendor = vendor;
        this.id = id;
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Accessory)) return false;
        Accessory accessory = (Accessory) o;
        return price == accessory.price && name.equals(accessory.name) && vendor.equals(accessory.vendor) && id.equals(accessory.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, vendor, id, price);
    }

    public Boolean checkName(String name) {
        return name.isEmpty() || name.equals("\"\"") || this.name.contains(name);
    }

    public Boolean checkID(UUID id) {
        return this.id.equals(id);
    }

    public abstract AccessoryDao convertToAccessoryDao();

    public abstract Boolean compatibilityCheck(@NotNull Accessory accessory) throws RuntimeException;

     protected AccessoryDao createAccessoryDao(){
        AccessoryDao accessoryDao = new AccessoryDao();
        accessoryDao.setName(this.getName());
        accessoryDao.setId(this.getId());
        accessoryDao.setPrice(this.getPrice());
        accessoryDao.setVendor(this.getVendor());
        return accessoryDao;
    }

    public String getName() {
        return name;
    }

    public String getVendor() {
        return vendor;
    }

    public UUID getId() {
        return id;
    }

    public int getPrice() {
        return price;
    }
}