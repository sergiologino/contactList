package com.example.contactList.repository;

import com.example.contactList.Contact;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.jdbc.JdbcTemplateAutoConfiguration;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@Primary
@RequiredArgsConstructor
@Slf4j
public class DatabaseContactListRepository implements ContactListRepository{


    private final JdbcTemplate jdbcTemplate;
    @Override
    public List<Contact> findAll() {
        log.debug("Calling DatabaseContactListRepository -> findAll");

        String sql="SELECT * FROM contact";


        return jdbcTemplate.query;
    }

    @Override
    public Optional<Contact> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public Contact save(Contact contact) {
        return null;
    }

    @Override
    public Contact update(Contact contact) {
        return null;
    }

    @Override
    public void deleteById(Long id) {

    }
}
