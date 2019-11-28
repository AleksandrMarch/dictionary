package dictionary.data;

import java.util.*;

public class TextFileDataSource implements DataSource {
  private static final String DATA_FOLDER_NAME = "data";
  private static final String FOLDERS_FILE_NAME = "folders";
  private static final String RECORDS_FILE_NAME = "records";

  public TextFileDataSource() {
    initialize();
  }

  @Override
  public void saveRecord(Record record) {

  }

  @Override
  public void deleteRecordByEnglishWord(String englishWord) {

  }

  @Override
  public List<Record> getAllRecords() {
    return null;
  }

  @Override
  public Record findRecordByEnglishWord() {
    return null;
  }

  @Override
  public List<Folder> getAllFolders() {
    List<Folder> folderList = new ArrayList<>();
    folderList.add(new Folder("All"));
    folderList.add(new Folder("Home"));
    folderList.add(new Folder("Street"));
    folderList.add(new Folder("Work"));
    return folderList;
  }

  @Override
  public void deleteFolderByName(String folderName) {

  }

  @Override
  public void saveFolder(Folder folder) {

  }

  private void initialize() {

  }
}
