package com.example.contactList.listener;

import com.example.contactList.Contact;
import com.example.contactList.service.ContactListService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.event.ApplicationStartedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.awt.desktop.AppReopenedEvent;
import java.util.ArrayList;
import java.util.List;

@Component
@RequiredArgsConstructor
@Slf4j
public class DatabaseContactCreator {
    private final ContactListService contactListService;

    @EventListener(ApplicationStartedEvent.class)
    public void createContactData(){
        log.debug(" Calling DatabaseContactCreator -> createContactData... ");
        List<Contact> contacts =new ArrayList<>();
        for(int i=0;i<10; i++){
            int value = i+1;
            Contact contact=new Contact();
            contact.setId((long) value);
            contact.setFirstName("Sergey "+value);
            contact.setLastName("Savkin "+value);
            contact.setEmail("email "+value);
            contact.setPhone("phone "+value);

            contacts.add(contact);
        }
        contactListService.batchInsert(contacts);
    }
}
