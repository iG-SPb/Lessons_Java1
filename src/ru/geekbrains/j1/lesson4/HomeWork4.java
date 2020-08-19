package ru.geekbrains.j1.lesson4;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.text.ParseException;

public class HomeWork4 {

    public static int id = 0; // идентификатор работника

    // идентификатор для нового работника
    public static int getID() {
        return id++;
    }

    private static boolean diffYear(String wkYear, long dfYear) {

        long diff;
        Date myDate1 = new Date(); // текущая дата
        Date myDate2 = new Date(); // для даты рождения работника
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy.MM.dd");

        try {
            myDate2 = formatter.parse(wkYear);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        diff = myDate1.getTime() - myDate2.getTime(); // разность дат
        return diff > dfYear;
    }

    private static void addPay(Worker[] arr, int count, long cYear) {
        int pay;

        for (Worker worker : arr) {
            if (diffYear(worker.get_birthdayWorker(),cYear)) {
                System.out.println("Работник: " + worker.get_fioWorker());
                System.out.println("До - " + worker.get_payWorker());
                pay = worker.get_payWorker();
                pay += count;
                worker.set_payWorker(pay);
                System.out.println("После - " + worker.get_payWorker());
            }
        }
    }

    public static void main(String[] args) {

        String col_Green = "\u001B[32m";
        String col_No = "\u001B[0m";
        final long consYear40 = 1262376150548L; // 40 лет
        final long consYear45 = 1420156800000L; // 45 лет

        Worker worker1 = new Worker("Иванов Иван Иванович", 65000, "1980.05.27");

        System.out.println(worker1.get_fioWorker());
        System.out.println(worker1.get_birthdayWorker());
        Worker[] worker = new Worker[5];
        // заполнение массива
        // вариант 1
        worker[0] = worker1;
        // вариант 2
        worker[1] = new Worker("Петров Александр Александрович", 80000, "1975.08.17");
        worker[2] = new Worker("Сидоров Александр Александрович", 40000, "2000.03.15");
        worker[3] = new Worker("Иванов Александр Александрович", 73000, "1999.08.16");
        // вариант 3
        worker[4] = new Worker();
        worker[4].set_fioWorker("Кузнецов Александр Александрович");
        worker[4].set_payWorker(180000);
        worker[4].set_birthdayWorker("1980.08.19");


        // вывод пользователей старше 40 лет
        System.out.println(col_Green+"Cтарше 40 лет:"+col_No);
        for (Worker value : worker) {
            if (diffYear(value.get_birthdayWorker(), consYear40)) {
                System.out.println("ФИО: " + value.get_fioWorker());
                System.out.println("ДР: " + value.get_birthdayWorker());
                System.out.println("iD: " + value.get_idWorker());
            }
        }
        // увеличение оплаты
        System.out.println(col_Green+"Увеличение оплаты:"+col_No);
        addPay(worker, 5000, consYear45); // увеличение на 5000
    }
}