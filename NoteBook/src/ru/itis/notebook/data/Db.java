package ru.itis.notebook.data;

public interface Db {
    void save(String str) throws DbException;

    String[] findAll() throws DbException;

    void removeAll() throws DbException;
}
