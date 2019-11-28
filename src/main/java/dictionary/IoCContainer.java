package dictionary;

import dictionary.data.*;

public class IoCContainer {
  private static IoCContainer container = new IoCContainer();
  private DataSource dataSource;

  private IoCContainer() {
    initialize();
  }

  private void initialize() {
    dataSource = new TextFileDataSource();
  }

  public static DataSource getDataSource() {
    return container.dataSource;
  }
}
