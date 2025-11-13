import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== Программа работы с файлами ===");
        System.out.println("1. Информация о себе");
        System.out.println("2. Анализ температур");
        System.out.println("3. Сортировка дат");
        System.out.print("Выберите задание (1-3): ");

        int choice = scanner.nextInt();
        scanner.nextLine();

        switch (choice) {
            case 1:
                FileInfoOperation.execute();
                break;
            case 2:
                TemperatureAnalysis.execute();
                break;
            case 3:
                DateSorting.execute();
                break;
            default:
                System.out.println("Неверный выбор!");
        }

        scanner.close();
    }
}