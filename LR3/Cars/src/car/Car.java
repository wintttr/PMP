package car;

import java.util.Objects;

abstract public class Car implements IStartable, IConditionable {
    private String brand;
    private int issueYear;
    private double engineCapacity;
    private String transmissionType;
    private double base;

    protected Car(String brand,
                  int issueYear,
                  double engineCapacity,
                  String transmissionType,
                  double base) {
        this.brand = brand;
        this.issueYear = issueYear;
        this.engineCapacity = engineCapacity;
        this.transmissionType = transmissionType;
        this.base = base;
    }

    @Override
    public void inConditioner() {
        System.out.println("Default InConditioner");
    }

    @Override
    public void outConditioner() {
        System.out.println("Default OutConditioner");
    }

    @Override
    public void start() {
        System.out.println("Default Start");
    }

    @Override
    public void stop() {
        System.out.println("Default Stop");
    }

    @Override
    public boolean equals(Object obj) {
        if(obj instanceof Car anotherCar) {
            boolean brandEqual = Objects.equals(brand, anotherCar.brand);
            boolean issueYearEqual = Objects.equals(issueYear, anotherCar.issueYear);
            boolean engineCapacityEqual = Objects.equals(engineCapacity, anotherCar.engineCapacity);
            boolean transmissionTypeEqual = Objects.equals(transmissionType, anotherCar.transmissionType);
            boolean baseEqual = Objects.equals(base, anotherCar.base);

            return brandEqual && issueYearEqual && engineCapacityEqual && transmissionTypeEqual && baseEqual;
        }
        else
            return false;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append("Brand is ").append(brand).append("; ");
        sb.append("Issue year is ").append(issueYear).append("; ");
        sb.append("Engine capacity is ").append(engineCapacity).append("; ");
        sb.append("Transmission type is ").append(transmissionType).append("; ");
        sb.append("Base is ").append(base).append("; ");

        return sb.toString();
    }

    // геттеры сеттеры
    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public int getIssueYear() {
        return issueYear;
    }

    public void setIssueYear(int issueYear) {
        this.issueYear = issueYear;
    }

    public double getEngineCapacity() {
        return engineCapacity;
    }

    public void setEngineCapacity(double engineCapacity) {
        this.engineCapacity = engineCapacity;
    }

    public String getTransmissionType() {
        return transmissionType;
    }

    public void setTransmissionType(String _transmissionType) {
        this.transmissionType = transmissionType;
    }

    public double getBase() {
        return base;
    }

    public void setBase(double base) {
        this.base = base;
    }
}
