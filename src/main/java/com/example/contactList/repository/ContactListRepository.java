package com.example.contactList.repository;

import com.example.contactList.Contact;

import java.util.List;
import java.util.Optional;

public interface ContactListRepository {
    List<Contact> findAll();

    Optional<Contact> findById(Long id);

    Contact save(Contact contact);

    Contact update(Contact contact);

    void deleteById(Long id);

    void batchInsert(List<Contact> contacts);



}
