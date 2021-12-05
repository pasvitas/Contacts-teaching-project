package ru.pasvitas.teaching.contactteachinapp.model;

public class AddContactRequest {

    private String name;
    private String contact;

    public AddContactRequest(String name, String contact) {
        this.name = name;
        this.contact = contact;
    }

    public AddContactRequest() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }
}
