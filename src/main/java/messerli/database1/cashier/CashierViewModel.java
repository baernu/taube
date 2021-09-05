package messerli.database1.cashier;

import java.util.List;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import messerli.database1.data.Postgres;

public class CashierViewModel {

    private StringProperty taubenId;
    private StringProperty flugId;
    private StringProperty taubenflugtext;

    public CashierViewModel(DataModel model) {
        taubenId = new SimpleStringProperty("");
        flugId = new SimpleStringProperty("");
        taubenflugtext = new SimpleStringProperty("");

        // this.taubenId.setValue(model.getTaubenId());
        // this.flugId.setValue(model.getFlugId());

        model.addStateChangedLister(new StateChangedListener() {

            @Override
            public void updatedValues(DataModel data, String taubeId, String flightId) {
                // taubenId.setValue(taubeId);
                // flugId.setValue(flightId);

            }
        });

    }

    public void taubeBtnClicked(String string) {
        this.taubenId.setValue(string);
    }

    public void setIdBtnClicked(String string) {
        this.taubenId.setValue(string);
    }

    public void setFlugIdBtnClicked(String string) {
        this.flugId.setValue(string);
    }

    public void resultTaubenFlugBtnClicked() {

        // this.taubenflugtext.setValue(string);

        Postgres postgres = new Postgres();
        postgres.connect();
        String string = "";
        List<String> list = Postgres.main1();
        int i = 0;
        for (String str : list) {
            if (i % 5 == 0) {
                string = string.concat(str + "\n");
            }
            string = string.concat(str);
            i++;
        }
        /*
         * list.stream().forEach((value) -> { String str = str.concat(value + "  ");
         * System.out.println(value);
         * 
         * });
         */
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

}
