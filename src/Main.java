package src;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * The Main class simulates the behavior of animals in a field over a given number of days.
 * It reads input data from a file, initializes animals, runs the simulation, and prints the results.
 * The Main class provides the following functionality:
 * - It reads data from an "input.txt" file to initialize the animals, their attributes, and the field.
 * - It validates the input data and handles exceptions if the data is invalid.
 * - It simulates the animals eating, growing grass in the field, and losing energy each day.
 * - It removes dead animals (those with zero energy) from the simulation.
 * - It prints the sounds made by the animals after the simulation is completed.
 */
public class Main {
    private static final int MAX_NUMBER_OF_ANIMALS = 4;
    private static final int START_OF_ANIMALS = 3;
    private static final int MAX_DAYS = 30;
    private static final int MIN_DAYS = 1;
    private static final int MAX_N = 20;
    private static final int MIN_N = 1;
    private static int days;
    private static float grassAmount;
    private static Field field;
    public static void main(String[] args) {
        List<Animal> animals = readAnimals();
        removeDeadAnimals(animals);
        runSimulation(days, grassAmount, animals);
        animals.forEach(Animal::makeSound);
    }

    /**
     * Reads animal data from a file and initializes the list of animals.
     *
     * @return A list of animals initialized from the input file.
     */
    private static List<Animal> readAnimals() {
        List<Animal> animals = new ArrayList<>();
        String filePath = "input.txt";
        try (Scanner scanner = new Scanner(new File(filePath))) {
            List<String> lines = new ArrayList<>();
            while (scanner.hasNextLine()) {
                lines.add(scanner.nextLine());
            }
            if (lines.isEmpty()) {
                throw new InvalidInputException();
            }

            grassAmount = strToFloat(lines.get(1));
            field = new Field(grassAmount);

            for (int i = START_OF_ANIMALS; i < lines.size(); i++) {
                String line = lines.get(i);
                if (line.split(" ").length != MAX_NUMBER_OF_ANIMALS) {
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
            if ((days < MIN_DAYS || days > MAX_DAYS) || (n < MIN_N || n > MAX_N)) {
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

    /**
     * Converts a string to a float.
     *
     * @param str The string to be converted.
     * @return The float value of the string.
     * @throws InvalidInputException If the string cannot be parsed to a valid float.
     */
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

    /**
     * Converts a string to an integer.
     *
     * @param str The string to be converted.
     * @return The integer value of the string.
     * @throws InvalidInputException If the string cannot be parsed to a valid integer.
     */
    private static Integer strToInt(String str) throws InvalidInputException {
        String pattern = "\\d+$";
        if (str.matches(pattern)) {
            return Integer.parseInt(str);
        }
        throw new InvalidInputException();
    }

    /**
     * Prints the details of all animals in the list.
     *
     * @param animals The list of animals to be printed.
     */
    private static void printAnimals(List<Animal> animals) {
        for (Animal animal : animals) {
            System.out.println(animal);
        }
    }

    /**
     * Removes dead animals (animals with zero energy) from the list.
     *
     * @param animals The list of animals from which dead animals will be removed.
     */
    private static void removeDeadAnimals(List<Animal> animals) {
        animals.removeIf(animal -> animal.getEnergy() == 0);
    }

    /**
     * Runs the simulation for the specified number of days.
     *
     * @param days The number of days to run the simulation.
     * @param grassAmount The initial amount of grass in the field.
     * @param animals The list of animals participating in the simulation.
     */
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
