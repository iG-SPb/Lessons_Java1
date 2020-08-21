package ru.geekbrains.j1.lesson4;

public class Worker {
    private String fioWorker;
    private int payWorker;
    private String birthdayWorker;
    private int idWorker;

    Worker( String fio, int pay, String birthday ) {
        this.fioWorker = fio;
        this.payWorker = pay;
        this.birthdayWorker = birthday;
        this.idWorker = HomeWork4.getID();
    }

    Worker() {
        System.out.println("Параметры не переданы");
        this.idWorker = HomeWork4.getID();
    }

    // Предусматриваем возможность изменения данных
    // (некорректный первоначальный ввод и т.д.)

    void set_fioWorker(String fio) {
        this.fioWorker = fio;
    }

    void set_payWorker(int pay) {
        this.payWorker = pay;
    }

    void set_birthdayWorker(String birthday) {
        this.birthdayWorker = birthday;
    }

    // вывод значений по работнику
    String get_fioWorker() {
        return fioWorker;
    }

    int get_payWorker() {
        return payWorker;
    }

    String get_birthdayWorker() {
        return birthdayWorker;
    }
    int get_yearWorker() {
        int yearWorker = 0;
        return yearWorker;
    }
    int get_idWorker() {
        return idWorker;
    }
    void set_idWorker(int id) {
        this.idWorker = id;
    }
}
