package ru.geekbrains.j1.lesson5;

public class notTypicalCat extends Cat {

    protected int otherRun;
    protected float otherJump;
    protected int otherSwimming;

    public notTypicalCat(String name, String color, int age, int otherRun, float otherJump) {
        super(name, color, age);
        this.otherRun = otherRun;
        this.otherJump = otherJump;
    }
    @Override
    public String runAnimal(int distance) {
        if (distance <= 0)
            return ("Explain the task.");
        if (distance <= otherRun)
            return ("I ran.");
        else
            return ("Run yourself, I have no more strength.");
    }

    @Override
    public String jumpAnimal(float distance) {
        if (distance < 0)
            return ("Let's see what's down there.");
        if (distance > 0 && distance <= otherJump)
            return ("I jump.");
        if (distance > 2)
            return ("Need a catapult.");
        return ("Did not work out.");
    }
}
