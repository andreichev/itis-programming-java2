package info.istamendil.notebook.utils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

/**
 * Implementation of UserInteractor with reading command from file ("punched card").
 *
 * @author Alexander Ferenets (Istamendil) <ist.kazan@gmail.com>
 * <p>
 * Code for studying purposes. Programming course. Kazan Federal
 * University, ITIS. http://study.istamendil.info/
 */
public class PunchedCardUserInteract implements UserInteract {

    protected final String[] lines;
    protected int currentLine = 0;

    public PunchedCardUserInteract(Path path) throws UserInteractException {
        try {
            List<String> lines = Files.readAllLines(path);
            this.lines = lines.toArray(new String[lines.size()]);
            this.currentLine = 0;
        } catch (IOException ex) {
            throw new UserInteractException("Can't load punched card.");
        }
    }

    @Override
    public String readCommand() throws UserInteractReadException {
        if (currentLine >= lines.length) {
            return null;
        }
        String command = lines[currentLine];
        currentLine++;
        System.out.println("<< " + command);
        return command;
    }

    @Override
    public void print(String output) throws UserInteractWriteException {
        System.out.println(">> " + output);
    }

}
