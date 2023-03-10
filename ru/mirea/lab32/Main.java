package ru.mirea.lab32;
import java.util.Scanner;
import java.io.FileNotFoundException;

public class Main {
    private static Scanner str;
    private static Scanner num;
    private static Scanner dou;
    private static Scanner cha;
    private static Scanner boo;

    public static Order Inet() {
        System.out.print("Введите имя: ");
        String nameO = str.nextLine();
        System.out.print("Введите фамилию: ");
        String nameT = str.nextLine();
        System.out.print("Введите возраст: ");
        int age = num.nextInt();
        System.out.print("Введите город: ");
        String city = str.nextLine();
        System.out.print("Введите индекс: ");
        int index = num.nextInt();
        System.out.print("Введите название улицы: ");
        String street = str.nextLine();
        System.out.print("Введите номер дома: ");
        int home = num.nextInt();
        System.out.print("Введите корпус дома(N - если корпус отсутствует): ");
        char homeL = cha.next().charAt(0);
        System.out.print("Введите номер квартиры: ");
        int homeK = num.nextInt();
        Address adr1 = new Address(city, index, street, home, homeL, homeK);
        System.out.println(adr1.toString());
        Customer customer = new Customer(nameO, nameT, age, adr1);
        int buf;
        Order internetOrder = new InternetOrder(customer);
        MenuItem bufItem;
        boolean end = false;
        boolean ret = true;
        int price;
        String name;
        String description;
        double pr = 0;
        NamePhoneTypeEnum namePhoneTypeEnum;
        boolean check;

        System.out.println();
        do {
            System.out.println("1. Добавить компьютер в заказ");
            System.out.println("2. Добавить телефон в заказ");
            System.out.println("3. Удалить технику из заказа");
            System.out.println("4. Создать заказ");
            System.out.println("5. Отменить заказ");
            System.out.println("6. Посмотреть технику");
            System.out.print("Ввод: ");
            buf = num.nextInt();
            if (buf == 1) {
                System.out.print("Введите название: ");
                name = str.nextLine();
                System.out.print("Введите описание: ");
                description = str.nextLine();
                System.out.print("Введите цену: ");
                price = num.nextInt();
                bufItem = new NameComputer(price, name, description);
                check = internetOrder.add(bufItem);
                if (check == true) {
                    System.out.println("Компьютер добавлен");
                } else {
                    System.out.println("Ошибка! Компьютер не добавлен!");
                }
            }
            else if (buf == 2) {
                System.out.println(NamePhoneTypeEnum.list());
                do {
                    System.out.print("Введите индекс телефона: ");
                    buf = num.nextInt();
                    namePhoneTypeEnum = NamePhoneTypeEnum.get(buf);
                } while ((buf <= 0) || (17 < buf) || (NamePhone.isAlcoholicDrink(namePhoneTypeEnum) == true && customer.getAge() < 18));
                System.out.print("Введите название: ");
                name = str.nextLine();
                System.out.print("Введите описание: ");
                description = str.nextLine();
                if (NamePhone.isAlcoholicDrink(namePhoneTypeEnum) == true)
                {
                    System.out.print("Введите % телефона: ");
                    pr = dou.nextDouble();
                }
                System.out.print("Введите цену: ");
                price = num.nextInt();
                if (NamePhone.isAlcoholicDrink(namePhoneTypeEnum) == true)
                {
                    bufItem = new NamePhone(price, name, description, pr, namePhoneTypeEnum);
                }
                else
                {
                    bufItem = new NamePhone(price, name, description, namePhoneTypeEnum);
                }
                check = internetOrder.add(bufItem);
                if (check == true) {
                    System.out.println("Телефон добавлен");
                } else {
                    System.out.println("Ошибка! Телефон не добавлен!");
                }
            }
            else if (buf == 3 && internetOrder.itemsQuantity() != 0) {
                System.out.println(internetOrder.toString());
                System.out.print("Ввведите номер: ");
                buf = num.nextInt();
                check = internetOrder.remove(internetOrder.get(buf - 1));
                if (check == true) {
                    System.out.println("Техника удалена");
                } else {
                    System.out.println("Ошибка! Техника не удалена!");
                }
            }
            else if (buf == 4) {
                end = true;
            }
            else if (buf == 5) {
                ret = false;
                end = true;
            }
            else if (buf == 6) {
                System.out.println(internetOrder.toString());
            }
        } while (end == false);
        if (ret == true)
        {
            return internetOrder;
        }
        else
        {
            return null;
        }
    }

    public static Order Table()
    {
        System.out.print("Введите возраст: ");
        int age = num.nextInt();
        Customer customer = new Customer(age);
        int buf;
        Order tableOrder = new TableOrder(customer);
        MenuItem bufItem;
        boolean end = false;
        boolean ret = true;
        int price;
        String name;
        String description;
        double pr = 0;
        NamePhoneTypeEnum namePhoneTypeEnum;
        boolean check;

        System.out.println();
        do {
            System.out.println("1. Добавить компьютер в заказ");
            System.out.println("2. Добавить телефон в заказ");
            System.out.println("3. Удалить технику из заказа");
            System.out.println("4. Создать заказ");
            System.out.println("5. Отменить заказ");
            System.out.println("6. Посмотреть технику");
            System.out.print("Ввод: ");
            buf = num.nextInt();
            if (buf == 1) {
                System.out.print("Введите название: ");
                name = str.nextLine();
                System.out.print("Введите описание: ");
                description = str.nextLine();
                System.out.print("Введите цену: ");
                price = num.nextInt();
                bufItem = new NameComputer(price, name, description);
                check = tableOrder.add(bufItem);
                if (check == true)
                {
                    System.out.println("Компьютер добавлен");
                }
                else
                {
                    System.out.println("Ошибка! Компьютер не добавлен!");
                }
            }
            else if (buf == 2) {
                System.out.println(NamePhoneTypeEnum.list());
                do {
                    System.out.print("Введите индекс телефона: ");
                    buf = num.nextInt();
                    namePhoneTypeEnum = NamePhoneTypeEnum.get(buf);
                } while ((buf <= 0) || (17 < buf) || (NamePhone.isAlcoholicDrink(namePhoneTypeEnum) == true && customer.getAge() < 18));
                System.out.print("Введите название: ");
                name = str.nextLine();
                System.out.print("Введите описание: ");
                description = str.nextLine();
                if (NamePhone.isAlcoholicDrink(namePhoneTypeEnum) == true)
                {
                    System.out.print("Введите % телефона: ");
                    pr = dou.nextDouble();
                }
                System.out.print("Введите цену: ");
                price = num.nextInt();
                if (NamePhone.isAlcoholicDrink(namePhoneTypeEnum) == true)
                {
                    bufItem = new NamePhone(price, name, description, pr, namePhoneTypeEnum);
                }
                else
                {
                    bufItem = new NamePhone(price, name, description, namePhoneTypeEnum);
                }
                check = tableOrder.add(bufItem);
                if (check == true) {
                    System.out.println("Телефон добавлен");
                }
                else
                {
                    System.out.println("Ошибка! Телефон не добавлен!");
                }
            }
            else if (buf == 3 && tableOrder.itemsQuantity() != 0) {
                System.out.println(tableOrder.toString());
                System.out.print("Ввведите номер: ");
                buf = num.nextInt();
                check = tableOrder.remove(tableOrder.get(buf - 1));
                if (check == true) {
                    System.out.println("Техника удалена");
                } else {
                    System.out.println("Ошибка! Техника не удалена!");
                }
            }
            else if (buf == 4) {
                end = true;
            }
            else if (buf == 5) {
                ret = false;
                end = true;
            }
            else if (buf == 6) {
                System.out.println(tableOrder.toString());
            }
        } while (end == false);
        if (ret == true)
        {
            return tableOrder;
        }
        else
        {
            return null;
        }
    }

    public static void Menu() throws FileNotFoundException
    {
        int bufINT;
        boolean error;
        System.out.print("Загрузить файл сохранения CitiLink менеджера(true) или начать с чистого листа(false): ");
        error = boo.nextBoolean();
        boolean check;
        InternetOrdersManager internetOrdersManager;
        if (error == true)
        {
            internetOrdersManager = FileManager.readI("D:\\Для всего\\МИРЭА\\Программирование на языке джава\\JAVA\\IdeaProjects\\untitled\\src\\ru\\mirea\\lab32\\InternetOrders.txt");
            if (internetOrdersManager == null)
            {
                System.out.println("Ошибка загрузки файла, менеджер создан с чистого листа!");
                internetOrdersManager = new InternetOrdersManager();
            }
            else
            {
                System.out.println("Файл загружен!");
            }
        }
        else
        {
            internetOrdersManager = new InternetOrdersManager();
        }
        System.out.print("Загрузить файл сохранения менеджера магазина(true) или начать с чистого листа(false): ");
        error = boo.nextBoolean();
        TableOrdersManager tableOrdersManager;
        if (error == false) {
            System.out.print("Введите количество заказчиков: ");
            bufINT = num.nextInt();
            tableOrdersManager = new TableOrdersManager(bufINT);
        }
        else
        {
            tableOrdersManager = FileManager.readT("D:\\Для всего\\МИРЭА\\Программирование на языке джава\\JAVA\\IdeaProjects\\untitled\\src\\ru\\mirea\\lab32\\TableOrders.txt");
            if (tableOrdersManager == null)
            {
                System.out.println("Ошибка загрузки файла, менеджер создан с чистого листа!");
                System.out.print("Введите количество заказчиков: ");
                bufINT = num.nextInt();
                tableOrdersManager = new TableOrdersManager(bufINT);
            }
            else
            {
                System.out.println("Файл загружен!");
            }
        }
        boolean end = false;
        do {
            System.out.println("1. Посмотреть CitiLink заказы");
            System.out.println("2. Посмотреть DNS заказы");
            System.out.println("3. Добавить CitiLink заказ");
            System.out.println("4. Добавить DNS заказ");
            System.out.println("5. Удалить/Закрыть CitiLink заказы");
            System.out.println("6. Удалить/Закрыть DNS заказы");
            System.out.println("7. Кол-во заказчиков");
            System.out.println("8. Изменить кол-во заказчиков");
            System.out.println("9. Загрузить файлы");
            System.out.println("10. Отчистить файлы");
            System.out.println("11. Сохранить файлы");
            System.out.println("0. Выйти");
            System.out.print("Ввод: ");
            bufINT = num.nextInt();
            if (bufINT == 1)
            {
                System.out.println(internetOrdersManager.toString());
            }
            else if(bufINT == 2)
            {
                System.out.println(tableOrdersManager.toString());
            }
            else if(bufINT == 3)
            {
                internetOrdersManager.add(Inet());
            }
            else if(bufINT == 4)
            {
                tableOrdersManager.add(Table());
            }
            else if(bufINT == 5)
            {
                System.out.println(internetOrdersManager.toString());
                System.out.print("Ввод: ");
                bufINT = num.nextInt();
                if (bufINT < internetOrdersManager.ordersQuantity())
                {
                    internetOrdersManager.remove(bufINT-1);
                }
                else
                {
                    System.out.println("Ошибка");
                }
            }
            else if(bufINT == 6)
            {
                System.out.println(tableOrdersManager.toString());
                System.out.print("Ввод: ");
                bufINT = num.nextInt();
                if (bufINT <= tableOrdersManager.ordersQuantity())
                {
                    tableOrdersManager.remove(bufINT-1);
                }
                else
                {
                    System.out.println("Ошибка");
                }
            }
            else if (bufINT == 7)
            {
                System.out.println("Всего заказчиков: " + tableOrdersManager.AllTableNumber());
                System.out.println("Не заказало ничего: " + tableOrdersManager.freeTableNumber());
                System.out.print("Заказчик ");
                int[] bufmass = tableOrdersManager.freeTableNumbers();
                for (int j = 0; j < tableOrdersManager.freeTableNumber(); ++j)
                {
                    System.out.print("№" + (bufmass[j]) + " ");
                }
                System.out.println("ничего не заказал.");
            }
            else if (bufINT == 8)
            {
                System.out.print("Введите новое кол-во заказчиков");
                bufINT = num.nextInt();
                check = tableOrdersManager.resizeTable(bufINT);
                if (check == true)
                {
                    System.out.println("Кол-во заказчиков успешно изменено! ");
                }
                else
                {
                    System.out.println("Ошибка!");
                }
            }
            else if (bufINT == 9)
            {
                System.out.print("Выберите файл\ntrue - CitiLink менеджер\nfalse - менеджер DNS\nВвод: ");
                check = boo.nextBoolean();
                if (check == true)
                {
                    internetOrdersManager = FileManager.readI("D:\\Для всего\\МИРЭА\\Программирование на языке джава\\JAVA\\IdeaProjects\\untitled\\src\\ru\\mirea\\lab32\\InternetOrders.txt");
                }
                else
                {
                    tableOrdersManager = FileManager.readT("D:\\Для всего\\МИРЭА\\Программирование на языке джава\\JAVA\\IdeaProjects\\untitled\\src\\ru\\mirea\\lab32\\TableOrders.txt");
                }
            }
            else if (bufINT == 10)
            {
                System.out.print("Выберите файл\ntrue - CitiLink менеджер\nfalse - менеджер DNS\nВвод: ");
                check = boo.nextBoolean();
                if (check == true)
                {
                    FileManager.Zero("D:\\Для всего\\МИРЭА\\Программирование на языке джава\\JAVA\\IdeaProjects\\untitled\\src\\ru\\mirea\\lab32\\InternetOrders.txt");
                }
                else
                {
                    FileManager.Zero("D:\\Для всего\\МИРЭА\\Программирование на языке джава\\JAVA\\IdeaProjects\\untitled\\src\\ru\\mirea\\lab32\\TableOrders.txt");
                }
            }
            else if (bufINT == 11)
            {
                System.out.print("Выберите файл\ntrue - CitiLink менеджер\nfalse - менеджер DNS\nВвод: ");
                check = boo.nextBoolean();
                if (check == true)
                {
                    FileManager.write("D:\\Для всего\\МИРЭА\\Программирование на языке джава\\JAVA\\IdeaProjects\\untitled\\src\\ru\\mirea\\lab32\\InternetOrders.txt", internetOrdersManager.fileString());
                }
                else
                {
                    FileManager.write("D:\\Для всего\\МИРЭА\\Программирование на языке джава\\JAVA\\IdeaProjects\\untitled\\src\\ru\\mirea\\lab32\\TableOrders.txt", tableOrdersManager.fileString());
                }
            }
            else if(bufINT == 0)
            {
                end = true;
                FileManager.write("D:\\Для всего\\МИРЭА\\Программирование на языке джава\\JAVA\\IdeaProjects\\untitled\\src\\ru\\mirea\\lab32\\TableOrders.txt", tableOrdersManager.fileString());
                FileManager.write("D:\\Для всего\\МИРЭА\\Программирование на языке джава\\JAVA\\IdeaProjects\\untitled\\src\\ru\\mirea\\lab32\\InternetOrders.txt", internetOrdersManager.fileString());
            }
        }while (end == false);
    }

    public static void main(String[] args) throws FileNotFoundException {
        str = new Scanner(System.in);
        num = new Scanner(System.in);
        dou = new Scanner(System.in);
        cha = new Scanner(System.in);
        boo = new Scanner(System.in);
        Menu();
    }
}
