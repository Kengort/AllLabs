public class Main {
    public static void main(String[] args) {
        Firma firma = new Firma("");

        Otdel otdelIT = new Otdel("IT отдел");
        Otdel otdelHR = new Otdel("HR отдел");

        firma.dobavitOtdel(otdelIT);
        firma.dobavitOtdel(otdelHR);

        System.out.println("=== Тестирование обработки исключений ===");

        try {
            Sotrudnik sotrudnik1 = new Sotrudnik("", "Программист", 50000);
        } catch (OkladException e) {
            System.out.println("Невозможно создать сотрудника – указан отрицательный оклад: " + e.getOklad());
            try {
                throw new OkladException("Повторное исключение", e.getOklad());
            } catch (OkladException e2) {
                System.out.println("Повторно перехвачено: " + e2.getMessage());
            }
        }

        try {
            ShtatnySotrudnik shtatnik1 = new ShtatnySotrudnik("Петров Петр", "Senior Developer", 100000, 20000);
            ShtatnySotrudnik shtatnik2 = new ShtatnySotrudnik("Сидорова Анна", "Junior Developer", 50000, -5000); // Отрицательная премия

            SotrudnikPoKontraktu kontraktnik1 = new SotrudnikPoKontraktu("Козлов Алексей", "Консультант", 80000);

            otdelIT.dobavitSotrudnika(shtatnik1);
            otdelIT.dobavitSotrudnika(shtatnik2);
            otdelIT.dobavitSotrudnika(kontraktnik1);

            System.out.println("\n=== Расчет зарплаты ===");

            double zarplata1 = shtatnik1.rasschitatZarplatu();
            System.out.println("Зарплата " + shtatnik1.getFio() + ": " + zarplata1);

            double zarplata2 = shtatnik2.rasschitatZarplatu();
            System.out.println("Зарплата " + shtatnik2.getFio() + ": " + zarplata2);

            double zarplata3 = kontraktnik1.rasschitatZarplatu();
            System.out.println("Зарплата " + kontraktnik1.getFio() + ": " + zarplata3);

            System.out.println("\n=== Информация о фирме ===");
            System.out.println("Фирма: " + firma.getNazvanie());
            for (Otdel otdel : firma.getOtdely()) {
                System.out.println("Отдел: " + otdel.getNazvanie() +
                        ", сотрудников: " + otdel.getKolichestvoSotrudnikov());

                for (Sotrudnik sotrudnik : otdel.getSotrudniki()) {
                    System.out.println("  - " + sotrudnik.getFio() + ", " +
                            sotrudnik.getDolzhnost() + ", оклад: " +
                            sotrudnik.getOklad());
                }
            }

        } catch (OkladException e) {
            System.out.println("Ошибка при создании сотрудника: " + e.getMessage());
        }
    }
}