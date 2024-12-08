package src;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static int days;
    private static float grassAmount;
    private static Field field;
    public static void main(String[] args) {
        List<Animal> animals = readAnimals();
        removeDeadAnimals(animals);
        runSimulation(days, grassAmount, animals);
        animals.forEach(Animal::makeSound);
    }

    private static List<Animal> readAnimals() {
        List<Animal> animals = new ArrayList<>();
        String filePath = "input.txt";
        try (Scanner scanner = new Scanner(new File(filePath))) {
            List<String> lines = new ArrayList<>();
            while (scanner.hasNextLine()) {
                lines.add(scanner.nextLine());
            }

            grassAmount = strToFloat(lines.get(1));
            field = new Field(grassAmount);

            for (int i = 3; i < lines.size(); i++) {
                String line = lines.get(i);
                if (line.split(" ").length != 4) {
                    throw new InvalidNumberOfAnimalParametersException();
                }
                try (Scanner sc = new Scanner(line)) {
                    String animal = sc.next();
                    if (animal.equals("Lion") || animal.equals("Boar") || animal.equals("Zebra")) {
                        float weight = strToFloat(sc.next());
                        float speed = strToFloat(sc.next());
                        float energy = strToFloat(sc.next());
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
                    System.exit(0);
                }
            }

            days = strToInt(lines.getFirst());
            int n = strToInt(lines.get(2));
            if ((days < 1 || days > 30) || (n < 1 || n > 20)) {
                throw new InvalidInputException();
            }
            if (animals.size() != n) {
                throw new InvalidInputException();
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.exit(0);
        }
        return animals;
    }

    private static Float strToFloat(String str) throws InvalidInputException {
        String pattern = "^-?\\d+(\\.\\d+)?$";
        if (str.endsWith("F") || str.endsWith("f")) {
            str = str.substring(0, str.length() - 1);
        }
        if (str.matches(pattern)) {
            return Float.parseFloat(str);
        }
        throw new InvalidInputException();
    }

    private static Integer strToInt(String str) throws InvalidInputException {
        String pattern = "\\d+$";
        if (str.matches(pattern)) {
            return Integer.parseInt(str);
        }
        throw new InvalidInputException();
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
            for (int i = 0; i < days; i++) {
                for (Animal animal : animals) {
                    if (animal.getEnergy() != 0) {
                        animal.eat(animals, field);
                    }
                }
                field.makeGrassGrow();
                for (Animal animal : animals) {
                    animal.decrementEnergy();
                }
                removeDeadAnimals(animals);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
