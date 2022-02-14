package ru.kfu.itis.example2;

import ru.kfu.itis.example1.base.MyList;
import ru.kfu.itis.example1.impl.MyListOptimized;

import java.util.Scanner;

public class Example4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        MyList<String> list = new MyListOptimized<>();

        while(true) {
            String line = scanner.nextLine();
            if(line.equals("0")) {
                break;
            }
            list.add(line);
        }

        for(int i = 0; i < list.size(); i++) {
            System.out.println("Element: " + i + ", Value: " + list.get(i));
        }
    }
}
