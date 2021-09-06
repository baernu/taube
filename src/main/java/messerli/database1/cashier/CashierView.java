package messerli.database1.cashier;

import javafx.geometry.Insets;
import javafx.scene.control.Button;
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

        Button clearbtntaube = new Button("clear");
        Button clearbtnflug = new Button("clear");
        Button clearbtnendzeit = new Button("clear");
        Button btntaubenfluege = new Button("TAUBENFLUEGE");

        tfTaube.setPadding(insets);
        tfFlug.setPadding(insets);
        tfEndzeit.setPadding(insets);

        btntaubenfluege.setPadding(insets);
        clearbtntaube.setPadding(insets);
        clearbtnflug.setPadding(insets);
        clearbtnendzeit.setPadding(insets);

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

        this.getChildren().add(gridPane);

        tfTaube.textProperty().bindBidirectional(cashierViewModel.getTaubenId());
        tfFlug.textProperty().bindBidirectional(cashierViewModel.getFlugId());
        taTaubenflug.textProperty().bindBidirectional(cashierViewModel.getTaubenflug());
        tfEndzeit.textProperty().bindBidirectional(cashierViewModel.getEndzeit());

        clearbtntaube.setOnAction(event -> {

            cashierViewModel.clearBtnClicked();
        });

        clearbtnflug.setOnAction(event -> {
            cashierViewModel.clearBtnClicked2();
        });

        btntaubenfluege.setOnAction(event -> {
            cashierViewModel.resultTaubenFlugBtnClicked();
        });

        clearbtnendzeit.setOnAction(event -> {
            cashierViewModel.clearBtnClickedEndzeit();
        });

    }

}
