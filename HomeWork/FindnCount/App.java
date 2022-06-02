package HomeWork.FindnCount;

import HomeWork.FindnCount.utils.UserInteractorInputExeption;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class App extends Application{
    private static final String STANDARD_PATH = "src";

    protected File file;

    public App(String[] args) throws IOException, UserInteractorInputExeption {
        super(args);
    }

    public static void main(String[] args) throws IOException, UserInteractorInputExeption {
        App app = new App(args);
    }

    @Override
    public void init() throws UserInteractorInputExeption, IOException {
        if (args.length == 0)
            file = new File(STANDARD_PATH);
        if (args.length > 1)
            throw new UserInteractorInputExeption("Invalid number of arguments!");
        file = new File(args[0]);
        if (!file.isDirectory() && !file.getName().endsWith(".java"))
            throw new UserInteractorInputExeption("Wrong file type. Folder or Java file required!");
    }

    private static int getLineNumber(File file) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(file));
        int lines = 0;

        while (reader.readLine() != null)
            lines++;
        reader.close();
        return (lines);
    }

    private static int searchFile(File rootFile, List<File> fileList) throws IOException {
        File[] directoryFiles = rootFile.listFiles();
        int lineCounter = 0;
        if (directoryFiles != null) {
             for (File file : directoryFiles) {
                 if (file.isDirectory())
                     lineCounter += searchFile(file, fileList);
                 else if (file.getName().endsWith(".java")) {
                     lineCounter += getLineNumber(file);
                     fileList.add(file);
                 }
             }
        }
        return (lineCounter);
    }

    @Override
    public void start() throws IOException {
        int lines;
        ArrayList<File> fileList = new ArrayList<>();

        lines = searchFile(file, fileList);
        if (!file.getName().endsWith(".java")) {
            for (int i = 0; i < fileList.size(); i++) {
                System.out.println((i + 1) + ") " + fileList.get(i).getName());
            }
            System.out.println("Total number of files: " + fileList.size());
        }
        System.out.println("Total number of lines: " + lines);
    }
}
