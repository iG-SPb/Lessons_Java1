package ru.geekbrains.j1.lesson5;

public class notTypicalDog extends Cat {

    protected int otherRun;
    protected float otherJump;
    protected int otherSwimming;

    public notTypicalDog(String name, String color, int age, int otherRun, float otherJump, int otherSwimming) {
        super(name, color, age);
        this.otherRun = otherRun;
        this.otherJump = otherJump;
        this.otherSwimming = otherSwimming;
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
        if (distance > otherJump)
            return ("Need a catapult.");
        return ("Did not work out.");
    }

    @Override
    public String swimmingAnimal(int distance) {
        if (distance <= 0)
            return ("Explain the task");
        if (distance > 0 && distance <= otherSwimming)
            return ("I swimming");
        else
            return ("Swim yourself, I have no more strength.");
    }
}
