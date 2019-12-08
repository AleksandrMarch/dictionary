package dictionary.data;

import dictionary.data.DAO.*;

import java.util.List;

public interface DataSource {
  public void saveRecord(RecordDAO record);

  public void deleteRecordByEnglishWord(String englishWord);

  public List<RecordDAO> getAllRecords();

  public RecordDAO findRecordByEnglishWord();

  public List<FolderDAO> getAllFolders();

  public void deleteFolderByName(String folderName);

  public void saveFolder(FolderDAO folder);
}
