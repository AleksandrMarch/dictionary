package dictionary.data;

import dictionary.data.exceptions.DataFileNotFound;

import java.io.*;
import java.net.URISyntaxException;
import java.nio.file.*;
import java.util.*;

abstract class AbstractTextFileDataSource {
  static final String FOLDERS_FILE_NAME = "folders.data";
  static final String RECORDS_FILE_NAME = "records.data";

  private static final String DATA_FOLDER_NAME = "data";

  private static final Map<Integer, String> FOLDER_STRUCT = new HashMap<Integer, String>(){{
    put(0, "name");
  }};

  AbstractTextFileDataSource() {
    initialize();
  }

  void addLineToFile(String fileName, String data) {
    try {
      BufferedWriter writer = new BufferedWriter(new FileWriter(getFilePath(fileName), true));
      writer.write(data);
      writer.newLine();
      writer.close();
      System.out.println(data);
    } catch (IOException | URISyntaxException e) {
      e.printStackTrace();
    }
  }

  String getStringData(String ... data) {
    return String.join(";", data);
  }

  BufferedReader getFileReader(String fileName) throws DataFileNotFound {
    try {
      return new BufferedReader(new FileReader(getFilePath(fileName)));
    } catch (FileNotFoundException | URISyntaxException e) {
      throw new DataFileNotFound();
    }
  }

  private void initialize() {
    try {
      createDataDirectory();
      if (new File(getFilePath(FOLDERS_FILE_NAME)).createNewFile()) System.out.println(FOLDERS_FILE_NAME);
      if (new File(getFilePath(RECORDS_FILE_NAME)).createNewFile()) System.out.println(RECORDS_FILE_NAME);
    } catch (URISyntaxException | IOException e) {
      e.printStackTrace();
    }
  }

  private String getFilePath(String fileName) throws URISyntaxException {
    return getDataFolderPath().toString() + "/" + fileName;
  }

  private void createDataDirectory() {
    try {
      Files.createDirectory(Paths.get(getDataFolderPath().toString()));
    } catch (IOException e) {
      System.out.println("FolderDAO exists");
    } catch (URISyntaxException e) {
      e.printStackTrace();
    }
  }

  private Path getDataFolderPath() throws URISyntaxException {
    String path = getClass().getProtectionDomain().getCodeSource().getLocation().toURI().getPath();
    return Paths.get(String.format("%s../%s", path, DATA_FOLDER_NAME));
  }
}
