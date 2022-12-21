package ru.mirea.lab32;
public class NamePhone extends MenuItem implements Alcoholable {
    private double alcoholDegree;
    private NamePhoneTypeEnum typeEnum;

    public NamePhone(int price, String name, String description, double alcoholDegree, NamePhoneTypeEnum typeEnum) {
        super(price, name, description);
        //this.alcoholDegree = alcoholDegree;
        this.typeEnum = typeEnum;
    }

    public NamePhone(int price, String name, String description, NamePhoneTypeEnum typeEnum) {
        super(price, name, description);
        //this.alcoholDegree = 0.0;
        this.typeEnum = typeEnum;
    }

    public NamePhone(String name, NamePhoneTypeEnum typeEnum) {
        super(0, name, (String)null);
        //this.alcoholDegree = 0.0;
        this.typeEnum = typeEnum;
    }

    public int getPrice() {
        return this.price;
    }

    public String getName() {
        return this.name;
    }

    public String getDescription() {
        return this.description;
    }

    public static boolean isAlcoholicDrink(NamePhoneTypeEnum a) {
        if (a == NamePhoneTypeEnum.OnePlus || a == NamePhoneTypeEnum.Honor || a == NamePhoneTypeEnum.Sony || a == NamePhoneTypeEnum.Google || a == NamePhoneTypeEnum.Realme || a == NamePhoneTypeEnum.Philips || a == NamePhoneTypeEnum.Motorola)
        {
            return false;
        }
        else
        {
            return true;
        }
    }

    public double getAlcoholVol() {
        return this.alcoholDegree;
    }

    public NamePhoneTypeEnum getType() {
        return this.typeEnum;
    }

    public String toString() {
        String var10000 = String.valueOf(this.typeEnum);
        return "Телефон: " + var10000 + " " + this.name + " - " + this.price + " % - " + this.description;
    }

    public String fileString()
    {
        String result = "Телефон " + String.valueOf(this.typeEnum) + " '" + this.name + "' " + this.price + " " + this.description + "'";
        result = result.replace(".", ",");
        return result;
    }

    public boolean equals(Object object) {
        if (object != null && object.getClass() == this.getClass()) {
            return object == this;
        } else {
            return false;
        }
    }

    public int hashCode() {
        boolean prime = true;
        int result = 5;
        result = 31 * result + this.price;
        result = 31 * result + this.name.hashCode();
        result = 31 * result + this.description.hashCode();
        result = 31 * result + (int)this.alcoholDegree;
        result = 31 * result + this.typeEnum.hashCode();
        return result;
    }
}
