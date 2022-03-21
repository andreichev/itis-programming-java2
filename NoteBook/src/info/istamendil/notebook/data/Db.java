package info.istamendil.notebook.data;

/**
 * @author Alexander Ferenets (Istamendil) <ist.kazan@gmail.com>
 * <p>
 * Code for studying purposes. Programming course. Kazan Federal University, ITIS.
 * http://study.istamendil.info
 */
public interface Db {
    void save(Object obj) throws DbException;

    Object[] findAll() throws DbException;

    void removeAll() throws DbException;
}
