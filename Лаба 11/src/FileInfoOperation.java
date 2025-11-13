import java.io.*;
import java.nio.file.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class FileInfoOperation {

    public static void execute() {
        String fileName = "data/personal_info.txt";

        try {
            Files.createDirectories(Paths.get("data"));
            writePersonalInfo(fileName);
            displayFileInfo(fileName);
            displayFileContent(fileName);

        } catch (IOException e) {
            System.out.println("Ошибка при работе с файлом: " + e.getMessage());
        }
    }

    private static void writePersonalInfo(String fileName) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            writer.write("=== Личная информация ===");
            writer.newLine();
            writer.write("ФИО: Критский Владислав Олегович");
            writer.newLine();
            writer.write("Дата рождения: 06.11.2005");
            writer.newLine();
            writer.write("Город: Минск");
            writer.newLine();
            writer.write("Профессия: Техник-программист");
            writer.newLine();
            writer.write("Хобби: программирование, фильмы");
            writer.newLine();
            writer.write("Дата создания файла: " +
                    LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm:ss")));
            writer.newLine();
        }
        System.out.println("Файл успешно создан: " + fileName);
    }

    private static void displayFileInfo(String fileName) throws IOException {
        Path path = Paths.get(fileName);

        if (Files.exists(path)) {
            System.out.println("\n=== Информация о файле ===");
            System.out.println("Имя файла: " + path.getFileName());
            System.out.println("Путь: " + path.toAbsolutePath());
            System.out.println("Размер: " + Files.size(path) + " байт");
            System.out.println("Дата последнего изменения: " +
                    Files.getLastModifiedTime(path));
            System.out.println("Доступен для чтения: " + Files.isReadable(path));
            System.out.println("Доступен для записи: " + Files.isWritable(path));
        }
    }

    private static void displayFileContent(String fileName) throws IOException {
        System.out.println("\n=== Содержимое файла ===");
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        }
    }
}