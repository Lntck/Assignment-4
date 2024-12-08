package src;

import java.util.List;

public interface Carnivore {
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
    default void huntPrey(Animal hunter, Animal prey) throws TooStrongPreyException {
        if (hunter.getSpeed() <= prey.getSpeed() && hunter.getEnergy() <= prey.getEnergy()) {
            throw new TooStrongPreyException();
        }
        hunter.setEnergy(hunter.getEnergy() + prey.getWeight());
        prey.setEnergy(0);
    }
}
