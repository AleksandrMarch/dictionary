package dictionary.ui;

import javafx.scene.*;
import javafx.stage.*;

public class ModalWindow {
  public static void open(Parent root, String title) {
    Stage stage = new Stage();
    Scene scene = new Scene(root);
    stage.setScene(scene);
    stage.setResizable(false);
    stage.setTitle(title);
    stage.initModality(Modality.APPLICATION_MODAL);
    stage.show();
  }
}
