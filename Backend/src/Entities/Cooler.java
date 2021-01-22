package Entities;

import java.util.Objects;

public class Cooler {


    private Socket socket;
    private Material material;
    private int hight;
    private int noiceLvl;

    public Socket getSocket() {
        return socket;
    }

    public Material getMaterial() {
        return material;
    }

    public int getHight() {
        return hight;
    }

    public int getNoiceLvl() {
        return noiceLvl;
    }

    public Cooler(Socket socket, Material material, int hight, int noiceLvl) {
        this.socket = socket;
        this.material = material;
        this.hight = hight;
        this.noiceLvl = noiceLvl;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Cooler)) return false;
        Cooler cooler = (Cooler) o;
        return hight == cooler.hight &&
                noiceLvl == cooler.noiceLvl &&
                socket == cooler.socket &&
                material == cooler.material;
    }

    @Override
    public int hashCode() {
        return Objects.hash(socket, material, hight, noiceLvl);
    }
}
