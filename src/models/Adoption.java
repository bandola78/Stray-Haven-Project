package models;

public class Adoption {
    private String adopterName;
    private Animal animal;

    public Adoption(String adopterName, Animal animal) {
        this.adopterName = adopterName;
        this.animal = animal;
    }

    public String getAdopterName() {
        return adopterName;
    }

    public Animal getAnimal() {
        return animal;
    }

    public void adoptionInfo() {
        System.out.println("Adopter: " + adopterName + " adopted " + animal.getName() + " the " + animal.getType());
    }
}
