package dictionary;

import javafx.fxml.FXMLLoader;
import javafx.scene.*;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;

public class Application extends javafx.application.Application {
  public void start(Stage primaryStage) {
    try {
      openMainView(primaryStage);
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  private void openMainView(Stage primaryStage) throws IOException {
    URL mainViewUrl = getClass().getClassLoader().getResource("fxml/main.fxml");
    if (mainViewUrl == null) return;
    Parent root = FXMLLoader.load(mainViewUrl);
    Scene scene = new Scene(root);
    primaryStage.setScene(scene);
    primaryStage.setTitle("Dictionary");
    primaryStage.show();
    primaryStage.setMinWidth(800);
    primaryStage.setMinHeight(600);
  }
}
