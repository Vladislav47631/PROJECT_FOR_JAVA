package ru.mirea.lab32;
public enum NamePhoneTypeEnum {
    Iphone,
    Samsung,
    HP,
    Lenovo,
    POCO,
    Xperia,
    Nokia,
    LG,
    Xiaomi,
    Huawei,
    Google,
    Motorola,
    Honor,
    OnePlus,
    Realme,
    Philips,
    Sony;

    private NamePhoneTypeEnum() {
    }

    public static String list()
    {
        String str = "";
        str += "1 | Iphone\n";
        str += "2 | Samsung\n";
        str += "3 | HP\n";
        str += "4 | Lenovo\n";
        str += "5 | POCO\n";
        str += "6 | Xperia\n";
        str += "7 | Nokia\n";
        str += "8 | LG\n";
        str += "9 | Xiaomi\n";
        str += "10 | Huawei\n";
        str += "11 | Google\n";
        str += "12 | Motorola\n";
        str += "13 | Honor\n";
        str += "14 | OnePlus\n";
        str += "15 | Realme\n";
        str += "16 | Philips\n";
        str += "17 | Sony";
        return str;
    }

    public static NamePhoneTypeEnum get(int i)
    {
        switch (i)
        {
            case 1:
            {
                return Iphone;
            }
            case 2:
            {
                return Samsung;
            }
            case 3:
            {
                return HP;
            }
            case 4:
            {
                return Lenovo;
            }
            case 5:
            {
                return POCO;
            }
            case 6:
            {
                return Xperia;
            }
            case 7:
            {
                return Nokia;
            }
            case 8:
            {
                return LG;
            }
            case 9:
            {
                return Xiaomi;
            }
            case 10:
            {
                return Huawei;
            }
            case 11:
            {
                return Google;
            }
            case 12:
            {
                return Motorola;
            }
            case 13:
            {
                return Honor;
            }
            case 14:
            {
                return OnePlus;
            }
            case 15:
            {
                return Realme;
            }
            case 16:
            {
                return Philips;
            }
            case 17:
            {
                return Sony;
            }
        }
        return null;
    }

    public static NamePhoneTypeEnum get(String i)
    {
        switch (i)
        {
            case "IPHONE":
            {
                return Iphone;
            }
            case "SAMSUNG":
            {
                return Samsung;
            }
            case "HP":
            {
                return HP;
            }
            case "LENOVO":
            {
                return Lenovo;
            }
            case "POCO":
            {
                return POCO;
            }
            case "XPERIA":
            {
                return Xperia;
            }
            case "NOKIA":
            {
                return Nokia;
            }
            case "LG":
            {
                return LG;
            }
            case "XIAOMI":
            {
                return Xiaomi;
            }
            case "HUAWEI":
            {
                return Huawei;
            }
            case "GOOGLE":
            {
                return Google;
            }
            case "MOTOROLA":
            {
                return Motorola;
            }
            case "HONOR":
            {
                return Honor;
            }
            case "ONEPLUS":
            {
                return OnePlus;
            }
            case "REALME":
            {
                return Realme;
            }
            case "PHILIPS":
            {
                return Philips;
            }
            case "SONY":
            {
                return Sony;
            }
        }
        return null;
    }
}
