package HW_04;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        EmployeeDirectory directory = new EmployeeDirectory();

        // Добавление нескольких сотрудников в справочник
        directory.addEmployee(new Employee(1, "123-456-7890", "Иванов", 5));
        directory.addEmployee(new Employee(2, "987-654-3210", "Петров", 7));
        directory.addEmployee(new Employee(3, "555-123-4567", "Сидоров", 3));

        // Поиск сотрудников по стажу
        System.out.println("Сотрудники со стажем 5 лет:");
        List<Employee> employeesWithExperience5 = directory.findEmployeesByExperience(5);
        for (Employee employee : employeesWithExperience5) {
            System.out.println(employee.getName());
        }

        // Поиск номера телефона сотрудника по имени
        System.out.println("\nНомера телефонов сотрудника с фамилией Петров:");
        List<String> phoneNumbersOfPetrovs = directory.findPhoneNumbersByName("Петров");
        for (String phoneNumber : phoneNumbersOfPetrovs) {
            System.out.println(phoneNumber);
        }

        // Поиск сотрудника по табельному номеру
        System.out.println("\nПоиск сотрудника с табельным номером 2:");
        Employee employeeWithId2 = directory.findEmployeeByEmployeeId(2);
        if (employeeWithId2 != null) {
            System.out.println("Найден сотрудник: " + employeeWithId2.getName());
        } else {
            System.out.println("Сотрудник с табельным номером 2 не найден");
        }
    }
}

