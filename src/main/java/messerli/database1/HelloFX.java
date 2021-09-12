package messerli.database1;

import java.time.LocalDateTime;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import messerli.database1.cashier.CashierView;
import messerli.database1.cashier.CashierViewModel;
import messerli.database1.cashier.DataModel;
import messerli.database1.data.DataClass;
import messerli.database1.model.Flug;
import messerli.database1.model.Taube;

public class HelloFX extends Application {

	@Override
	public void start(Stage stage) throws Exception {
		var javaVersion = SystemInfo.javaVersion();
		var javafxVersion = SystemInfo.javafxVersion();

		var label = new Label("Hello, JavaFX " + javafxVersion + ", running on Java " + javaVersion + ".");
		// var scene = new Scene(new StackPane(label), 640, 480);
		VBox vbox = new VBox();
		HBox hbox = new HBox();

		Taube taube = new Taube("CH", "20", "3534");
		Flug flug = new Flug("Messkirch", LocalDateTime.now());

		DataModel datamodel = new DataClass(taube, flug);

		CashierView cashierView = new CashierView(new CashierViewModel(datamodel));
		hbox.getChildren().add(cashierView);
		vbox.getChildren().add(hbox);
		Scene scene = new Scene(vbox, 1200, 900);

		stage.setScene(scene);
		stage.show();
	}

	public static void main2(String[] args) {
		Application.launch(HelloFX.class, args);
	}
}
