package net.bensullivan.connect4.model;

public class FrameDimension {
    private int width;
    private int height;

    public FrameDimension(int width, int height) {
        this.width = width;
        this.height = height;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FrameDimension that = (FrameDimension) o;
        if (width != that.width) return false;
        return height == that.height;
    }

    @Override
    public int hashCode() {
        int result = width;
        result = 31 * result + height;
        return result;
    }

    @Override
    public String toString() {
        return "FrameDimension{width=" + width + ", height=" + height + '}';
    }
}
