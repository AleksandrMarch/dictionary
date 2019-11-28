package dictionary.data;

import java.util.List;

public interface DataSource {
  public void saveRecord(Record record);

  public void deleteRecordByEnglishWord(String englishWord);

  public List<Record> getAllRecords();

  public Record findRecordByEnglishWord();

  public List<Folder> getAllFolders();

  public void deleteFolderByName(String folderName);

  public void saveFolder(Folder folder);
}
