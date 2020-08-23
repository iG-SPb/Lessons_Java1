package ru.geekbrains.j1.lesson5;

public class Dog extends Animal {

    public Dog(String name, String color, int age) {
        super(name, color, age);
    }

    @Override
    public String runAnimal(int distance) {
        if (distance <= 0)
            return ("Explain the task");
        if (distance <= 500)
            return ("I ran.");
        else
            return ("Run yourself, I have no more strength.");
    }

    @Override
    public String jumpAnimal(float distance) {
        if (distance < 0)
            return ("I'm afraid to jump.");
        if (distance > 0 && distance <= 0.5f)
            return ("I jump.");
        if (distance > 0.5)
            return ("Need a catapult.");
        return ("Did not work out.");
    }

    @Override
    public String swimmingAnimal(int distance) {
        if (distance <= 0)
            return ("Explain the task");
        if (distance > 0 && distance <= 10)
            return ("I swimming");
        else
            return ("Swim yourself, I have no more strength.");
    }
}
