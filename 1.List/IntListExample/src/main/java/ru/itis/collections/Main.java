package ru.itis.collections;

import ru.itis.collections.list.ArrayListInt;
import ru.itis.collections.list.IntList;
import ru.itis.collections.list.LinkedListInt;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // IntList list = new LinkedListInt();
        IntList list = new ArrayListInt();
        while (true) {
            int x = scanner.nextInt();
            if(x == 0) { break; }
            list.add(x);
        }
        for(int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
    }
}
