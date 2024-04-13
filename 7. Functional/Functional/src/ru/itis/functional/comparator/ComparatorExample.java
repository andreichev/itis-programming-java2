package ru.itis.functional.comparator;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class ComparatorExample {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("XX");
        list.add("X");
        list.add("XXXXX");
        list.add("XXX");
        list.add("X");

//        Comparator<String> lineLengthComparator = new Comparator<String>() {
//            @Override
//            public int compare(String l, String r) {
//                if(l.length() == r.length()) {
//                    return 0;
//                } else if(l.length() > r.length()) {
//                    return 1;
//                } else {
//                    return -1;
//                }
//            }
//        };
//        list.sort(lineLengthComparator);

//         list.sort((l, r) -> {
//             if(l.length() == r.length()) {
//                 return 0;
//             } else if(l.length() > r.length()) {
//                 return 1;
//             } else {
//                 return -1;
//             }
//         });

        for(String line: list) {
            System.out.println(line);
        }
    }
}
