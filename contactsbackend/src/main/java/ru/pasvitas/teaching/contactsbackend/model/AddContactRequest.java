package ru.pasvitas.teaching.contactsbackend.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class AddContactRequest {
    private String name;
    private String contact;
}
