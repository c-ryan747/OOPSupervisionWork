package uk.ac.cam.cpr41.oopsupervisions.supervision3.q11;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class PetDataStore implements Iterable<Pet> {
    private List<Pet> pets = new ArrayList<Pet>();

    public void addPet(int type) throws PetException{
        Pet p;
        switch (type) {
            case 1:
                p = new Dog();
                break;
            case 2:
                p = new Ninja();
                break;
            case 3:
                p = new Fish();
                break;
            default:
                throw new PetException("Pet type doesn't exist");
        }
        pets.add(p);
    }

    public Pet getPet(int index) throws PetException {
        if (index < 0 || index >= pets.size()) {
            throw new PetException("Pet doesn't exist");
        } else {
            Pet p = pets.get(index);
            if (p.getAlive()) {
                return p;
            } else {
                throw new PetException("This pets dead :(");
            }
        }
    }

    public void removePet(int index) throws PetException {
        if (index < 0 || index >= pets.size()) {
            throw new PetException("Pet doesn't exist");
        }
        pets.remove(index);
    }

    public int numberOfPets() {
        return pets.size();
    }

    @Override
    public Iterator<Pet> iterator() {
        return pets.iterator();
    }

}
