import java.util.ArrayList;
import java.util.List;

public class Otdel {
    private String nazvanie;
    private List<Sotrudnik> sotrudniki;

    public Otdel(String nazvanie) {
        this.nazvanie = nazvanie;
        this.sotrudniki = new ArrayList<>();
    }

    public String getNazvanie() {
        return nazvanie;
    }

    public void setNazvanie(String nazvanie) {
        this.nazvanie = nazvanie;
    }

    public int getKolichestvoSotrudnikov() {
        return sotrudniki.size();
    }

    public void dobavitSotrudnika(Sotrudnik sotrudnik) {
        sotrudniki.add(sotrudnik);
    }

    public void udalitSotrudnika(Sotrudnik sotrudnik) {
        sotrudniki.remove(sotrudnik);
    }

    public List<Sotrudnik> getSotrudniki() {
        return new ArrayList<>(sotrudniki);
    }
}