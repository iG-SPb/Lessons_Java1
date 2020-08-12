package ru.geekbrains.j1.lesson1;

public class HomeWork1 {
    // ввод переменных пользователем не предусмотрен заданием
    // значения переменным (произвольные значения) присвоены программно

    // методичка - 3. Написать метод вычисляющий выражение a * (b + (c / d)) и возвращающий
    // результат, где a, b, c, d – аргументы этого метода, имеющие тип float.
    // сайт - Написать метод вычисляющий выражение a * (b + (c / d)) и возвращающий
    // результат с плавающей точкой, где a, b, c, d – целочисленные входные параметры этого метода;
    // решение по второму варианту
    private static float dz_3 (int a, int b, int c, int d) {
        return a * (b + ((float)c / d));
    }
    // 4. Написать метод, принимающий на вход два целых числа и проверяющий,
    // что их сумма лежит в пределах от 10 до 20 (включительно),
    // если да – вернуть true, в противном случае – false.
    private static boolean dz_4 (int a, int b) {
        boolean param;
        System.out.println("Первое число - "+a);
        System.out.println("Второе число - "+b);
        System.out.println("Сумма чисел - "+(a+b));
        param= a + b >= 10 && a + b <= 20;
        return param;
    }
    // 5. Написать метод, которому в качестве параметра передается целое число,
    // метод должен напечатать в консоль, положительное ли число передали или отрицательное.
    // Замечание: ноль считаем положительным числом.
    private static void dz_5 (int a) {
        if (a<0) System.out.println("Число "+a+" отрицательное");
        else System.out.println("Число "+a+" положительное");
    }
    // 6. Написать метод, которому в качестве параметра передается целое число.
    // Метод должен вернуть true, если число отрицательное, и вернуть false если положительное.
    private static boolean dz_6 (int a) {
        System.out.println("Число = "+a);
        return a < 0;
    }
    // 7. Написать метод, которому в качестве параметра передается строка, обозначающая имя.
    // Метод должен вывести в консоль сообщение «Привет, указанное_имя!».
    private static void dz_7 (String name) {
        System.out.println("Привет, "+name+"!");
    }
    // 8. *Написать метод, который определяет, является ли год високосным,
    // и выводит сообщение в консоль. Каждый 4-й год является високосным,
    // кроме каждого 100-го, при этом каждый 400-й – високосный.
    public static void dz_8 (int a) {
        String param = "не високосный";
        if (a<0) {
            System.out.println("Значение должно быть положительным");
        }
        else if ((a % 4 == 0 || a % 400 == 0) && a % 100 != 0) param = "високосный";
        System.out.println("Год "+a+" - "+param);
    }
    // 1. Создать пустой проект в IntelliJ IDEA и прописать метод main().
    public static void main(String[] args) {
        System.out.println("\u001B[32m"+"пункт-1"+"\u001B[0m");
        System.out.println("Start DZ");
        System.out.println("\u001B[32m"+"пункт-2"+"\u001B[0m");
        // 2. Создать переменные всех пройденных типов данных и инициализировать их значения.
        byte a1 = 127;
        short a2 = 32767;
        int  a3 = 214789;
        long a4 = 23421251L;
        char a5 = 'i';
        float a6 = 7.8f;
        double a7 = 8.0;
        boolean a8 = true;
        String a9 = "GeekBrains";
        System.out.println("byte = "+a1+"\nshort = "+a2+"\nint = "+a3+"\nlong = "+a4);
        System.out.println("char = "+a5+"\nfloat = "+a6+"\ndouble = "+a7+"\nboolean = "+a8);
        System.out.println("String - "+a9);

        System.out.println("\u001B[32m"+"пункт-3"+"\u001B[0m");
        int a = 75, b = 24, c = 569, d = 212;
        System.out.println(dz_3(a, b, c, d));

        System.out.println("\u001B[32m"+"пункт-4"+"\u001B[0m");
        System.out.println(dz_4(11, 9));

        System.out.println("\u001B[32m"+"пункт-5"+"\u001B[0m");
        dz_5(3);

        System.out.println("\u001B[32m"+"пункт-6"+"\u001B[0m");
        System.out.println(dz_6(-1));

        System.out.println("\u001B[32m"+"пункт-7"+"\u001B[0m");
        dz_7(a9);

        System.out.println("\u001B[32m"+"пункт-8"+"\u001B[0m");
        dz_8(1000);
    }
}
