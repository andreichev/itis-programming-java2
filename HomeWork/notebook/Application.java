package HomeWork.notebook;

import java.io.IOException;

/**
 *
 * Application base.
 * @author Alexander Ferenets (Istamendil) <ist.kazan@gmail.com>
 * 
 * Code for studying purposes. Programming course. Kazan Federal University, ITIS.
 * http://study.istamendil.info/
 */
public abstract class Application {
  protected String[] args;
  
  public Application(String[] args) throws IOException {
    this.args = args;
    this.init();
    this.start();
  }
  
  public abstract void init() throws IOException;
  public abstract void start();
}