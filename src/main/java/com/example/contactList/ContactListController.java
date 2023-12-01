package com.example.contactList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class ContactListController {
    private final List<Contact> contacts = new ArrayList<>();

    @GetMapping("/")
    public String index(Model model){
        model.addAttribute("contacts", contacts);
        return "index";
    }

    @GetMapping("/contact/create")
    public String showCreateForm(Model model){
        model.addAttribute("contact", new Contact());
        return "create";
    }

    @PostMapping("/contact/create")
    public String createContact(@ModelAttribute Contact contact) {
        contact.setId(System.currentTimeMillis());
        contacts.add(contact);
        return "redirect:/";
    }
    @GetMapping("/contact/edit/{id}")
    public String showEditForm(@PathVariable Long id, Model model){
        Contact contact=findContactById(id);
        if(contact!=null){
            model.addAttribute("contact", contact);
                    return "edit";
        }
        return "redirect:/";
    }
    @PostMapping("/contact/edit")
    public String editContact(@ModelAttribute Contact contact){
        Contact existedContact=findContactById(contact.getId());
        if(existedContact !=null){
            existedContact.setFirstName(contact.getFirstName());
            existedContact.setLastName(contact.getLastName());
            existedContact.setEmail(contact.getEmail());
            existedContact.setPhone(contact.getPhone());
        }
        return "redirect:/";
    }
    @GetMapping("/contact/delete/{id}")
    public String deleteContact(@PathVariable Long id){
        Contact contact=findContactById(id);
            if(contact!=null) {
                contacts.remove(contact);
        }
            return "redirect:/";
    }
    private Contact findContactById(Long id){
        return contacts.stream()
                .filter(t->t.getId().equals(id))
                .findFirst()
                .orElse(null);
    }
}
