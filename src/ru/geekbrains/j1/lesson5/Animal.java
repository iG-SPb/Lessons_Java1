package ru.geekbrains.j1.lesson5;

public abstract class Animal {

    protected final String name;
    protected final String color;
    protected int age;

    protected Animal(String name, String color, int age) {
        this.age = age;
        this.name = name;
        this.color = color;
    }

    public String runAnimal(int distance) {
        if (distance < 0)
            return ("Explain the task.");
        if (distance > 0)
            return ("I ran.");
        return ("Already in place.");
    }
    public String jumpAnimal(float distance) {
        if (distance < 0)
            return ("Explain the task.");
        if (distance > 0)
            return ("I jump.");
        return ("Already in place.");
    }
    public String swimmingAnimal(int distance) {
        if (distance < 0)
            return ("Explain the task.");
        if (distance > 0)
            return ("I swimming.");
        return ("Already in place.");
    }
}
