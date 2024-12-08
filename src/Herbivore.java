package src;

public interface Herbivore {
    float CONDITION = 0.1f;
    default void grazeInTheField(Animal grazer, Field field) {
        if (CONDITION * grazer.getWeight() < field.getGrassAmount()) {
            float grassEaten = CONDITION * grazer.getWeight();
            grazer.setEnergy(grassEaten + grazer.getEnergy());
            field.setGrassAmount(field.getGrassAmount() - grassEaten);
        }
    }
}
