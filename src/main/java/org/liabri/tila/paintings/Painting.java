package org.liabri.tila.paintings;

public class Painting {
    private final String refName;
    private int sizeX = 16;
    private int sizeY = 16;

    public Painting(String refName, int sizeX, int sizeY) {
        this.refName = refName;
        if (sizeX > 0)
            this.sizeX = sizeX;
        if (sizeY > 0)
            this.sizeY = sizeY;
    }

    public int getSizeX() {
        return this.sizeX;
    }

    public int getSizeY() {
        return this.sizeY;
    }

    public String getRefName() {
        return this.refName;
    }
}