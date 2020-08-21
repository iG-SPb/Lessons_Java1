package ru.geekbrains.j1.lesson2;

import java.util.Arrays;

public class HomeWork2 {

    // замена элемента массива
    public static int[] replaceElements(int[] arr) {
        for (int i = 0; i < arr.length; i++ ) {
            arr[i] = (arr[i] == 0) ? 1 : 0;
        }
        return arr;
    }

    // заполнение массива элементами
    public static int[] putElements(int[] arr) {
        for (int i = 0, x = 1; i < arr.length; i++, x += 3) {
            arr[i] = x;
        }
        return arr;
    }

    // умножение элементов массива (числа меньше 6-ти)
    public static int[] changeElements(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (arr[i] < 6) ? arr[i]*2 : arr[i];
        }
        return arr;
    }

    // поиск min/max элементов массива
    public static int[] searchElements(int[] arr) {
        int[] min_max = new int[2];
        min_max[0] = arr[0];
        min_max[1] = arr[0];
        for (int arr_digital : arr) {
            min_max[0] = (arr_digital < min_max[0]) ? min_max[0] = arr_digital : min_max[0];
            min_max[1] = (arr_digital > min_max[1]) ? min_max[1] = arr_digital : min_max[1];
        }
        return min_max;
    }

    // заполнение диагонали массива
    public static int[][] dgElements(int sizeArr) {
        int[][] arr = new int[sizeArr][sizeArr];
        for (int i1 = 0; i1 < (sizeArr); i1++) {
            for (int i2 = 0; i2 < (sizeArr); i2++) {
                if (i1==i2 || i2 == (sizeArr-i1-1)) {
                    arr[i1][i2] = 1;
                }
            }
        }
        return arr;
    }

    // поиск симметрии элементов массива
    public static boolean symmetryElements(int[] arr) {
        int a1 = 0;
        int a2 = 0;
        for (int arr_digital : arr) {
            a1 += arr_digital;
        }
        // если сумма элементов четная
        if (a1 % 2 == 0) {
            a1 /= 2;
            // поиск половины суиммы
            for (int arr_digital : arr) {
                a2 += arr_digital;
                if (a1 == a2) return true;
            }
        }
        return false;
    }

    // сдвиг элементов массива
    public static int[] slipElements(int[] arr, int slip) {
        int tmp_a1;
        int x;
        if (slip > 0) {
            for (x = 0; x < slip; x++) {
                tmp_a1 = arr[0];
                for (int i = 0; i < arr.length - 1; i++) {
                    arr[i] = arr[i + 1];
                }
                arr[arr.length - 1] = tmp_a1;
            }
        }
        if (slip < 0) {
            slip *= -1;
            for (x = 0; x < slip; x++) {
                tmp_a1 = arr[arr.length - 1];
                for (int i = arr.length-2; i >= 0; i--) {
                    arr[i+1] = arr[i];
                }
                arr[0] = tmp_a1;
            }
        }
        return arr;
    }

    public static void main(String[] args) {
        String col_Green = "\u001B[32m";
        String col_No = "\u001B[0m";
        int[] arr1 = {1,1,0,0,0,1,0,1,1,0,0,0,1,1,1};
        int[] arr2 = new int[8];
        int[] arr3 = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        int[] arr4 = {21, 3, 5, 1};
        System.out.println(col_Green+"Step 1"+col_No);
        System.out.println("before - "+Arrays.toString(arr1));
        System.out.println("after - "+Arrays.toString(replaceElements(arr1)));
        System.out.println(col_Green+"Step 2"+col_No);
        System.out.println(Arrays.toString(putElements(arr2)));
        System.out.println(col_Green+"Step 3"+col_No);
        System.out.println("before - "+Arrays.toString(arr3));
        System.out.println("after - "+Arrays.toString(changeElements(arr3)));
        System.out.println(col_Green+"Step 4"+col_No);
        System.out.println("min/max - "+Arrays.toString(searchElements(arr3))+"; array - "+Arrays.toString(arr3));
        System.out.println(col_Green+"Step 5"+col_No);
        System.out.println(Arrays.deepToString(dgElements(5)));
        System.out.println(col_Green+"Step 6"+col_No);
        System.out.println(symmetryElements(arr3)+" - "+Arrays.toString(arr3));
        System.out.println(symmetryElements(arr4)+" - "+Arrays.toString(arr4));
        System.out.println(col_Green+"Step 7-8"+col_No);
        System.out.println("before - "+Arrays.toString(arr4));
        System.out.println("right - "+Arrays.toString(slipElements(arr4, 2)));
        System.out.println("left - "+Arrays.toString(slipElements(arr4, -2)));
    }
}

