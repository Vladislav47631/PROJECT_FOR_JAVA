package ru.mirea.lab17.number2;

public class MVCPattern {
    public static void main(String[] args) {
        EmployeeView view = new EmployeeView();
        EmployeeController controller = new EmployeeController(view);
        System.out.println(controller.getSalaryMonth());
    }
}
