import java.util.*;

public class Main3 {
    public static void main(String[] args) {
        Employee[] employees = {
                new Employee("Иванов", 2500.50),
                new Employee("Петров", 3200.75),
                new Employee("Сидорова", 2800.00),
                new Employee("Козлов", 3200.75), // Такая же зарплата как у Петрова
                new Employee("Смирнов", 4100.25),
                new Employee("Новикова", 1950.80),
                new Employee("Васильев", 3500.00),
                new Employee("Павлова", 2750.40)
        };

        Report.generateReport(employees);

        System.out.println("\na) Упорядоченный список сотрудников (по возрастанию зарплаты):");
        List<Employee> sortedEmployees = getSortedEmployees(employees);
        printEmployees(sortedEmployees);

        System.out.println("\nb) Первые 5 имен работников:");
        printFirstFiveNames(sortedEmployees);

        System.out.println("\nc) Последние 3 идентификатора работников:");
        printLastThreeIds(sortedEmployees);
    }

    public static List<Employee> getSortedEmployees(Employee[] employees) {
        List<Employee> employeeList = new ArrayList<>(Arrays.asList(employees));

        Collections.sort(employeeList, new Comparator<Employee>() {
            @Override
            public int compare(Employee e1, Employee e2) {
                int salaryCompare = Double.compare(e1.getSalary(), e2.getSalary());
                if (salaryCompare != 0) {
                    return salaryCompare;
                }
                return e1.getFullname().compareTo(e2.getFullname());
            }
        });

        return employeeList;
    }

    public static void printEmployees(List<Employee> employees) {
        System.out.printf("%-4s %-15s %12s%n", "ID", "Имя", "Зарплата");
        System.out.println("-----------------------------------");
        for (Employee employee : employees) {
            System.out.printf("%-4d %-15s %12.2f%n",
                    employee.getId(),
                    employee.getFullname(),
                    employee.getSalary());
        }
    }

    public static void printFirstFiveNames(List<Employee> employees) {
        if (employees.size() < 5) {
            System.out.println("В списке меньше 5 сотрудников");
            return;
        }

        System.out.println("Первые 5 сотрудников (с наименьшими зарплатами):");
        for (int i = 0; i < 5; i++) {
            System.out.println((i + 1) + ". " + employees.get(i).getFullname() +
                    " - " + employees.get(i).getSalary() + " руб.");
        }
    }

    public static void printLastThreeIds(List<Employee> employees) {
        if (employees.size() < 3) {
            System.out.println("В списке меньше 3 сотрудников");
            return;
        }

        System.out.println("Последние 3 ID (сотрудники с наибольшими зарплатами):");
        for (int i = employees.size() - 3; i < employees.size(); i++) {
            System.out.println("ID: " + employees.get(i).getId() + " - " +
                    employees.get(i).getFullname() +
                    " (" + employees.get(i).getSalary() + " руб.)");
        }
    }
}