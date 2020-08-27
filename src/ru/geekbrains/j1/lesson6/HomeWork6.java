package ru.geekbrains.j1.lesson6;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class HomeWork6 {

    public static void main(String[] args) {

        FileInputStream myFile_first;
        FileInputStream myFile_second;
        FileOutputStream myFile_result;
        String myFile_first_path = "D:/GeekBrains/Lessons_Java1/src/ru/geekbrains/j1/lesson6/test1.txt";
        String myFile_second_path = "D:/GeekBrains/Lessons_Java1/src/ru/geekbrains/j1/lesson6/test2.txt";
        String myFile_result_path = "D:/GeekBrains/Lessons_Java1/src/ru/geekbrains/j1/lesson6/test_result.txt";

        try {
            myFile_first = new FileInputStream(myFile_first_path);
            myFile_second = new FileInputStream(myFile_second_path);
            myFile_result = new FileOutputStream(myFile_result_path);

            int myFile_char;
            int myCount = 0;
            while ((myFile_char = myFile_first.read()) != -1 ) {
                myFile_result.write(myFile_char);
                myCount++;
            }
            myFile_first.close();
            System.out.println("Copy " + myCount + " symbol");
            myFile_char = 0x0A;
            myFile_result.write(myFile_char);
            myCount = 0;
            while ((myFile_char = myFile_second.read()) != -1 ) {
                myFile_result.write(myFile_char);
                myCount++;
            }
            myFile_second.close();
            System.out.println("Copy " + myCount + " symbol");
            myFile_result.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
