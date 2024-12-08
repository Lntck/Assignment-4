package src;

public final class Field {
    public static final float MIN_GRASS = 0;
    public static final float MAX_GRASS = 100;
    private float grassAmount;

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
