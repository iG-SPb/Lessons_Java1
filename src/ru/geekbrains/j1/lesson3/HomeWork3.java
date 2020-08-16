package ru.geekbrains.j1.lesson3;

import java.util.Random;
import java.util.Scanner;

public class HomeWork3 {

    private static final char DOT_EMPTY = ' ';
    private static final char DOT_HUMAN = 'X';
    private static final char DOT_AI = 'O';
    private static final String colGreen = "\u001B[32m";
    private static final String colRed = "\u001B[31m";
    private static final String colNo = "\u001B[0m";
    private static int humanX = -1;
    private static int humanY = -1;
    private static int aiX = -1;
    private static int aiY = -1;
    private static char[][] field;
    private static final int fieldSizeX = 3;
    private static final int fieldSizeY = 3;
    private static int fieldSum = 0;
    private static final int winCount = 3; // кличество одинаковых ячеек для победы
    private static final Scanner SCANNER = new Scanner(System.in);
    private static final Random RANDOM = new Random();

    // init field
    private static void initField() {
        field = new char[fieldSizeY][fieldSizeX];
        for (int y = 0; y < fieldSizeY; y++) {
            for (int x = 0; x < fieldSizeX; x++) {
                field[y][x] = DOT_EMPTY;
            }
        }
    }

    // print field
    private static void printField () {
        System.out.print(" ");
        for (int i = 0; i < fieldSizeX * 2 + 1; i++)
            System.out.print((i % 2 == 0) ? "-" : i / 2 + 1);
        System.out.println();

        for (int i = 0; i < fieldSizeY; i++) {
            System.out.print(i + 1 + "|");
            for (int j = 0; j < fieldSizeX; j++) {
                if (humanX == i && humanY == j) {
                    System.out.print(colGreen);
                }
                if (aiX == i && aiY == j) {
                    System.out.print(colRed);
                }
                System.out.print(field[i][j] + colNo +"|");
            }
            System.out.println();
        }
        //System.out.println("hX-"+humanX+"; hY-"+humanY+"; aX-"+aiX+"; aY-"+aiY+";");
    }

    // human turn
    private static void humanTurn() {
        do {
            System.out.print("Введите координаты хода X (строка) и Y (столбец) (от 1 до 3) через пробел >>> ");
            humanX = SCANNER.nextInt() - 1;
            humanY = SCANNER.nextInt() - 1;
        } while (!isValidCell(humanX, humanY) || !isCellEmpty(humanX, humanY));
        field[humanX][humanY] = DOT_HUMAN;
    }

    // check valid cell
    private static boolean isValidCell(int x, int y) {
        return x >= 0 && x < fieldSizeX && y >= 0 && y < fieldSizeY;
    }

    // check empty cell
    private static boolean isCellEmpty(int x, int y) {
        return field[x][y] == DOT_EMPTY;
    }

    // ai turn
    private static void aiTurn() {
        switch (fieldSum) {
            case 0:
                if (field[1][1] == DOT_HUMAN) {
                    int i = RANDOM.nextInt(4);
                    switch (i) {
                        case 0:
                            aiX = 0;
                            aiY = 0;
                            break;
                        case 1:
                            aiX = 0;
                            aiY = 2;
                            break;
                        case 2:
                            aiX = 2;
                            aiY = 0;
                            break;
                        case 3:
                            aiX = 2;
                            aiY = 2;
                            break;
                    }
                    field[aiX][aiY] = DOT_AI;
                } else {
                    aiX = 1;
                    aiY = 1;
                    field[aiX][aiY] = DOT_AI;
                }
                break;
            case 4:
                return;
            default:
                do {
                    aiX = RANDOM.nextInt(fieldSizeX);
                    aiY = RANDOM.nextInt(fieldSizeY);
                } while (!isCellEmpty(aiX, aiY));
                field[aiX][aiY] = DOT_AI;
        }
    }

    private static boolean checkWin(char c, String msg) {

        // проверка строки
        char str_col = 's';
        if ( countChar(c, str_col, fieldSizeX )) {
            System.out.println(msg);
            return true;
        }

        // проверка столбца
        str_col = 'c';
        if ( countChar(c, str_col, fieldSizeY )) {
            System.out.println(msg);
            return true;
        }
        // проверка диагонали
        if ( countCharDiag(c)) {
            System.out.println(msg);
            return true;
        }
        return false;
    }

    // проверка строки или столбца длинной fieldSize
    // и количеством одинаковых ячеек подряд winCount
    // строка - 's', столбец - 'c'
    private static boolean countChar(char c, char str_col, int fieldSizeXY) {
        for ( int j = 0; j < fieldSizeXY; j++) {
            for ( int i =0; i < fieldSizeXY-winCount+1; i++) {
                int cntChar = 0;
                for (int y = 0; y < winCount; y++) {
                    if( str_col == 's') {
                        if (field[j][y] == c)
                            cntChar++;
                    }
                    if( str_col == 'c') {
                        if (field[y][j] == c)
                            cntChar++;
                    }
                }
                if ( cntChar == winCount)
                    return true;
            }
        }
        return false;
    }

    // проверка диагонали в поле с размерами fieldSizeX - fieldSizeY
    // и количеством одинаковых ячеек подряд winCount
    private static boolean countCharDiag(char c) {
        // начало поля (0,0) - вниз до строки fieldSizeY-winCount
        for ( int j = 0; j < fieldSizeY-winCount+1 && winCount >= fieldSizeY; j++) {
            // начало поля (0,0) - вправо до столбца fieldSizeX-winCount
            for ( int z = 0; z < fieldSizeX-winCount+1; z++) {
                // сдвиг по диагонали на 1
                for ( int i =0; i < fieldSizeY-winCount+1; i++) {
                    int cntChar1 = 0;
                    int cntChar2 = 0;
                    // подсчет ячеек с символом
                    for (int y = 0; y < winCount; y++) {
                        if (field[j + i + y][z + i + y] == c)
                            cntChar1++;
                        if (field[j + i + y][fieldSizeX-1-z - i - y] == c)
                            cntChar2++;
                    }
                    if ( cntChar1 == winCount || cntChar2 == winCount )
                        return true;
                }
            }
        }
        return false;
    }

    // check draw
    private static boolean checkDraw() {
        if (fieldSum == 4 ) {
            System.out.println("Draw. Game over.");
            return true;
        } else fieldSum++;
        return false;
    }

    public static void main (String[]args){

        initField();
        printField();
        while (true) {
            humanTurn();
            aiTurn();
            printField();
            if (checkWin(DOT_HUMAN, "Human Win! Game over."))
                break;
            if (checkWin(DOT_AI, "Computer win! Game over."))
                break;
            if (checkDraw())
                break;
        }
    }
}