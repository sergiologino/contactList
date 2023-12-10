package com.example.contactList.service;

import com.example.contactList.Contact;
import com.example.contactList.repository.ContactListRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class ContactListServiceImpl implements ContactListService{

    private final ContactListRepository contactListRepository;

    @Override
    public List<Contact> findAll() {
        log.debug("Call findAll in ContactListServiceImpl");
        return contactListRepository.findAll();
    }

    @Override
    public Contact findById(Long id) {
        log.debug("Call findById in ContactListServiceImpl");

        return contactListRepository.findById(id).orElseThrow();
    }

    @Override
    public Contact save(Contact contact) {
        log.debug("Call save in ContactListServiceImpl");
        return contactListRepository.save(contact);
    }

    @Override
    public Contact update(Contact contact) {
        log.debug("Call update in ContactListServiceImpl");
        return contactListRepository.update(contact);
    }

    @Override
    public void deleteById(Long id) {
        log.debug("Call delete in ContactListServiceImpl");
        contactListRepository.deleteById(id);

    }

    @Override
    public void batchInsert(List<Contact> contacts) {
        log.debug("Call batchInsert in ContactListServiceImpl");

        contactListRepository.batchInsert(contacts);
    }
}
