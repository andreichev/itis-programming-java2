package HomeWork.notebook.utils;


/**
 *
 * @author Alexander Ferenets (Istamendil) <ist.kazan@gmail.com>
 * 
 * Code for studying purposes. Programming course. Kazan Federal University, ITIS.
 * http://study.istamendil.info/
 */
public interface UserInteractor {
  public String readCommand() throws UserInteractorReadException;
  public void print(String output) throws UserInteractorWriteException;
}
