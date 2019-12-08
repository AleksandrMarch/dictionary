package dictionary;

import dictionary.ui.FXMLLoader;
import javafx.scene.*;
import javafx.stage.Stage;

public class Application extends javafx.application.Application {
  public void start(Stage primaryStage) {
    openMainView(primaryStage);
    Object obj;
  }

  private void openMainView(Stage primaryStage) {
    Parent parent = FXMLLoader.loadParent(FXMLLoader.MAIN_FXML);
    if (parent == null) return;
    Scene scene = new Scene(parent);
    primaryStage.setScene(scene);
    primaryStage.setTitle("Dictionary");
    primaryStage.show();
    primaryStage.setMinWidth(800);
    primaryStage.setMinHeight(600);
  }
}
