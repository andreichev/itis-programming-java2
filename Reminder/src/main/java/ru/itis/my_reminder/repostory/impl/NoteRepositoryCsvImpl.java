package ru.itis.my_reminder.repostory.impl;

import ru.itis.my_reminder.exceptions.NotePersistenceException;
import ru.itis.my_reminder.model.Note;
import ru.itis.my_reminder.repostory.NoteRepository;
import ru.itis.my_reminder.utils.Utils;

import java.io.*;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class NoteRepositoryCsvImpl implements NoteRepository {
    private int incrementValue = 0;
    // Разделитель csv файла
    private static final String DELIMITER = ",";
    private final String filePath;
    private final List<Note> notes = new ArrayList<>();

    public NoteRepositoryCsvImpl(String filePath) {
        this.filePath = filePath;
        readNotes();
    }

    @Override
    public void save(Note note) {
        if(note.getId() == null) {
            note.setId(++incrementValue);
            notes.add(note);
        } else {
            notes.set(getIndexById(note.getId()), note);
        }
        saveNotes();
    }

    @Override
    public List<Note> getAll() {
        return notes;
    }

    @Override
    public Note getById(int id) {
        return notes.get(getIndexById(id));
    }

    @Override
    public List<Note> getByDate(Instant date) {
        return notes.stream()
                .filter(item -> Utils.isSameDay(date, item.getDateTime()))
                .collect(Collectors.toList());
    }

    @Override
    public List<Note> getUndoneByDate(Instant date) {
        return notes.stream()
                .filter(item -> Utils.isSameDay(date, item.getDateTime()) && item.isDone() == false)
                .collect(Collectors.toList());
    }

    @Override
    public void delete(int id) {
        notes.remove(getIndexById(id));
        saveNotes();
    }

    @Override
    public void deleteAll() {
        notes.clear();
        saveNotes();
    }

    private void readNotes() {
        notes.clear();
        try {
            FileReader fileReader = new FileReader(filePath);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line;
            boolean isHeader = true;
            while ((line = bufferedReader.readLine()) != null) {
                if(isHeader) {
                    isHeader = false;
                    continue;
                }
                line = line.replaceAll("\\s+", "");
                String[] tokens = line.split("[" + DELIMITER + "]");
                Note note = new Note(
                        tokens[1],
                        Instant.ofEpochSecond(Long.parseLong(tokens[2])),
                        Boolean.parseBoolean(tokens[3])
                );
                note.setId(Integer.parseInt(tokens[0]));
                incrementValue = note.getId();
                notes.add(note);
            }
        } catch (IOException e) {
            throw new NotePersistenceException(e.getMessage());
        }
    }

    private void saveNotes() {
        FileWriter csvWriter = null;
        try {
            csvWriter = new FileWriter(filePath);
            csvWriter.append("ID");
            csvWriter.append(DELIMITER);
            csvWriter.append("TEXT");
            csvWriter.append(DELIMITER);
            csvWriter.append("DATE_TIME");
            csvWriter.append(DELIMITER);
            csvWriter.append("IS_DONE");
            csvWriter.append("\n");
            for (Note item : notes) {
                csvWriter.append(String.valueOf(item.getId()));
                csvWriter.append(DELIMITER);
                csvWriter.append(item.getText());
                csvWriter.append(DELIMITER);
                csvWriter.append(String.valueOf(item.getDateTime().getEpochSecond()));
                csvWriter.append(DELIMITER);
                csvWriter.append(String.valueOf(item.isDone()));
                csvWriter.append("\n");
            }
            csvWriter.flush();
            csvWriter.close();
        } catch (IOException e) {
            throw new NotePersistenceException(e.getMessage());
        }
    }

    private int getIndexById(int id) {
        for(int i = 0; i < notes.size(); i++) {
            if (id == notes.get(i).getId()) {
                return i;
            }
        }
        throw new NotePersistenceException(
               String.format("Note with id %d not found", id)
        );
    }
}
