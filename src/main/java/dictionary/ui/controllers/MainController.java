package dictionary.ui.controllers;

import dictionary.IoCContainer;
import dictionary.ui.*;
import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.layout.*;

public class MainController {
  @FXML
  private Pane searchPane;

  @FXML
  private ComboBox<String> searchComboBox;

  @FXML
  private Button newWordButton;

  @FXML
  private Button newFolderButton;

  @FXML
  private VBox folderListVBox;

  private static final int PADDING = 20;

  @FXML
  public void initialize() {
    setWidthListeners();
    updateFolderList();
    initButtons();
    IoCContainer.getDataSource();
  }

  private void setWidthListeners() {
    searchPane.widthProperty().addListener(
        (obs, oldVal, newVal) -> searchComboBox.setPrefWidth(newVal.intValue() - PADDING * 2)
    );
  }

  private void updateFolderList() {
    folderListVBox.getChildren().clear();
    IoCContainer.getDataSource().getAllFolders().forEach(folder -> {
      Button folderButton = new Button(folder.getFolderName());
      folderButton.getStyleClass().add("folderButton");
      folderButton.setPrefWidth(193);
      folderButton.setPrefHeight(40);
      folderButton.setAlignment(Pos.BASELINE_LEFT);
      folderListVBox.getChildren().add(folderButton);
    });
  }

  private void initButtons() {
    newFolderButton.setOnAction((event) -> openNewFolderModal());
  }

  private void openNewFolderModal() {
    ModalWindow.open(FXMLLoader.loadParent(FXMLLoader.NEW_FOLDER_FXML), "New folder");
  }
}
