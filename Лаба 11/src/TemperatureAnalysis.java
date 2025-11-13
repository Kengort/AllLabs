import java.io.*;
import java.util.Scanner;

public class TemperatureAnalysis {

    public static void execute() {
        String fileName = "data/temperatures.txt";

        try {
            new File("data").mkdirs();
            inputTemperatures(fileName);
            calculateAverageTemperature(fileName);

        } catch (IOException e) {
            System.out.println("Ошибка при работе с файлом: " + e.getMessage());
        }
    }

    private static void inputTemperatures(String fileName) throws IOException {
        System.out.println("Введите 15 вещественных значений температуры:");
        System.out.println("Можно использовать как точку (15.5), так и запятую (15,5)");

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            BufferedReader consoleReader = new BufferedReader(new InputStreamReader(System.in));

            for (int i = 1; i <= 5; i++) {
                while (true) {
                    System.out.print("Температура " + i + ": ");

                    try {
                        String input = consoleReader.readLine().trim();

                        if (input.isEmpty()) {
                            System.out.println("❌ Пустой ввод. Попробуйте снова.");
                            continue;
                        }
                        String normalizedInput = input.replace(',', '.');
                        double temperature = Double.parseDouble(normalizedInput);
                        writer.write(normalizedInput);
                        writer.newLine();
                        System.out.println("✓ Принято: " + normalizedInput);
                        break;

                    } catch (NumberFormatException e) {
                        System.out.println("❌ Ошибка! Введите корректное вещественное число (например: 15.5 или -3.2)");
                    }
                }
            }
        }
        System.out.println("Температуры успешно записаны в файл: " + fileName);
    }

    private static void calculateAverageTemperature(String fileName) {
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            double sum = 0;
            int count = 0;
            String line;

            System.out.println("\n=== Считанные температуры ===");
            while ((line = reader.readLine()) != null) {
                line = line.trim();
                if (!line.isEmpty()) {
                    try {
                        String normalizedLine = line.replace(',', '.');
                        double temperature = Double.parseDouble(normalizedLine);
                        System.out.printf("Температура %d: %.2f°C\n", count + 1, temperature);
                        sum += temperature;
                        count++;
                    } catch (NumberFormatException e) {
                        System.out.println("Ошибка формата в строке: " + line);
                    }
                }
            }

            if (count > 0) {
                double average = sum / count;
                System.out.printf("\n=== Результаты анализа ===\n");
                System.out.printf("Количество значений: %d\n", count);
                System.out.printf("Сумма температур: %.2f°C\n", sum);
                System.out.printf("Средняя температура: %.2f°C\n", average);
            } else {
                System.out.println("Не удалось считать ни одного значения температуры.");
            }

        } catch (IOException e) {
            System.out.println("Ошибка при чтении файла: " + e.getMessage());
        }
    }
}