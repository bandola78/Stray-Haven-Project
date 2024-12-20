package models;

public class Volunteer {
    private String name;
    private String contact;

    public Volunteer(String name, String contact) {
        this.name = name;
        this.contact = contact;
    }

    public String getName() {
        return name;
    }

    public String getContact() {
        return contact;
    }

    public void volunteerInfo() {
        System.out.println("Volunteer: " + name + ", Contact: " + contact);
    }
}
