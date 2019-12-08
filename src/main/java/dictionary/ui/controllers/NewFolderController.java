package dictionary.ui.controllers;

import dictionary.IoCContainer;
import dictionary.data.DAO.FolderDAO;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.stage.Stage;

public class NewFolderController {
  @FXML
  private Button saveButton;

  @FXML
  private Button cancelButton;

  @FXML
  private TextField folderNameTextField;

  @FXML
  public void initialize() {
    saveButton.setOnAction((event -> {
      saveFolder();
      closeModalWindow();
    }));

    cancelButton.setOnAction((event -> closeModalWindow()));
  }

  private void saveFolder() {
    IoCContainer.getDataSource().saveFolder(new FolderDAO(folderNameTextField.getText()));
  }

  private void closeModalWindow() {
    ((Stage) cancelButton.getScene().getWindow()).close();
  }
}
