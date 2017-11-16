import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class FrontEnd extends Application {
	private Desktop desktop = Desktop.getDesktop();

	@Override
	public void start(Stage primaryStage) throws Exception {
		FileChooser fileChooser = new FileChooser();
		fileChooser.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("Comma Separated Values (.csv)", "*.csv*"));
		Button importBtn = new Button();

		importBtn.setText("Import CSV File");

		importBtn.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				File file = fileChooser.showOpenDialog(primaryStage);
				if (file != null) {
					new Proofer(file);
				}
			}
		});
		StackPane root = new StackPane();
		root.getChildren().add(importBtn);

		Scene scene = new Scene(root, 300, 250);
		primaryStage.setTitle("Peregrine (1.0)");
		primaryStage.setScene(scene);
		primaryStage.show();

	}

	public static void main(String[] args) {
		launch(args);
	}
}
