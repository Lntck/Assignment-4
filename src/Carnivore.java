package src;

import java.util.List;

/**
 * Interface representing carnivorous behavior for animals that hunt and prey on other animals.
 * It defines methods for choosing prey and hunting.
 */
public interface Carnivore {
    /**
     * Chooses a prey from the given list of animals for a specified hunter animal.
     * The prey is selected based on the hunter's capabilities and the list of available animals.
     *
     * If the hunter attempts to hunt itself or another animal of the same species, exceptions will be thrown:
     * - SelfHuntingException if the hunter tries to hunt itself.
     * - CannibalismException if the hunter tries to hunt another animal of the same species.
     *
     * @param animals The list of available animals to choose from.
     * @param hunter The animal performing the hunt.
     * @return The chosen prey animal, or null if no valid prey is found.
     * @throws SelfHuntingException If the hunter tries to hunt itself.
     * @throws CannibalismException If the hunter tries to hunt an animal of the same species.
     */
    default Animal choosePrey(List<Animal> animals, Animal hunter) throws SelfHuntingException, CannibalismException {
        for (int i = 0; i <= animals.size(); i++) {
            if (animals.get(i).equals(hunter)) {
                if (animals.get((i + 1) % animals.size()).equals(hunter)) {
                    throw new SelfHuntingException();
                }
                if (animals.get((i + 1) % animals.size()).getClass().equals(hunter.getClass())) {
                    throw new CannibalismException();
                }
                return animals.get((i + 1) % animals.size());
            }
        }
        return null;
    }

    /**
     * Hunts the specified prey animal, transferring energy from the prey to the hunter.
     * If the prey is too strong or too fast for the hunter to catch, a TooStrongPreyException is thrown.
     *
     * @param hunter The animal performing the hunt.
     * @param prey The prey animal being hunted.
     * @throws TooStrongPreyException If the prey is too strong or too fast to be hunted.
     */
    default void huntPrey(Animal hunter, Animal prey) throws TooStrongPreyException {
        if (hunter.getSpeed() <= prey.getSpeed() && hunter.getEnergy() <= prey.getEnergy()) {
            throw new TooStrongPreyException();
        }
        hunter.setEnergy(hunter.getEnergy() + prey.getWeight());
        prey.setEnergy(0);
    }
}
