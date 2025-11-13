public class ShtatnySotrudnik extends Sotrudnik {
    private double premiya;

    public ShtatnySotrudnik(String fio, String dolzhnost, double oklad, double premiya) throws OkladException {
        super(fio, dolzhnost, oklad);
        this.premiya = premiya;
    }

    public double getPremiya() {
        return premiya;
    }

    public void setPremiya(double premiya) {
        this.premiya = premiya;
    }

    @Override
    public double rasschitatZarplatu() {
        try {
            if (premiya < 0) {
                throw new PremiyaException("Премия не может быть отрицательной: " + premiya);
            }

            if (getOklad() <= 0) {
                throw new ArithmeticException("Оклад должен быть положительным");
            }

            return getOklad() + premiya;

        } catch (PremiyaException e) {
            System.out.println("Ошибка при расчете зарплаты: " + e.getMessage());
            return getOklad(); // Возвращаем только оклад без премии
        } catch (Exception e) {
            System.out.println("Общая ошибка при расчете зарплаты: " + e.getMessage());
            return 0;
        }
    }
}