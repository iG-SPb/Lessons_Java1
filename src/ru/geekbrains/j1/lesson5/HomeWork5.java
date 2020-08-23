package ru.geekbrains.j1.lesson5;

public class HomeWork5 {
    public static void main(String[] args) {
        final String CHAR_GREEN = "\u001B[32m";
        final String CHAR_RED = "\u001B[31m";
        final String CHAR_No = "\u001B[0m";

        Cat myCat = new Cat("Gemma", "Motley", 3);
        Dog myDog = new Dog("Gracie", "Redhead", 4);
        notTypicalCat myUnicCat = new notTypicalCat("Jumper", "Motley", 3, 150, 2.5f);
        notTypicalDog myUnicDog = new notTypicalDog("Newfoundland", "Motley", 3, 150, 1.5f, 380);

        Animal[] zoo = {myCat, myDog, myUnicCat, myUnicDog};

        // testing my animals (run)
        for ( int i = 0; i < 700; i += 100) {
            for (Animal animal : zoo) {
                System.out.println("Distance - " + CHAR_RED + i + CHAR_No + "; " + CHAR_GREEN +
                        animal.name + CHAR_No + ": " + animal.runAnimal(i));
            }
        }
        System.out.println("------------------------------------------------------------");
        // testing my animals (jump)
        float distance = -0.5f;
        for ( int i = 1; i < 8; i++) {
            for (Animal animal : zoo) {
                System.out.println("Distance - " + CHAR_RED + i + CHAR_No + "; " + CHAR_GREEN +
                        animal.name + CHAR_No + ": " + animal.jumpAnimal(distance));
            }
            distance += 0.5f;
        }
        System.out.println("------------------------------------------------------------");
        // testing my animals (swimming)
        for ( int i = 0; i < 30; i += 10) {
            for (Animal animal : zoo) {
                System.out.println("Distance - "  + CHAR_RED + i + CHAR_No + "; " + CHAR_GREEN +
                        animal.name + CHAR_No + ": " + animal.swimmingAnimal(i));
            }
        }
    }
}
