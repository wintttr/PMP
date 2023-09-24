package car;

import java.util.Objects;

final public class HomeBrand extends Car {
    private int color;
    public HomeBrand(String brand,
                   int issueYear,
                   double engineCapacity,
                   String transmissionType,
                   double base,
                   int color
    ) {
        super(brand, issueYear, engineCapacity, transmissionType, base);
        this.color = color;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj instanceof HomeBrand hb) {
            return super.equals(hb) && Objects.equals(color, hb.color);
        }
        else
            return false;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(super.toString());
        sb.append("Color is ").append(color).append("; ");
        return sb.toString();
    }

    @Override
    public void start() {
        System.out.println("HomeBrand Start");
    }

    @Override
    public void stop() {
        System.out.println("HomeBrand Stop");
    }

    @Override
    public void inConditioner() {
        System.out.println("HomeBrand InConditioner");
    }

    @Override
    public void outConditioner() {
        System.out.println("HomeBrand OutConditioner");
    }

    public int getColor() {
        return color;
    }

    public void setColor(int color) {
        this.color = color;
    }
}
