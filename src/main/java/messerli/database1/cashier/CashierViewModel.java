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

    public CashierViewModel(DataModel model) {
        taubenId = new SimpleStringProperty("");
        flugId = new SimpleStringProperty("");
        taubenflugtext = new SimpleStringProperty("");
        endzeit = new SimpleStringProperty("");

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

}
