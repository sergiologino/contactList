package com.example.contactList;

import com.example.contactList.service.ContactListService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class ContactListController {

    private final ContactListService contactListService;

    @GetMapping("/")
    public String index(Model model){
        model.addAttribute("contacts", contactListService.findAll());
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
        contactListService.save(contact);
        return "redirect:/";
    }
    @GetMapping("/contact/edit/{id}")
    public String showEditForm(@PathVariable Long id, Model model){
        Contact contact=contactListService.findById(id);
        if(contact!=null){
            model.addAttribute("contact", contact);
                    return "edit";
        }
        return "redirect:/";
    }
    @PostMapping("/contact/edit")
    public String editContact(@ModelAttribute Contact contact){
        contactListService.update(contact);

        return "redirect:/";
    }
    @GetMapping("/contact/delete/{id}")
    public String deleteContact(@PathVariable Long id){
        contactListService.deleteById(id);
            return "redirect:/";
    }

}
