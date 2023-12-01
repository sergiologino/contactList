package com.example.contactList;

import lombok.Data;
import org.thymeleaf.spring6.templateresolver.SpringResourceTemplateResolver;

@Data
public class Contact {

    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String phone;


}
