package ru.geekbrains.j1.lesson6;

import java.io.FileInputStream;
import java.io.IOException;

public class StrSearch {

    public static void main(String[] args) {

        FileInputStream myFile;
        StringBuilder str_file = new StringBuilder();
        String myFile_path = "D:/GeekBrains/Lessons_Java1/src/ru/geekbrains/j1/lesson6/test_search.txt";
        String s2 = "System";

        try {
            myFile = new FileInputStream(myFile_path);

            int myFile_char;
            int myCount = 0;
            while ((myFile_char = myFile.read()) != -1 ) {
                str_file.append((char)myFile_char);
            }
            myFile.close();

            String s1 = str_file.toString();
            for (int j = 0; j < (s1.length() - s2.length()); j++) {
                boolean result = s1.regionMatches(j, s2, 0, s2.length() );
                if( result ) {
                    myCount++;
                    System.out.println("Найдено " + myCount + " совпадение(ий).");
                }
            }
            if (myCount == 0) {
                System.out.println("Совпадений не найдено");
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
