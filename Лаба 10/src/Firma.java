import java.util.ArrayList;
import java.util.List;

public class Firma {
    private String nazvanie;
    private List<Otdel> otdely;

    public Firma(String nazvanie) {
        this.nazvanie = nazvanie;
        this.otdely = new ArrayList<>();
    }

    public String getNazvanie() {
        return nazvanie;
    }

    public void setNazvanie(String nazvanie) {
        this.nazvanie = nazvanie;
    }

    public void dobavitOtdel(Otdel otdel) {
        otdely.add(otdel);
    }

    public void udalitOtdel(Otdel otdel) {
        otdely.remove(otdel);
    }

    public List<Otdel> getOtdely() {
        return new ArrayList<>(otdely);
    }
}