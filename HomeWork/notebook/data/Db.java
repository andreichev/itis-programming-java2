package HomeWork.notebook.data;

/**
 *
 * @author Alexander Ferenets (Istamendil) <ist.kazan@gmail.com>
 * 
 * Code for studying purposes. Programming course. Kazan Federal University, ITIS.
 * http://study.istamendil.info
 */
public interface Db {
  public void save(Object obj) throws DbException;
  public Object[] findAll() throws DbException;
  public void remove(Object obj) throws DbException;
}
