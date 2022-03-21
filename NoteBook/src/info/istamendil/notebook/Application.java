package info.istamendil.notebook;

/**
 * Application base.
 *
 * @author Alexander Ferenets (Istamendil) <ist.kazan@gmail.com>
 * <p>
 * Code for studying purposes. Programming course. Kazan Federal University, ITIS.
 * http://study.istamendil.info/
 */
public abstract class Application {
    protected String[] args;

    public Application(String[] args) {
        this.args = args;
        this.init();
        this.start();
    }

    public abstract void init();

    public abstract void start();
}