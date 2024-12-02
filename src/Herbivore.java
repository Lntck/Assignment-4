package src;

public interface Herbivore {
    default void grazeInTheField(Animal grazer, Field field) {
        if (0.1*grazer.getWeight() < field.getGrassAmount()) {
            float grassEaten = 0.1f*grazer.getWeight();
            grazer.setEnergy(grassEaten + grazer.getEnergy());
            field.setGrassAmount(field.getGrassAmount()-grassEaten);
        }
    }
}
