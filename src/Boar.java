package src;

import java.util.List;

public final class Boar extends Animal implements Omnivore {
    public Boar(float weight, float speed, float energy, AnimalSound sound) throws WeightOutOfBoundsException,
            SpeedOutOfBoundsException, EnergyOutOfBoundsException {
        super(weight, speed, energy, sound);
    }

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
