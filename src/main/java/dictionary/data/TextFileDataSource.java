package dictionary.data;

import dictionary.data.DAO.*;
import dictionary.data.exceptions.DataFileNotFound;

import java.io.*;
import java.util.*;

public class TextFileDataSource extends AbstractTextFileDataSource implements DataSource {
  public TextFileDataSource() {
    super();
  }

  @Override
  public void saveRecord(RecordDAO record) {
    addLineToFile(
        AbstractTextFileDataSource.RECORDS_FILE_NAME,
        getStringData(
            record.getEnglishWord(),
            record.getRussianWord()
        )
    );
  }

  @Override
  public void deleteRecordByEnglishWord(String englishWord) {

  }

  @Override
  public List<RecordDAO> getAllRecords() {
    return null;
  }

  @Override
  public RecordDAO findRecordByEnglishWord() {
    return null;
  }

  @Override
  public List<FolderDAO> getAllFolders() {
    List<FolderDAO> folderList = new ArrayList<>();
    try {
      BufferedReader reader = getFileReader(AbstractTextFileDataSource.FOLDERS_FILE_NAME);
      String line;
      while ((line = reader.readLine()) != null) {
        folderList.add(new FolderDAO(line));
      }
    } catch (DataFileNotFound | IOException e) {
      e.printStackTrace();
    }
    return folderList;
  }

  @Override
  public void deleteFolderByName(String folderName) {

  }

  @Override
  public void saveFolder(FolderDAO folder) {
    addLineToFile(
        AbstractTextFileDataSource.FOLDERS_FILE_NAME,
        getStringData(folder.getFolderName())
    );
  }
}
