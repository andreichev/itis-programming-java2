package HomeWork.Reminder;

import HomeWork.Reminder.model.Note;
import HomeWork.Reminder.repostory.NoteRepository;
import HomeWork.Reminder.repostory.impl.NoteRepositoryCsvImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.time.Instant;

public class NoteRepositoryCsvImplTest {
    private final NoteRepository repository = new NoteRepositoryCsvImpl("database" + File.separator +"notes_test.csv");

    @Test
    void checkSave() {
        repository.save(new Note("Test1", Instant.ofEpochSecond(1648190891), false));
        repository.save(new Note("Test2", Instant.ofEpochSecond(1648190891), false));

        Assertions.assertEquals(2, repository.getAll().size());
        repository.deleteAll();
    }

    // TODO: Написать тест на получение по id
    // TODO: Написать тест на получение невыполненных
    // TODO: Написать тест на удаление по id
}
