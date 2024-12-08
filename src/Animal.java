package src;

import java.util.List;

public abstract class Animal {
    public static final float MIN_SPEED = 5;
    public static final float MAX_SPEED = 60;
    public static final float MIN_ENERGY = 0;
    public static final float MAX_ENERGY = 100;
    public static final float MIN_WEIGHT = 5;
    public static final float MAX_WEIGHT = 200;

    private float weight;
    private float speed;
    private float energy;
    private AnimalSound sound;

    protected Animal(float weight, float speed, float energy, AnimalSound sound) throws WeightOutOfBoundsException,
            SpeedOutOfBoundsException, EnergyOutOfBoundsException {
        if (weight < MIN_WEIGHT || weight > MAX_WEIGHT) {
            throw new WeightOutOfBoundsException();
        }
        if (speed < MIN_SPEED || speed > MAX_SPEED) {
            throw new SpeedOutOfBoundsException();
        }
        if (energy < MIN_ENERGY || energy > MAX_ENERGY) {
            throw new EnergyOutOfBoundsException();
        }

        this.weight = weight;
        this.speed = speed;
        this.energy = energy;
        this.sound = sound;
    }

    public final void makeSound() {
        System.out.println(this.getSound().getSound());
    }
    public final void decrementEnergy() {
        this.energy -= 1;
        if (this.energy < MIN_ENERGY) {
            this.energy = MIN_ENERGY;
        }
    }
    public abstract void eat(List<Animal> animals, Field field);
    public final float getWeight() {
        return weight;
    }
    public final float getSpeed() {
        return speed;
    }
    public final float getEnergy() {
        return energy;
    }
    public final void setEnergy(float energy) {
        this.energy = energy;
        if (this.energy < MIN_ENERGY) {
            this.energy = MIN_ENERGY;
        }
        if (this.energy > MAX_ENERGY) {
            this.energy = MAX_ENERGY;
        }
    }
    public final AnimalSound getSound() {
        return sound;
    }

    @Override
    public final String toString() {
        return "Animal: " + this.getClass().getSimpleName() + " weight=" + weight + ", speed=" + speed
                + ", energy=" + energy;
    }
}
