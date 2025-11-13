import java.io.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.*;

public class DateSorting {

    public static void execute() {
        String inputFile = "data/dates_input.txt";
        String outputFile = "data/dates_sorted.txt";

        try {
            new File("data").mkdirs();
            createSampleDatesFile(inputFile);
            sortDates(inputFile, outputFile);

        } catch (IOException e) {
            System.out.println("Ошибка при работе с файлом: " + e.getMessage());
        }
    }

    private static void createSampleDatesFile(String fileName) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            String[] sampleDates = {
                    "15.03.2023",
                    "01.01.2024",
                    "25.12.2022",
                    "invalid_date",
                    "10.05.2023",
                    "30.06.2024",
                    "15.13.2023",
                    "32.01.2023",
                    "20.11.2022",
                    "05.07.2023"
            };

            for (String date : sampleDates) {
                writer.write(date);
                writer.newLine();
            }
        }
        System.out.println("Тестовый файл с датами создан: " + fileName);
    }

    private static void sortDates(String inputFile, String outputFile) {
        List<LocalDate> validDates = new ArrayList<>();
        List<String> invalidDates = new ArrayList<>();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");

        System.out.println("\n=== Обработка дат ===");

        try (BufferedReader reader = new BufferedReader(new FileReader(inputFile))) {
            String line;
            int lineNumber = 1;

            while ((line = reader.readLine()) != null) {
                line = line.trim();
                if (!line.isEmpty()) {
                    try {
                        LocalDate date = LocalDate.parse(line, formatter);
                        validDates.add(date);
                        System.out.println("✓ Строка " + lineNumber + ": '" + line + "' - корректная дата");
                    } catch (DateTimeParseException e) {
                        invalidDates.add("Строка " + lineNumber + ": '" + line + "' - " + e.getMessage());
                        System.out.println("✗ Строка " + lineNumber + ": '" + line + "' - ошибка формата");
                    }
                }
                lineNumber++;
            }
        } catch (IOException e) {
            System.out.println("Ошибка при чтении файла: " + e.getMessage());
            return;
        }

        Collections.sort(validDates);

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile))) {
            writer.write("=== Отсортированные даты ===");
            writer.newLine();

            for (LocalDate date : validDates) {
                writer.write(date.format(formatter));
                writer.newLine();
            }

            writer.newLine();
            writer.write("=== Ошибочные записи ===");
            writer.newLine();

            for (String invalid : invalidDates) {
                writer.write(invalid);
                writer.newLine();
            }

            writer.newLine();
            writer.write("=== Статистика ===");
            writer.newLine();
            writer.write("Корректных дат: " + validDates.size());
            writer.newLine();
            writer.write("Ошибочных записей: " + invalidDates.size());

        } catch (IOException e) {
            System.out.println("Ошибка при записи файла: " + e.getMessage());
            return;
        }

        System.out.println("\n=== Результаты обработки ===");
        System.out.println("Корректных дат: " + validDates.size());
        System.out.println("Ошибочных записей: " + invalidDates.size());
        System.out.println("Отсортированные даты записаны в файл: " + outputFile);

        System.out.println("\n=== Отсортированные даты ===");
        for (LocalDate date : validDates) {
            System.out.println(date.format(formatter));
        }

        if (!invalidDates.isEmpty()) {
            System.out.println("\n=== Ошибочные записи ===");
            for (String invalid : invalidDates) {
                System.out.println(invalid);
            }
        }
    }
}