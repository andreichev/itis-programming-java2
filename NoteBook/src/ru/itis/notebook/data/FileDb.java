package ru.itis.notebook.data;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class FileDb implements Db {

    protected final String path;

    public FileDb(String path) {
        this.path = path;
    }

    @Override
    public void save(String obj) throws DbException {
        try {
            List<String> data = readData();
            data.add(obj);
            saveData(data);
        } catch (IOException ex) {
            throw new DbException("DB error: " + ex.getMessage());
        }
    }

    @Override
    public String[] findAll() throws DbException {
        try {
            List<String> data = readData();
            String[] result = new String[data.size()];
            return data.toArray(result);
        } catch (IOException e) {
            throw new DbException("DB error: " + e.getMessage());
        }
    }

    @Override
    public void removeAll() throws DbException {
        try {
            saveData(new ArrayList<>());
        } catch (IOException ex) {
            throw new DbException("DB error: " + ex.getMessage());
        }
    }

    private List<String> readData() throws IOException {
        return Files.readAllLines(Path.of(path));
    }

    private void saveData(List<String> data) throws FileNotFoundException {
        FileOutputStream stream = new FileOutputStream(this.path);
        PrintWriter writer = new PrintWriter(stream);
        for(String line: data) {
            writer.println(line);
        }
        writer.close();
    }
}
