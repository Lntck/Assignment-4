package src;

import java.util.List;

/**
 * Represents a Boar, which is an omnivorous animal capable of grazing in the field and hunting prey.
 * Extends {@link Animal} and implements {@link Omnivore}.
 */
public final class Boar extends Animal implements Omnivore {
    /**
     * Constructs a new Boar with the specified weight, speed, energy, and sound.
     *
     * @param weight The weight of the boar.
     * @param speed  The speed of the boar.
     * @param energy The energy of the boar.
     * @param sound  The sound associated with the boar.
     * @throws WeightOutOfBoundsException If the weight is out of bounds.
     * @throws SpeedOutOfBoundsException  If the speed is out of bounds.
     * @throws EnergyOutOfBoundsException If the energy is out of bounds.
     */
    public Boar(float weight, float speed, float energy, AnimalSound sound) throws WeightOutOfBoundsException,
            SpeedOutOfBoundsException, EnergyOutOfBoundsException {
        super(weight, speed, energy, sound);
    }

    /**
     * Makes the boar graze in the field and attempts to hunt prey.
     * If a prey is chosen, the boar attempts to hunt it. Exceptions during hunting
     * (e.g., self-hunting, cannibalism, or prey being too strong) are caught and their
     * messages are printed to the console.
     *
     * @param animals The list of animals present on the field.
     * @param field   The field in which the boar grazes.
     */
    @Override
    public void eat(List<Animal> animals, Field field) {
        grazeInTheField(this, field);
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
