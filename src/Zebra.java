package src;

import java.util.List;

public class Zebra extends Animal implements Herbivore{
    public Zebra(float weight, float speed, float energy, AnimalSound sound) throws WeightOutOfBoundsException, SpeedOutOfBoundsException, EnergyOutOfBoundsException {
        super(weight, speed, energy, sound);
    }

    @Override
    public void eat(List<Animal> animals, Field field) {
        grazeInTheField(this, field);
    }
}
