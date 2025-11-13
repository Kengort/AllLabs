public class SotrudnikPoKontraktu extends Sotrudnik {

    public SotrudnikPoKontraktu(String fio, String dolzhnost, double oklad) throws OkladException {
        super(fio, dolzhnost, oklad);
    }

    @Override
    public double rasschitatZarplatu() {
        try {
            if (getOklad() <= 0) {
                throw new ArithmeticException("Оклад должен быть положительным");
            }

            return getOklad();

        } catch (Exception e) {
            System.out.println("Ошибка при расчете зарплаты контрактника: " + e.getMessage());
            return 0;
        }
    }
}