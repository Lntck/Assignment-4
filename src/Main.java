package src;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static int d;
    private static float g;
    public static void main(String[] args) {
        List<Animal> animals = readAnimals();
        if (animals != null) {runSimulation(d, g, animals);}
    }

    private static List<Animal> readAnimals() {
        List<Animal> animals = new ArrayList<>();
        String filePath = "input.txt";
        try (Scanner scanner = new Scanner(new File(filePath))) {
            d = scanner.nextInt();
            g = str_to_float(scanner.next());
            int n = scanner.nextInt();
            if (g < 0 || g > 100) {throw new GrassOutOfBoundsException();}
            if (d < 1 || d > 20) {throw new InvalidInputException();}
            scanner.nextLine();
            for (int i = 0; i < n; i++) {
                String line = scanner.nextLine();
                if (line.split(" ").length != 4) { throw new InvalidNumberOfAnimalParametersException();}
                try (Scanner sc = new Scanner(line)) {
                    String animal = sc.next();
                    if (animal.equals("Lion") || animal.equals("Boar") || animal.equals("Zebra")) {
                        float weight = str_to_float(sc.next());
                        float speed = str_to_float(sc.next());
                        float energy = str_to_float(sc.next());
                        switch (animal) {
                            case "Lion" -> animals.add(new Lion(weight, speed, energy, AnimalSound.LION));
                            case "Boar" -> animals.add(new Boar(weight, speed, energy, AnimalSound.BOAR));
                            case "Zebra" -> animals.add(new Zebra(weight, speed, energy, AnimalSound.ZEBRA));
                            default -> System.out.println("Animal Not Found");
                        }
                    } else {
                        throw new InvalidInputException();
                    }
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                    return null;
                }
            }
            if (scanner.hasNextLine()) {throw new InvalidInputException();}
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
        return animals;
    }

    private static Float str_to_float(String str) {
        if (str.endsWith("F") || str.endsWith("f")) {
            str = str.substring(0, str.length() - 1);
        }
        return Float.parseFloat(str);
    }

    private static void printAnimals(List<Animal> animals) {
        for (Animal animal : animals) {
            System.out.println(animal);
        }
    }

    private static void removeDeadAnimals(List<Animal> animals) {
        animals.removeIf(animal -> animal.getEnergy() == 0);
    }

    private static void runSimulation(int days, float grassAmount, List<Animal> animals) {
        try {
            Field field = new Field(grassAmount);
            removeDeadAnimals(animals);
            for (int i = 0; i < days; i++) {
                for (Animal animal : animals) {
                    if (animal.getEnergy() != 0) {
                        animal.eat(animals, field);
                        animal.decrementEnergy();
                    }
                }
                removeDeadAnimals(animals);
                field.makeGrassGrow();

            }
            for (Animal animal : animals) {
                animal.makeSound();
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
