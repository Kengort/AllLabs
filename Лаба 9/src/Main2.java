import java.util.*;

public class Main2 {
    public static void main(String[] args) {
        List<Student> students = new ArrayList<>();

        students.add(new Student("Иван Иванов", "ГР-01", 1,
                Arrays.asList(4, 5, 3, 4, 5)));
        students.add(new Student("Петр Петров", "ГР-01", 1,
                Arrays.asList(2, 3, 2, 3, 2)));
        students.add(new Student("Мария Сидорова", "ГР-02", 2,
                Arrays.asList(5, 5, 5, 4, 5)));
        students.add(new Student("Анна Козлова", "ГР-02", 2,
                Arrays.asList(3, 3, 2, 3, 3)));
        students.add(new Student("Сергей Смирнов", "ГР-03", 3,
                Arrays.asList(4, 4, 4, 4, 4)));
        students.add(new Student("Ольга Новикова", "ГР-03", 3,
                Arrays.asList(2, 2, 2, 3, 2)));

        System.out.println("Исходный список студентов:");
        printAllStudents(students);
        processStudents(students);

        System.out.println("\nСписок студентов после обработки:");
        printAllStudents(students);

        System.out.println("\nСтуденты 2 курса:");
        printStudents(students, 2);

        System.out.println("\nСтуденты 1 курса:");
        printStudents(students, 1);
    }

    public static void processStudents(List<Student> students) {
        Iterator<Student> iterator = students.iterator();

        while (iterator.hasNext()) {
            Student student = iterator.next();
            double averageGrade = student.getAverageGrade();

            if (averageGrade < 3.0) {
                iterator.remove();
                System.out.printf("Студент %s отчислен (средний балл: %.2f)%n",
                        student.getName(), averageGrade);
            } else {
                student.setCourse(student.getCourse() + 1);
                System.out.printf("Студент %s переведен на %d курс (средний балл: %.2f)%n",
                        student.getName(), student.getCourse(), averageGrade);
            }
        }
    }

    public static void printStudents(List<Student> students, int course) {
        System.out.println("Студенты " + course + " курса:");

        boolean found = false;
        for (Student student : students) {
            if (student.getCourse() == course) {
                System.out.println("- " + student.getName() + " (группа: " + student.getGroup() +
                        ", средний балл: " + String.format("%.2f", student.getAverageGrade()) + ")");
                found = true;
            }
        }

        if (!found) {
            System.out.println("На данном курсе студентов не найдено");
        }
    }

    public static void printAllStudents(List<Student> students) {
        for (Student student : students) {
            System.out.println(student);
        }
    }
}