package ru.pasvitas.teaching.contactsbackend.service;

import ru.pasvitas.teaching.contactsbackend.model.ContactModel;

public interface ContactService {
    Long saveContact(ContactModel model);
}
