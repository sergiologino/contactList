package com.example.contactList.service;

import com.example.contactList.Contact;

import java.util.List;
import java.util.Optional;

public interface ContactListService {
    List<Contact> findAll();

    Contact findById(Long id);

    Contact save(Contact contact);

    Contact update(Contact contact);

    void deleteById(Long id);
}
