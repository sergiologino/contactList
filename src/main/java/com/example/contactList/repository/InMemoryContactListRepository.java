package com.example.contactList.repository;

import com.example.contactList.Contact;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
@Slf4j
public class InMemoryContactListRepository implements ContactListRepository{

    private final List<Contact> contacts = new ArrayList<>();
    @Override
    public List<Contact> findAll() {
        log.debug("Call findAll in InMemoryContactListRepository");
        return contacts;
    }

    @Override
    public Optional<Contact> findById(Long id) {
        log.debug("Call findById in InMemoryContactListRepository. ID is {}", id);
        return contacts.stream()
                .filter(t -> t.getId().equals(id))
                .findFirst();
    }

    @Override
    public Contact save(Contact contact) {
        log.debug("Call save in InMemoryContactListRepository. Contact is {}", contact);
        contact.setId(System.currentTimeMillis());
        contacts.add(contact);
        return contact;
    }

    @Override
    public Contact update(Contact contact) {
        log.debug("Call update in InMemoryContactListRepository. Contact is {}", contact);
        Contact existedContact=findById(contact.getId()).orElse(null);
        if(existedContact !=null){
            existedContact.setFirstName(contact.getFirstName());
            existedContact.setLastName(contact.getLastName());
            existedContact.setEmail(contact.getEmail());
            existedContact.setPhone(contact.getPhone());
        }
        return existedContact;
    }

    @Override
    public void deleteById(Long id) {
        log.debug("Call delete in InMemoryContactListRepository. ID is {}", id);
        findById(id).ifPresent(contacts::remove);

    }
}
