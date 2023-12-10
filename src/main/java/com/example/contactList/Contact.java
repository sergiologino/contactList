package com.example.contactList;

import lombok.Data;
import lombok.experimental.FieldNameConstants;
import org.thymeleaf.spring6.templateresolver.SpringResourceTemplateResolver;

@Data
@FieldNameConstants
public class Contact {

    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String phone;


}
