package dictionary.ui;

import javafx.scene.Parent;

import java.io.IOException;
import java.net.URL;

public class FXMLLoader {
  public static final String MAIN_FXML = "fxml/main.fxml";
  public static final String NEW_FOLDER_FXML = "fxml/newFolder.fxml";

  public static Parent loadParent(String path) {
    URL url = FXMLLoader.class.getClassLoader().getResource(path);
    if (url == null) return null;
    try {
      return javafx.fxml.FXMLLoader.load(url);
    } catch (IOException e) {
      e.printStackTrace();
      return null;
    }
  }
}
