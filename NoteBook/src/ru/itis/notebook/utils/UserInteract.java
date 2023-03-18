package ru.itis.notebook.utils;

/**
 * @author Alexander Ferenets (Istamendil) <ist.kazan@gmail.com>
 * <p>
 * Code for studying purposes. Programming course. Kazan Federal University, ITIS.
 * http://study.istamendil.info/
 */
public interface UserInteract {
    String readCommand() throws UserInteractReadException;

    void print(String output) throws UserInteractWriteException;
}
