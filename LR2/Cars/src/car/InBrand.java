package car;

import java.util.Objects;

final public class InBrand extends Car {
    private int equipmentType;
    public InBrand(String brand,
                   int issueYear,
                   double engineCapacity,
                   String transmissionType,
                   double base,
                   int equipmentType
    ) {
        super(brand, issueYear, engineCapacity, transmissionType, base);
        this.equipmentType = equipmentType;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj instanceof InBrand ib) {
            return super.equals(ib) && Objects.equals(equipmentType, ib.equipmentType);
        }
        else
            return false;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(super.toString());
        sb.append("Equipment type is ").append(equipmentType).append("; ");
        return sb.toString();
    }

    public int getEquipmentType() {
        return equipmentType;
    }
    public void setEquipmentType(int equipmentType) {
        this.equipmentType = equipmentType;
    }
}
