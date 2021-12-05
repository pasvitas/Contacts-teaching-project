package ru.pasvitas.teaching.contactsbackend.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.pasvitas.teaching.contactsbackend.model.ContactModel;
import ru.pasvitas.teaching.contactsbackend.repository.ContactRepository;

@Service
@RequiredArgsConstructor
public class ContactServiceImpl implements ContactService {

    private final ContactRepository contactRepository;

    @Override
    public Long saveContact(ContactModel model) {
        ContactModel contactModel = contactRepository.save(model);
        return contactModel.getId();
    }
}
