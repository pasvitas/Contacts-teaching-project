package ru.pasvitas.teaching.contactsbackend.repository;

import java.util.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.pasvitas.teaching.contactsbackend.model.ContactModel;

@Repository
public interface ContactRepository extends CrudRepository<ContactModel, Long> {
    List<ContactModel> findContactModelByContact(String contact);
}