package ru.pasvitas.teaching.contactteachinapp.model;

public class AddContactResponse {

    private Long id;

    public AddContactResponse() {

    }

    public AddContactResponse(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
