package ru.itis.prisoners_dilemma.reflect;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class ClassesScanner {
    public static List<Class<?>> getClasses(String packageName) {
        String packagePath = packageName.replace('.', '/');
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        File packageDirectory = new File(classLoader.getResource(packagePath).getFile());
        List<Class<?>> classesInPackage = new ArrayList<>();
        File[] files = packageDirectory.listFiles();
        for (File file : files) {
            if (file.isFile() && file.getName().endsWith(".class")) {
                String className = packageName + "." + file.getName().substring(0, file.getName().lastIndexOf('.'));
                try {
                    Class<?> clazz = Class.forName(className);
                    classesInPackage.add(clazz);
                } catch (ClassNotFoundException e) {
                    System.err.println(e.getMessage());
                }
            }
        }
        return classesInPackage;
    }
}
