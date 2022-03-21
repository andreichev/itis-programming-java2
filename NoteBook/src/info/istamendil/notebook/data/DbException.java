package info.istamendil.notebook.data;

/**
 * General DB exception.
 *
 * @author Alexander Ferenets (Istamendil) <ist.kazan@gmail.com>
 * <p>
 * Code for studying purposes. Programming course. Kazan Federal University, ITIS.
 * http://study.istamendil.info/
 */
public class DbException extends Exception {
    public DbException() {
    }

    public DbException(String msg) {
        super(msg);
    }
}
