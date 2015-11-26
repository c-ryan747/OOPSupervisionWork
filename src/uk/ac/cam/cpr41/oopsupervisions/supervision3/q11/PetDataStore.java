package uk.ac.cam.cpr41.oopsupervisions.supervision3.q11;

import java.util.ArrayList;
import java.util.List;

public class PetDataStore {
    private List<Pet> pets = new ArrayList<Pet>();
    private int petLimit = 5;

    public int getPetLimit() {
        return petLimit;
    }

    public void setPetLimit(int petLimit) {
        this.petLimit = petLimit;
    }

    public void addPet(Pet p) throws PetException{
        if (pets.size() == petLimit) {
            throw new PetException("Too many pets!");
        } else {
            pets.add(p);
        }
    }

    public void removePet(Pet p) {
        pets.remove(p);
    }
}
