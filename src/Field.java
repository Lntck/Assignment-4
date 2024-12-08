package src;

/**
 * Represents a field with a certain amount of grass.
 * The field contains a certain quantity of grass, and this class provides methods to grow
 * the grass and manage the amount of grass in the field, with validation against predefined limits.
 */
public final class Field {
    public static final float MIN_GRASS = 0;
    public static final float MAX_GRASS = 100;
    private float grassAmount;

    /**
     * Constructs a Field object with the specified amount of grass.
     * The grass amount is validated against the predefined limits.
     *
     * @param grassAmount The initial amount of grass in the field.
     * @throws GrassOutOfBoundsException If the specified amount of grass is outside the valid range.
     */
    public Field(float grassAmount) throws GrassOutOfBoundsException {
        if (grassAmount < MIN_GRASS || grassAmount > MAX_GRASS) {
            throw new GrassOutOfBoundsException();
        }
        this.grassAmount = grassAmount;
    }

    public void makeGrassGrow() {
        this.grassAmount *= 2;
        if (this.grassAmount > MAX_GRASS) {
            this.grassAmount = MAX_GRASS;
        }
    }
    public float getGrassAmount() {
        return grassAmount;
    }
    public void setGrassAmount(float grassAmount) {
        this.grassAmount = grassAmount;
        if (this.grassAmount > MAX_GRASS) {
            this.grassAmount = MAX_GRASS;
        }
        if (this.grassAmount < MIN_GRASS) {
            this.grassAmount = MIN_GRASS;
        }
    }
}
