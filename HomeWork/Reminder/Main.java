package HomeWork.Reminder;

import HomeWork.Reminder.exceptions.NotePersistenceException;
import HomeWork.Reminder.model.Note;
import HomeWork.Reminder.repostory.NoteRepository;
import HomeWork.Reminder.repostory.impl.NoteRepositorySerializableImpl;

import java.io.File;
import java.time.Instant;

public class Main {
    // Добавлять заметки на определенное время
    // Отмечать заметки как выполнено
    // Удалять заметки
    // Получать список всех заметок на день
    // Получать список всех выполненных заметок на день
    public static void main(String[] args) {
        try {
            NoteRepository repository = new NoteRepositorySerializableImpl("database" + File.separator + "notes_database");
            repository.save(new Note("Test1", Instant.now(), false));
            System.out.println(repository.getUndoneByDate(Instant.now()).size());
        } catch (NotePersistenceException e) {
            System.out.println(e.getMessage());
        }
    }
}
