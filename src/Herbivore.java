package src;

/**
 * Interface representing Herbivores, which are animals that graze in the field for sustenance.
 * Herbivores can eat grass from the field and convert it into energy based on their weight.
 */
public interface Herbivore {
    /** The constant factor used to calculate how much grass an animal eats based on its weight. */
    float CONDITION = 0.1f;
    /**
     * Allows a herbivore animal to graze in the field, consuming grass and converting it into energy.
     * The amount of grass eaten is calculated based on the animal's weight and the condition factor.
     * The field's grass amount is reduced by the amount eaten.
     *
     * @param grazer The animal that is grazing in the field.
     * @param field  The field where the grazing takes place.
     */
    default void grazeInTheField(Animal grazer, Field field) {
        if (CONDITION * grazer.getWeight() < field.getGrassAmount()) {
            float grassEaten = CONDITION * grazer.getWeight();
            grazer.setEnergy(grassEaten + grazer.getEnergy());
            field.setGrassAmount(field.getGrassAmount() - grassEaten);
        }
    }
}
