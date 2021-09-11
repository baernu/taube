package messerli.database1.cashier;

import java.util.List;

import javafx.beans.property.Property;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import messerli.database1.data.Postgres;
import messerli.database1.data.PostgresDAO;
import messerli.database1.postgres_classes.SelectTaubenflug;

public class CashierViewModel {

    private StringProperty taubenId;
    private StringProperty flugId;
    private StringProperty taubenflugtext;
    private StringProperty endzeit;
    private StringProperty preis;
    private StringProperty rang;
    private StringProperty distance;
    private StringProperty besitzer;
    private StringProperty saison;
    private StringProperty minutenmeter;

    public CashierViewModel(DataModel model) {
        taubenId = new SimpleStringProperty("");
        flugId = new SimpleStringProperty("");
        taubenflugtext = new SimpleStringProperty("");
        endzeit = new SimpleStringProperty("");
        preis = new SimpleStringProperty("");
        rang = new SimpleStringProperty("");
        distance = new SimpleStringProperty("");
        besitzer = new SimpleStringProperty("");
        saison = new SimpleStringProperty("");
        minutenmeter = new SimpleStringProperty("");

        model.addStateChangedLister(new StateChangedListener() {

            @Override
            public void updatedValues(DataModel data, String taubeId, String flightId) {

            }
        });

    }

    public void resultTaubenFlugBtnClicked() {

        Postgres postgres = new Postgres();
        postgres.connect();
        String string = "";
        PostgresDAO pdao = new SelectTaubenflug(taubenId.get(), flugId.get());
        System.out.println(taubenId.get());
        List<String> list = Postgres.main1(pdao);
        int i = 0;
        for (String str : list) {
            if (i % 5 == 0) {
                string = string.concat(str + "\n");
            } else {
                string = string.concat(str);
            }

            i++;
        }

        this.taubenflugtext.setValue(string);
        System.out.println(string);

    }

    public void clearBtnClicked() {
        this.taubenId.setValue("");
    }

    public void clearBtnClicked2() {
        this.flugId.setValue("");
    }

    public StringProperty getTaubenId() {
        return taubenId;
    }

    public StringProperty getFlugId() {
        return flugId;
    }

    public StringProperty getTaubenflug() {
        return this.taubenflugtext;
    }

    public StringProperty getEndzeit() {
        return this.endzeit;
    }

    public void clearBtnClickedEndzeit() {
        this.endzeit.setValue("");
    }

    public StringProperty getPreis() {
        return this.preis;
    }

    public void clearBtnClickedPreis() {
        this.preis.setValue("");

    }

    public StringProperty getRang() {
        return this.rang;
    }

    public void clearBtnClickedRang() {
        this.rang.setValue("");
    }

    public StringProperty getDistance() {
        return this.distance;
    }

    public void clearBtnClickedDistance() {
        this.distance.setValue("");
        ;
    }

    public StringProperty getBesitzer() {
        return this.besitzer;
    }

    public void clearBtnClickedBesitzer() {
        this.besitzer.setValue("");
        ;
    }

    public void updateTaubenFlugBtnClicked() {
        Postgres postgres = new Postgres();
        postgres.connect();
        PostgresDAO pdao = new SelectTaubenflug(taubenId.get(), flugId.get(), endzeit.get(), preis.get(), rang.get(),
                distance.get(), besitzer.get());

        int i = Postgres.main3(pdao);

        this.taubenflugtext.setValue(String.valueOf(i));
        System.out.println(i);

    }

    public StringProperty getSaison() {
        return this.saison;
    }

    public void clearBtnClickedSaison() {
        this.saison.setValue("");
    }

    public void saisonErgebnis() {
        Postgres postgres = new Postgres();
        postgres.connect();
        String string = "";
        PostgresDAO pdao = new SelectTaubenflug(besitzer.get(), Integer.parseInt(saison.get()));
        // System.out.println(taubenId.get());
        List<String> list = Postgres.main4(pdao);
        int i = 1;
        for (String str : list) {
            if (i % 1 == 0) {
                string = string.concat(str + "\n");
            } else {
                string = string.concat(str);
            }

            i++;
        }

        this.taubenflugtext.setValue(string);
        System.out.println(string);
    }

    public void percent() {
        Postgres postgres = new Postgres();
        postgres.connect();
        String string = "";
        PostgresDAO pdao = new SelectTaubenflug(taubenId.get(), flugId.get(), minutenmeter.get());
        List<String> list = Postgres.main5(pdao);
        int i = 1;
        for (String str : list) {
            if (i % 1 == 0) {
                string = string.concat(str + "\n");
            } else {
                string = string.concat(str);
            }

            i++;
        }

        this.taubenflugtext.setValue(string);
        System.out.println(string);
    }

    public StringProperty getMinutenMeter() {
        return this.minutenmeter;
    }

    public void clearBtnClickedMinutenMeter() {
        this.minutenmeter.setValue("");
    }

}
