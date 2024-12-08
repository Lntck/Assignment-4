package src;

import java.util.List;

/**
 * The Lion class represents a lion, which is a carnivorous animal.
 * It extends the Animal class and implements the Carnivore interface, meaning it can hunt and eat other animals.
 */
public final class Lion extends Animal implements Carnivore {
    /**
     * Constructs a Lion with the specified attributes.
     *
     * @param weight The weight of the lion.
     * @param speed The speed of the lion.
     * @param energy The energy of the lion.
     * @param sound The sound the lion makes.
     * @throws WeightOutOfBoundsException If the weight is out of the valid range.
     * @throws SpeedOutOfBoundsException If the speed is out of the valid range.
     * @throws EnergyOutOfBoundsException If the energy is out of the valid range.
     */
    public Lion(float weight, float speed, float energy, AnimalSound sound) throws WeightOutOfBoundsException,
            SpeedOutOfBoundsException, EnergyOutOfBoundsException {
        super(weight, speed, energy, sound);
    }

    /**
     * Defines the behavior of the lion when it tries to eat.
     * It first tries to choose a prey from the given list of animals, and if it finds one, it hunts and eats it.
     *
     * @param animals The list of available animals from which the lion can choose its prey.
     * @param field The field where the lion is located.
     */
    @Override
    public void eat(List<Animal> animals, Field field) {
        try {
            Animal prey = choosePrey(animals, this);
            if (prey != null) {
                this.huntPrey(this, prey);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
