public class Sotrudnik {
    private String fio;
    private String dolzhnost;
    private double oklad;

    public Sotrudnik(String fio, String dolzhnost, double oklad) throws OkladException {
        if (oklad < 0) {
            throw new OkladException("Оклад не может быть отрицательным", oklad);
        }
        this.fio = fio;
        this.dolzhnost = dolzhnost;
        this.oklad = oklad;
    }

    public String getFio() {
        return fio;
    }

    public void setFio(String fio) {
        this.fio = fio;
    }

    public String getDolzhnost() {
        return dolzhnost;
    }

    public void setDolzhnost(String dolzhnost) {
        this.dolzhnost = dolzhnost;
    }

    public double getOklad() {
        return oklad;
    }

    public void setOklad(double oklad) throws OkladException {
        if (oklad < 0) {
            throw new OkladException("Оклад не может быть отрицательным", oklad);
        }
        this.oklad = oklad;
    }

    public double rasschitatZarplatu() {
        return oklad;
    }
}