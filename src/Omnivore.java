package src;

/**
 * The Omnivore interface represents an animal that is both a carnivore and a herbivore.
 * It extends both the Carnivore and Herbivore interfaces, allowing an omnivore to exhibit behaviors of both.
 * An omnivore can hunt other animals (carnivorous behavior) and graze on plants (herbivorous behavior).
 */
public interface Omnivore extends Carnivore, Herbivore {
}
