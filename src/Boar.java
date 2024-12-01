package src;

import java.util.List;

public class Boar extends Animal implements Omnivore{
    public Boar(float weight, float speed, float energy, AnimalSound sound) throws WeightOutOfBoundsException, SpeedOutOfBoundsException, EnergyOutOfBoundsException {
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

    @Override
    public void grazeInTheField(Animal grazer, Field field) {
        if (0.1*grazer.getWeight() < field.getGrassAmount()) {
            grazer.setEnergy(0.1f*grazer.getWeight() + grazer.getEnergy());
            field.setGrassAmount(field.getGrassAmount()-(0.1f*grazer.getWeight()));
        }
    }
}
