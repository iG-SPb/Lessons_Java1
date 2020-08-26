package ru.geekbrains.j1.lesson5;

public class Cat extends Animal {

    public Cat(String name, String color, int age) {
        super(name, color, age);
    }
    @Override
    public String runAnimal(int distance) {
        if (distance <= 0)
            return ("Explain the task.");
        if (distance <= 200)
            return ("I ran/");
        else
            return ("Run yourself, I have no more strength.");
    }

    @Override
    public String jumpAnimal(float distance) {
        if (distance < 0)
            return ("Let's see what's down there.");
        if (distance > 0 && distance <= 2)
            return ("I jump.");
        if (distance > 2)
            return ("Need a catapult.");
        return ("Did not work out.");
    }

    @Override
    public String swimmingAnimal(int distance) {
        return ("I am a cat and do not like to swim.");
    }
}
