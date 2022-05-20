package kz.narxoz.Contacts.Controller;

import kz.narxoz.Contacts.Entity.Contacts;
import kz.narxoz.Contacts.Repository.ContactsRepository;
import kz.narxoz.Contacts.Service.ContactServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
public class HomeController {
    @Autowired
    ContactServiceInterface contactService;

    @Autowired
    ContactsRepository contactsRepository;

    @Autowired
    ContactsRepository SecurityConfig;


    @GetMapping("/contacts")
    public String Contacts(Model model){
        model.addAttribute("contacts", contactService.FindAllContacts());
        return "contacts";
    }

    @GetMapping("/navbar")
    public String nav(){
        return "navbar";
    }


    @GetMapping("/contacts/new")
    public String addContactForm(Model model){
        Contacts contact = new Contacts();
        model.addAttribute("contact", contact);
        return "add_contact";
    }

    @PostMapping(value = "/contacts")
    public String saveContact(@ModelAttribute("contact") Contacts contact){
        contactService.saveContact(contact);
        return "redirect:/contacts";
    }


    @GetMapping("/contacts/update/{id}")
    public String updateContactForm(Model model, @PathVariable("id") Long id){
        Contacts contact = contactService.findById(id);
        model.addAttribute("contact", contact);
        return "update";
    }

    @GetMapping("/contacts/delete/{id}")
    public String deleteContact(@PathVariable("id") Long id) {
        contactService.deleteContact(id);
        return "redirect:/contacts";
    }

    @PostMapping("/contacts/update/{id}")
    public String updateContact(@PathVariable("id") Long id, @ModelAttribute("contact") Contacts contact){
        Contacts Contact2 = contactService.findById(id);
        Contact2 = contact;
        contactService.saveContact(Contact2);
        return "redirect:/contacts";
    }

    @GetMapping("/login")
    public String login() {



        return "redirect:/contacts";
    }

    @GetMapping("/success")
    public String log(){
        return "redirect:/contacts";
    }

    @GetMapping("/logout")
    public String logout() { return "login"; }


}
