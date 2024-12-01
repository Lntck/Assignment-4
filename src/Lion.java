package src;

import java.util.List;

public class Lion extends Animal implements Carnivore {
    public Lion(float weight, float speed, float energy, AnimalSound sound) throws WeightOutOfBoundsException, SpeedOutOfBoundsException, EnergyOutOfBoundsException {
        super(weight, speed, energy, sound);
    }

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
