package messerli.database1.model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ResultTaubeFlug {
    Taube taube;
    Flug flug;
    List<ResultTaubeFlug> list = new ArrayList<>();
    LocalDateTime endzeit;
    int rang;
    boolean preis = false;
    private String flugId;
    private String taubeId;

    public ResultTaubeFlug(Taube taube, Flug flug, LocalDateTime endzeit, int rang, boolean preis) {
        this.taube = taube;
        this.flug = flug;
        this.endzeit = endzeit;
        this.rang = rang;
        this.preis = preis;
        this.flugId = taube.getTaubenId();
        this.taubeId = flug.getFlugId();
    }

    public void addResultTaubeFlug(ResultTaubeFlug rtf) {
        list.add(rtf);
    }

    public void removeResultTaubeFlug(ResultTaubeFlug rtf) {
        list.remove(rtf);
    }

    public ResultTaubeFlug searchResultTaubeFlug(String taubeId, String flugId) {
        Stream<ResultTaubeFlug> rtf = list.stream().filter((value) -> {
            return (value.flugId == flugId || value.taubeId == taubeId);
        });

        return rtf.collect(Collectors.toList()).get(0);
    }

    @Override
    public String toString() {
        return "{" + " taube='" + taube.getJahrgang() + "'" + taube.getNummer() + ", flug='" + flug.getAuflassOrt()
                + "'" + "}";
    }

}
