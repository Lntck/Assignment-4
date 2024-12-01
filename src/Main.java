package src;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Main {
    private static int d;
    private static float g;
    public static void main(String[] args) {
        List<Animal> animals = readAnimals();
        if (animals != null) {runSimulation(d, g, animals);}
    }

    private static List<Animal> readAnimals() {
        List<Animal> animals = new ArrayList<>();
        String filePath = "input.txt"; // Specify the path to the file
        try (Scanner scanner = new Scanner(new File(filePath))) {
            d = scanner.nextInt();
            g = str_to_float(scanner.next());
            int n = scanner.nextInt();
            scanner.nextLine();
            for (int i = 0; i < n; i++) {
                String line = scanner.nextLine();
                try (Scanner sc = new Scanner(line)) {
                    String animal = sc.next();
                    if (Pattern.compile("(Lion|Boar|Zebra)").matcher(animal).matches()) {
                        float weight = str_to_float(sc.next());
                        float speed = str_to_float(sc.next());
                        float energy = str_to_float(sc.next());
                        if (!sc.hasNext()) {
                            switch (animal) {
                                case "Lion" -> animals.add(new Lion(weight, speed, energy, AnimalSound.LION));
                                case "Boar" -> animals.add(new Boar(weight, speed, energy, AnimalSound.BOAR));
                                case "Zebra" -> animals.add(new Zebra(weight, speed, energy, AnimalSound.ZEBRA));
                                default -> System.out.println("Animal Not Found");
                            }
                        } else {throw new InvalidNumberOfAnimalParametersException();}
                    } else {
                        throw new IllegalArgumentException();
                    }
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                    return null;
                }
            }
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
