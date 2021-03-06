package messerli.database1.cashier;

import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;

public class CashierView extends HBox {

    public CashierView(CashierViewModel cashierViewModel) {

        Insets insets = new Insets(10.0f, 40.0f, 10.0f, 40.0f);

        TextField tfTaube = new TextField();
        tfTaube.setPromptText("TaubenId eingeben");
        TextField tfFlug = new TextField();
        tfFlug.setPromptText("FlugId eingeben");
        TextArea taTaubenflug = new TextArea();
        TextField tfEndzeit = new TextField();
        tfEndzeit.setPromptText("Endzeit eingeben");
        TextField tfIsPreis = new TextField();
        tfIsPreis.setPromptText("Preis: false or true");
        TextField tfRang = new TextField();
        tfRang.setPromptText("Rang eingeben");
        TextField tfDistance = new TextField();
        tfDistance.setPromptText("Distanz eingeben");
        TextField tfBesitzer = new TextField();
        tfBesitzer.setPromptText("Besitzer eingeben");
        TextField tfSaison = new TextField();
        tfSaison.setPromptText("Saison eingeben");
        TextField tfMinutenMeter = new TextField();
        tfMinutenMeter.setPromptText("Abfrage Minutenmeter");

        Button clearbtntaube = new Button("clear");
        Button clearbtnflug = new Button("clear");
        Button clearbtnendzeit = new Button("clear");
        Button btntaubenfluege = new Button("Taube und Flug");
        Button btnupdatetaubenflug = new Button("update Taube und Flug");
        Button clearbtnpreis = new Button("clear");
        Button clearbtnrang = new Button("clear");
        Button clearbtndistance = new Button("clear");
        Button clearbtnbesitzer = new Button("clear");
        Button clearbtnsaison = new Button("clear");
        Button btnsaisonergebnis = new Button("Saisonergebnis");
        Button btnpercent = new Button("Prozent ??ber Fluggeschw.");
        Button clearbtnminutenmeter = new Button("clear");
        Button btncreatetaube = new Button("create Taube");
        Button btncreatetaubeundflug = new Button("create Taube und Flug");
        Button btnbewertung = new Button("Flug bewerten");

        ChoiceBox<String> choiceBox = new ChoiceBox<>();
        choiceBox.setId("choiceBox");
        choiceBox.getItems().add("sehr gut");
        choiceBox.getItems().add("gut");
        choiceBox.getItems().add("ok");
        choiceBox.getItems().add("schlecht");
        choiceBox.getItems().add("miserabel");
        choiceBox.setPadding(insets);

        tfTaube.setPadding(insets);
        tfFlug.setPadding(insets);
        tfEndzeit.setPadding(insets);
        tfIsPreis.setPadding(insets);
        tfRang.setPadding(insets);
        tfDistance.setPadding(insets);
        tfBesitzer.setPadding(insets);
        tfSaison.setPadding(insets);
        tfMinutenMeter.setPadding(insets);

        btntaubenfluege.setPadding(insets);
        btnupdatetaubenflug.setPadding(insets);
        clearbtntaube.setPadding(insets);
        clearbtnflug.setPadding(insets);
        clearbtnendzeit.setPadding(insets);
        clearbtnpreis.setPadding(insets);
        clearbtnrang.setPadding(insets);
        clearbtndistance.setPadding(insets);
        clearbtnbesitzer.setPadding(insets);
        clearbtnsaison.setPadding(insets);
        btnsaisonergebnis.setPadding(insets);
        btnpercent.setPadding(insets);
        clearbtnminutenmeter.setPadding(insets);
        btncreatetaube.setPadding(insets);
        btncreatetaubeundflug.setPadding(insets);
        btnbewertung.setPadding(insets);

        GridPane gridPane = new GridPane();
        gridPane.setPadding(insets);
        gridPane.setHgap(20);
        gridPane.setVgap(20);

        gridPane.add(tfTaube, 0, 0);
        gridPane.add(tfFlug, 0, 1);
        gridPane.add(btntaubenfluege, 0, 2);
        gridPane.add(clearbtntaube, 1, 0);
        gridPane.add(clearbtnflug, 1, 1);
        gridPane.add(taTaubenflug, 1, 2);
        gridPane.add(tfEndzeit, 0, 3);
        gridPane.add(clearbtnendzeit, 1, 3);
        gridPane.add(tfIsPreis, 0, 4);
        gridPane.add(clearbtnpreis, 1, 4);

        gridPane.add(tfRang, 0, 5);
        gridPane.add(clearbtnrang, 1, 5);
        gridPane.add(tfDistance, 0, 6);
        gridPane.add(clearbtndistance, 1, 6);
        gridPane.add(tfBesitzer, 0, 7);
        gridPane.add(clearbtnbesitzer, 1, 7);
        gridPane.add(btnupdatetaubenflug, 0, 8);

        gridPane.add(tfSaison, 0, 9);
        gridPane.add(clearbtnsaison, 1, 9);
        gridPane.add(btnsaisonergebnis, 0, 10);
        gridPane.add(btnpercent, 1, 10);
        gridPane.add(tfMinutenMeter, 0, 11);
        gridPane.add(clearbtnminutenmeter, 1, 11);
        gridPane.add(btncreatetaube, 0, 12);
        gridPane.add(btncreatetaubeundflug, 1, 12);
        gridPane.add(choiceBox, 2, 2);
        gridPane.add(btnbewertung, 2, 3);

        this.getChildren().add(gridPane);

        tfTaube.textProperty().bindBidirectional(cashierViewModel.getTaubenId());
        tfFlug.textProperty().bindBidirectional(cashierViewModel.getFlugId());
        taTaubenflug.textProperty().bindBidirectional(cashierViewModel.getTaubenflug());
        tfEndzeit.textProperty().bindBidirectional(cashierViewModel.getEndzeit());
        tfIsPreis.textProperty().bindBidirectional(cashierViewModel.getPreis());
        tfRang.textProperty().bindBidirectional(cashierViewModel.getRang());
        tfDistance.textProperty().bindBidirectional(cashierViewModel.getDistance());
        tfBesitzer.textProperty().bindBidirectional(cashierViewModel.getBesitzer());
        tfSaison.textProperty().bindBidirectional(cashierViewModel.getSaison());
        tfMinutenMeter.textProperty().bindBidirectional(cashierViewModel.getMinutenMeter());
        choiceBox.valueProperty().bindBidirectional(cashierViewModel.getBewertung());

        clearbtntaube.setOnAction(event -> {

            cashierViewModel.clearBtnClicked();
        });

        clearbtnflug.setOnAction(event -> {
            cashierViewModel.clearBtnClicked2();
        });

        btntaubenfluege.setOnAction(event -> {
            cashierViewModel.resultTaubenFlugBtnClicked();
        });

        btnupdatetaubenflug.setOnAction(event -> cashierViewModel.updateTaubenFlugBtnClicked());

        clearbtnendzeit.setOnAction(event -> {
            cashierViewModel.clearBtnClickedEndzeit();
        });

        clearbtnpreis.setOnAction(event -> cashierViewModel.clearBtnClickedPreis());
        clearbtnrang.setOnAction(event -> cashierViewModel.clearBtnClickedRang());
        clearbtndistance.setOnAction(event -> cashierViewModel.clearBtnClickedDistance());
        clearbtnbesitzer.setOnAction(event -> cashierViewModel.clearBtnClickedBesitzer());
        clearbtnsaison.setOnAction(event -> cashierViewModel.clearBtnClickedSaison());
        btnsaisonergebnis.setOnAction(event -> cashierViewModel.saisonErgebnis());
        btnpercent.setOnAction(event -> cashierViewModel.percent());
        clearbtnminutenmeter.setOnAction(event -> cashierViewModel.clearBtnClickedMinutenMeter());
        btncreatetaube.setOnAction(event -> cashierViewModel.createTaube());
        btncreatetaubeundflug.setOnAction(event -> cashierViewModel.createTaubeUndFlug());
        btnbewertung.setOnAction(event -> cashierViewModel.bewerten());

    }

}
