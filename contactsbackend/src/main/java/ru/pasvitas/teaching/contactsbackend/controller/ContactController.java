package ru.pasvitas.teaching.contactsbackend.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import ru.pasvitas.teaching.contactsbackend.model.AddContactRequest;
import ru.pasvitas.teaching.contactsbackend.model.AddContactResponse;
import ru.pasvitas.teaching.contactsbackend.model.ContactModel;
import ru.pasvitas.teaching.contactsbackend.service.ContactService;

@RestController
@RequiredArgsConstructor
public class ContactController {

    private final ContactService contactService;

    @PostMapping("/api/contacts")
    public ResponseEntity<AddContactResponse> saveContact(@RequestBody AddContactRequest request) {
        return ResponseEntity.ok(new AddContactResponse(contactService.saveContact(
                new ContactModel(
                        request.getName(),
                        request.getContact()
                )
        )));
    }

}
