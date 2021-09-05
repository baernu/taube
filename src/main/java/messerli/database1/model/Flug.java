package messerli.database1.model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Flug {
    private List<Taube> tauben;
    private List<Flug> list = new ArrayList<>();

    private String saison;
    private String auflassOrt;

    private LocalDateTime auflassZeit;
    private int anzahlJahr = 0;

    public Flug(String auflassOrt, LocalDateTime auflassZeit) {
        this.auflassOrt = auflassOrt;
        this.saison = String.valueOf(auflassZeit.getYear());
        this.anzahlJahr++;

    }

    public Flug searchFlug(String auflassOrt, String anzahlJahr, String jahr) {

        Stream<Flug> flug = list.stream().filter((value) -> {
            return (String.valueOf(value.anzahlJahr) == anzahlJahr || (value.auflassOrt == auflassOrt)
                    || (value.saison == jahr));

        });

        return flug.collect(Collectors.toList()).get(0);
    }

    public void addFlug(Flug f) {
        list.add(f);
    }

    public void removeFlug(Flug f) {
        list.remove(f);
    }

    public void addTaube(Taube taube) {
        tauben.add(taube);
    }

    public String getAuflassOrt() {
        return this.auflassOrt;
    }

    public LocalDateTime getAuflassZeit() {
        return this.auflassZeit;
    }

    public List<Taube> getTauben() {
        return this.tauben;
    }

    public String getFlugId() {
        return auflassOrt + "-" + anzahlJahr + "-" + saison;
    }

}
