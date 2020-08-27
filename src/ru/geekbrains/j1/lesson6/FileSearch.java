package ru.geekbrains.j1.lesson6;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class FileSearch {

    private static int searchString(File nameFile, String textSearch) {

        FileInputStream myFile;
        StringBuilder str_file = new StringBuilder();
        int myCount = 0;

        try {
            myFile = new FileInputStream(nameFile);
            int myFile_char;

            while ((myFile_char = myFile.read()) != -1 ) {
                str_file.append((char)myFile_char);
            }
            myFile.close();

            String s1 = str_file.toString();
            for (int j = 0; j < (s1.length() - textSearch.length()); j++) {
                boolean result = s1.regionMatches(j, textSearch, 0, textSearch.length() );
                if( result ) {
                    myCount++;
                }
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return myCount;
    }

    public static void main(String[] args) {

        String myFile_path = "D:/GeekBrains/Lessons_Java1/src/ru/geekbrains/j1/lesson6";
        String str_search = "System";

        File myFileFolder = new File(myFile_path);
        File[] filesList = myFileFolder.listFiles();

        if(filesList != null) {
            for (File file : filesList) {
                System.out.println(file);
                System.out.println("Найдено " + searchString(file, str_search) + " совпадение(ий).");
            }
        }
    }
}
