package HomeWork.Reminder.repostory.impl;

import HomeWork.Reminder.exceptions.NotePersistenceException;
import HomeWork.Reminder.model.Note;
import HomeWork.Reminder.repostory.NoteRepository;
import HomeWork.Reminder.utils.Utils;

import java.io.*;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class NoteRepositorySerializableImpl implements NoteRepository {
    private final String filePath;
    private int incrementValue = 0;
    private List<Note> notes = new ArrayList<>();

    public NoteRepositorySerializableImpl(String filePath) {
        this.filePath = filePath;
        if(new File(filePath).length() == 0) {
            saveNotes();
        } else {
            readNotes();
        }
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
            ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(filePath));
            notes = (List<Note>) objectInputStream.readObject();
            if(notes.size() > 0) {
                incrementValue = notes.get(notes.size() - 1).getId();
            }
        } catch (IOException | ClassNotFoundException e) {
            throw new NotePersistenceException(e.getMessage());
        }
    }

    private void saveNotes() {
        try {
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(filePath));
            objectOutputStream.writeObject(notes);
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
