package src;

import java.util.List;

/**
 * The Zebra class represents a herbivorous animal that extends the Animal class.
 * It implements the Herbivore interface to define its behavior of grazing in the field.
 *
 * The Zebra class provides the following functionality:
 * - It allows setting the weight, speed, and energy attributes during initialization,
 *   ensuring they are within acceptable ranges through exception handling.
 * - It overrides the eat method to implement grazing behavior by calling the grazeInTheField method.
 */
public final class Zebra extends Animal implements Herbivore {
    /**
     * Constructs a Zebra object with the specified weight, speed, energy, and sound.
     *
     * @param weight The weight of the zebra, which must be within the defined bounds.
     * @param speed The speed of the zebra, which must be within the defined bounds.
     * @param energy The energy of the zebra, which must be within the defined bounds.
     * @param sound The sound made by the zebra, represented by the AnimalSound enum.
     * @throws WeightOutOfBoundsException If the weight is out of the acceptable bounds.
     * @throws SpeedOutOfBoundsException If the speed is out of the acceptable bounds.
     * @throws EnergyOutOfBoundsException If the energy is out of the acceptable bounds.
     */
    public Zebra(float weight, float speed, float energy, AnimalSound sound) throws WeightOutOfBoundsException,
            SpeedOutOfBoundsException, EnergyOutOfBoundsException {
        super(weight, speed, energy, sound);
    }

    /**
     * Implements the eat method for the Zebra. It simulates the grazing behavior by calling the grazeInTheField method.
     *
     * @param animals A list of animals, but not used in this implementation.
     * @param field The field where the zebra grazes to replenish its energy.
     */
    @Override
    public void eat(List<Animal> animals, Field field) {
        grazeInTheField(this, field);
    }
}
