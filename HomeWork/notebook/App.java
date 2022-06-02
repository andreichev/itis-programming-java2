package HomeWork.notebook;

import HomeWork.notebook.data.Db;
import HomeWork.notebook.data.DbException;
import HomeWork.notebook.data.FileDb;
import HomeWork.notebook.utils.PunchedCardUserInteractor;
import HomeWork.notebook.utils.UserInteractor;
import HomeWork.notebook.utils.UserInteractorReadException;
import HomeWork.notebook.utils.UserInteractorWriteException;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.Arrays;

/**
 *
 * Note Book. UserInteractor and DB modules.
 * @author Alexander Ferenets (Istamendil) <ist.kazan@gmail.com>
 * 
 * Code for studying purposes. Programming course. Kazan Federal University, ITIS.
 * http://study.istamendil.info/
 */
public class App extends Application {
  
  private static final String DB = "./tmp/db.txt";
  private static final String PUNCH_CARD = "./tmp/card.txt";
  
  protected UserInteractor terminal;
  protected Db db;

  /**
   * @param args the command line arguments
   */
  public App(String[] args) throws IOException {
    super(args);
  }

  public static void main(String[] args) throws Exception{
    App app = new App(args);
  }

  @Override
  public void init() throws IOException {
    this.terminal = new PunchedCardUserInteractor(Paths.get(App.PUNCH_CARD));
    this.db = new FileDb(App.DB);
  }

  @Override
  public void start() {
    try {
      String command;
      while((command = this.terminal.readCommand()) != null){
        switch(command){
          case "readAll":
            this.terminal.print(Arrays.toString(this.db.findAll()));
            break;
          case "save":
            if((command = this.terminal.readCommand()) != null){
              this.db.save(command);
            }
            break;
          case "remove":
              this.db.remove(this.terminal.readCommand());
            break;
          default:
            this.terminal.print("Unkown command");
        }
//        this.terminal.print(command);
      }
    } catch (UserInteractorReadException ex) {
      System.out.println("Can't read user input due error:");
      System.err.println(ex.getMessage());
      System.exit(1);
    } catch (UserInteractorWriteException ex) {
      System.out.println("Can't print data to user due error:");
      System.err.println(ex.getMessage());
      System.exit(1);
    } catch (DbException ex) {
      System.err.println(ex.getMessage());
      System.exit(1);
    }
  }
  
}
