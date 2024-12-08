package src;

/**
 * Enum representing the sounds associated with different animal types.
 */
public enum AnimalSound {
    LION("Roar"),
    ZEBRA("Ihoho"),
    BOAR("Oink");

    private final String sound;

    /**
     * Constructs an AnimalSound enum with the specified sound.
     *
     * @param sound The sound associated with the animal.
     */
    AnimalSound(String sound) {
        this.sound = sound;
    }

    public String getSound() {
        return sound;
    }
}
